package core.gameTypes;

import core.Board;
import core.State;
import entities.squirrels.MasterSquirrel.HandOperatedMasterSquirrel;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import ui.CommandHandler.GameCommandProcessor;
import ui.UI;

public class SinglePlayerGame extends Game{
    MasterSquirrel player;
    public SinglePlayerGame(State state, UI ui, Board board) {
        super(state, ui, board);
        player = new HandOperatedMasterSquirrel(200, board.getFreePosition());
        board.getData().getEntitySet().addEntity(player);
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
}
