package Entities.squirrels.MasterSquirrel;

import Entities.Entity;
import Entities.EntitySet;
import Entities.Wall;
import Entities.squirrels.Squirrel;
import geom.XY;

public abstract class MasterSquirrel extends Squirrel {
    private static final int INIT_ENERGY = 1000;
    public MasterSquirrel(int ID, XY position) {
        super(ID, INIT_ENERGY, position);
        //Change energy here!
    }

    @Override
    public void nextStep() {
        move(getDirection());
    }

    public void move(XY direction){
        XY loc = new XY(position, direction);
        Entity target = EntitySet.getEntity(loc);


        if (target != null && this.getID() != target.getID()) {
            if(!(target instanceof Wall)){
                this.updateEnergy(target.getEnergy());
                target.die();
            }else{     //This is called when an entity is a Wall
                this.updateEnergy(target.getEnergy());
                return;
            }
        }


        this.position = new XY(position, direction);
    }


    public abstract XY getDirection();

}
