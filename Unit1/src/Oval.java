//Dean Mason
//Unit 1

import java.awt.*;

/**
 * Oval extends shape, implements the draw method
 * @author Dean Mason
 * @version 1.1
 */
public class Oval extends Shape{

    /** Height of oval */
    private int height;
    /** Width of oval */
    private int width;

    public Oval(Point point1, Point point2, double color, int height, int width){
        super(point1, point2, color);
        this.height = height;
        this.width = width;

    }
    /**
     * Draw method for ovals
     * @param g Graphics object to be used
     */
    @Override
    public void draw(Graphics g) {

    }
}
