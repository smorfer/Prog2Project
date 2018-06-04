package core;

public class BoardConfig {
     private static final int SIZE = 80;
     static final int BADBEAST_QUANTITY = 10;
     static final int GOODBEAST_QUANTITY = 15;
     static final int BADPLANT_QUANTITY = 20;
     static final int GOODPLANT_QUANTITY = 15;
     static final int BORDER = SIZE*4 - 4;
     static final int WALL_QUANTITY = 30; //Ignoring borders
     static final int MASTERSQUIRREL_QUANTITY = 1;
     static final int MINISQUIRREL_QUANTITY = 8;
     static final int ENTITY_QUANTITY = BADBEAST_QUANTITY +
            GOODBEAST_QUANTITY +
            BADPLANT_QUANTITY +
            GOODPLANT_QUANTITY +
            BORDER +
            WALL_QUANTITY +
            MASTERSQUIRREL_QUANTITY +
            MINISQUIRREL_QUANTITY;

    private static final int FPS = 30;
    private static final int REFRESH_RATE = 5;

    public static int getFPS() {
        return FPS;
    }

    public static int getRefreshRate() {
        return REFRESH_RATE;
    }

    public static int getSize(){
        return SIZE;
    }

}
