package Entities;

import geom.XY;
import ID.IDManager;

public abstract class Entity {
    protected final int ID;
    protected int energy;
    protected XY position;

    public Entity(int energy, XY position) {
        this.ID = IDManager.getNextID();
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
        return this.getClass().getSimpleName() + " {" +
                "ID=" + ID +
                ", energy=" + energy +
                ", position=" + position.toString() +
                " Distance to Origin: " + XY.distanceToTarget(XY.vectorToTarget(XY.ORIGIN, position)) +"}";
    }


}
