//Dean Mason
//Unit 1
import org.junit.jupiter.api.Test;
import java.awt.Point;
import static org.junit.Assert.*;

public class LineTest {
    @Test
    public void testLine(){
        Point point1 = new Point(2,5);
        Point point2 = new Point(7,10);
        double color = 12.4;
        Line l = new Line(point1, point2, color);
        assertEquals(point1, l.getPoint1());
        assertEquals(point2, l.getPoint2());
        assertEquals(color, l.getColor());

        Point newPoint1 = new Point(12,50);
        Point newPoint2 = new Point(10,20);
        double newColor = 100.3;
        l.setColor(newColor);
        l.setPoint1(newPoint1);
        l.setPoint2(newPoint2);
        assertEquals(newPoint1, l.getPoint1());
        assertEquals(newPoint2, l.getPoint2());
        assertEquals(newColor, l.getColor(), 0.0001);

    }

}
