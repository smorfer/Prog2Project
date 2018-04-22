package ui.CommandHandler;

public enum GameCommandTypes implements CommandTypeInfo{

    HELP("help", "  * list all commands"),
    EXIT("exit", "  * exit program"),
    ALL("all" , "  * not useful for now"),
    DOWN_LEFT("down_left", "  * MasterSquirrel moves down left"),
    DOWN("down", "  * MasterSquirrel moves down"),
    DOWN_RIGHT("down_right", "  * MasterSquirrel moves down right"),
    LEFT("left", "  * MasterSquirrel moves left"),
    RIGHT("right", "  * MasterSquirrel moves right"),
    UP_LEFT("up_left", "  * MasterSquirrel moves up left"),
    UP("up", "  * MasterSquirrel moves up"),
    UP_RIGHT("up_right", "  * MasterSquirrel moves up right"),
    MASTER_ENERGY("master_energy", "  * get energy of MasterSquirrel"),		
    SPAWN_MINI("spawn_mini", "  * spawn a MiniSquirrel"),
    DO_NOTHING("none", "  * MasterSquirrel doesn't move");



    private String name;
    private String helpText;
    private Class<?> [] paramTypes;

    GameCommandTypes(String name, String helpText) {
        this.name = name;
        this.helpText = helpText;
    }

    GameCommandTypes(String name, String helpText, Class<?> param1, Class<?> param2) {
        this.name = name;
        this.helpText = helpText;
        this.paramTypes = new Class<?>[] {param1, param2};

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
        if(paramTypes == null) {
            return this.name + this.helpText + "\n";
        } else {
            return this.name + " " + this.helpText + " param1 type: " + this.paramTypes[0] + " param2 type: " + this.paramTypes[1] + "\n";
        }
    }
}
