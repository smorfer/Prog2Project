package Entities.beasts.BadBeast;

import Entities.Entity;
import Entities.beasts.Beast;
import geom.XY;

public class BadBeast extends Beast {
    private static final int INIT_ENERGY = -150;
    private int biteCounter;
    public BadBeast(int ID, XY position) {
        super(ID, INIT_ENERGY, position);
        // Change energy here!

        biteCounter = 0;
    }

    public void bite(Entity target){
        if(biteCounter == 7){
            this.die();
        }

        target.updateEnergy(this.getEnergy());
        biteCounter++;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " {" +
                "ID=" + ID +
                ", energy=" + energy +
                ", position=" + position.toString() +
                " Bite Counter: " + biteCounter + " }";
    }

}
