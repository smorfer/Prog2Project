package entities.squirrels;

import core.EntityContext;
import entities.Character;
import entities.Wall;
import entities.beasts.BadBeast;
import entities.beasts.GoodBeast;
import entities.plants.Plant;
import geom.XY;

public abstract class Squirrel extends Character {
    public Squirrel(int energy, XY position) {
        super(energy, position);
    }

    private int freezeCounter = 0;

    public boolean isFrozen(){

        assert freezeCounter>=0 : "Freeze Counter < 0";

        if(freezeCounter >= 3){
            freezeCounter = 0;
            return true;
        } else if(freezeCounter == 0) {
            return false;
        } else {
            freezeCounter++;
            return true;
        }
    }

    public void hit(EntityContext entityContext, Plant plant){

        this.updateEnergy(plant.getEnergy());
        entityContext.killAndReplace(plant);
    }

    public void hit(EntityContext entityContext, GoodBeast goodBeast){
        this.updateEnergy(goodBeast.getEnergy());
        entityContext.killAndReplace(goodBeast);
    }

    public void hit(EntityContext entityContext, BadBeast badBeast){

        badBeast.bite(entityContext, this);
    }

    public void hit(EntityContext entityContext, Wall wall){
        this.updateEnergy(wall.getEnergy());
        freezeCounter = 1;

    }


    public void move(XY direction){
        if(isFrozen())
            return;

        this.setPosition(getPosition().plus(direction));
    }



}
