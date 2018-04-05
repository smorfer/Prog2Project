package Entities.plants;

import Entities.Entity;
import geom.XY;

public class GoodPlant extends Plant {
    private static final int INIT_ENERGY = 100;
    public GoodPlant(int ID, XY position)
    {
        super(ID, INIT_ENERGY, position);
    }

    @Override
    public void nextStep() {

    }
}
