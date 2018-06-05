package core.gameTypes;

import core.Board;
import core.State;
import entities.squirrels.MasterSquirrel.HandOperatedMasterSquirrel;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import geom.XY;
import ui.CommandHandler.GameCommandProcessor;
import ui.MoveCommand;
import ui.UI;

import java.util.Timer;
import java.util.TimerTask;

public class SinglePlayerGame extends Game{
    private MasterSquirrel player;
    public SinglePlayerGame(State state, UI ui, Board board) {
        super(state, ui, board);
        player = new HandOperatedMasterSquirrel(200, new XY(board.getConfig().getSize()/2,board.getConfig().getSize()/2));
        board.getEntitySet().add(player);
        board.setMaster(player);
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
        ui.message("" + player.getEnergy() + "\t\t\t\t\t\t\t\t Press H for Help");

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
