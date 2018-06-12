package entities;

import core.EntityContext;
import geom.XY;
import ID.IDManager;

/**
 * Every entity is a subclass of this superclass.
 * This class contains all important variables and methods that an entity has to have.
 */

public abstract class Entity {

    /**
     * @value ID Every entity has a unique ID
     * @value energy The "health points" of every Entity
     * @value position A Vector (XY) that shows the current position of an Entity
     */

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
                ", position=" + position.toString() +"}";
    }


}
