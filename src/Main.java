import Entities.EntitySet;
import Entities.beasts.BadBeast.BadBeast;
import Entities.beasts.GoodBeast;
import Entities.plants.BadPlant;
import Entities.plants.GoodPlant;
import Entities.squirrels.MasterSquirrel.HandOperatedMasterSquirrel;
import Entities.squirrels.MiniSquirrel.MiniSquirrel;
import geom.XY;

public class Main {
    static EntitySet ES = new EntitySet();

    public static void main(String[] args) {

        ES.addEntity(new HandOperatedMasterSquirrel(4444, 200, XY.ORIGIN));
//        ES.addEntity(new MiniSquirrel(123, 300, new XY(3,2), 4444));
//        ES.addEntity(new MiniSquirrel(234, 300, new XY(5,2), 1234));
//        ES.addEntity(new BadBeast(69, new XY(4,4)));
//        ES.addEntity(new GoodBeast(68, new XY(2,2)));
//        ES.addEntity(new BadPlant(70, new XY(8,4)));
//        ES.addEntity(new GoodPlant(71, new XY(3,3)));


        run(); // DUN DUNN DUNN DUNN DUNN
    }

    public static void run(){
        while(true) {
            System.out.println(ES.toString());
            ES.nextStep();
        }
    }
}
