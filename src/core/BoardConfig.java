package core;

public class BoardConfig {
    protected static final int SIZE = 15;
    protected static final int BADBEAST_QUANTITY = 2;
    protected static final int GOODBEAST_QUANTITY = 3;
    protected static final int BADPLANT_QUANTITY = 3;
    protected static final int GOODPLANT_QUANTITY = 3;
    protected static final int BORDER = SIZE*4 - 4;
    protected static final int WALL_QUANTITY = 7; //Ignoring borders
    protected static final int MASTERSQUIRREL_QUANTITY = 1;
    protected static final int MINISQUIRREL_QUANTITY = 8;
    protected static final int ENTITY_QUANTITY = BADBEAST_QUANTITY +
            GOODBEAST_QUANTITY +
            BADPLANT_QUANTITY +
            GOODPLANT_QUANTITY +
            BORDER +
            WALL_QUANTITY +
            MASTERSQUIRREL_QUANTITY +
            MINISQUIRREL_QUANTITY;

}
