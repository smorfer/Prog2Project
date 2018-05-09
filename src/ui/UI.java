package ui;

import core.BoardView;
import ui.CommandHandler.Command;

public interface UI {

    public void render(BoardView view);

    public Command getCommand();

    public void message (String message);

}
