package core; // Diese Lösung gehört Luis Schweigard und Samuel Glogger

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
import ui.MoveCommand;

import java.util.Random;

public class Board {

    private EntitySet entitySet;
    private FlattenedBoard flattenedBoard;

    public Board()
    {
        entitySet = new EntitySet(BoardConfig.ENTITY_QUANTITY);

        int entitiesIndex = 0;
        for (int height = 1; height <= BoardConfig.getSize(); height++)
        {
            for (int width = 1; width <= BoardConfig.getSize(); width++ )
            {
                if (height == 1 || width == 1 || height == BoardConfig.getSize() || width == BoardConfig.getSize())
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



    }

    public String toString() {
        String rets = "";
        for (Entity e : entitySet.getEntities())
        {
            if (e instanceof MasterSquirrel)
            {
                rets += e.toString() + "\n";

            }
        }
        return rets;
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

    public XY getFreePosition()
    {
        Random rnd = new Random();
        XY spawn;
        do {
            spawn = new XY(rnd.nextInt(BoardConfig.getSize()),rnd.nextInt(BoardConfig.getSize()));
        } while (isEntityAtPosition(spawn));
        return spawn;
    }

    public FlattenedBoard getData(){

        if (flattenedBoard == null) {
            Entity[][] data = new Entity[BoardConfig.getSize()][BoardConfig.getSize()];

            for (Entity e : entitySet.getEntities()) {
                if (e == null) continue;

                XY location = e.getPosition();
                data[location.getX()][location.getY()] = e;
            }
            flattenedBoard = new FlattenedBoard(data, entitySet, this);
        }

        return flattenedBoard;
    }


    public void spawnMiniSquirrel(Object energy){
        MasterSquirrel squirrel;

        for(Entity e : getData().getEntitySet().getEntities()){
            if(e instanceof MasterSquirrel){
                ((MasterSquirrel) e).spawnMiniSquirrel(getData(), Integer.parseInt((String)energy));
            }
        }
    }



    public void nextStep(MoveCommand moveCommand)
    {
        EntityContext data = getData();

        MasterSquirrel master = null;
        for (entities.Character c : entitySet.getCharacters())
        {
            if(c instanceof HandOperatedMasterSquirrel){
                ((MasterSquirrel)c).doNextStep(data, moveCommand);
                continue;
            }

            if (c != null)
            {
                c.nextStep(data);
            }
        }

    }
}
