package geom;

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
}
