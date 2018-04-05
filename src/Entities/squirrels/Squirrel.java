package Entities.squirrels;

import Entities.Entity;
import Entities.EntitySet;
import Entities.Wall;
import Entities.beasts.BadBeast.BadBeast;
import Entities.beasts.GoodBeast;
import Entities.plants.GoodPlant;
import Entities.plants.Plant;
import geom.XY;

public abstract class Squirrel extends Entity {
    public Squirrel(int ID, int energy, XY position) {
        super(ID, energy, position);
    }



    public void hit(Entity entity){
        if(entity instanceof Plant){

            this.updateEnergy(entity.getEnergy());
            entity.die();

        } else if(entity instanceof BadBeast){

            ((BadBeast) entity).bite(this);

        } else if(entity instanceof GoodBeast){

            this.updateEnergy(entity.getEnergy());
            entity.die();

        } else if (entity instanceof Wall){

            this.updateEnergy(entity.getEnergy());

        }
    }

    @Override
    public void nextStep() {
        move(getDirection());
    }

    public abstract XY getDirection();

    public void move(XY direction){
        XY loc = new XY(position, direction);

        if(!canMove(loc)){
            return;
        }

        this.position = new XY(position, direction);
    }

    public boolean canMove(XY targetLocation){
        Entity targets[] = EntitySet.getEntitiesAtPosition(targetLocation);
        boolean canMove = true;
        if (targets != null)
        {
            for (Entity target : targets) {
                if (target != null && this.getID() != target.getID()) {

                    canMove = (!(target instanceof Wall));
                    this.hit(target);
                }
            }
        }

        return canMove;
    }


}
