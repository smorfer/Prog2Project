import Entities.beasts.GoodBeast;
import Entities.plants.BadPlant;
import Entities.squirrels.MasterSquirrel.HandOperatedMasterSquirrel;
import geom.XY;

public class Main {
    static EntitySet ES = new EntitySet();

    public static void main(String[] args) {

        ES.addEntity(new HandOperatedMasterSquirrel(4444, 200, XY.ORIGIN));
        run();
    }

    public static void run(){
        while(true) {
            System.out.println(ES.toString());
            ES.nextStep();

            EntitySet entitySet = new EntitySet();
            entitySet.addEntity(new HandOperatedMasterSquirrel(0, 1000, XY.ORIGIN));
            entitySet.addEntity(new GoodBeast(1, XY.DOWN_RIGHT));
            entitySet.addEntity(new BadPlant(2, new XY(10, 10)));
        }
    }
}
