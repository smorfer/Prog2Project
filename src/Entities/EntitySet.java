package Entities;

import Entities.Entity;
import geom.XY;

public class EntitySet {
    private static Entity entities[] = new Entity[100];

    public void addEntity(Entity entity)
    {
        int index;
        for (index = 0; entities[index] != null; index++);
        entities[index] = entity;
    }


    public void removeEntity(int id)
    {
        for (int i = 0; i < entities.length; i++)
        {
            if (entities[i] != null && entities[i].getID() == id)
            {
                entities[i] = null;
                break;
            }
        }
    }

    public static Entity getEntity(XY location) {
        for (Entity e : entities) {
            if (e != null) {        // This statement works!
                if (e.getPosition().equals(location)) {     //This statement is never called
                    return e;
                }
            }
        }

        return null;
    }


    @Override
    public String toString() {
        String rets = "";
        for (Entity e : entities)
        {
            if (e != null)
            {
                rets += e.toString() + "\n";

            }
        }
        return rets;
    }

    public void nextStep()
    {
        for (Entity e : entities)
        {
            if (e != null)
            {
                e.nextStep();
            }
        }
    }
}