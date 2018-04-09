package core;

public class BoardConfig {
    protected static final int SIZE = 5;
    protected static final int BADBEAST_QUANTITY = 0;
    protected static final int GOODBEAST_QUANTITY = 0;
    protected static final int BADPLANT_QUANTITY = 0;
    protected static final int GOODPLANT_QUANTITY = 0;
    protected static final int BORDER = SIZE*4 - 4;
    protected static final int WALL_QUANTITY = BORDER + 0; //Ignoring borders
    protected static final int MASTERSQUIRREL_QUANTITY = 1;
    protected static final int ENTITY_QUANTITY = BADBEAST_QUANTITY +
            GOODBEAST_QUANTITY +
            BADPLANT_QUANTITY +
            GOODPLANT_QUANTITY +
            WALL_QUANTITY +
            MASTERSQUIRREL_QUANTITY;

}
