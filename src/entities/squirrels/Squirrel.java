package entities.squirrels;

import core.EntityContext;
import entities.Entity;
import geom.XY;

public abstract class Squirrel extends Entity {
    public Squirrel(int energy, XY position) {
        super(energy, position);
    }



//    public void hit(Entity entity){       This is the collision handler, wrong in this class!
//        if(entity instanceof Plant){
//
//            this.updateEnergy(entity.getEnergy());
//            entity.die();
//
//        } else if(entity instanceof BadBeast){
//
//            ((BadBeast) entity).bite(this);
//
//        } else if(entity instanceof GoodBeast){
//
//            this.updateEnergy(entity.getEnergy());
//            entity.die();
//
//        } else if (entity instanceof Wall){
//
//            this.updateEnergy(entity.getEnergy());
//
//        } else if(entity instanceof MiniSquirrel){
//
//            if (((MiniSquirrel) entity).getMasterID() == this.getID()) {
//                this.updateEnergy(entity.getEnergy());
//                entity.die();
//            } else{
//                this.updateEnergy(+150);
//                entity.die();
//            }
//
//        }
//    }


    public abstract XY getDirection();

    public void move(XY direction){
        XY loc = new XY(getPosition(), direction);
        this.setPosition(new XY(getPosition(), direction));
    }

//    public boolean canMove(XY targetLocation){                                    Wrong in this class!
//        Entity targets[] = EntitySet.getEntitiesAtPosition(targetLocation);
//        boolean canMove = true;
//        if (targets != null)
//        {
//            for (Entity target : targets) {
//                if (target != null && this.getID() != target.getID()) {
//
//                    canMove = (!(target instanceof Wall));
//                    this.hit(target);
//                }
//            }
//        }
//
//        return canMove;
//    }


}
