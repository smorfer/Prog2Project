package core;

import Entities.Entity;
import Entities.beasts.BadBeast.BadBeast;
import Entities.beasts.GoodBeast;
import Entities.squirrels.MasterSquirrel.MasterSquirrel;
import Entities.squirrels.MiniSquirrel.MiniSquirrel;
import Entities.squirrels.Squirrel;
import geom.XY;

public class FlattenedBoard implements EntityContext{
    //    x  y
    Entity[][] entities;

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

        if(targetEntity instanceof MiniSquirrel){
            // Mini Squirrel Collision, probably in MasterSquirrel
        } else if(targetEntity != null){
            // Collide with target entity, probably in Squirrel
            // TODO: Where to put wall collision?
        } else{
            masterSquirrel.move(direction);
        }
    }

    @Override
    public void tryMove(MiniSquirrel miniSquirrel, XY direction) {

    }

    @Override
    public void tryMove(GoodBeast goodBeast, XY direction) {

    }

    @Override
    public void tryMove(BadBeast badBeast, XY direction) {

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
