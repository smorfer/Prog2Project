package Entities.beasts.BadBeast;

import Entities.Entity;
import Entities.beasts.Beast;
import geom.XY;

public class BadBeast extends Beast {
    private static final int INIT_ENERGY = -150;
    public BadBeast(int ID, XY position) {
        super(ID, INIT_ENERGY, position);
        // Change energy here!
    }


}
