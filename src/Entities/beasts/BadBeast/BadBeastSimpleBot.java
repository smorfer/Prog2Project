package Entities.beasts.BadBeast;

import Entities.Entity;
import Entities.EntitySet;
import Entities.squirrels.MasterSquirrel.MasterSquirrel;
import geom.XY;

public class BadBeastSimpleBot {
    Entity target;


    public XY getDirection(){
        return XY.inputToDirection(XY.getRandomNumber());
    }
}