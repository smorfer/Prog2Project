package Entities;

import Entities.plants.GoodPlant;
import geom.XY;

public abstract class Entity {
    protected final int ID;
    protected int energy;
    protected XY position;

    public Entity(int ID, int energy, XY position) {
        this.ID = ID;
        this.energy = energy;
        this.position = position;
    }

    public abstract void nextStep();

    public void updateEnergy(int deltaEnergy){
        energy += deltaEnergy;
    }

    public int getID() {
        return ID;
    }

    public int getEnergy() {
        return energy;
    }

    public XY getPosition(){
        return position;
    }

    public void move(XY direction){}



    @Override
    public String toString() {
        return this.getClass().getName() + " {" +
                "ID=" + ID +
                ", energy=" + energy +
                ", position=" + position.toString() +
                '}';
    }

    public void die(){
        EntitySet.removeEntity(this.getID());
    }
}
