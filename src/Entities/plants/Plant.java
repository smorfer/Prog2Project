package Entities.plants;

import Entities.Entity;
import geom.XY;

public abstract class Plant extends Entity {
    public Plant(int ID, int energy, XY position) {
        super(ID, energy, position);
    }
}
