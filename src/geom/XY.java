package geom;

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

    public XY(XY origin, XY direction) {
        X = origin.getX() + direction.getX();
        Y = origin.getY() + direction.getY();
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public String toString() {
        return "XY{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }

    public static XY getRandomDirection() {
        int selector = new Random().nextInt(8);
        switch (selector)
        {
            case 0:
                return UP;
            case 1:
                return DOWN;
            case 2:
                return RIGHT;
            case 3:
                return LEFT;
            case 4:
                return UP_RIGHT;
            case 5:
                return UP_LEFT;
            case 6:
                return DOWN_RIGHT;
            case 7:
                return DOWN_LEFT;
            default:
                return ORIGIN;
        }
    }
}
