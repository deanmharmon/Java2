import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputHandle implements ActionListener {
    private final JButton escape;
    private final JButton newCave;
    private final GUI gui;
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
            Cave attempt = new Cave(depthRating, gui.getCaveGrid(), gui);
            //TODO add recursive func
        }
        else if(e.getSource() == newCave){
            gui.newCave();
        }
    }
}
