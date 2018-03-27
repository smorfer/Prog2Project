import Entities.squirrels.MasterSquirrel.HandOperatedMasterSquirrel;
import geom.XY;

public class Main {
    static EntitySet ES = new EntitySet();

    public static void main(String[] args) {

        ES.addEntity(new HandOperatedMasterSquirrel(4444, 200, XY.ORIGIN));
        run();
    }

    public static void run(){
        while(true){
            System.out.println(ES.toString());
            ES.nextStep();
        }
    }
}
