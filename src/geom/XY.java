package geom;

import ui.MoveCommand;

import java.util.Random;

public final class XY {

    private final int X;
    private final int Y;

    public static final XY ORIGIN       = new XY(0, 0);
    public static final XY UP           = new XY(0,-1);
    public static final XY DOWN         = new XY(0,1);
    public static final XY RIGHT        = new XY(1,0);
    public static final XY LEFT         = new XY(-1,0);
    public static final XY UP_RIGHT     = new XY(1,-1);
    public static final XY UP_LEFT      = new XY(-1,-1);
    public static final XY DOWN_RIGHT   = new XY(1,1);
    public static final XY DOWN_LEFT    = new XY(-1, 1);

    public XY(int x, int y) {
        X = x;
        Y = y;
    }

    public XY(XY xy){
        X = xy.getX();
        Y = xy.getY();
    }

    public XY(XY origin, XY direction) {

        int newX = origin.getX() + direction.getX();
        int newY = origin.getY() + direction.getY();
        X = (newX<0) ? 0 : newX;
        Y = (newY<0) ? 0 : newY;

    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public boolean equals(XY location){
        return(this.getX() == location.getX() && this.getY() == location.getY());
    }

    @Override
    public String toString() {
        return "XY{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }

    public static int getRandomNumber(){
        Random rnd = new Random();
        return rnd.nextInt(8)+1;
    }

    public static XY inputToDirection(int selector) {
        switch (selector)
        {
            case 8:
                return UP;
            case 2:
                return DOWN;
            case 6:
                return RIGHT;
            case 4:
                return LEFT;
            case 9:
                return UP_RIGHT;
            case 7:
                return UP_LEFT;
            case 3:
                return DOWN_RIGHT;
            case 1:
                return DOWN_LEFT;
            default:
                return ORIGIN;
        }
    }

    public static XY commandToMove(MoveCommand moveCommand)
    {
        switch (moveCommand)
        {
            case UP:
                return UP;
            case DOWN:
                return DOWN;
            case LEFT:
                return LEFT;
            case RIGHT:
                return RIGHT;
            case UP_LEFT:
                return UP_LEFT;
            case UP_RIGHT:
                return UP_RIGHT;
            case DOWN_LEFT:
                return DOWN_LEFT;
            case DOWN_RIGHT:
                return DOWN_RIGHT;
            case ORIGIN:
                return ORIGIN;
            default: return ORIGIN;
        }
    }

    public static XY vectorToTarget(XY loc, XY target){
        return new XY((target.getX()-loc.getX()), (target.getY() - loc.getY()));
    }

    public static double distanceToTarget(XY vector){
        double x = vector.getX();
        double y = vector.getY();

        return Math.sqrt(Math.pow(x,2f) + Math.pow(y,2f));
    }

    public static XY normalize(XY vector){

        int x = vector.getX();
        int y = vector.getY();

        if(x == 0 && y == 0){
            return ORIGIN;
        }

        if(x == 0){
            return new XY(0, y/Math.abs(y));
        }

        if(y == 0){
            return new XY(x/Math.abs(x), 0);
        }

        if(Math.abs(x) > Math.abs(y)){
            return new XY(x/Math.abs(x),0);
        } else if(Math.abs(x) > Math.abs(y)){
            return new XY(0, y/Math.abs(y));
        } else{
            return new XY(x/Math.abs(x),y/Math.abs(y));
        }

    }

    public static XY invertVector(XY vector){
        return new XY(-vector.getX(), -vector.getY());
    }
}
