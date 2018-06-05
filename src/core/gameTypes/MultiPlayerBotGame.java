package core.gameTypes;

import core.Board;
import core.State;
import entities.squirrelBots.MasterSquirrelBot;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import ui.CommandHandler.GameCommandProcessor;
import ui.MoveCommand;
import ui.UI;

import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("Duplicates")
public class MultiPlayerBotGame extends Game{
    private MasterSquirrel bot1;
    private MasterSquirrel bot2;

    public MultiPlayerBotGame(State state, UI ui, Board board) {
        super(state, ui, board);
        bot1 = new MasterSquirrelBot(board.getFreePosition(), board.getConfig().getBotNames().get(0));
        bot2 = new MasterSquirrelBot(board.getFreePosition(), board.getConfig().getBotNames().get(1));
        board.getEntitySet().add(bot1);
        board.getEntitySet().add(bot2);

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
        }, 0, 1000/getFPS());

        timer1.scheduleAtFixedRate(
                new TimerTask() {
                    @Override
                    public void run() {
                        processInput();
                    }
                }, 0, 1000/getREFRESH_RATE());
    }
}
