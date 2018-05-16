package entities.beasts;

import core.EntityContext;
import entities.squirrels.Squirrel;
import geom.XY;
import geom.XYSupport;

public class BeastSimpleBot {



    public XY getDirection(EntityContext entityContext, XY currentLocation){

        XY target = getNearestSquirrel(entityContext, currentLocation);
        XY vectorToTarget = XYSupport.vectorToTarget(currentLocation, target);

        if(vectorToTarget.length() <= 6f){
            return XYSupport.normalize(vectorToTarget);
        }

        return XYSupport.inputToDirection(XYSupport.getRandomNumber());
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