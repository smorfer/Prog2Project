package core;

import Entities.Entity;
import Entities.Wall;
import Entities.beasts.BadBeast.BadBeast;
import Entities.beasts.GoodBeast;
import Entities.plants.BadPlant;
import Entities.plants.GoodPlant;
import Entities.squirrels.MasterSquirrel.MasterSquirrel;
import Entities.squirrels.MiniSquirrel.MiniSquirrel;

public enum EntityType {
    GOOD_BEAST, BAD_BEAST, GOOD_PLANT, BAD_PLANT,
    MINI_SQUIRREL, MASTER_SQUIRREL, WALL;

    public static EntityType getEntityType(Entity entity){
        if(entity instanceof Wall) return EntityType.WALL;
        else if(entity instanceof MasterSquirrel) return EntityType.MASTER_SQUIRREL;
        else if(entity instanceof MiniSquirrel) return EntityType.MINI_SQUIRREL;
        else if(entity instanceof GoodPlant) return EntityType.GOOD_PLANT;
        else if(entity instanceof BadPlant) return EntityType.BAD_PLANT;
        else if(entity instanceof GoodBeast) return EntityType.GOOD_BEAST;
        else if(entity instanceof BadBeast) return EntityType.BAD_BEAST;

        else
            return null;    // if(entity == null)

    }
}

