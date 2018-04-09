package Entities.beasts;

import Entities.Entity;
import geom.XY;

import java.util.Random;


public abstract class Beast extends Entity{
    private int moveCounter = 0;

    public Beast(int energy, XY position) {
        super(energy, position);
    }

    @Override
    public void nextStep() {
        move(XY.inputToDirection(XY.getRandomNumber()));
    }

    public void move(XY direction){
        if(moveCounter % 4 == 0){
            this.position = new XY(position, direction);
        }
        moveCounter++;


    }
}
