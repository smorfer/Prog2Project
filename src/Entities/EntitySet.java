package Entities;

import Entities.Entity;
import Entities.squirrels.MasterSquirrel.MasterSquirrel;
import geom.XY;

public class EntitySet {
    private Entity entities[];

    public EntitySet(int length){
         entities = new Entity[length];
    }

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

    public Entity getEntity(int ID)
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

    public Entity[] getEntities(){
        return entities;
    }

    public Entity[] getEntitiesAtPosition(XY location) {
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
        int ArrayPosition = 0;
        for (Entity e : entities)
        {
            if (e!=null)
            {
                if (e.getPosition().equals(location))
                {
                    EntitiesAtPosition[ArrayPosition] = e;
                    ArrayPosition++;
                }
            }
        }
        return EntitiesAtPosition;
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
        Entity master = null;
        for (Entity e : entities)
        {
            if(e instanceof MasterSquirrel){
                master = e;
                continue;
            }

            if (e != null)
            {
                e.nextStep();
            }
        }

        if(master == null)
            return;

        master.nextStep();

    }
}
