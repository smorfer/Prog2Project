package core;

import Entities.Entity;
import Entities.Wall;
import Entities.beasts.BadBeast.BadBeast;
import Entities.beasts.GoodBeast;
import Entities.plants.BadPlant;
import Entities.plants.GoodPlant;
import Entities.plants.Plant;
import Entities.squirrels.MasterSquirrel.MasterSquirrel;
import Entities.squirrels.MiniSquirrel.MiniSquirrel;
import geom.XY;

import java.util.Random;

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


        for(int BadBeastCounter = 0; BadBeastCounter < BoardConfig.BADBEAST_QUANTITY; BadBeastCounter++)
        {
            entities[entitiesIndex++] = new BadBeast(getFreePosition());
        }
        for(int GoodBeastCounter = 0; GoodBeastCounter < BoardConfig.GOODBEAST_QUANTITY; GoodBeastCounter++)
        {
            entities[entitiesIndex++] = new GoodBeast(getFreePosition());
        }
        for(int BadPlantCounter = 0; BadPlantCounter < BoardConfig.BADPLANT_QUANTITY; BadPlantCounter++)
        {
            entities[entitiesIndex++] = new BadPlant(getFreePosition());
        }
        for(int GoodPlantCounter = 0; GoodPlantCounter < BoardConfig.GOODPLANT_QUANTITY; GoodPlantCounter++)
        {
            entities[entitiesIndex++] = new GoodPlant(getFreePosition());
        }
        for(int WallCounter = 0; WallCounter < BoardConfig.WALL_QUANTITY; WallCounter++)
        {
            entities[entitiesIndex++] = new Wall(getFreePosition());
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

    public void printBoard()
    {
        String rets = "\n";
        for (int height = 0; height < BoardConfig.SIZE; height++)
        {
            for(int width = 0; width < BoardConfig.SIZE; width++)
            {
                Entity entity = getEntityAtPosition(new XY(width,height));
                if(entity instanceof BadPlant)
                {
                    rets += "V\t";
                }
                else if (entity instanceof GoodPlant)
                {
                    rets += "P\t";
                }
                else if(entity instanceof BadBeast)
                {
                    rets += "K\t";
                }
                else if(entity instanceof GoodBeast)
                {
                    rets += "B\t";
                }
                else if (entity instanceof Wall)
                {
                    rets += "W\t";
                }
                else if (entity instanceof MasterSquirrel)
                {
                    rets += "S\t";
                }
                else if(entity instanceof MiniSquirrel)
                {
                    rets += "M\t";
                }
                else
                {
                    rets += ".\t";
                }
            }
            rets += "\n";
        }
        System.out.print(rets);
    }

    boolean isEntityAtPosition(XY pos)
    {
        for (Entity e : entities)
        {
            if (e != null) {
                if (e.getPosition().equals(pos))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public Entity getEntityAtPosition(XY location) {
        for (Entity e : entities) {
            if (e != null) {        // This statement works!
                if (e.getPosition().equals(location)) {     //This statement is never called
                    return e;
                }
            }
        }

        return null;
    }

    XY getFreePosition()
    {
        Random rnd = new Random();
        XY spawn;
        do {
            spawn = new XY(rnd.nextInt(BoardConfig.SIZE),rnd.nextInt(BoardConfig.SIZE));
        } while (isEntityAtPosition(spawn));
        return spawn;
    }
}
