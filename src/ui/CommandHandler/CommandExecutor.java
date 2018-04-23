package ui.CommandHandler;

import ui.MoveCommand;

public class CommandExecutor {


    public void move(Object moveString){
        System.out.println("MoveCommand: " + MoveCommand.parseMoveCommand((String)moveString));
    }

    public void help(){
        StringBuilder str = new StringBuilder("List of commands: \n");

        for(GameCommandTypes type : GameCommandTypes.values()){
            str.append(type.toString());
            str.append("\n");
        }

        System.out.println(str);
    }

    //TODO: Implement all GameCommandType Methods!
    //TODO: Handle MoveCOmmand in Processor (via State)
}
