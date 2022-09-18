package my.tetris.figureFactory;

import java.util.Random;

public class FigureFactory {

    public Figure generateFigure() {
        int figureInd = new Random().nextInt(7);
        switch (figureInd) {
            case 0 : return new I();
            case 1 : return new J();
            case 2 : return new L();
            case 3 : return new O();
            case 4 : return new S();
            case 5 : return new T();
            case 6 : return new Z();
            default: throw new RuntimeException("No such figure");
        }
    }
}
