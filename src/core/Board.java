package core;

import entities.Entity;
import entities.EntitySet;
import entities.Wall;
import entities.beasts.BadBeast;
import entities.beasts.GoodBeast;
import entities.plants.BadPlant;
import entities.plants.GoodPlant;
import entities.squirrels.MasterSquirrel.HandOperatedMasterSquirrel;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import entities.squirrels.MiniSquirrel.MiniSquirrel;
import geom.XY;

import java.util.Random;

public class Board {

    EntitySet entitySet;

    public Board()
    {
        entitySet = new EntitySet(BoardConfig.ENTITY_QUANTITY);

        int entitiesIndex = 0;
        for (int height = 1; height <= BoardConfig.SIZE; height++)
        {
            for (int width = 1; width <= BoardConfig.SIZE; width++ )
            {
                if (height == 1 || width == 1 || height == BoardConfig.SIZE || width == BoardConfig.SIZE)
                {
                    entitySet.addEntity(new Wall(new XY(width-1,height-1)));
                }
            }
        }


        for(int BadBeastCounter = 0; BadBeastCounter < BoardConfig.BADBEAST_QUANTITY; BadBeastCounter++)
        {
            entitySet.addEntity(new BadBeast(getFreePosition()));
        }
        for(int GoodBeastCounter = 0; GoodBeastCounter < BoardConfig.GOODBEAST_QUANTITY; GoodBeastCounter++)
        {
            entitySet.addEntity(new GoodBeast(getFreePosition()));
        }
        for(int BadPlantCounter = 0; BadPlantCounter < BoardConfig.BADPLANT_QUANTITY; BadPlantCounter++)
        {
            entitySet.addEntity(new BadPlant(getFreePosition()));
        }
        for(int GoodPlantCounter = 0; GoodPlantCounter < BoardConfig.GOODPLANT_QUANTITY; GoodPlantCounter++)
        {
            entitySet.addEntity(new GoodPlant(getFreePosition()));
        }
        for(int WallCounter = 0; WallCounter < BoardConfig.WALL_QUANTITY; WallCounter++)
        {
            entitySet.addEntity(new Wall(getFreePosition()));
        }

        entitySet.addEntity(new HandOperatedMasterSquirrel(200, getFreePosition()));
        entitySet.addEntity(new MiniSquirrel(200, getFreePosition(), 29828));
    }

    public String toString() {
        String rets = "";
        for (Entity e : entitySet.getEntities())
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

        for(Entity e : entitySet.getEntities()){

            if(e instanceof MasterSquirrel)
            System.out.println(e.toString());
        }
    }

    boolean isEntityAtPosition(XY pos)
    {
        for (Entity e : entitySet.getEntities())
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
        for (Entity e : entitySet.getEntities()) {
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

    public FlattenedBoard getData(){

            Entity[][] data = new Entity[BoardConfig.SIZE][BoardConfig.SIZE];

            for (Entity e : entitySet.getEntities()) {
                if (e == null) continue;

                XY location = e.getPosition();
                data[location.getX()][location.getY()] = e;
            }

            return new FlattenedBoard(data, entitySet, this);



    }

    public void callNextStep(){
        nextStep();
        printBoard();
    }

    public void nextStep()
    {
        EntityContext data = getData();
        Entity master = null;
        for (Entity e : entitySet.getEntities())
        {
            if(e instanceof MasterSquirrel){
                master = e;
                continue;
            }

            if (e != null)
            {
                e.nextStep(data);
            }
        }

        if(master == null)
            return;

        master.nextStep(data);

    }
}
