package core.gameTypes;

import core.Board;
import core.State;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import exceptions.WrongMethodUsageException;
import ui.UI;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {

    State state;
    UI ui;
    Board board;
    private int FPS;
    private int REFRESH_RATE;



    protected List<MasterSquirrel> masters = new ArrayList<>();

    public Game(State state, UI ui, Board board)
    {
        this.state = state;
        this.ui = ui;
        this.board = board;
        this.FPS = board.getConfig().getFPS();
        this.REFRESH_RATE = board.getConfig().getRefreshRate();
    }

    public void resetGame(){}

    public void saveBotScores(){
        throw new WrongMethodUsageException();
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




