package entities.beasts;

import core.EntityContext;
import entities.squirrels.Squirrel;
import geom.XY;

public class BeastSimpleBot {



    public XY getDirection(EntityContext entityContext, XY currentLocation){

        XY target = getNearestSquirrel(entityContext, currentLocation);
        XY vectorToTarget = XY.vectorToTarget(currentLocation, target);

        if(target != null && XY.getVectorLength(vectorToTarget) <= 6f){
            return XY.normalize(vectorToTarget);
        }

        return XY.inputToDirection(XY.getRandomNumber());
    }

    public XY getNearestSquirrel(EntityContext entityContext, XY currentLocation){
        Squirrel nearest = entityContext.nearestPlayerEntity(currentLocation);

        if(nearest != null){
            return nearest.getPosition();
        } else {
            return null;
        }

    }



}