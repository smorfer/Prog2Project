package entities.squirrels.MiniSquirrel;

import core.EntityContext;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import entities.squirrels.Squirrel;
import geom.XY;
import geom.XYSupport;

public class MiniSquirrel extends Squirrel {

    private static final int INIT_ENERGY = 100;
    private MasterSquirrel masterSquirrel;

    public MiniSquirrel( XY position, MasterSquirrel masterSquirrel) {
        super(INIT_ENERGY, position);
        this.masterSquirrel = masterSquirrel;
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
        return XYSupport.inputToDirection(XYSupport.getRandomNumber());
    }

    public MasterSquirrel getMasterSquirrel(){
        return masterSquirrel;
    }

    public int getMasterID() {
        return masterSquirrel.getID();
    }
}
