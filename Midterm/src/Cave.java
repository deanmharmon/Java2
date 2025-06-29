public class Cave {
    private int depth;
    private int column;
    private int row;
    private int nextStep;
    private int depthRating;
    private CaveDrawing caveInfo;
    private GUI gui;

    public Cave(int depthRating, CaveDrawing caveInfo, GUI gui) {
        //this.depthRating = depthRating;
        this.caveInfo = caveInfo;
        this.gui = gui;
        this.depthRating = depthRating;
    }



}
