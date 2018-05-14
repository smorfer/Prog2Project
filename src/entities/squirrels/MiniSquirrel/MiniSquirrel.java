package entities.squirrels.MiniSquirrel;

import core.EntityContext;
import entities.squirrels.Squirrel;
import geom.XY;

public class MiniSquirrel extends Squirrel {

    private int masterID;
    private static final int INIT_ENERGY = 200;

    public MiniSquirrel( XY position, int masterID) {
        super(INIT_ENERGY, position);
        this.masterID = masterID;
        //Change energy here!
    }

    @Override
    public void nextStep(EntityContext entityContext) {
        if(this.getEnergy() <= 0){
            entityContext.kill(this);
        }

        entityContext.tryMove(this, getDirection());
        this.updateEnergy(-1);
    }


    private XY getDirection() {
        return new XY(XY.ORIGIN);
    }

    public int getMasterID() {
        return masterID;
    }
}
