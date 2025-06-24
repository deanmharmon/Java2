//Dean Mason
//Unit 2

import java.awt.*;

/**
 * Oval extends shape, implements the draw method
 * @author Dean Mason
 * @version 2.0
 */
public class Oval extends Shape{

    /**
     * Constructor for oval class
     * @param point1 first point
     * @param point2 second point
     * @param color color value
     */
    public Oval(Point point1, Point point2, Color color){
        super(point1, point2, color);

    }
    /**
     * Draw method for ovals
     * A lot of math because otherwise it doesn't want to draw when you flip it around
     * @param g Graphics object to be used
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        int beginX = getPoint1().x;
        int beginY = getPoint1().y;
        int endX = getPoint2().x;
        int endY = getPoint2().y;
        int originX = Math.min(beginX, endX);
        int originY = Math.min(beginY, endY);
        /// Using the absolute value prevents the program from trying to figure out how
        /// to draw an oval with negative width or height
        int width = Math.abs(beginX - endX);
        int height = Math.abs(beginY - endY);
        g.drawOval(originX, originY, width, height);
    }
}
