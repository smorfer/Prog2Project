package core;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.ConsoleUI;
import ui.FxUI;


public class Launcher extends Application {
    private boolean fxMode = true;

    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        FxUI fxUI = FxUI.createInstance(BoardConfig.getSize());
        ConsoleUI consoleUI = new ui.ConsoleUI();
        Board board = new Board();
        State state = new State(board);

        final Game game;
        if (fxMode) {
            game = new Game(state, fxUI, board);
        } else {
            game = new Game(state, consoleUI, board);
        }

        primaryStage.setScene(fxUI);
        primaryStage.setTitle("Squirrel Game");
        fxUI.getWindow().setOnCloseRequest(event -> {
            System.exit(-1);
        });

        primaryStage.show();

        game.run();


    }
}

/*public class Launcher {
    public static void main(String[] args) {

        ConsoleUI ui = new ui.ConsoleUI();
        Board board = new Board();
        State state = new State(board);
        Game instance = new Game(state, ui, board);
        instance.run();



    }
}*/
