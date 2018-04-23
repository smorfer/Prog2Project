package ui.CommandHandler;

import ui.MoveCommand;

import java.util.Arrays;

public enum GameCommandTypes implements CommandTypeInfo{

    HELP("help", "help", " \t \t \t* list all commands"),
    EXIT("exit", "exit", " \t \t \t* exit program"),
    ALL("all" , "all"," \t \t \t* not useful for now"),
    MOVE("move", "move", " \t\t\t* <direction> moves in direction", String.class),
    MASTER_ENERGY("master_energy", "getMasterEnergy", " \t* get energy of MasterSquirrel"),
    SPAWN_MINI("spawn_mini", "spawnMiniSquirrel", " \t* <energy> spawns a mini squirrel", String.class);



    private String name;
    private String helpText;
    private Class<?> [] paramTypes;
    private String methodName;


    GameCommandTypes(String name, String methodName, String helpText, Class<?>... paramTypes) {
        this.name = name;
        this.helpText = helpText;
        this.paramTypes = paramTypes;
        this.methodName = methodName;
    }



    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getHelpText() {
        return helpText;
    }

    @Override
    public Class<?>[] getParamTypes() {
        return paramTypes;
    }

    @Override
    public String toString() {
        return name + " " + helpText;
    }

    public String getMethodName() {
        return methodName;
    }
}
