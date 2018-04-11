package entities.beasts;

import core.EntityContext;
import entities.Entity;
import entities.squirrels.Squirrel;
import geom.XY;


public abstract class Beast extends Entity{
    private int moveCounter = 0;


    public Beast(int energy, XY position) {
        super(energy, position);
    }


    public void move(XY direction){
        if(canMove()){
            this.setPosition(new XY(getPosition(), direction));
            moveCounter = 0;

        }
        moveCounter++;
    }

    public boolean canMove(){

        return (moveCounter++%4==0);
    }



}
