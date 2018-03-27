package Entities.beasts;

import Entities.Entity;
import geom.XY;


public abstract class Beast extends Entity{
    public Beast(int ID, int energy, XY position) {
        super(ID, energy, position);
    }


}
