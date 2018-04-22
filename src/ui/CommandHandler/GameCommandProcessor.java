package ui.CommandHandler;

import ui.MoveCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class GameCommandProcessor {


    public MoveCommand process(Command command){

        GameCommandTypes commandType = (GameCommandTypes) command.getCommandType();
        Object[] params = command.getParams();

        switch(commandType){
            case EXIT:
                System.exit(0);
            case HELP:
                System.out.println(help());
                return null;
            case ALL:
                System.out.println("No usage found yet");
                return null;
            case DOWN:
                return MoveCommand.DOWN;
                
            case DOWN_LEFT:
                return MoveCommand.DOWN_LEFT;
                
            case DOWN_RIGHT:
                return MoveCommand.DOWN_RIGHT;
                
            case LEFT:
                return MoveCommand.LEFT;
                
            case RIGHT:
                return MoveCommand.RIGHT;
                
            case UP:
                return MoveCommand.UP;
                
            case UP_LEFT:
                return MoveCommand.UP_LEFT;
                
            case UP_RIGHT:
                return MoveCommand.UP_RIGHT;
                
            case DO_NOTHING:
                return MoveCommand.ORIGIN;

            default:
                System.out.println("Unknown command! Use \"help\" to display all commands!");
                return null;

        }


    }

    private static String help(){
        StringBuilder s = new StringBuilder("List of Commands: \n");

        for(CommandTypeInfo e : GameCommandTypes.values()){
            s.append(e.toString());
        }
        return s.toString();
    }
}
