import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputHandle implements ActionListener {
    private JButton escape;
    private JButton newCave;
    private GUI gui;
    private Cave attempt;
    private int depthRating;

    public InputHandle(JButton escape, JButton newCave, GUI gui){
        this.escape = escape;
        this.newCave = newCave;
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == escape){
            int depthRating = gui.getDepthRating();
            attempt = new Cave(depthRating, gui.getCaveGrid(), gui);
            //TODO add recursive func
        }
        else if(e.getSource() == newCave){
            gui.newCave();
        }
    }
}
