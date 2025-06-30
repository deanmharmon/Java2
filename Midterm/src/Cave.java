import java.awt.*;
import java.util.ArrayList;

public class Cave {

    private final int depthRating;
    private final CaveDrawing caveInfo;
    private final GUI gui;


    public Cave(int depthRating, CaveDrawing caveInfo, GUI gui) {
        this.caveInfo = caveInfo;
        this.gui = gui;
        this.depthRating = depthRating;

    }

    public void tryToSolve(){
        caveInfo.resetForAttempt();
        ArrayList<Point> pathAttempt = new ArrayList<>();
        boolean[][] checked = new boolean[10][10];
        if (!recursiveSolution(0,0,0, checked, pathAttempt)){
            gui.failedPopup();
        }

    }

    public boolean recursiveSolution(int row, int column, int movesMade, boolean[][] checked, ArrayList<Point> pathAttempt){
        //First checks if row is outside of possible choices
        if ((row < 0) || (row >= 10) || (column < 0) || (column >= 10)){
            return false;
        }
        //if it has already looked at that row, moves on
        else if (checked[row][column]){
            return false;
        }
        //if you've made too many moves, give up
        else if (movesMade > 20){
            return false;
        }
        //making sure diver can
        int depth = caveInfo.getCaveCellDepth(row, column);
        if (depthRating < depth){
            return false;
        }

        //since starting at 0, once they reach 9 it means we are at the end
        if ((row == 9) && (column == 9)) {
            pathAttempt.add(new Point(row, column));
            caveInfo.drawWinningSolution(pathAttempt);
            System.out.println("Row" + row + "Column " + column);
            return true;
        }

        //for recursion, as it goes back it marks that they have
        //been checked and they're added to the path attempt
        checked[row][column] = true;
        pathAttempt.add(new Point(row, column));

        int[][] directions = {
                // Starting with moving right, then moving down as that is the most
                // efficient way to solve, but still checks all directions
                // Diagonals may be more efficient, but this works after visually testing
                // every cave I have ran
                {0,1}, {1,0}, {0,-1}, {-1,0}
        };

        //this is where it is actually recursive, for every
        for (int[] value : directions){
            int newRow = row + value[0];
            int newColumn = column + value[1];


            if (recursiveSolution(newRow, newColumn, movesMade + 1, checked, pathAttempt)){
                return true;
            }
        }

        checked[row][column] = false;
        pathAttempt.removeLast();

        return false;

    }


}
