import java.awt.*;
import java.util.ArrayList;

public class Cave {
    private int depth;
    private final CaveCell[][] fullGrid;
    private int nextStep;
    private final int depthRating;
    private final CaveDrawing caveInfo;
    private final GUI gui;
    private final boolean[][] checked = new boolean[10][10];

    public Cave(int depthRating, CaveDrawing caveInfo, GUI gui) {
        //this.depthRating = depthRating;
        this.caveInfo = caveInfo;
        this.gui = gui;
        this.depthRating = depthRating;
        this.fullGrid = caveInfo.getCellCoord();
    }

    public void tryToSolve(){
        caveInfo.resetForAttempt();
        ArrayList<Point> pathAttempt = new ArrayList<>();
        boolean[][] checked = new boolean[10][10];
        recursiveSolution(0,0,0, checked, pathAttempt);
    }

    public boolean recursiveSolution(int row, int column, int movesMade, boolean[][] checked, ArrayList<Point> pathAttempt){
        if ((row < 0) || (row >= 10) || (column < 0) || (column >= 10)){
            return false;
        }
        else if (checked[row][column]){
            return false;
        }
        else if (movesMade > 20){
            return false;
        }
        depth = caveInfo.getCaveCellDepth(row, column);
        if (depthRating < depth){
            return false;
        }

        int movesNeeded = Math.abs(9 - row) + Math.abs(9-column);
        if ((movesNeeded + movesMade) > 20){
            return false;
        }
        if ((row == 9) && (column == 9)) {
            pathAttempt.add(new Point(row, column));
            caveInfo.drawWinningSolution(pathAttempt);
            return true;
        }

        checked[row][column] = true;
        pathAttempt.add(new Point(row, column));

        int[][] directions = {
                {0,1}, {1,0}, {0,-1}, {-1,0}
        };

        for (int[] newDir : directions){
            int newRow = row + newDir[0];
            int newCol = column + newDir[1];

            if (recursiveSolution(newRow, newCol, movesMade + 1, checked, pathAttempt)){
                return true;
            }
        }

        checked[row][column] = false;
        pathAttempt.removeLast();

        return false;

    }


}
