package Entities.squirrels.MasterSquirrel;

import geom.XY;

import java.util.Scanner;

import static geom.XY.inputToDirection;

public class HandOperatedMasterSquirrel extends MasterSquirrel {

    Scanner sc = new Scanner(System.in);

    public HandOperatedMasterSquirrel(int ID, int energy, XY position) {
        super(ID, energy, position);
    }

    public XY getHandOperatedDirection() {
        return inputToDirection(sc.nextInt());
    }

    @Override
    public void nextStep() {
        move(getHandOperatedDirection());
    }

}
