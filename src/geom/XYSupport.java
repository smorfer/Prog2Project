package geom;

import ui.MoveCommand;

import java.util.Random;


public class XYSupport {
    public static XY inputToDirection(int selector) {
        switch (selector)
        {
            case 8:
                return XY.UP;
            case 2:
                return XY.DOWN;
            case 6:
                return XY.RIGHT;
            case 4:
                return XY.LEFT;
            case 9:
                return XY.RIGHT_UP;
            case 7:
                return XY.LEFT_UP;
            case 3:
                return XY.RIGHT_DOWN;
            case 1:
                return XY.LEFT_DOWN;
            default:
                return inputToDirection(getRandomNumber());
        }
    }

    public static XY commandToMove(MoveCommand moveCommand)
    {
        switch (moveCommand)
        {
            case UP:
                return XY.UP;
            case DOWN:
                return XY.DOWN;
            case LEFT:
                return XY.LEFT;
            case RIGHT:
                return XY.RIGHT;
            case UP_LEFT:
                return XY.LEFT_UP;
            case UP_RIGHT:
                return XY.RIGHT_UP;
            case DOWN_LEFT:
                return XY.LEFT_DOWN;
            case DOWN_RIGHT:
                return XY.RIGHT_DOWN;
            case ORIGIN:
                return XY.ZERO_ZERO;
            default: return XY.ZERO_ZERO;
        }
    }

    public static XY vectorToTarget(XY loc, XY target){
        return new XY((target.x-loc.x), (target.y - loc.y));
    }


    public static XY normalize(XY vector){

        int x = vector.x;
        int y = vector.y;

        return new XY(normalize(x), normalize(y));

    }

    public static int normalize(int coord){
        if(coord > 0)
            return 1;
        if(coord < 0)
            return -1;
        return 0;
    }

    public static int getRandomNumber(){
        Random rnd = new Random();
        int i = rnd.nextInt(8)+1;

        while(i==5){
            i = rnd.nextInt(8)+1;
        }

        return i;
    }
}
