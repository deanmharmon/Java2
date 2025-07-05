//Dean Mason
//Midterm
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * CaveDrawing class is a JPanel object to be placed in the GUI
 */
public class CaveDrawing extends JPanel {
    private final int MAX_SIZE = 10;
    private final CaveCell[][] cell = new CaveCell[MAX_SIZE][MAX_SIZE];
    private final JPanel[][] winningPath = new JPanel[MAX_SIZE][MAX_SIZE];


    /**
     * Returns a color based on the depth, not the most
     * robust solution, but it works well and can be edited easily
     * @param depth the random num for depth
     * @return the color for the given box
     */
    private Color depthBasedColor(int depth){
        int red = depth * 3;
        int green = depth * 3;
        int blue = 230 - (depth * 23);

        return new Color(red, green, blue);
    }

    /**
     * Constructor for the cave grid
     */
    public CaveDrawing(){
        setLayout(new GridLayout(MAX_SIZE, MAX_SIZE, 0, 0));

        for (int x = 0; x < MAX_SIZE; x++){
            for (int y = 0; y < MAX_SIZE; y++){
                Random random = new Random();
                int randInt = random.nextInt(MAX_SIZE) + 1;
                cell[x][y] = new CaveCell(new Point(x, y), randInt);

                JPanel box = new JPanel();
                winningPath[x][y] = box;

                JLabel depthNum = new JLabel("" + randInt);
                depthNum.setForeground(Color.WHITE);
                depthNum.setFont(new Font("Times New Roman", Font.PLAIN, 20));

                box.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
                box.setBackground(depthBasedColor(randInt));
                box.add(depthNum);
                add(box);
                //System.out.println("row" + x + " " + "column " + y);
            }

        }
    }

    /**
     * @param x x-coordinate
     * @param y y- coordinate
     * @return returns the depth shown on screen
     */
    public int getCaveCellDepth(int x, int y){
        return cell[x][y].getDepth();
    }

    /**
     * Draws the winning path on the screen
     * @param path array point for the correct path
     */
    public void drawWin(ArrayList<Point> path){
        for (Point box : path) {
            int x = box.x;
            int y = box.y;
            winningPath[x][y].setBackground(Color.RED);
        }
        repaint();
    }

    /**
     * Resets the cave grid for when you attempt a new one, so that it doesn't overlay multiple
     */
    public void reset(){
        for(int x = 0; x < MAX_SIZE; x++){
            for (int y = 0; y < MAX_SIZE; y++) {
                int depth = cell[x][y].getDepth();
                winningPath[x][y].setBackground(depthBasedColor(depth));
            }
        }

        repaint();
    }
}
