import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class CaveDrawing extends JPanel {
    private final CaveCell[][] cellCoord = new CaveCell[10][10];
    private final JPanel[][] winningGrid = new JPanel[10][10];
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
                winningGrid[row][column] = box;
                JLabel depthNum = new JLabel("" + randInt);
                depthNum.setForeground(Color.WHITE);
                depthNum.setFont(new Font("Arial", Font.PLAIN, 20));
                box.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

                box.setBackground(depthBased(randInt));
                box.add(depthNum);
                add(box);
                System.out.println("row" + row + " " + "column " + column);
            }

        }
    }

    public int getCaveCellDepth(int row, int column){
        return cellCoord[row][column].getDepth();
    }

    public CaveCell[][] getCellCoord(){
        return cellCoord;
    }

    public void drawWinningSolution(ArrayList<Point> path){
        for (Point point : path) {
            int row = point.x;
            int column = point.y;
            winningGrid[row][column].setBackground(Color.RED);
        }
        repaint();
    }

    public void resetForAttempt(){
        for(int row = 0; row < 10; row++){
            for (int col = 0; col < 10; col++) {
                int depth = cellCoord[row][col].getDepth();
                winningGrid[row][col].setBackground(depthBased(depth));
            }
        }
        repaint();
    }
}
