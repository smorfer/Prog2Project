package core.gameTypes;

import core.Board;
import core.State;
import entities.squirrelBots.MasterSquirrelBot;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import ui.MoveCommand;
import ui.UI;

import java.util.Timer;
import java.util.TimerTask;

public class BotGame extends Game{
    MasterSquirrel bot;
    public BotGame(State state, UI ui, Board board) {
        super(state, ui, board);
        bot = new MasterSquirrelBot(board.getFreePosition());
        board.getData().getEntitySet().addEntity(bot);
    }

    @Override
    public void run() {

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
                BotGame.super.board.nextStep(MoveCommand.ORIGIN);
            }
        }, 0, 1000/REFRESH_RATE);
    }

    @Override
    protected void processInput() {
        // no input when using bots
    }

    @Override
    protected void render() {
        ui.render(state.flattenedBoard());
        ui.message("" + bot.getEnergy() + "\t\t\t\t\t\t\t\t Press H for Help");

    }
}