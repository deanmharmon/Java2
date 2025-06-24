//Dean Mason
//Unit 2

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

    /**
     * Constructor for oval class
     * @param point1 first point
     * @param point2 second point
     * @param color color value
     * @param height height of oval
     * @param width width of oval
     */
    public Oval(Point point1, Point point2, Color color, int height, int width){
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
        int mouseX=0, mouseY=0, width=0, height=0;
        //TODO implement vars and add switchable colors
        g.setColor(Color.GREEN);
        g.drawOval(mouseX, mouseY, width, height);
    }
}
