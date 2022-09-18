package my.tetris;

import javafx.application.Application;
import javafx.stage.Stage;
import my.tetris.gui.GuiPojo;
import my.tetris.gui.Gui;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Gui gui = new Gui();
        GuiPojo guiPojo = gui.getGuiPojo();
        Controller controller = new Controller(guiPojo);

        stage.setScene(guiPojo.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}