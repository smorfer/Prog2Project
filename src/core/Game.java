package core;

import geom.XY;
import ui.CommandHandler.GameCommandProcessor;
import ui.MoveCommand;
import ui.UI;

public class Game {

    private State state;
    private UI ui;
    private Board board;



    public Game(State state, UI ui, Board board)
    {
        this.state = state;
        this.ui = ui;
        this.board = board;
    }

    public void run() {
        MoveCommand command;

        while (true) {
            render();
            processInput();
            //update();

        }
    }

    protected void render(){
        ui.render(state.flattenedBoard());
    }

    protected void processInput(){
        GameCommandProcessor processor = new GameCommandProcessor(board);
        try {
            processor.process(ui.getCommand());
        } catch (Exception e) {
            System.out.println("Command not found! " + e.getMessage());
        }
    }

    protected void update(){
    }
}




