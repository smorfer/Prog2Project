package core;

import Entities.Entity;
import Entities.beasts.BadBeast.BadBeast;
import Entities.beasts.GoodBeast;
import Entities.squirrels.MasterSquirrel.MasterSquirrel;
import Entities.squirrels.MiniSquirrel.MiniSquirrel;
import Entities.squirrels.Squirrel;
import geom.XY;

public class FlattenedBoard implements EntityContext{
    @Override
    public XY getSize() {
        return null;
    }

    @Override
    public void tryMove(MasterSquirrel masterSquirrel, XY direction) {

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
