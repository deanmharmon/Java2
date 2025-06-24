//Dean Mason
//Unit 2

import java.awt.*;

/**
 * Line is an extension of shape class, inherits draw method
 * @author Dean Mason
 * @version 2.0
 */
public class Line extends Shape{


    public Line(Point point1, Point point2, Color color){
        super(point1, point2, color);
    }
    /**
     * Draw method for lines, much simpler than doing it for boxes/ovals so the method for getpoint is passed
     * directly into it rather than assigned to another var
     * @param g Graphics object to be used
     */
    @Override
    public void draw (Graphics g){
        g.setColor(getColor());
        g.drawLine(getPoint1().x, getPoint1().y, getPoint2().x, getPoint2().y);
    }

}
