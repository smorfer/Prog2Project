import core.Board;

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
