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


    public static void removeEntity(int id)
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

    public static Entity getEntity(int ID)
    {
        for (Entity e : entities)
        {
            if (e != null)
            {
                if (e.getID() == ID)
                {
                    return e;
                }
            }
        }
        return null;
    }

    public static Entity[] getEntitiesAtPosition(XY location) {
        int ArrayLength = 0;
        for (Entity e : entities)
        {
            if (e!=null)
            {
                if (e.getPosition().equals(location))
                {
                    ArrayLength++;
                }
            }
        }
        Entity EntitiesAtPosition[] = new Entity[ArrayLength];
        int ArraryPosition = 0;
        for (Entity e : entities)
        {
            if (e!=null)
            {
                if (e.getPosition().equals(location))
                {
                    EntitiesAtPosition[ArraryPosition] = e;
                    ArraryPosition++;
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
