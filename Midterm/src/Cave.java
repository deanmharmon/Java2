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
        caveInfo.reset();
        ArrayList<Point> pathAttempt = new ArrayList<>();
        boolean[][] checked = new boolean[10][10];
        if (!escape(0,0,0, checked, pathAttempt)){
            gui.failedPopup();
        }

    }

    public boolean escape(int row, int column, int breath, boolean[][] checked, ArrayList<Point> pathAttempt){

        if ((row < 0) || (row >= 10) || (column < 0) || (column >= 10)){
            return false;
        }

        if (checked[row][column]){
            return false;
        }

        if (breath < 0){
            return false;
        }


        int depth = caveInfo.getCaveCellDepth(row, column);
        if (depthRating < depth){
            return false;
        }


        if ((row == 9) && (column == 9)) {
            pathAttempt.add(new Point(row, column));
            caveInfo.drawWin(pathAttempt);
            System.out.println("Row" + row + "Column " + column);
            return true;
        }

        //marks path
        checked[row][column] = true;
        pathAttempt.add(new Point(row, column));

        int[][] directions = {
                {0, 1}, {1, 0}, {0, -1}, {-1,0}
        };
        int right = 1;
        int down = 0;
        int up = 0;
        int left = 1;


        for (int[] value : directions){
            int newRow = row + value[0];
            int newColumn = column + value[1];

            if (escape(newRow, newColumn, breath - 1, checked, pathAttempt)){
                return true;
            }
        }

        checked[row][column] = false;
        pathAttempt.removeLast();

        return false;

    }


}
