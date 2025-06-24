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
        int mouseX = 0, mouseY = 0, width = 0, height = 0;
       //TODO- create vars and implement swtichable colors
        g.setColor(Color.GREEN);
        g.drawRect(mouseX, mouseY, width, height);
    }
}
