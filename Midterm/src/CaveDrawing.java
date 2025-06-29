import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CaveDrawing extends JPanel {
    private CaveCell[][] cellCoord = new CaveCell[10][10];
    
    /**
     * Returns a color based on the depth, not the most
     * robust solution, but it works well and can be edited easily
     * @param depth the random num for depth
     * @return the color for the given box
     */
    private Color depthBased(int depth){
        int red = depth * 3;
        int green = depth * 3;
        int blue = 230 - (depth * 23);

        return new Color(red, green, blue);
    }

    public CaveDrawing(){
        setLayout(new GridLayout(10, 10, 0, 0));

        for (int row = 0; row < 10; row++){
            for (int column = 0; column < 10; column++){
                Random random = new Random();
                int randInt = random.nextInt(10) + 1;
                /// This line saves the info to our CaveCell instance
                cellCoord[row][column] = new CaveCell(row, column, randInt);
                JPanel box = new JPanel();
                JLabel depthNum = new JLabel("" + randInt);
                depthNum.setForeground(Color.WHITE);
                depthNum.setFont(new Font("Arial", Font.PLAIN, 20));
                box.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

                box.setBackground(depthBased(randInt));
                box.add(depthNum);
                add(box);
            }

        }
    }
}
