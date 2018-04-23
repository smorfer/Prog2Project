package ui.CommandHandler;

import ui.MoveCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GameCommandProcessor {


    public void process(Command command) {
        GameCommandTypes commandType = (GameCommandTypes) command.getCommandType();
        Object[] params = command.getParams();
        CommandExecutor commandExecutor = new CommandExecutor();

        try {
            Method method;

            if(params.length == 1){
                method = commandExecutor.getClass().getDeclaredMethod(command.getCommandType().getMethodName(), Object.class);
                method.invoke(commandExecutor, params);
            } else {
                method = commandExecutor.getClass().getDeclaredMethod(command.getCommandType().getMethodName());
                method.invoke(commandExecutor);
            }



        } catch(Exception e){
            System.out.println("Wrong syntax!");
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
