package entities.squirrels.MasterSquirrel;

import core.EntityContext;
import geom.XY;

import java.util.Scanner;

import static geom.XY.inputToDirection;

public class HandOperatedMasterSquirrel extends MasterSquirrel {

    Scanner sc = new Scanner(System.in);

    public HandOperatedMasterSquirrel(int energy, XY position) {
        super(position);
    }


    @Override
    public void nextStep(EntityContext entityContext) {
        int op = sc.nextInt();
        if (op > 9)
        {
            spawnMiniSquirrel(200);
        }
        else
        {
            previousLocation = new XY(this.getPosition());

            entityContext.tryMove(this, inputToDirection(op));
        }
    }
}
