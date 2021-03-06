package core;

import entities.Entity;
import entities.Wall;
import entities.beasts.BadBeast;
import entities.beasts.GoodBeast;
import entities.plants.BadPlant;
import entities.plants.GoodPlant;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import entities.squirrels.MiniSquirrel.MiniSquirrel;

public enum EntityType {
    GOOD_BEAST, BAD_BEAST, GOOD_PLANT, BAD_PLANT,
    MINI_SQUIRREL, MASTER_SQUIRREL, WALL, NONE;

    public static EntityType getEntityType(Entity entity){
        if(entity instanceof Wall) return EntityType.WALL;
        else if(entity instanceof MasterSquirrel) return EntityType.MASTER_SQUIRREL;
        else if(entity instanceof MiniSquirrel) return EntityType.MINI_SQUIRREL;
        else if(entity instanceof GoodPlant) return EntityType.GOOD_PLANT;
        else if(entity instanceof BadPlant) return EntityType.BAD_PLANT;
        else if(entity instanceof GoodBeast) return EntityType.GOOD_BEAST;
        else if(entity instanceof BadBeast) return EntityType.BAD_BEAST;

        else
            return EntityType.NONE;    // if(entity == null)

    }
}

