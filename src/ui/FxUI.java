package ui;

import core.BoardConfig;
import core.BoardView;
import geom.XY;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import ui.CommandHandler.Command;
import ui.CommandHandler.GameCommandTypes;

public class FxUI extends Scene implements UI {

    private static int CELL_SIZE = 20;
    private static Command nextCommand = null;

    private Canvas boardCanvas;
    private Label msgLabel;

    private FxUI(Parent parent, Canvas boardCanvas, Label msgLabel) {
        super(parent);
        this.boardCanvas = boardCanvas;
        this.msgLabel = msgLabel;
    }

    public static FxUI createInstance(int size) {
        Canvas boardCanvas = new Canvas(size * CELL_SIZE, size * CELL_SIZE);
        Label statusLabel = new Label();
        VBox top = new VBox();
        top.getChildren().add(boardCanvas);
        top.getChildren().add(statusLabel);
        statusLabel.setText("0");
        final FxUI fxUI = new FxUI(top, boardCanvas, statusLabel);
        fxUI.setOnKeyPressed(value -> {
            switch (value.getCode()) {
                case W:
                    nextCommand = new Command(GameCommandTypes.MOVE, MoveCommand.UP);
                    break;
                case A:
                    nextCommand = new Command(GameCommandTypes.MOVE, MoveCommand.LEFT);
                    break;
                case S:
                    nextCommand = new Command(GameCommandTypes.MOVE, MoveCommand.ORIGIN);
                    break;
                case D:
                    nextCommand = new Command(GameCommandTypes.MOVE, MoveCommand.RIGHT);
                    break;
                case X:
                    nextCommand = new Command(GameCommandTypes.MOVE, MoveCommand.DOWN);
                    break;
                case Q:
                    nextCommand = new Command(GameCommandTypes.MOVE, MoveCommand.UP_LEFT);
                    break;
                case E:
                    nextCommand = new Command(GameCommandTypes.MOVE, MoveCommand.UP_RIGHT);
                    break;
                case Y:
                    nextCommand = new Command(GameCommandTypes.MOVE, MoveCommand.DOWN_LEFT);
                    break;
                case C:
                    nextCommand = new Command(GameCommandTypes.MOVE, MoveCommand.DOWN_RIGHT);
                    break;
                case P:
                    nextCommand = new Command(GameCommandTypes.SPAWN_MINI, "100");
                    break;
                case ESCAPE:
                    nextCommand = new Command(GameCommandTypes.EXIT);
                    break;
                case H:
                    nextCommand = new Command(GameCommandTypes.HELP);
                    break;
                default:
                    break;
            }
        });
        return fxUI;
    }



    @Override
    public void render(final BoardView view) {

        if(nextCommand == null){
            nextCommand = new Command(GameCommandTypes.MOVE, MoveCommand.ORIGIN);   //TODO: this isnt right here!
        }


        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                repaintBoardCanvas(view);
            }
        });
    }

    @Override
    public Command getCommand() {
        if(nextCommand.getCommandType() != GameCommandTypes.MOVE) {
            Command returned = nextCommand;
            nextCommand = null;
            return returned;
        }
        return nextCommand;
    }

    private void repaintBoardCanvas(BoardView view) {
        GraphicsContext gc = boardCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, boardCanvas.getWidth(), boardCanvas.getHeight());
        XY size = view.getSize();

        for(int i = 0, a = 0; i < size.getY() * CELL_SIZE; i += CELL_SIZE, a++) {
            for(int j = 0, b = 0; j < size.getX() * CELL_SIZE; j += CELL_SIZE, b++) {
                switch(view.getEntityType(b, a)) {
                    case WALL:
                        gc.setFill(Color.DARKSLATEGRAY);
                        gc.fillRect(j, i, CELL_SIZE, CELL_SIZE);
                        break;
                    case BAD_BEAST:
                        gc.setFill(Color.RED);
                        gc.fillOval(j, i, CELL_SIZE, CELL_SIZE);
                        break;
                    case BAD_PLANT:
                        gc.setFill(Color.RED);
                        gc.fillRect(j, i, CELL_SIZE, CELL_SIZE);
                        break;
                    case GOOD_BEAST:
                        gc.setFill(Color.LAWNGREEN);
                        gc.fillOval(j, i, CELL_SIZE, CELL_SIZE);
                        break;
                    case GOOD_PLANT:
                        gc.setFill(Color.LAWNGREEN);
                        gc.fillRect(j, i, CELL_SIZE, CELL_SIZE);
                        break;
                    case MASTER_SQUIRREL:
                        gc.setFill(Color.BLUE);
                        gc.fillOval(j, i, CELL_SIZE, CELL_SIZE);
                        break;
                    case MINI_SQUIRREL:
                        gc.setFill(Color.AQUA);
                        gc.fillOval(j, i, CELL_SIZE, CELL_SIZE);
                        break;
                    case NONE:
                        break;
                    default:
                        break;
                }
            }
        }
    }


    public void message(final String msg) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                msgLabel.setText(msg);
            }
        });
    }
}
