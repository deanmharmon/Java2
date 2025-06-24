//Dean Mason
//Unit 2

import java.awt.*;

/**
 * Box is an extension of Shape, implements draw method
 * @author Dean Mason
 * @version 2.0
 */
public class Box extends Shape{

    public Box(Point point1, Point point2, Color color){
        super(point1, point2, color);
    }
    /**
     * Draw method for boxes, lot of math for it to be able to work properly
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
        /// Using the abs value here allows it to work
        int width = Math.abs(beginX - endX);
        int height = Math.abs(beginY - endY);
        g.drawRect(originX, originY, width, height);
    }
}
