package geom;


import java.util.Random;

public class XY {

    public final int x;
    public final int y;

    public static final XY ZERO_ZERO = new XY(0, 0);
    public static final XY RIGHT = new XY(1, 0);
    public static final XY LEFT = new XY(-1, 0);
    public static final XY UP = new XY(0, -1);
    public static final XY DOWN = new XY(0, 1);
    public static final XY RIGHT_UP = new XY(1, -1);
    public static final XY RIGHT_DOWN = new XY(1, 1);
    public static final XY LEFT_UP = new XY(-1, -1);
    public static final XY LEFT_DOWN = new XY(-1, 1);

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public XY plus(XY xy) {
        return new XY(this.x + xy.x, this.y + xy.y);
    }

    public XY minus(XY xy) {
        return new XY(this.x -xy.x, this.y -xy.y);
    }


    public XY times(int factor) {
        return new XY(this.x * factor, this.y * factor);
    }

    public double length() {
        return Math.sqrt(Math.pow(x,2f) + Math.pow(y,2f));
    }

    /**
     *
     * @param xy a second coordinate pair
     * @return the euklidian distance (pythagoras)
     */
    public double distanceFrom(XY xy) {
        int x = (xy.x - this.x);
        int y = (xy.y - this.y);

        XY distance = new XY(x,y);
        return distance.length();
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public boolean equals(Object obj) {
        if(obj instanceof XY){
            XY loc = (XY)obj;
            return (this.x == loc.x && this.y == loc.y);
        }
        return false;
    }

    @Override
    public String toString() {
        return "XY{" + x + "|" + y + "}";
    }


}
