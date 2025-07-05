import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    final int FRAME_WIDTH = 800;
    final int FRAME_HEIGHT = 600;
    private CaveDrawing caveGrid;
    String frameName = "Cave Diver - Find an Escape Route";
    private final JTextField textInp;

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
        textInp = new JTextField(4);

        /// Input handling done here for buttons
        InputHandle buttonHandle = new InputHandle(escape, newCave, this);
        escape.addActionListener(buttonHandle);
        newCave.addActionListener(buttonHandle);

        userInput.add(butLabel);
        userInput.add(textInp);
        userInput.add(escape);
        userInput.add(newCave);

        caveGrid = new CaveDrawing();


        /*
        Mostly formatting things in this section to get it to
        look similar to the one shown in the demo video
         */
        setLayout(new BorderLayout());
        topText.setHorizontalAlignment(SwingConstants.CENTER);
        topText.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        caveGrid.setBorder(BorderFactory.createEmptyBorder(20,80,20,80));
        userInput.setBorder(BorderFactory.createEmptyBorder(10,10,30,10));
        //First add puts the instructions
        add(topText, BorderLayout.NORTH);
        //Second add puts the caveGrid on;
        add(caveGrid, BorderLayout.CENTER);
        //Third adds the user input section at the bottom
        add(userInput, BorderLayout.SOUTH);

        setVisible(true);


    }

    public void newCave(){
        remove(caveGrid);
        caveGrid = new CaveDrawing();
        caveGrid.setBorder(BorderFactory.createEmptyBorder(20,80,20,80));
        add(caveGrid, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public int getDepthRating() {
        try{
            int depth = Integer.parseInt(textInp.getText());

            if (depth <= 0) {
                JOptionPane.showMessageDialog(this,
                        "You have not entered a positive number, please enter a positive integer.");
                return -1;
            }
            return depth;
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid integer.");
            return -1;
        }
    }

    public CaveDrawing getCaveGrid(){
        return caveGrid;
    }

    public void failedPopup(){
        JOptionPane.showMessageDialog(this, "You were not able to escape!");
    }
}
