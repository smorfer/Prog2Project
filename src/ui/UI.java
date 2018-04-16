package ui;

import core.BoardView;

public interface UI {

    public void render(BoardView view);

    public MoveCommand getCommand();


}
