package Entities.plants;

import Entities.Entity;
import geom.XY;

public class BadPlant extends Plant {
    private static final int INIT_ENERGY = -100;
    public BadPlant(int ID, XY position) {
        super(ID, INIT_ENERGY, position);
        // Change energy here!
    }

    @Override
    public void nextStep() {

    }


}