package entities.beasts;

import entities.Entity;
import geom.XY;

public class BeastSimpleBot {
    Entity target;


    public XY getDirection(){
        return XY.inputToDirection(XY.getRandomNumber());
    }

}