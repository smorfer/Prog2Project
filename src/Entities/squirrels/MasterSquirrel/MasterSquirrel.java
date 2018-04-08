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
        EntitySet.addEntity(new MiniSquirrel(energy, new XY(previousLocation), this.getID()));  // This doesnt spawn the entity
                                                            // KOMISCHER BUG: AN DER PREVIOUS LOC KANN WIRD NICHTS GESPAWNT
                                                            // Man muss von der prev. Location mit einer Konstanten (XY.DOWN beispielsweise)
                                                            // weggehen. XY.ORIGIN funktioniert aber auch nicht ...
    }

    public XY getPreviousLocation() {
        return previousLocation;
    }

}
