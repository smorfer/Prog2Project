import core.Board;

public class Main {

    static Board board;
    public static void main(String[] args) {

        board = new Board();
        run();


    }

    public static void run(){
        while(true) {
        board.callNextStep();

        }
    }
}
