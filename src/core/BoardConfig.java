package core;

public class BoardConfig {
     static final int SIZE = 25;
     static final int BADBEAST_QUANTITY = 2;
     static final int GOODBEAST_QUANTITY = 3;
     static final int BADPLANT_QUANTITY = 3;
     static final int GOODPLANT_QUANTITY = 3;
     static final int BORDER = SIZE*4 - 4;
     static final int WALL_QUANTITY = 2; //Ignoring borders
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

    public static int getSize(){
        return SIZE;
    }

}
