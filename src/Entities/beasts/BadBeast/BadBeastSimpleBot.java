package Entities.beasts.BadBeast;

import Entities.Entity;
import Entities.EntitySet;
import Entities.squirrels.MasterSquirrel.MasterSquirrel;
import geom.XY;

public class BadBeastSimpleBot {
    Entity target;

    BadBeastSimpleBot(){
        for(Entity e : EntitySet.getEntities()){
            if(e instanceof MasterSquirrel){
                target = e;
                break;
            }
        }
    }

    public XY getDirection(){
        //TODO: Vector from Beast to Target
        return null;
    }
}