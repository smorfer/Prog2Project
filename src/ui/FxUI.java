package ui;

import core.BoardView;
import geom.XY;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import ui.CommandHandler.Command;
import ui.CommandHandler.GameCommandTypes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FxUI extends Scene implements UI {

    private static boolean fxDebugMode = false;

    private static int CELL_SIZE = 30;
    private static Command nextCommand = null;

    private Image masterImg;
    private Image miniImg;
    private Image goodBeastImg;
    private Image badBeastImg;
    private Image goodPlantImg;
    private Image badPlantImg;
    private Image wallImg;

    private Canvas boardCanvas;
    private Label msgLabel;

    private FxUI(Parent parent, Canvas boardCanvas, Label msgLabel) {
        super(parent);
        this.boardCanvas = boardCanvas;
        this.msgLabel = msgLabel;
        loadIconsFromFile();
    }

    public static FxUI createInstance(int size) {
        Canvas boardCanvas = new Canvas(size * CELL_SIZE, size * CELL_SIZE);
        Label statusLabel = new Label();
        VBox top = new VBox();
        top.getChildren().add(boardCanvas);
        top.getChildren().add(statusLabel);
        //This code belongs to Samuel Glogger and Luis Schweigard
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
                    System.exit(0);
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

        for(int i = 0, a = 0; i < size.y * CELL_SIZE; i += CELL_SIZE, a++) {
            for(int j = 0, b = 0; j < size.x * CELL_SIZE; j += CELL_SIZE, b++) {
                switch(view.getEntityType(b, a)) {
                    case WALL:
                        gc.drawImage(wallImg, j, i);
                        break;
                    case BAD_BEAST:
                        gc.drawImage(badBeastImg, j, i);
                        break;
                    case BAD_PLANT:
                        gc.drawImage(badPlantImg, j, i);
                        break;
                    case GOOD_BEAST:
                        gc.drawImage(goodBeastImg, j, i);
                        break;
                    case GOOD_PLANT:
                        gc.drawImage(goodPlantImg, j, i);
                        break;
                    case MASTER_SQUIRREL:
                        gc.drawImage(masterImg, j, i);

                        if (fxDebugMode) {
                            gc.setFill(Color.rgb(0,0,255,0.2));
                            gc.fillRect(j-15*CELL_SIZE, i-15*CELL_SIZE,31*CELL_SIZE,31*CELL_SIZE);
                        }
                        break;
                    case MINI_SQUIRREL:
                        gc.drawImage(miniImg, j, i);
                        //Not useful right now
                        if (false) {
                            gc.setFill(Color.rgb(0,0,255,0.2));
                            gc.fillRect(j-10*CELL_SIZE, i-10*CELL_SIZE,21*CELL_SIZE,21*CELL_SIZE);
                        }
                        break;
                    case NONE:
                        break;
                    default:
                        break;
                }
            }
        }
    }


    private void loadIconsFromFile() {
        try {
            masterImg = new Image(new FileInputStream("icons/squirrelMaster.png"), CELL_SIZE, CELL_SIZE, false, false);
            wallImg = new Image(new FileInputStream("icons/wall.png"), CELL_SIZE, CELL_SIZE, false, false);
            goodBeastImg = new Image(new FileInputStream("icons/cat.png"), CELL_SIZE, CELL_SIZE, false, false);
            goodPlantImg = new Image(new FileInputStream("icons/peach.png"), CELL_SIZE, CELL_SIZE, false, false);
            badBeastImg = new Image(new FileInputStream("icons/snake.png"), CELL_SIZE, CELL_SIZE, false, false);
            badPlantImg = new Image(new FileInputStream("icons/fliegenpilz.png"), CELL_SIZE, CELL_SIZE, false, false);
            miniImg = new Image(new FileInputStream("icons/squirrelMini.png"), CELL_SIZE, CELL_SIZE, false, false);
        } catch (FileNotFoundException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Could not find the specified image to load");
            e.printStackTrace();
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
