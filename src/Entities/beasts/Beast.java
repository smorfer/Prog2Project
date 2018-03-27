package Entities.beasts;

import Entities.Entity;
import geom.XY;

import java.util.Random;


public abstract class Beast extends Entity{
    public Beast(int ID, int energy, XY position) {
        super(ID, energy, position);
    }

    @Override
    public void nextStep() {
        move(XY.inputToDirection(XY.getRandomNumber()));
    }
}
