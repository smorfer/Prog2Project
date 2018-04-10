package Entities.squirrels.MasterSquirrel;

import Entities.Entity;
import Entities.EntitySet;
import Entities.Wall;
import Entities.squirrels.MiniSquirrel.MiniSquirrel;
import Entities.squirrels.Squirrel;
import geom.XY;

public abstract class MasterSquirrel extends Squirrel {
    private static final int INIT_ENERGY = 1000;

    public XY previousLocation = this.getPosition();
    public MasterSquirrel(XY position) {
        super(INIT_ENERGY, position);
        //Change energy here!
    }

    @Override
    public void nextStep() {
        previousLocation = new XY(this.getPosition());
        move(getDirection());

    }

    public void spawnMiniSquirrel(int energy){
        this.energy -= energy;
        //TODO: This has to be somewhere else
    }

    public XY getPreviousLocation() {
        return previousLocation;
    }

}
