package Entities;

import geom.XY;

public class Wall extends Entity {
    private static final int INIT_ENERGY = -10;
    public Wall(XY position) {
        super(INIT_ENERGY, position);
    }

    @Override
    public void nextStep() {
    }

    @Override
    public void updateEnergy(int deltaEnergy){}
}
