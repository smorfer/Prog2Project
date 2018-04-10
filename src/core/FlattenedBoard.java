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

public class FlattenedBoard implements EntityContext{
    //    x  y
    private Entity[][] entities;
    private EntitySet entitySet;


    FlattenedBoard(Entity[][] data, EntitySet entitySet){

        entities = data;
        this.entitySet = entitySet;
    }

    @Override
    public XY getSize() {
        return null;
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
            // miniSquirrel.collide(masterSquirrel)
        }

    }

    @Override
    public void tryMove(GoodBeast goodBeast, XY direction) {
        XY newLocation = new XY(goodBeast.getPosition(), direction);
        Entity targetEntity = entities[newLocation.getX()][newLocation.getY()];

        //move! if target null

        if(targetEntity instanceof Squirrel){
            // collide method in Squirrel
        }
    }

    @Override
    public void tryMove(BadBeast badBeast, XY direction) {
        XY newLocation = new XY(badBeast.getPosition(), direction);
        Entity targetEntity = entities[newLocation.getX()][newLocation.getY()];

        if(targetEntity == null){
            //badBeast.move(direction);
        } else if(targetEntity instanceof Squirrel){
            badBeast.bite(this, targetEntity);
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
            System.out.println("Hit Bad Beast");
            // do bad beast collision
            return true;
        } else if(targetEntity instanceof Wall){
            // dont move
            System.out.println("Hit Wall");
            squirrel.hit(this, (Wall)targetEntity);
            return true;
        }


        return false;
    }

    public void moveEntity(Entity entity, XY direction){
        entities[entity.getPosition().getX()][entity.getPosition().getY()] = null;

        XY targetLocation = new XY(entity.getPosition(), direction);
        entities[targetLocation.getX()][targetLocation.getY()] = entity;

        entity.move(direction);

    }

    @Override
    public Squirrel nearestPlayerEntity(XY location) {
        return null;
    }

    @Override
    public void killAndReplace(Entity entity) {

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
