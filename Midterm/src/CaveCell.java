public class CaveCell {
    private int row;
    private int column;
    private int depth;

    public CaveCell(int row, int column, int depth){
        this.row = row;
        this.column = column;
        this.depth = depth;
    }


    public int getDepth() {
        return depth;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}