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
    static final int FPS = 30;
    static final int REFRESH_RATE = 2;



    public Game(State state, UI ui, Board board)
    {
        this.state = state;
        this.ui = ui;
        this.board = board;
    }

    public abstract void run();

    protected abstract void render();

    protected abstract void processInput();

}




