import Entities.EntitySet;
import Entities.beasts.BadBeast.BadBeast;
import Entities.beasts.GoodBeast;
import Entities.plants.BadPlant;
import Entities.plants.GoodPlant;
import Entities.squirrels.MasterSquirrel.HandOperatedMasterSquirrel;
import Entities.squirrels.MiniSquirrel.MiniSquirrel;
import core.Board;
import geom.XY;

public class Main {
    static EntitySet ES = new EntitySet();

    public static void main(String[] args) {

        Board board = new Board();
        board.printBoard();
    }

    public static void run(){
        while(true) {
            System.out.println(ES.toString());
            ES.nextStep();
        }
    }
}
