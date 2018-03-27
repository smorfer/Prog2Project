package Entities.squirrels.MiniSquirrel;

import Entities.squirrels.Squirrel;
import geom.XY;

public class MiniSquirrel extends Squirrel {

    private int masterID;

    public MiniSquirrel(int ID, int energy, XY position, int masterID) {
        super(ID, energy, position);
        this.masterID = masterID;
        //Change energy here!
    }

    @Override
    public void nextStep() {

    }

}
