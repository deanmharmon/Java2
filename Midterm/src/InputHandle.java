import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputHandle implements ActionListener {
    private final JButton escape;
    private final JButton newCave;
    private final GUI gui;

    public InputHandle(JButton escape, JButton newCave, GUI gui){
        this.escape = escape;
        this.newCave = newCave;
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == escape){

            int depthRating = gui.getDepthRating();
            /// This stops it from running if invalid input is entered
            if (depthRating == -1){
                return;
            }
            Cave attempt = new Cave(depthRating, gui.getCaveGrid(), gui);
            attempt.tryToSolve();

        }
        else if(e.getSource() == newCave){
            gui.newCave();
        }
    }
}
