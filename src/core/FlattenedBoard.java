package core;

import entities.Entity;
import entities.Wall;
import entities.beasts.BadBeast.BadBeast;
import entities.beasts.GoodBeast;
import entities.plants.Plant;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import entities.squirrels.MiniSquirrel.MiniSquirrel;
import entities.squirrels.Squirrel;
import geom.XY;

public class FlattenedBoard implements EntityContext{
    //    x  y
    private Entity[][] entities;


    // TODO: Move muss auch die data (entities array positionen) verändern!

    FlattenedBoard(Entity[][] data){
        entities = data;
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
            //MiniSquirrel collision missing here!
        }
    }

    @Override
    public void tryMove(MiniSquirrel miniSquirrel, XY direction) {
        XY newLocation = new XY(miniSquirrel.getPosition(), direction);
        Entity targetEntity = entities[newLocation.getX()][newLocation.getY()];

        if(targetEntity instanceof MasterSquirrel){
            MasterSquirrel target = (MasterSquirrel)targetEntity;

        } else if(targetEntity instanceof MiniSquirrel){
            MiniSquirrel target = (MiniSquirrel)targetEntity;
        } else if(targetEntity != null){
            // Get Target Type (we have an ENUM, may that work)
            // Alternative: Generics Method
        }
    }

    @Override
    public void tryMove(GoodBeast goodBeast, XY direction) {
        XY newLocation = new XY(goodBeast.getPosition(), direction);
        Entity targetEntity = entities[newLocation.getX()][newLocation.getY()];

        //move!

        if(targetEntity instanceof Squirrel){
            // collide method in Squirrel
        }
    }

    @Override
    public void tryMove(BadBeast badBeast, XY direction) {
        XY newLocation = new XY(badBeast.getPosition(), direction);
        Entity targetEntity = entities[newLocation.getX()][newLocation.getY()];

        if(targetEntity == null){
            badBeast.move(direction);
        } else if(targetEntity instanceof Squirrel){
            // collide method in Squirrel
        }

    }

    public boolean squirrelCollision(Squirrel squirrel, XY direction, Entity targetEntity) {

        if (targetEntity == null) {
            squirrel.move(direction);
        } else if (targetEntity instanceof Plant) {
            // do plant collision
            return true;
        } else if (targetEntity instanceof GoodBeast){
            // do good beast collision
            return true;
        } else if(targetEntity instanceof BadBeast){
            // do bad beast collision
            return true;
        } else if(targetEntity instanceof Wall){
            // do wall collision
            return true;
        }


        return false;
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

    }

    @Override
    public EntityType getEntityType(Entity entity) {
        return null;
    }
}
