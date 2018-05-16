package core.gameTypes;

import core.Board;
import core.BoardConfig;
import core.State;
import entities.squirrelBots.MasterSquirrelBot;
import entities.squirrels.MasterSquirrel.HandOperatedMasterSquirrel;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import geom.XY;
import ui.CommandHandler.GameCommandProcessor;
import ui.MoveCommand;
import ui.UI;

import java.util.Timer;
import java.util.TimerTask;

public class MultiPlayerBotGame extends Game{
    MasterSquirrel bot1;
    MasterSquirrel bot2;
    public MultiPlayerBotGame(State state, UI ui, Board board) {
        super(state, ui, board);
        bot1 = new MasterSquirrelBot(board.getFreePosition());
        bot2 = new MasterSquirrelBot(board.getFreePosition());
        board.getData().getEntitySet().addEntity(bot1);
        board.getData().getEntitySet().addEntity(bot2);
    }



    @Override
    protected void processInput() {
        GameCommandProcessor processor = new GameCommandProcessor(board);
        try {
            processor.process(ui.getCommand());
        } catch (Exception e) {
            System.out.println("No command!");
        }
    }

    @Override
    protected void render() {
        ui.render(state.flattenedBoard());


    }

    @Override
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

        timer1.scheduleAtFixedRate(
                new TimerTask() {
                    @Override
                    public void run() {
                        processInput();
                    }
                }, 0, 1000/REFRESH_RATE);
    }
}