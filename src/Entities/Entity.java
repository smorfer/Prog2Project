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

    public void move(XY direction)
    {
        XY loc = new XY(position, direction);
        Entity target = EntitySet.getEntity(loc);

        if(target instanceof GoodPlant){
            this.updateEnergy(30);
        }

        this.position = loc;

    }



    @Override
    public String toString() {
        return this.getClass().getName() + "\n{" +
                "ID=" + ID +
                ", energy=" + energy +
                ", position=" + position.toString() +
                '}';
    }
}
