package entities;

import core.EntityContext;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import geom.XY;
import ID.IDManager;

public abstract class Entity {
    private final int ID;
    private int energy;
    private XY position;

    public Entity(int energy, XY position) {
        this.ID = IDManager.getNextID();
        this.energy = energy;
        this.position = position;
    }

    public abstract void nextStep(EntityContext entityContext);

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

    public void setPosition(XY position) {
        this.position = position;
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
