package entities.beasts;

import core.EntityContext;
import entities.Entity;
import entities.squirrels.Squirrel;
import geom.XY;


public abstract class Beast extends Entity{
    private int moveCounter = 0;
    private Squirrel target = null;

    public Beast(int energy, XY position) {
        super(energy, position);
    }


    public void move(XY direction){
        if(moveCounter % 4 == 0){
            this.setPosition(new XY(getPosition(), direction));

        }
        moveCounter++;
    }

    public XY getNearestSquirrelLocation(EntityContext entityContext){
        Squirrel nearestPlayerEntity = entityContext.nearestPlayerEntity(this.getPosition());
    }
}
