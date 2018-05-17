package test;

import geom.XY;
import geom.XYSupport;
import org.junit.*;
import static org.junit.Assert.*;

public class XYTest {

    private XY xy1;

    @Before
    public void setupTest(){
        xy1 = new XY(2,2);
    }

    @Test
    public void testPlusTest(){
        assertNotEquals(xy1, xy1.plus(xy1));
    }

    @Test
    public void testMinusTest(){
        assertNotEquals(xy1, xy1.minus(xy1));
    }

    @Test
    public void testTimesTest(){
        XY solution = new XY(8,8);
        assertEquals(xy1.times(4), solution);
    }

    @Test
    public void lengthTest(){
        double length = Math.sqrt(Math.pow(xy1.x, 2)+ Math.pow(xy1.y, 2));
        assertEquals(length, xy1.length(), 1/Double.MAX_VALUE);
    }

    @Test
    public void distanceFromTest(){
        XY origin = new XY(0,0);
        assertEquals(xy1.length(), xy1.distanceFrom(origin), 1/Double.MAX_VALUE);
    }

    @Test
    public void equalsTest(){
        XY xy2 = new XY(xy1.x, xy1.y);
        XY xy3 = xy1.times(3);
        assertEquals(xy1, xy2);
        assertNotEquals(xy1, xy3);
    }

    @Test
    public void hashCodeTest(){
        assertEquals(0, xy1.hashCode());
    }


}
