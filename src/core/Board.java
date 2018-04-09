package core;

import Entities.Entity;
import Entities.Wall;
import geom.XY;

public class Board {

    Entity entities[];

    public Board()
    {
        entities = new Entity[BoardConfig.ENTITY_QUANTITY];
        int entitiesIndex = 0;
        for (int height = 1; height <= BoardConfig.SIZE; height++)
        {
            for (int width = 1; width <= BoardConfig.SIZE; width++ )
            {
                if (height == 1 || width == 1 || height == BoardConfig.SIZE || width == BoardConfig.SIZE)
                {
                    entities[entitiesIndex++] = new Wall(new XY(width-1,height-1));
                }
            }
        }
    }

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
