package my.tetris;

import javafx.application.Application;
import javafx.stage.Stage;
import my.tetris.figureFactory.FigureFactory;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Gui gui = new Gui(stage);
        FigureFactory figureFactory = new FigureFactory();

        Controller controller = new Controller(gui, figureFactory);

        gui.setController(controller);

        gui.launch();
    }

    public static void main(String[] args) {
        launch();
    }

}