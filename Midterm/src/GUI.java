//Dean Mason
// Midterm

import javax.swing.*;
import java.awt.*;

/**
 * GUI is the main frame for the application
 */
public class GUI extends JFrame {

    final int FRAME_WIDTH = 800;
    final int FRAME_HEIGHT = 600;
    private CaveDrawing visualCave;
    String frameName = "Cave Diver - Find an Escape Route";
    private final JTextField text;

    /**
     * Constructor, completely sets up the visual interface that the player sees
     * A lot of standard swing boilerplate to get it working
     */
    public GUI(){

        setTitle(frameName);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JLabel topText = new JLabel("The diver begins in the upper-left corner and escapes by" +
                " reaching the lower-right corner");
        topText.setFont(new Font("Arial", Font.PLAIN,18));
        JPanel userInput = new JPanel();
        JButton escape = new JButton("Escape");
        JButton newCave = new JButton("New Cave");
        JLabel butLabel = new JLabel("Enter the diver's depth rating: ");
        text = new JTextField(4);

        // Input handling done here for buttons
        InputHandle buttonHandle = new InputHandle(escape, newCave, this);
        escape.addActionListener(buttonHandle);
        newCave.addActionListener(buttonHandle);

        userInput.add(butLabel);
        userInput.add(text);
        userInput.add(escape);
        userInput.add(newCave);

        visualCave = new CaveDrawing();

        /*
        Mostly formatting things in this section to get it to
        look similar to the one shown in the demo video
         */
        setLayout(new BorderLayout());

        topText.setHorizontalAlignment(SwingConstants.CENTER);
        topText.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        visualCave.setBorder(BorderFactory.createEmptyBorder(20,80,20,80));
        userInput.setBorder(BorderFactory.createEmptyBorder(10,10,30,10));

        add(topText, BorderLayout.NORTH);
        add(visualCave, BorderLayout.CENTER);
        add(userInput, BorderLayout.SOUTH);

        setVisible(true);


    }

    /**
     * Creates a new cave, without destroying the rest of the visuals
     */
    public void newCave(){
        remove(visualCave);
        visualCave = new CaveDrawing();
        visualCave.setBorder(BorderFactory.createEmptyBorder(20,80,20,80));
        add(visualCave, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    /**
     * Validates input for depth rating given by user
     * @return depth rating
     */
    public int getDepthRating() {
        try{
            int depth = Integer.parseInt(text.getText());
            if (depth <= 0) {
                //Found JOptionPane messageDialog online while researching and this is the easiest way to do popups
                JOptionPane.showMessageDialog(this,
                        "You have not entered a positive number, please enter a positive whole number.");
                return -1;
            }
            return depth;

        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid whole number.");
            return -1;
        }
    }

    /**
     * @return CaveDrawing instance
     */
    public CaveDrawing getVisualCave(){
        return visualCave;
    }

    /**
     * Causes message to be displayed if attempt fails
     */
    public void failed(){
        JOptionPane.showMessageDialog(this, "You were not able to escape!");
    }
}
