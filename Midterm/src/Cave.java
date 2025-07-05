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
        if (!escape(new Point(0,0),20, checked, pathAttempt)){
            gui.failed();
        }

    }

    public boolean escape(Point location, int breath, boolean[][] checked, ArrayList<Point> pathAttempt){
        int x = location.x;
        int y = location.y;

        if (((x >= 10) || (y >= 10)) || ((x < 0) || (y < 0))){
            return false;
        }

        if (checked[x][y]){
            return false;
        }

        if (breath < 0){
            return false;
        }


        int depth = caveInfo.getCaveCellDepth(x, y);
        if (depthRating < depth){
            return false;
        }


        if ((x == 9) && (y == 9)) {
            pathAttempt.add(new Point(x, y));
            caveInfo.drawWin(pathAttempt);
            System.out.println("Row" + x + "Column " + y);
            return true;
        }

        //marks path
        checked[x][y] = true;
        pathAttempt.add(new Point(x, y));

        if (escape(new Point(x,y+1), breath - 1, checked, pathAttempt)){
            return true;
        }
        if (escape(new Point(x + 1,y), breath - 1, checked, pathAttempt)){
            return true;
        }
        if (escape(new Point(x,y - 1), breath - 1, checked, pathAttempt)){
            return true;
        }
        if (escape(new Point(x - 1,y), breath - 1, checked, pathAttempt)){
            return true;
        }

        checked[x][y] = false;
        pathAttempt.removeLast();

        return false;

    }


}
