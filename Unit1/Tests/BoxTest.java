//Dean Mason
//Unit 1

import org.junit.jupiter.api.Test;
import java.awt.Point;
import static org.junit.Assert.*;

/**
 * Test for box class
 * @author Dean Mason
 * @version 1.1
 */
public class BoxTest {
    @Test
    public void testBox(){
        Point point1 = new Point(1,1);
        Point point2 = new Point(2,2);
        double color = 1.4;
        Box b = new Box(point1, point2, color);
        assertEquals(point1, b.getPoint1());
        assertEquals(point2, b.getPoint2());
        assertEquals(color, b.getColor(), 0.0001);

        double newColor = 15.3;
        Point newPoint1 = new Point(12,12);
        Point newPoint2 = new Point(5,20);
        b.setPoint1(newPoint1);
        b.setPoint2(newPoint2);
        b.setColor(newColor);
        assertEquals(newPoint1, b.getPoint1());
        assertEquals(newPoint2, b.getPoint2());
        assertEquals(newColor, b.getColor(), 0.0001);

        /**
         * Done as one test, tests for setting all variables and verifying that the ones returned are correct
         */

    }
}
