package Entities.beasts;

import Entities.Entity;
import geom.XY;

public class GoodBeast extends Beast {
    private static final int INIT_ENERGY = 200;
    public GoodBeast(int ID, XY position) {
        super(ID, INIT_ENERGY, position);
        // Change energy here!
    }

    @Override
    public void nextStep() {

    }


}
