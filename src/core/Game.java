package core;

import geom.XY;
import ui.MoveCommand;
import ui.UI;

public class Game {

    private static State state;
    private static UI ui;
    private static Board board;

    public static void main(String[] args) {

        ui = new ui.ConsoleUI();
        board = new Board();
        state = new State(board);
        run();


    }

//    public Game(State state)
//    {
//        this.state = state;
//    }

    public static void run() {
        while (true) {
            render();
            processInput();
            update();
        }
    }

    protected static void render(){
        ui.render(state.flattenedBoard());
    }

    protected static void processInput(){
        MoveCommand moveCommand = ui.getCommand(); // Hier muss der command weitergegeben werden an MasterSquirrel

    }

    protected static void update(){
        board.callNextStep();
    }
}




