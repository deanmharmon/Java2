// Dean Mason
// Midterm

import java.awt.*;
import java.util.ArrayList;

/**
 * Class cave holds the logic for the program (the recursive solution)
 */
public class Cave {

    private final int depthRating;
    private final CaveDrawing caveInfo;
    private final GUI gui;
    private final int MAX_SIZE = 10;

    /**
     * Constructor
     * @param depthRating depth rating of diver
     * @param caveInfo our object that draws the cave
     * @param gui object for the frame
     */
    public Cave(int depthRating, CaveDrawing caveInfo, GUI gui) {
        this.caveInfo = caveInfo;
        this.gui = gui;
        this.depthRating = depthRating;
    }

    /**
     * Begins the check for the solution
     */
    public void tryToSolve(){
        caveInfo.reset();
        ArrayList<Point> path = new ArrayList<>();
        boolean[][] checked = new boolean[MAX_SIZE][MAX_SIZE];
        int MAX_BREATHS = 20;
        if (!escape(new Point(0,0), MAX_BREATHS, checked, path)){
            gui.failed();
        }
    }

    /**
     * Recursively checks for solution
     * @param location point we are checking
     * @param breath how many breaths diver has left (max 20)
     * @param checked array storing whether a grid location has been checked
     * @param path array list of points holding the current path being checked
     * @return true if solved, false if not
     */
    public boolean escape(Point location, int breath, boolean[][] checked, ArrayList<Point> path){
        int x = location.x;
        int y = location.y;

        if (((x >= MAX_SIZE) || (y >= MAX_SIZE)) || ((x < 0) || (y < 0))){
            return false;
        }

        if (checked[x][y]){
            return false;
        }

        if (breath < 0){
            return false;
        }

        int depth = caveInfo.getCaveCellDepth(x, y);
        // Potentially not the way the program is intended to run, but makes it easier to find ones that can run with
        // a low rating
        if ((x == 0) && (y == 0)){
            depth = 0;
        }
        if (depthRating < depth){
            return false;
        }

        if ((x == 9) && (y == 9)) {
            path.add(new Point(x, y));
            caveInfo.drawWin(path);
            
            int count = 0;
            System.out.println("Correct solution is:\n");
            for (Point r : path) {
                System.out.println("Move:" + count +", Row: " + (int)r.getX() + ", Column: " + (int)r.getY());
                count += 1;
            }
            
            return true;
        }

        checked[x][y] = true;
        path.add(new Point(x, y));

        if (escape(new Point(x,y+1), breath - 1, checked, path)){
            return true;
        }
        if (escape(new Point(x + 1,y), breath - 1, checked, path)){
            return true;
        }
        if (escape(new Point(x,y - 1), breath - 1, checked, path)){
            return true;
        }
        if (escape(new Point(x - 1,y), breath - 1, checked, path)){
            return true;
        }

        checked[x][y] = false;
        path.removeLast();

        return false;

    }

}
