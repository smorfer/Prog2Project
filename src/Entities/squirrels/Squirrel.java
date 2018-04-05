package Entities.squirrels;

import Entities.Entity;
import Entities.EntitySet;
import Entities.Wall;
import Entities.beasts.BadBeast.BadBeast;
import Entities.beasts.GoodBeast;
import Entities.plants.Plant;
import geom.XY;

public abstract class Squirrel extends Entity {
    public Squirrel(int ID, int energy, XY position) {
        super(ID, energy, position);
    }


    //GoodBeast, BadBeast, Plant, Wall
    public void hit(GoodBeast goodBeast){
        this.updateEnergy(goodBeast.getEnergy());
        goodBeast.die();
    }

    public void hit(BadBeast badBeast){
        //TODO: Hier müsste das BadBeast angreifen (attack() oder bite() Methode Implementieren!)
    }

    public void hit(Plant plant){
        this.updateEnergy(plant.getEnergy());
        plant.die();
    }

    public void hit(Wall wall){
        this.updateEnergy(wall.getEnergy());
    }

    @Override
    public void nextStep() {
        move(getDirection());
    }

    public abstract XY getDirection();

    public void move(XY direction){
        XY loc = new XY(position, direction);
        this.position = new XY(position, direction);
    }
}
