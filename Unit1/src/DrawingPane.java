import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Drawing pane
 */
public class DrawingPane extends JComponent {

    private LinkedList<Shape> shapesList = new LinkedList<>();

    public DrawingPane(){
        //
    }

    /**
     * Clears all shapes from linked list
     */
    public void clearPane(){
        shapesList.clear();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int count = 0; count < shapesList.size(); count++) {
            shapesList.get(count).draw(g);
        }
    }

    /**
     * Starts a new shape, doing it this way so
     * that we can have the shapes show as you are dragging cursor
     * @param x1 Beginning x
     * @param y1 Beginning y
     * @param type Line/Box/Oval
     * @param color Color value
     */
    public void beginShape(int x1, int y1, Shapes type, Color color){
        Point start = new Point(x1, y1);
        Shape newShape = null;
        if (type == Shapes.LINE) {
            newShape = new Line(start, start, color);
        }
        else if (type == Shapes.BOX){
            newShape = new Box(start, start, color);
        }
        else if (type == Shapes.OVAL) {
            newShape = new Oval(start, start, color, 0, 0);
        }

        if (newShape != null){
            shapesList.add(newShape);
            repaint();
        }
    }

    public void updateShape(int x2, int y2){
        Point end = new Point(x2,y2);
        shapesList.getLast().setPoint2(new Point(x2, y2));
        repaint();
    }

}