//Dean Mason
//Unit1

import java.awt.*;

/**
 * Shape is an abstract class to be used by individual shapes
 * @author Dean Mason
 * @version 1.1
 */
public abstract class Shape {
    /** First point*/
    private Point point1;
    /** Second point*/
    private Point point2;
    /** Color value*/
    private double color;

    /**
     * Constructor for Shape, will initialize instance vars
     * with given values
     * @param point1 given first point
     * @param point2 given second point
     * @param color given color
     */
    public Shape(Point point1, Point point2, double color){
        this.point1 = point1;
        this.point2 = point2;
        this.color = color;

    }
    /**
     * The graphics method is used to draw shapes
     * Abstract because it will not be used from this class~
     * @param g Graphics object to be used
     */
    public abstract void draw(Graphics g);

    /**
     * Returns the first point value
     * @return point1 value
     */
    public Point getPoint1(){
        return point1;
    }

    /**
     * Sets point1 value
     * @param newPoint1 new value for point1
     */
    public void setPoint1(Point newPoint1){
        point1 = newPoint1;
    }

    /**
     * Returns second point
     * @return point2
     */
    public Point getPoint2(){
        return point2;
    }

    /**
     * Sets new point2
     * @param newPoint2 the new value for point2
     */
    public void setPoint2(Point newPoint2){
        point2 = newPoint2;
    }

    /**
     * Returns color value
     * @return color
     */
    public double getColor(){
        return color;
    }

    /**
     * Sets the color value
     * @param newColor new color
     */
    public void setColor(double newColor){
        color = newColor;
    }

}
