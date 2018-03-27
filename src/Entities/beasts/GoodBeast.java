package Entities.beasts;

import Entities.Entity;

public class GoodBeast extends Entity {
    private static final int INIT_ENERGY = 200;
    public GoodBeast(int ID, int posX, int posY) {
        super(ID, INIT_ENERGY, posX, posY);
        // Change energy here!
    }

    @Override
    public void nextStep() {

    }


}
