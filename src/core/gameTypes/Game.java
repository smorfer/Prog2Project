package core.gameTypes;

import core.Board;
import core.State;
import ui.UI;

public abstract class Game {

    State state;
    UI ui;
    Board board;
    private int FPS;
    private int REFRESH_RATE;



    public Game(State state, UI ui, Board board)
    {
        this.state = state;
        this.ui = ui;
        this.board = board;
        this.FPS = board.getConfig().getFPS();
        this.REFRESH_RATE = board.getConfig().getRefreshRate();
    }

    public abstract void run();

    protected abstract void render();

    protected abstract void processInput();

    public int getFPS() {
        return FPS;
    }

    public int getREFRESH_RATE() {
        return REFRESH_RATE;
    }
}




