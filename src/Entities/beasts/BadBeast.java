package Entities.beasts;

import Entities.Entity;

public class BadBeast extends Entity {
    private static final int INIT_ENERGY = -150;
    public BadBeast(int ID, int posX, int posY) {
        super(ID, INIT_ENERGY, posX, posY);
        // Change energy here!
    }

    @Override
    public void nextStep() {

    }

}
