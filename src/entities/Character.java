package entities;

import geom.XY;

public abstract class Character extends Entity{
    public Character(int energy, XY position) {
        super(energy, position);
    }
}
