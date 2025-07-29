//Dean Mason
//Unit 6 Project 6

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.LinkedList;

/**
 * This class is used to handle all input for the program, can be updated later to account for more uses
 * extends MouseAdapter and implements KeyListener
 * @author Dean Mason
 * @version 3.0 - updated to have file saving/loading options
 */
public class InputHandler extends MouseAdapter implements KeyListener {
    /**
     * Variables with well-written names will not be doc'd
     */
    private int beginMouseX;
    private int endMouseX;
    private int beginMouseY;
    private int endMouseY;
    /** Starts us with using a line to draw */
    private Shapes shape = Shapes.LINE;
    private boolean trails = false;
    private Color currentColor = Color.BLACK;
    private final DrawingPane pane;

    /**
     * Constructor, sets drawing pane up
     * @param newPane ^
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
        pane.beginShape(beginMouseX, beginMouseY, shape, currentColor);
    }

    /**
     * Mouse released override, not necessary anymore since I decided to place
     * almost all logic inside mouse dragged for cleaner code
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e){
        endMouseX = e.getX();
        endMouseY = e.getY();
    }

    /**
     * Mouse dragged override, holds logic for using trails or not and when update pane
     * @param e the event to be processed
     */
    @Override
    public void mouseDragged(MouseEvent e){
        endMouseX = e.getX();
        endMouseY = e.getY();

        /// It gives a warning here about condition trail always being true....
        /// But the function of it in app works.
        if (!trails){
            pane.updateShape(endMouseX, endMouseY);
        }
        else if (trails) {
            pane.beginShape(beginMouseX, beginMouseY, shape, currentColor);
            pane.updateShape(endMouseX, endMouseY);
        }

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
        char whichKey = Character.toUpperCase(e.getKeyChar());

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
                //Breaks program if you select cancel in color picker
                if (choice != null) {
                    currentColor = choice;
                }
                break;

            case 'S':
                JFileChooser save = new JFileChooser();
                if (save.showSaveDialog(pane) == JFileChooser.APPROVE_OPTION){
                    File newFile = save.getSelectedFile();
                    Data.save(newFile, pane.getShapesList());
                }
                break;
            case 'R':
                //Try catch needed on this one to prevent running null through setShapesList
                JFileChooser load = new JFileChooser();
                if (load.showOpenDialog(pane) == JFileChooser.APPROVE_OPTION){
                    try {
                        File newFile = load.getSelectedFile();
                        LinkedList<Shape> loadedShapes = Data.load(newFile);
                        if (loadedShapes == null){
                            System.out.println("Incorrect file type loaded");
                        } else {
                            pane.setShapesList(loadedShapes);
                        }
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
                break;
                //No default case is needed because we don't need to handle other input and don't want it to crash
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Not necessary
    }

}
