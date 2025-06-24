import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {
    final int FRAME_WIDTH = 300;
    final int FRAME_HEIGHT = 400;
    String frameName = "Simple Drawing";

    public Frame() {
        setTitle(frameName);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * This section creates the components used in the program
     */
    public void createComponents(){
        JLabel bottomText = new JLabel("(E)rase (T)rails (L)ine (B)ox (O)val (C)olor");
        JPanel pane = new JPanel();
        pane.add(bottomText);
        add(pane);
    }


}
