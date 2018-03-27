package Entities.squirrels;

import geom.XY;

public class MasterSquirrel extends Squirrel{
    private static final int INIT_ENERGY = 1000;
    public MasterSquirrel(int ID, int energy, XY position) {
        super(ID, INIT_ENERGY, position);
        //Change energy here!
    }

    @Override
    public void nextStep() {

    }

}
