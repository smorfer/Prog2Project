package ui.CommandHandler;

import core.Board;
import ui.MoveCommand;

public class CommandExecutor {

    Board board;

    public CommandExecutor(Board board){
        this.board = board;
    }

    public void move(Object moveString){
        board.nextStep(MoveCommand.parseMoveCommand((String)moveString));
    }

    public void help(){
        StringBuilder str = new StringBuilder("List of commands: \n");

        for(GameCommandTypes type : GameCommandTypes.values()){
            str.append(type.toString());
            str.append("\n");
        }

        System.out.println(str);
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
