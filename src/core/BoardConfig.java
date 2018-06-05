package core;

public class BoardConfig {

    private static final int SIZE = 50;
    public int BADBEAST_QUANTITY = 5;
    public int GOODBEAST_QUANTITY = 5;
    public int BADPLANT_QUANTITY = 10;
    public int GOODPLANT_QUANTITY = 10;
    public int BORDER = SIZE*4 - 4;
    public int WALL_QUANTITY = 30; //Ignoring borders
    public int MASTERSQUIRREL_QUANTITY = 1;
    public int MINISQUIRREL_QUANTITY = 8;
    public int ENTITY_QUANTITY = BADBEAST_QUANTITY +
            GOODBEAST_QUANTITY +
            BADPLANT_QUANTITY +
            GOODPLANT_QUANTITY +
            BORDER +
            WALL_QUANTITY +
            MASTERSQUIRREL_QUANTITY +
            MINISQUIRREL_QUANTITY;

    private int FPS = 30;
    private int REFRESH_RATE = 5;

    public int getFPS() {
        return FPS;
    }

    public int getRefreshRate() {
        return REFRESH_RATE;
    }

    public int getSize(){
        return SIZE;
    }

}
