//Dean Mason
//Midterm

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for handling user input
 */
public class InputHandle implements ActionListener {
    private final JButton escape;
    private final JButton newCave;
    private final GUI gui;

    /**
     * Constructor
     * @param escape button to attempt the cave
     * @param newCave button to redraw a brand-new cave
     * @param gui the GUI object
     */
    public InputHandle(JButton escape, JButton newCave, GUI gui){
        this.escape = escape;
        this.newCave = newCave;
        this.gui = gui;
    }

    /**
     * Called when a button is pressed, determines which one is pressed and then makes the appropriate method calls
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == escape){
            int depthRating = gui.getDepthRating();
            if (depthRating == -1){
                return;
            }
            Cave attempt = new Cave(depthRating, gui.getVisualCave(), gui);
            attempt.tryToSolve();

        }
        else if(e.getSource() == newCave){
            gui.newCave();
        }
    }
}
