package core;

import geom.XY;
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
            command = processInput();
            update(command);

        }
    }

    protected void render(){
        ui.render(state.flattenedBoard());
    }

    protected MoveCommand processInput(){
        return ui.getCommand(); // Hier muss der command weitergegeben werden an MasterSquirrel
    }

    protected void update(MoveCommand moveCommand){
        if (moveCommand !=null) {
            board.nextStep(moveCommand);
        }
    }
}




