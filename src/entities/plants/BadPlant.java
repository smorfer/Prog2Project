package entities.plants;

import geom.XY;

public class BadPlant extends Plant {
    private static final int INIT_ENERGY = -100;
    public BadPlant(XY position) {
        super(INIT_ENERGY, position);
        // Change energy here!
    }

    @Override
    public void nextStep() {

    }


}