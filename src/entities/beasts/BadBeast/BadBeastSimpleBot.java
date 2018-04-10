package entities.beasts.BadBeast;

import entities.Entity;
import geom.XY;

public class BadBeastSimpleBot {
    Entity target;


    public XY getDirection(){
        return XY.inputToDirection(XY.getRandomNumber());
    }
}