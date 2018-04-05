package Entities.squirrels.MasterSquirrel;

import geom.XY;

import java.util.Scanner;

import static geom.XY.inputToDirection;

public class HandOperatedMasterSquirrel extends MasterSquirrel {

    Scanner sc = new Scanner(System.in);

    public HandOperatedMasterSquirrel(int ID, int energy, XY position) {
        super(ID, position);
    }

    public XY getDirection() {
        int direction = sc.nextInt();

        if(direction > 9){
            spawnMiniSquirrel(direction, 200);  //This is successfully called
            return XY.ORIGIN;
        }
        return inputToDirection(direction);
    }



}
