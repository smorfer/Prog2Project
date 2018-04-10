package entities.squirrels;

import core.EntityContext;
import entities.Entity;
import entities.Wall;
import entities.beasts.BadBeast;
import entities.beasts.GoodBeast;
import entities.plants.Plant;
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

    public void hit(EntityContext entityContext, Plant plant){

        this.updateEnergy(plant.getEnergy());
        entityContext.kill(plant);
    }

    public void hit(EntityContext entityContext, GoodBeast goodBeast){
        this.updateEnergy(goodBeast.getEnergy());
        entityContext.kill(goodBeast);
    }

    public void hit(EntityContext entityContext, BadBeast badBeast){
        badBeast.bite(entityContext, this);
    }

    public void hit(EntityContext entityContext, Wall wall){
        this.updateEnergy(wall.getEnergy());
    }


    public abstract XY getDirection();

    public void move(XY direction){
        XY loc = new XY(getPosition(), direction);
        this.setPosition(new XY(getPosition(), direction));
    }



}
