package core;

import core.gameTypes.SinglePlayerBotGame;
import core.gameTypes.Game;
import core.gameTypes.MultiPlayerBotGame;
import core.gameTypes.SinglePlayerGame;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.ConsoleUI;
import ui.FxUI;



public class Launcher extends Application {
    private boolean fxMode = true;
    private boolean botMode = true;
    private Game game;

    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        ConsoleUI consoleUI = new ui.ConsoleUI();
        Board board = new Board();
        State state = new State(board);
        FxUI fxUI = FxUI.createInstance(board.getConfig().getSize());


        if (fxMode) {
            game = botMode ? new MultiPlayerBotGame(state, fxUI, board) : new SinglePlayerGame(state, fxUI, board);
        } else {
            game = botMode ? new SinglePlayerBotGame(state, consoleUI, board) : new SinglePlayerGame(state, consoleUI, board);
        }

        primaryStage.setScene(fxUI);
        primaryStage.setTitle("Squirrel Game");
        fxUI.getWindow().setOnCloseRequest(event -> {
            System.exit(-1);
        });

        primaryStage.show();

        System.out.println("Starting Squirrel Game");
        game.run();
    }

}

