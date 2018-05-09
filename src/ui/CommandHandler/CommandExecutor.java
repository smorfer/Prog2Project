package ui.CommandHandler;

import core.Board;
import javafx.application.Platform;
import ui.MoveCommand;
import ui.NewWindow;

public class CommandExecutor {

    Board board;

    public CommandExecutor(Board board){
        this.board = board;
    }

    public void move(Object moveString){

        if(moveString instanceof MoveCommand){
            board.nextStep((MoveCommand) moveString);
            return;
        }

        board.nextStep(MoveCommand.parseMoveCommand((String)moveString));
    }

    public void help(){

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                new NewWindow("Help", getHelpText());
            }
        });

    }

    public String getHelpText(){

        StringBuilder sb = new StringBuilder("Help: \n");
        sb.append("Q move up left\n");
        sb.append("W move up\n");
        sb.append("E move up right\n");
        sb.append("A move left\n");
        sb.append("D move right\n");
        sb.append("Y move down left\n");
        sb.append("X move down\n");
        sb.append("C move down right\n");
        sb.append("P spawn MiniSquirrel with 100 energy\n");
        return sb.toString();

    }

    public void exit(){
        System.exit(0);
    }

    public void spawnMiniSquirrel(Object energy){
        board.spawnMiniSquirrel(energy);
    }

    public void getMasterEnergy(){
        System.out.println("getMasterEnergy() in CommandExecutor not implemented yet!");
    }

    public void all(){
        System.out.println("all() in CommandExecutor not implemented yet!");
    }


}
