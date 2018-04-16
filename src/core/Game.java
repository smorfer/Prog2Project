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
        MoveCommand command;
        while (true) {
            render();
            command = processInput();
            update(command);

        }
    }

    protected static void render(){
        ui.render(state.flattenedBoard());
    }

    protected static MoveCommand processInput(){
        return ui.getCommand(); // Hier muss der command weitergegeben werden an MasterSquirrel
    }

    protected static void update(MoveCommand moveCommand){
        board.nextStep(moveCommand);
    }
}




