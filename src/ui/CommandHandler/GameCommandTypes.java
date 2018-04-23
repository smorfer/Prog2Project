package ui.CommandHandler;

import java.util.Arrays;

public enum GameCommandTypes implements CommandTypeInfo{

    HELP("help", "help", " \t \t \t* list all commands"),
    EXIT("exit", "exit", " \t \t \t* exit program"),
    ALL("all" , "all"," \t \t \t* not useful for now"),
    DOWN_LEFT("down_left", "nextStep", " \t \t* MasterSquirrel moves down left"),
    DOWN("down", "nextStep", " \t \t \t* MasterSquirrel moves down"),
    DOWN_RIGHT("down_right", "nextStep", " \t* MasterSquirrel moves down right"),
    LEFT("left", "nextStep", " \t\t \t* MasterSquirrel moves left"),
    RIGHT("right", "nextStep", " \t \t \t* MasterSquirrel moves right"),
    UP_LEFT("up_left", "nextStep", " \t \t* MasterSquirrel moves up left"),
    UP("up", "nextStep", " \t \t \t* MasterSquirrel moves up"),
    UP_RIGHT("up_right", "nextStep", " \t \t* MasterSquirrel moves up right"),
    MASTER_ENERGY("master_energy", "getMasterEnergy", " \t* get energy of MasterSquirrel"),
    SPAWN_MINI("spawnMini", "spawnMiniSquirrel", " \t \t* <energy> spawns a mini squirrel", int.class), //TODO: This is not recognized yet
    DO_NOTHING("do_nothing", "nextStep", " \t* not useful right now");





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
