package entities;

import entities.squirrels.MasterSquirrel.MasterSquirrel;
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



    public Entity getEntityAtPosition(int x, int y)
    {
        for (Entity e : entities)
        {
            if (e != null)
            {
                if (e.getPosition().equals(new XY(x, y)))
                {
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


}
