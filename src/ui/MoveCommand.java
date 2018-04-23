package ui;

public enum MoveCommand {
    DOWN_LEFT,DOWN_RIGHT,UP_LEFT,UP_RIGHT,LEFT,RIGHT,UP,DOWN,ORIGIN,SPAWN_MINI;

    public static MoveCommand parseMoveCommand(String s) {
        for(MoveCommand mc : MoveCommand.values()) {
            if(s.toLowerCase().equals(mc.name().toLowerCase())) {
                return mc;
            }
        }
        return null;
    }

}
