//Dean Mason
//Unit 2

import java.awt.*;

/**
 * Box is an extension of Shape, implements draw method
 * @author Dean Mason
 * @version 1.1
 */
public class Box extends Shape{

    public Box(Point point1, Point point2, Color color){
        super(point1, point2, color);
    }
    /**
     * Draw method for boxes
     * @param g Graphics object to be used
     */
    @Override
    public void draw(Graphics g) {
        int width = getPoint1().x + getPoint2().x;
        int height = getPoint1().y + getPoint2().y;
        g.setColor(g.getColor());
        g.drawRect(getPoint1().x, getPoint1().y, width, height);
    }
}
