//Dean Mason
//Unit 1

import org.junit.jupiter.api.Test;
import java.awt.Point;
import static org.junit.Assert.*;

/**
 * Test case for oval class
 * @author Dean Mason
 * @version 1.1
 */
public class OvalTest {
    @Test
    public void testOval(){
        Point point1 = new Point(2,2);
        Point point2 = new Point(3,3);
        Oval o = new Oval(point1, point2, 2.5, 10, 10);
        assertEquals(point1, o.getPoint1());
        assertEquals(point2, o.getPoint2());
        assertEquals(2.5, o.getColor(), 0.00001);

        Point setPoint1 = new Point(5,5);
        Point setPoint2 = new Point(10,10);
        double newColor = 10.5;
        o.setColor(newColor);
        o.setPoint1(setPoint1);
        o.setPoint2(setPoint2);
        assertEquals(setPoint1, o.getPoint1());
        assertEquals(setPoint2, o.getPoint2());
        assertEquals(newColor, o.getColor(), 0.00001);

        /**
         * This tests for all cases, it includes setting new points and colors and works without error
         */

    }


}
