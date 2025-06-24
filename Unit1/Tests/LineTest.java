//Dean Mason
//Unit 2
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Test for line class
 * @author Dean Mason
 * @version 1.1
 */
public class LineTest {
    @Test
    public void testLine(){
        Point point1 = new Point(2,5);
        Point point2 = new Point(7,10);
        Color color = new Color(12, 24, 0);
        Line l = new Line(point1, point2, color);
        assertEquals(point1, l.getPoint1());
        assertEquals(point2, l.getPoint2());
        assertEquals(color, l.getColor());

        Point newPoint1 = new Point(12,50);
        Point newPoint2 = new Point(10,20);
        Color newColor = new Color(100, 12, 0);
        l.setColor(newColor);
        l.setPoint1(newPoint1);
        l.setPoint2(newPoint2);
        assertEquals(newPoint1, l.getPoint1());
        assertEquals(newPoint2, l.getPoint2());
        assertEquals(newColor, l.getColor());
        /**
         * This runs the test for initializing class as well as setting new points and color
         */

    }

}
