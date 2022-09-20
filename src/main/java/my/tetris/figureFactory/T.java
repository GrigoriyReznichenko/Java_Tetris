package my.tetris.figureFactory;

import my.tetris.utils.GridCoords;

import java.util.ArrayList;
import java.util.Random;

class T extends Figure {
    public T() {
        initializeColor();
        int shift = new Random().nextInt(numOfFigures);
        figureCoords = new ArrayList<>();
        figureCoords.add(new GridCoords(0 + shift, 0));
        figureCoords.add(new GridCoords(1 + shift, 0));
        figureCoords.add(new GridCoords(2 + shift, 0));
        figureCoords.add(new GridCoords(1 + shift, 1));
        initializeRectangles();
        this.pivot = new GridCoords(1 + shift, 1);
    }
}
