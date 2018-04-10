package entities.squirrels.MasterSquirrel;

import core.EntityContext;
import entities.squirrels.Squirrel;
import geom.XY;

public abstract class MasterSquirrel extends Squirrel {
    private static final int INIT_ENERGY = 1000;

    public XY previousLocation = this.getPosition();
    public MasterSquirrel(XY position) {
        super(INIT_ENERGY, position);
        //Change energy here!
    }

    @Override
    public void nextStep(EntityContext entityContext) {
        previousLocation = new XY(this.getPosition());

        entityContext.tryMove(this, getDirection());

    }

    public void spawnMiniSquirrel(int energy){
        this.updateEnergy(-energy);
        //TODO: This has to be somewhere else
    }

    public XY getPreviousLocation() {
        return previousLocation;
    }

}
