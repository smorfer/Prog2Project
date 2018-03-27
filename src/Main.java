import Entities.beasts.GoodBeast;
import Entities.squirrels.MasterSquirrel.HandOperatedMasterSquirrel;
import geom.XY;

public class Main {
    public static void main(String[] args) {
        boolean running = true;

        EntitySet entitySet = new EntitySet();
        entitySet.addEntity(new HandOperatedMasterSquirrel(0,1000, XY.ORIGIN));
        entitySet.addEntity(new GoodBeast(1,XY.DOWN_RIGHT));
        entitySet
        while(running){
            System.out.print(entitySet.toString());
            entitySet.nextStep();
        }
    }
}
