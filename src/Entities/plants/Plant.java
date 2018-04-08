package Entities.plants;

import Entities.Entity;
import geom.XY;

public abstract class Plant extends Entity {
    public Plant(int energy, XY position) {
        super(energy, position);
    }
}
