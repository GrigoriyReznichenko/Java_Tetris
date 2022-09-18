package my.tetris.figureFactory;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import my.tetris.Utils.GridCoords;
import my.tetris.Utils.IDs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Figure {
    protected static final int numOfFigures = 7;
    private static final int numOfColors = 10;
    private static final int RECTANGLE_SIZE = 35;
    private static final int ARC_SIZE = 10;
    private static final int STROKE_WIDTH = 2;
    private static final int NUM_OF_RECTANGLES_IN_FIGURE = 4;

    protected List<GridCoords> figureCoords;
    protected List<Rectangle> figureRectangles;
    protected LinearGradient figureColor;
    protected GridCoords pivot;

    protected void initializeColor() {
        int colorInd = new Random().nextInt(numOfColors);
        Stop[] stops;
        switch (colorInd) {
            case 0:
                stops = new Stop[] {
                        new Stop(0, Color.rgb(255, 130, 10)),
                        new Stop(1, Color.rgb(170, 0, 0))};
                this.figureColor = new LinearGradient(0.1, 0.1, 0.4, 0.4, true, CycleMethod.NO_CYCLE, stops);
                break;
            case 1:
                stops = new Stop[] {
                        new Stop(0, Color.rgb(45, 180, 245)),
                        new Stop(1, Color.rgb(30, 0, 240))};
                break;
            case 2:
                stops = new Stop[] {
                        new Stop(0, Color.rgb(187, 228, 186)),
                        new Stop(1, Color.rgb(5, 156, 40))};
                break;
            case 3:
                stops = new Stop[] {
                        new Stop(0, Color.rgb(190, 110, 200)),
                        new Stop(1, Color.rgb(156, 5, 120))};
                break;
            case 4:
                stops = new Stop[] {
                        new Stop(0, Color.rgb(190, 188, 240)),
                        new Stop(1, Color.rgb(20, 0, 170))};
                break;
            case 5:
                stops = new Stop[] {
                        new Stop(0, Color.rgb(244, 214, 214)),
                        new Stop(1, Color.rgb(170, 6, 6))};
                break;
            case 6:
                stops = new Stop[] {
                        new Stop(0, Color.rgb(212, 213, 226)),
                        new Stop(1, Color.rgb(17, 168, 7))};
                break;
            case 7:
                stops = new Stop[] {
                        new Stop(0, Color.rgb(10, 255, 235)),
                        new Stop(1, Color.rgb(0, 170, 150))};
                break;
            case 8:
                stops = new Stop[] {
                        new Stop(0, Color.rgb(223, 255, 10)),
                        new Stop(1, Color.rgb(150, 170, 0))};
                break;
            case 9:
                stops = new Stop[] {
                        new Stop(0, Color.rgb(255, 10, 225)),
                        new Stop(1, Color.rgb(85, 0, 170))};
                break;
            default:
                throw new RuntimeException("This Color does not exist");
        }
        this.figureColor = new LinearGradient(0.1, 0.1, 0.4, 0.4, true, CycleMethod.NO_CYCLE, stops);
    }
    protected void initializeRectangles() {
        List<Rectangle> rectangles = new ArrayList<>();
        for (int i = 0; i < NUM_OF_RECTANGLES_IN_FIGURE; i++) {
            Rectangle rectangle = new Rectangle();
            rectangle.setWidth(RECTANGLE_SIZE);
            rectangle.setHeight(RECTANGLE_SIZE);
            rectangle.setArcHeight(ARC_SIZE);
            rectangle.setArcWidth(ARC_SIZE);
            rectangle.setStroke(Color.BLACK);
            rectangle.setFill(figureColor);
            rectangle.setStrokeWidth(STROKE_WIDTH);
            rectangles.add(rectangle);
        }
        figureRectangles = rectangles;
    }

    public List<GridCoords> getFigureCoords() {
        return figureCoords;
    }
    public List<Rectangle> getFigureRectangles() {
        return figureRectangles;
    }
    public LinearGradient getFigureColor() {
        return figureColor;
    }
    public GridCoords getPivot() {
        return pivot;
    }
}
