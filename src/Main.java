import Entities.EntitySet;
import Entities.Wall;
import Entities.beasts.GoodBeast;
import Entities.plants.BadPlant;
import Entities.plants.GoodPlant;
import Entities.squirrels.MasterSquirrel.HandOperatedMasterSquirrel;
import geom.XY;

public class Main {
    static EntitySet ES = new EntitySet();

    public static void main(String[] args) {

        ES.addEntity(new HandOperatedMasterSquirrel(4444, 200, XY.ORIGIN));
        ES.addEntity(new GoodPlant(69, new XY(4,4)));
        ES.addEntity(new BadPlant(70, new XY(8,4)));
        ES.addEntity(new Wall(999, new XY(3,0)));
        ES.addEntity(new Wall(998, new XY(3,1)));
        ES.addEntity(new Wall(997, new XY(3,2)));
        ES.addEntity(new Wall(996, new XY(3,3)));

        run();
    }

    public static void run(){
        while(true) {
            System.out.println(ES.toString());
            ES.nextStep();
        }
    }
}
