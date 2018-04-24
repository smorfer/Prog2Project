package ui.CommandHandler;

import core.Board;
import exceptions.NotEnoughEnergyException;
import ui.MoveCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GameCommandProcessor {

    private Board board;

    public GameCommandProcessor(Board board){
        this.board = board;
    }


    public void process(Command command) {
        GameCommandTypes commandType = (GameCommandTypes) command.getCommandType();
        Object[] params = command.getParams();
        CommandExecutor commandExecutor = new CommandExecutor(board);
        Method method = null;

        try {


            if(params.length == 1){
                method = commandExecutor.getClass().getDeclaredMethod(command.getCommandType().getMethodName(), Object.class);
                method.invoke(commandExecutor, params);
            } else {
                method = commandExecutor.getClass().getDeclaredMethod(command.getCommandType().getMethodName());
                method.invoke(commandExecutor);
            }



        } catch(Exception e){
            if(method != null) {
                System.out.println("CommandProcessor: Wrong usage of command: <" + command.getCommandType().getName() + "> !");
            } else {
                System.out.println("CommandProcessor: Command can't be null!");
            }
        }

    }

    private String help(){
        StringBuilder s = new StringBuilder("List of Commands: \n");

        for(CommandTypeInfo e : GameCommandTypes.values()){
            s.append(e.toString());
            s.append("\n");
        }
        return s.toString();
    }
}
