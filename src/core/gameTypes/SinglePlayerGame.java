package core.gameTypes;

import core.Board;
import core.State;
import entities.squirrels.MasterSquirrel.HandOperatedMasterSquirrel;
import ui.CommandHandler.GameCommandProcessor;
import ui.UI;

public class SinglePlayerGame extends Game{
    public SinglePlayerGame(State state, UI ui, Board board) {
        super(state, ui, board);
        board.getData().getEntitySet().addEntity(new HandOperatedMasterSquirrel(200, board.getFreePosition()));
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

}
