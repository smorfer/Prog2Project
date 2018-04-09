package core;

import Entities.Entity;
import Entities.beasts.BadBeast.BadBeast;
import Entities.beasts.GoodBeast;
import Entities.squirrels.MasterSquirrel.MasterSquirrel;
import Entities.squirrels.MiniSquirrel.MiniSquirrel;
import Entities.squirrels.Squirrel;
import geom.XY;

public interface EntityContext {

    XY getSize();
    
    void tryMove(MasterSquirrel masterSquirrel, XY direction);

    void tryMove(MiniSquirrel miniSquirrel, XY direction);

    void tryMove(GoodBeast goodBeast, XY direction);

    void tryMove(BadBeast badBeast, XY direction);

    Squirrel nearestPlayerEntity(XY location);

    void killAndReplace(Entity entity);

    void kill(Entity entity);

    EntityType getEntityType(Entity entity); // Vielleicht default?


}

