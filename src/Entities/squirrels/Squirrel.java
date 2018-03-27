package Entities.squirrels;

import Entities.Entity;
import geom.XY;

public abstract class Squirrel extends Entity {
    public Squirrel(int ID, int energy, XY position) {
        super(ID, energy, position);
    }
}
