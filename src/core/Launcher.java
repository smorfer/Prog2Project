package core;

import ui.ConsoleUI;

public class Launcher {
    public static void main(String[] args) {

        ConsoleUI ui = new ui.ConsoleUI();
        Board board = new Board();
        State state = new State(board);
        Game instance = new Game(state, ui, board);
        instance.run();



    }
}
