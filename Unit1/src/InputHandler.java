import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class InputHandler extends MouseAdapter implements KeyListener {
    private int beginMouseX;
    private int endMouseX;
    private int beginMouseY;
    private int endMouseY;
    private boolean dragging = false;
    private Shapes shape = Shapes.LINE;
    private boolean trails = false;
    private Color currentColor = Color.BLACK;
    private char whichKey;
    private final DrawingPane pane;


    /**
     * Constructor, sets drawing pane up
     * @param newPane
     */
    public InputHandler(DrawingPane newPane){
        this.pane = newPane;
    }

    /**
     * Mouse pressed override
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e){
        beginMouseX = e.getX();
        beginMouseY = e.getY();
        dragging = true;
        pane.beginShape(beginMouseX, beginMouseY, shape, currentColor);
    }

    /**
     * Mouse released override
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e){
        endMouseX = e.getX();
        endMouseY = e.getY();
        dragging = false;
    }

    /**
     * Mouse dragged override
     * @param e the event to be processed
     */
    @Override
    public void mouseDragged(MouseEvent e){
        endMouseX = e.getX();
        endMouseY = e.getY();
        dragging = true;

        if (!trails){
            pane.updateShape(endMouseX, endMouseY);
        }
        else if (trails) {
            pane.beginShape(endMouseX, endMouseY, shape, currentColor);
            beginMouseX = endMouseX;
            beginMouseY = endMouseY;
        }

    }

    /**
     * Returns the x value when mouse press occurs
     * @return
     */
    public int getBeginMouseX(){
        return beginMouseX;
    }

    /**
     * @return x value when mouse pressed
     */
    public int getBeginMouseY(){
        return beginMouseY;
    }

    /**
     * @return x value when mouse is released
     */
    public int getEndMouseX(){
        return endMouseX;
    }

    /**
     * @return y value when mouse is released
     */
    public int getEndMouseY(){
        return endMouseY;
    }

    /**
     * @return if mouse is still being dragged
     */
    public boolean isDragging(){
        return dragging;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Not necessary
    }

    /**
     * Converts character to uppercase to be used in
     * switch statement for drawing
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        whichKey = Character.toUpperCase(e.getKeyChar());

        switch(whichKey){
            case 'E':
                pane.clearPane();
                break;
            case 'T':
                trails = !trails;
                break;
            case 'L':
                shape = Shapes.LINE;
                break;
            case 'B':
                shape = Shapes.BOX;
                break;
            case 'O':
                shape = Shapes.OVAL;
                break;
            case 'C':
                Color choice = JColorChooser.showDialog(null, "Select a color!", currentColor);
                currentColor = choice;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Not necessary
    }

    /**
     * @return Which key was pressed
     */
    public char getWhichKey() {
        return whichKey;
    }

    /**
     * @return Which shape is being used currently
     */
    public Shapes getShape() {
        return shape;
    }

    public boolean isTrails() {
        return trails;
    }
}
