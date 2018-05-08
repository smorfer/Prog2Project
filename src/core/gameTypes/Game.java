package core.gameTypes;

import core.Board;
import core.State;
import geom.XY;
import ui.CommandHandler.GameCommandProcessor;
import ui.MoveCommand;
import ui.UI;

import java.util.Timer;
import java.util.TimerTask;

public abstract class Game {

    State state;
    UI ui;
    Board board;
    private static final int FPS = 30;
    private static final int REFRESH_RATE = 5;



    public Game(State state, UI ui, Board board)
    {
        this.state = state;
        this.ui = ui;
        this.board = board;
    }

    public void run() {
        MoveCommand command;
        Timer timer = new Timer();
        Timer timer1 = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                render();
            }
        }, 0, 1000/FPS);

        timer1.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                processInput();
            }
        }, 0, 1000/REFRESH_RATE);

    }

    protected void render(){
        ui.render(state.flattenedBoard());
    }

    protected abstract void processInput();

}




