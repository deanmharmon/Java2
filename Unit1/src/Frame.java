import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {

    final int FRAME_WIDTH = 600;
    final int FRAME_HEIGHT = 800;
    String frameName = "Simple Drawing";
    private InputHandler mouse;
    private InputHandler keyboard;


    public Frame() {
        setTitle(frameName);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawingPane drawingPanel = new DrawingPane();
        InputHandler mouse = new InputHandler(drawingPanel);
        drawingPanel.addMouseListener(mouse);
        drawingPanel.addMouseMotionListener(mouse);
        drawingPanel.setFocusable(true);
        drawingPanel.addKeyListener(mouse);


        JLabel bottomText = new JLabel("(E)rase (T)rails (L)ine (B)ox (O)val (C)olor");
        //JPanel textPanel = new JPanel();
        bottomText.setHorizontalAlignment(SwingConstants.CENTER);
        setLayout(new BorderLayout());
        add(bottomText, BorderLayout.SOUTH);
        add(drawingPanel, BorderLayout.CENTER);


        setVisible(true);
    }




}
