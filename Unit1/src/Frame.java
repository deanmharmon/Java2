//Dean Mason
//Unit 2

import javax.swing.*;
import java.awt.*;

/**
 * Frame extends JFrame, setting up what out drawing pane will be placed inside,
 * as well as putting relevant user information onto the screen
 * @author Dean Mason
 * @version 2.0
 */
public class Frame extends JFrame {

    final int FRAME_WIDTH = 900;
    final int FRAME_HEIGHT = 800;
    String frameName = "Simple Drawing Application";

    /**
     * Constructor that sets everything up
     */
    public Frame() {

        /* Standard JFrame opening lines */
        setTitle(frameName);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Instantiating DrawingPlane */
        DrawingPane drawingPanel = new DrawingPane();
        /* Instantiating InputHandler */
        InputHandler mouse = new InputHandler(drawingPanel);
        /* Adding the mouse listener and mouse motion listener to our drawing panel */
        drawingPanel.addMouseListener(mouse);
        drawingPanel.addMouseMotionListener(mouse);
        /* Adding a key listener for keyboard input */
        drawingPanel.setFocusable(true);
        drawingPanel.addKeyListener(mouse);


        JLabel bottomText = new JLabel("(E)rase (T)rails (L)ine (B)ox (O)val (C)olor");
        /* Aligning our text */
        bottomText.setHorizontalAlignment(SwingConstants.CENTER);
        /* Border layout is a very easy to use way to set it up */
        setLayout(new BorderLayout());
        add(bottomText, BorderLayout.SOUTH);
        add(drawingPanel, BorderLayout.CENTER);

        /* Makes the whole thing show on the screen */
        setVisible(true);
    }




}
