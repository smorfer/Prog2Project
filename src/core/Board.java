package core; // Diese Lösung gehört Luis Schweigard und Samuel Glogger

import entities.Entity;
import entities.Wall;
import entities.beasts.BadBeast;
import entities.beasts.GoodBeast;
import entities.plants.BadPlant;
import entities.plants.GoodPlant;
import entities.squirrels.MasterSquirrel.HandOperatedMasterSquirrel;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import entities.squirrels.MiniSquirrel.MiniSquirrel;
import exceptions.NotEnoughEnergyException;
import geom.XY;
import ui.MoveCommand;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Board {

    private List<Entity> entitySet;
    private FlattenedBoard flattenedBoard;
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private MasterSquirrel masterSquirrel;
    private BoardConfig config = new BoardConfig();

    public Board(){
        
        entitySet = new CopyOnWriteArrayList<>();

        int entitiesIndex = 0;
        for (int height = 1; height <= config.getSize(); height++)
        {
            for (int width = 1; width <= config.getSize(); width++ )
            {
                if (height == 1 || width == 1 || height == config.getSize() || width == config.getSize())
                {
                    entitySet.add(new Wall(new XY(width-1,height-1)));
                }
            }
        }


        for(int BadBeastCounter = 0; BadBeastCounter < config.BADBEAST_QUANTITY; BadBeastCounter++)
        {
            entitySet.add(new BadBeast(getFreePosition()));
        }
        for(int GoodBeastCounter = 0; GoodBeastCounter < config.GOODBEAST_QUANTITY; GoodBeastCounter++)
        {
            entitySet.add(new GoodBeast(getFreePosition()));
        }
        for(int BadPlantCounter = 0; BadPlantCounter < config.BADPLANT_QUANTITY; BadPlantCounter++)
        {
            entitySet.add(new BadPlant(getFreePosition()));
        }
        for(int GoodPlantCounter = 0; GoodPlantCounter < config.GOODPLANT_QUANTITY; GoodPlantCounter++)
        {
            entitySet.add(new GoodPlant(getFreePosition()));
        }
        for(int WallCounter = 0; WallCounter < config.WALL_QUANTITY; WallCounter++)
        {
            entitySet.add(new Wall(getFreePosition()));
        }



    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Entity e : entitySet)
        {
            if (e instanceof MasterSquirrel)
            {
                str.append(e.toString());
                str.append("\n");

            }
        }
        return str.toString();
    }



    boolean isEntityAtPosition(XY pos)
    {
        for (Entity e : entitySet)
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
        for (Entity e : entitySet) {
            if (e != null) {
                if (e.getPosition().equals(location)) {
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

    public XY getFreePositionAroundLoc(XY pos){
        if(this.getEntityAtPosition(new XY(pos.x - 1, pos.y)) == null) {
            return new XY(pos.x - 1, pos.y);
        }
        if(this.getEntityAtPosition(new XY(pos.x - 1, pos.y)) == null) {
            return new XY(pos.x + 1, pos.y);
        }
        if(this.getEntityAtPosition(new XY(pos.x - 1, pos.y)) == null) {
            return new XY(pos.x, pos.y - 1);
        }
        if(this.getEntityAtPosition(new XY(pos.x - 1, pos.y)) == null) {
            return new XY(pos.x, pos.y + 1);
        }
        return null;
    }

    public FlattenedBoard getData(){
        return new FlattenedBoard(this);
    }


    public void spawnMiniSquirrel(MasterSquirrel master, int energy){
        MasterSquirrel squirrel;

        for(Entity e : entitySet){
            if(e instanceof MasterSquirrel){
                XY spawnLoc = getFreePositionAroundLoc(master.getPosition());

                if(spawnLoc == null){
                    logger.log(Level.FINE, "No valid spawn for MiniSquirrel found!");
                    return;
                }

                try {
                    MiniSquirrel ms = master.spawnMiniSquirrel(spawnLoc, energy);
                    master.updateEnergy(-energy);
                    this.getData().addEntity(ms);
                } catch (NotEnoughEnergyException e1) {
                    logger.log(Level.FINE, "Tried to spawn MiniSquirrel, NotEnoughEnergyException thrown!");
                }
            }
        }
    }

    public void setMaster(MasterSquirrel squirrel){
        this.masterSquirrel = squirrel;
    }

    public MasterSquirrel getMaster(){
        return this.masterSquirrel;
    }

    public List<Entity> getEntitySet(){
        return entitySet;
    }



    public void nextStep(MoveCommand moveCommand)
    {
        EntityContext data = getData();

        MasterSquirrel master = null;
        for (Entity e : entitySet){

            if(!(e instanceof entities.Character)){
                continue;
            }

            if(e instanceof HandOperatedMasterSquirrel){
                ((MasterSquirrel)e).doNextStep(data, moveCommand);
                continue;
            }

            e.nextStep(data);

        }

    }
}
