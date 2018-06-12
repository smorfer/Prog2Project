package core;

import entities.Entity;
import entities.beasts.BadBeast;
import entities.beasts.GoodBeast;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import entities.squirrels.MiniSquirrel.MiniSquirrel;
import entities.squirrels.Squirrel;
import geom.XY;


/**
 * All stuff needed for interactions between 2 or more entities.
 */

public interface EntityContext {

    XY getSize();
    
    void tryMove(MasterSquirrel masterSquirrel, XY direction);

    void tryMove(MiniSquirrel miniSquirrel, XY direction);

    void tryMove(GoodBeast goodBeast, XY direction);

    void tryMove(BadBeast badBeast, XY direction);

    Squirrel nearestPlayerEntity(XY location);

    void killAndReplace(Entity entity);

    void kill(Entity entity);

    EntityType getEntityType(Entity entity);

    Entity getEntityAt(int x, int y);

    int spawnMiniSquirrel(int energy,MiniSquirrel miniSquirrel);

    void implodus(MiniSquirrel squirrel, int impactRadius);

    void addEntity(Entity entity);

}

