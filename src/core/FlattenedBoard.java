package core;

import entities.Entity;
import entities.EntitySet;
import entities.Wall;
import entities.beasts.BadBeast;
import entities.beasts.GoodBeast;
import entities.plants.Plant;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import entities.squirrels.MiniSquirrel.MiniSquirrel;
import entities.squirrels.Squirrel;
import geom.XY;

public class FlattenedBoard implements EntityContext, BoardView{


    //            x  y
    private Entity[][] entities;
    private EntitySet entitySet;
    private Board board;


    FlattenedBoard(Entity[][] data, EntitySet entitySet, Board board){

        entities = data;
        this.entitySet = entitySet;
        this.board = board;
    }

    @Override
    public EntityType getEntityType(int x, int y) {
        Entity entity = entitySet.getEntityAtPosition(x, y);
        return entity != null ? EntityType.getEntityType(entity) : null;
    }

    @Override
    public XY getSize() {
        return new XY(entities.length,entities[0].length);
    }

    @Override
    public void tryMove(MasterSquirrel masterSquirrel, XY direction) {
        XY newLocation = new XY(masterSquirrel.getPosition(), direction);
        Entity targetEntity = entities[newLocation.getX()][newLocation.getY()];

        if(squirrelCollision(masterSquirrel, direction, targetEntity)) return;

        if(targetEntity instanceof MiniSquirrel){
            masterSquirrel.hit(this, (MiniSquirrel) targetEntity);
            moveEntity(masterSquirrel, direction);
        }
    }

    @Override
    public void tryMove(MiniSquirrel miniSquirrel, XY direction) {
        XY newLocation = new XY(miniSquirrel.getPosition(), direction);
        Entity targetEntity = entities[newLocation.getX()][newLocation.getY()];

        if(squirrelCollision(miniSquirrel, direction, targetEntity)) return;

        if(targetEntity instanceof MasterSquirrel){
            ((MasterSquirrel) targetEntity).hit(this, miniSquirrel);
        }

    }

    @Override
    public void tryMove(GoodBeast goodBeast, XY direction) {
        XY newLocation = new XY(goodBeast.getPosition(), direction);
        Entity targetEntity = entities[newLocation.getX()][newLocation.getY()];


        if(targetEntity instanceof Squirrel) {
            ((Squirrel) targetEntity).hit(this, goodBeast);
            return;
        }

        if(targetEntity == null) {
            moveEntity(goodBeast, direction);
            return;
        }



    }

    @Override
    public void tryMove(BadBeast badBeast, XY direction) {
        XY newLocation = new XY(badBeast.getPosition(), direction);
        Entity targetEntity = entities[newLocation.getX()][newLocation.getY()];

        if(targetEntity == null){
            moveEntity(badBeast, direction);
            return;
        }

        if(targetEntity instanceof Squirrel){
            badBeast.bite(this, targetEntity);
            return;
        }

    }

    public boolean squirrelCollision(Squirrel squirrel, XY direction, Entity targetEntity) {

        if (targetEntity == null) {
            moveEntity(squirrel, direction);
            return true;
        } else if (targetEntity instanceof Plant) {
            squirrel.hit(this, (Plant)targetEntity);
            moveEntity(squirrel, direction);
            return true;
        } else if (targetEntity instanceof GoodBeast){
            squirrel.hit(this, (GoodBeast)targetEntity);
            moveEntity(squirrel, direction);
            return true;
        } else if(targetEntity instanceof BadBeast){
            squirrel.hit(this, (BadBeast)targetEntity);
            // do bad beast collision
            return true;
        } else if(targetEntity instanceof Wall){
            // dont move
            squirrel.hit(this, (Wall)targetEntity);
            return true;
        }


        return false;
    }

    public void moveEntity(Entity entity, XY direction){
        entities[entity.getPosition().getX()][entity.getPosition().getY()] = null;

        entity.move(direction);

        entities[entity.getPosition().getX()][entity.getPosition().getY()] = entity;



    }

    @Override
    public Squirrel nearestPlayerEntity(XY location) {
        return null;
    }

    @Override
    public void killAndReplace(Entity entity) {
        XY newPos = board.getFreePosition();
        entities[entity.getPosition().getX()][entity.getPosition().getY()] = null;

        entity.setPosition(newPos);
        entities[entity.getPosition().getX()][entity.getPosition().getY()] = entity;

    }

    @Override
    public void kill(Entity entity) {
        entitySet.removeEntity(entity.getID());
        entities[entity.getPosition().getX()][entity.getPosition().getY()] = null;
    }

    @Override
    public EntityType getEntityType(Entity entity) {
        return null;
    }
}
