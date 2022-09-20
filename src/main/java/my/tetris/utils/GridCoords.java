package my.tetris.utils;

public class GridCoords {
    private final int xCoord;
    private final int yCoord;

    public GridCoords(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
    public int getXCoord() {
        return xCoord;
    }
    public int getYCoord() {
        return yCoord;
    }

}
