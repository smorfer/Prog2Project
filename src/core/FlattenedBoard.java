package core;

import entities.Entity;
import entities.EntitySet;
import entities.Wall;
import entities.beasts.BadBeast;
import entities.beasts.GoodBeast;
import entities.plants.BadPlant;
import entities.plants.Plant;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import entities.squirrels.MiniSquirrel.MiniSquirrel;
import entities.squirrels.Squirrel;
import geom.XY;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FlattenedBoard implements EntityContext, BoardView{


    //            x  y
    private Entity[][] entities;
    private EntitySet entitySet;
    private Board board;
    private static Logger logger = Logger.getLogger(FlattenedBoard.class.getName());

    FlattenedBoard(Entity[][] data, EntitySet entitySet, Board board){

        entities = data;
        this.entitySet = entitySet;
        this.board = board;
    }

    @Override
    public EntityType getEntityType(int x, int y) {
        Entity entity = entitySet.getEntityAtPosition(x,y);
        return EntityType.getEntityType(entity);
    }

    @Override
    public XY getSize() {
        return new XY(entities.length,entities[0].length);
    }

    @Override
    public void tryMove(MasterSquirrel masterSquirrel, XY direction) {
        logger.log(Level.INFO, "MasterSquirrel " + masterSquirrel.getID() + " tries to move in direction " + direction.toString());
        XY newLocation = masterSquirrel.getPosition().plus(direction);
        Entity targetEntity = entities[newLocation.x][newLocation.y];

        if(squirrelCollision(masterSquirrel, direction, targetEntity)) return;

        if(targetEntity instanceof MiniSquirrel){

            logger.log(Level.INFO, "MasterSquirrel " + masterSquirrel.getID() + " tries to absorb MiniSquirrel " + targetEntity.getID());

            masterSquirrel.hit(this, (MiniSquirrel) targetEntity);
            moveEntity(masterSquirrel, direction);
        }
    }

    @Override
    public void tryMove(MiniSquirrel miniSquirrel, XY direction) {
        XY newLocation = miniSquirrel.getPosition().plus(direction);
        Entity targetEntity = entities[newLocation.x][newLocation.y];

        if(squirrelCollision(miniSquirrel, direction, targetEntity)) return;

        if(targetEntity instanceof MasterSquirrel){
            ((MasterSquirrel) targetEntity).hit(this, miniSquirrel);
        }

    }

    @Override
    public void tryMove(GoodBeast goodBeast, XY direction) {
        XY newLocation = goodBeast.getPosition().plus(direction);
        Entity targetEntity = entities[newLocation.x][newLocation.y];


        if(targetEntity instanceof Squirrel) {
            ((Squirrel) targetEntity).hit(this, goodBeast);
            return;
        }

        if(targetEntity == null) {
                moveEntity(goodBeast, direction);
                goodBeast.addMoveCounter();

        }
    }

    @Override
    public void tryMove(BadBeast badBeast, XY direction) {
        XY newLocation = badBeast.getPosition().plus(direction);
        Entity targetEntity = entities[newLocation.x][newLocation.y];

        if(targetEntity == null){
                moveEntity(badBeast, direction);
                badBeast.addMoveCounter();
            return;
        }

        if(targetEntity instanceof Squirrel){
            logger.log(Level.INFO, "BadBeast " + badBeast.getID() + " tries to bite Squirrel " + targetEntity.getID());
            badBeast.bite(this, targetEntity);
        }

    }

    public boolean squirrelCollision(Squirrel squirrel, XY direction, Entity targetEntity) {

        if (targetEntity == null) {
            moveEntity(squirrel, direction);
            return true;
        } else if (targetEntity instanceof Plant) {
            logger.log(Level.INFO, "Squirrel " + squirrel.getID() + " tries to absorb Plant " + targetEntity.getID());
            squirrel.hit(this, (Plant)targetEntity);
            moveEntity(squirrel, direction);
            return true;
        } else if (targetEntity instanceof GoodBeast){
            logger.log(Level.INFO, "Squirrel " + squirrel.getID() + " tries to absorb GoodBeast " + targetEntity.getID());
            squirrel.hit(this, (GoodBeast)targetEntity);
            moveEntity(squirrel, direction);
            return true;
        } else if(targetEntity instanceof BadBeast){
            logger.log(Level.INFO, "Squirrel " + squirrel.getID() + " tries to attack BadBeast " + targetEntity.getID());
            squirrel.hit(this, (BadBeast)targetEntity);
            // do bad beast collision
            return true;
        } else if(targetEntity instanceof Wall){
            // dont move
            logger.log(Level.INFO, "Squirrel " + squirrel.getID() + " tries to walk on Wall " + targetEntity.getID());
            squirrel.hit(this, (Wall)targetEntity);
            return true;
        }


        return false;
    }

    public void moveEntity(Entity entity, XY direction){
        entities[entity.getPosition().x][entity.getPosition().y] = null;

        entity.move(direction);

        entities[entity.getPosition().x][entity.getPosition().y] = entity;



    }

    @Override
    public Squirrel nearestPlayerEntity(XY location) {
        double distance = Double.MAX_VALUE;
        Squirrel nearest = null;

        for(Entity e : entitySet.getEntities()){
            if(e instanceof MasterSquirrel){
                double newDistance = e.getPosition().distanceFrom(location);

                if(newDistance < distance){
                    nearest = (Squirrel)e;
                    distance = newDistance;
                }

            }
        }

        return nearest;


    }

    @Override
    public Entity getEntityAt(int x, int y) {
        return this.board.getData().getEntitySet().getEntityAtPosition(x,y);
    }

    @Override
    public void killAndReplace(Entity entity) {
        XY newPos = board.getFreePosition();

        entities[entity.getPosition().x][entity.getPosition().y] = null;

        entity.setPosition(newPos);
        entities[entity.getPosition().x][entity.getPosition().y] = entity;

    }

    public int spawnMiniSquirrel(int energy,MiniSquirrel miniSquirrel){
        if(this.getEntityType(miniSquirrel.getPosition().x, miniSquirrel.getPosition().y) != EntityType.NONE){
            return 0;
        }

        entitySet.addEntity(miniSquirrel);
        return -energy;
    }

    @Override
    public void kill(Entity entity) {
        entitySet.removeEntity(entity.getID());
        entities[entity.getPosition().x][entity.getPosition().y] = null;
    }

    public EntitySet getEntitySet() {
        return entitySet;
    }

    @Override
    public EntityType getEntityType(Entity entity) {
        return null;
    }

    @Override
    public void implodus(MiniSquirrel squirrel, int impactRadius)
    {

        logger.log(Level.INFO, "MiniSquirrel " + squirrel.getID() + " tries to implode!");
        XY position = squirrel.getPosition();
        int collectedEnergy = 0;
        double impactArea = impactRadius * impactRadius * Math.PI;

        for (int y = position.y-impactRadius; y <= position.y+impactRadius; y++){
            for (int x = position.x-impactRadius; x <= position.x+impactRadius; x++){
                Entity temp = getEntityAt(x,y);

                if(temp == null || temp instanceof Wall || temp.getID() == squirrel.getID() || squirrel.getPosition().distanceFrom(temp.getPosition()) > impactRadius) {
                    //
                    continue;
                }

                double energyLoss = 200 * (squirrel.getEnergy() / impactArea) * (1-squirrel.getPosition().distanceFrom(temp.getPosition())/impactRadius);

                collectedEnergy += implosionEffect(squirrel, temp, energyLoss);
            }


        }

        getEntitySet().getEntity(squirrel.getMasterID()).updateEnergy(collectedEnergy);
        kill(squirrel);
    }

    public int implosionEffect(MiniSquirrel squirrel, Entity target, double energyLoss){


        EntityType type = EntityType.getEntityType(target);

        switch(type){
            case MASTER_SQUIRREL:
                if(target.getID() != squirrel.getMasterID()){
                    target.updateEnergy(-(int)Math.round(energyLoss));
                    return (int)Math.round(energyLoss);
                }
                return 0;
            case MINI_SQUIRREL:
                if(((MiniSquirrel)target).getMasterID() == squirrel.getMasterID()){
                    return 0;
                }

                if(energyLoss > target.getEnergy()){
                    int energy = target.getEnergy();
                    this.kill(target);
                    return energy;
                } else {
                    target.updateEnergy((int)Math.round(-energyLoss));
                    return (int)Math.round(energyLoss);
                }
            case GOOD_BEAST:
            case GOOD_PLANT:
                if(energyLoss > target.getEnergy()){
                    int energy = target.getEnergy();
                    this.killAndReplace(target);
                    return energy;
                } else {
                    target.updateEnergy((int)Math.round(-energyLoss));
                    return (int)Math.round(energyLoss);
                }
            case BAD_BEAST:
            case BAD_PLANT:
                if (energyLoss > Math.abs(target.getEnergy())) {
                    killAndReplace(target);
                } else {
                    target.updateEnergy((int)Math.round(energyLoss));
                }
                return 0;
            default:
                return 0;

        }
    }

}
