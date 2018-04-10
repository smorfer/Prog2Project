import Entities.EntitySet;
import Entities.beasts.BadBeast.BadBeast;
import Entities.beasts.GoodBeast;
import Entities.plants.BadPlant;
import Entities.plants.GoodPlant;
import Entities.squirrels.MasterSquirrel.HandOperatedMasterSquirrel;
import Entities.squirrels.MasterSquirrel.MasterSquirrel;
import Entities.squirrels.MiniSquirrel.MiniSquirrel;
import core.Board;
import geom.XY;

public class Main {

    static Board board;
    public static void main(String[] args) {

        board = new Board();
        board.printBoard();
        run();


    }

    public static void run(){
        while(true) {
        board.callNextStep();

        }
    }
}
