//Dean Mason
//Unit 2

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Drawing pane, handles all graphics for the program
 * @author Dean Mason
 * @version 2.0
 */
public class DrawingPane extends JComponent {

    /** This is the linked list used to store our shape objects, unlike other final things this can still
     * be edited to a certain extent, the final just makes sure it always refers to the same object
     */
    private final LinkedList<Shape> shapesList = new LinkedList<>();

    /**
     * Clears all shapes from linked list, erasing them from pane
     */
    public void clearPane(){
        shapesList.clear();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //Enhanced for loop could be used, but these make more sense/look cleaner to me
        for (int count = 0; count < shapesList.size(); count++) {
            shapesList.get(count).draw(g);
        }
    }

    /**
     * Starts a new shape, doing it this way so
     * that we can have the shapes show as you are dragging cursor
     * @param x1 Beginning x
     * @param y1 Beginning y
     * @param shape Line/Box/Oval
     * @param color Color value
     */
    public void beginShape(int x1, int y1, Shapes shape, Color color){
        Point start = new Point(x1, y1);
        //Only assigning to null because it can cause an error otherwise
        Shape newShape = null;
        if (shape == Shapes.LINE) {
            newShape = new Line(start, start, color);
        }
        else if (shape == Shapes.BOX){
            newShape = new Box(start, start, color);
        }
        else if (shape == Shapes.OVAL) {
            newShape = new Oval(start, start, color);
        }

        if (newShape != null){
            shapesList.add(newShape);
            repaint();
        }
    }

    public void updateShape(int x2, int y2){
        Point end = new Point(x2,y2);
        shapesList.getLast().setPoint2(end);
        repaint();
    }

}