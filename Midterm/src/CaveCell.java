//Dean Mason
//Midterm

import java.awt.*;

/**
 * CaveCell is used to hold the information about each cell inside the cave, the position and depth
 * IDE is telling me it could be a record class, but I have not used nor learned about them so it will be normal for now
 */
public class CaveCell {

    private final int depth;
    private final Point location;

    /**
     * Constructor, initializes each new instance with the information
     * @param location Point object
     * @param depth depth of cell
     */
    public CaveCell(Point location, int depth){
        this.depth = depth;
        this.location = location;
    }

    /**
     * @return the depth of the cell
     */
    public int getDepth() {
        return depth;
    }

    /**
     * @return the location of the cell
     */
    public Point getLocation() {
        return location;
    }

}