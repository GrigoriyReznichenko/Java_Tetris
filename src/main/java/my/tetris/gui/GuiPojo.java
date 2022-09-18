package my.tetris.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GuiPojo {
    private final AnchorPane root;
    private final HBox hBox;
    private final VBox vBox;
    private final Label score;
    private final Button resetButton;
    private final AnchorPane rightScene;
    private final GridPane grid;
    private final Scene scene;

    public static class Builder {
        private AnchorPane root;
        private HBox hBox;
        private VBox vBox;
        private Label score;
        private Button resetButton;
        private AnchorPane rightScene;
        private GridPane grid;
        private Scene scene;

        public Builder() {
        }
        public Builder root(AnchorPane root) {
            this.root = root;
            return this;
        }
        public Builder hBox(HBox hBox) {
            this.hBox = hBox;
            return this;
        }
        public Builder vBox(VBox vBox) {
            this.vBox = vBox;
            return this;
        }
        public Builder score(Label score) {
            this.score = score;
            return this;
        }
        public Builder resetButton(Button resetButton) {
            this.resetButton = resetButton;
            return this;
        }
        public Builder rightScene(AnchorPane rightScene) {
            this.rightScene = rightScene;
            return this;
        }
        public Builder grid(GridPane grid) {
            this.grid = grid;
            return this;
        }
        public Builder scene(Scene scene) {
            this.scene = scene;
            return this;
        }
        public GuiPojo build() {
            return new GuiPojo(this);
        }

    }

    private GuiPojo(Builder builder) {
        this.root =        builder.root;
        this.hBox =        builder.hBox;
        this.vBox =        builder.vBox;
        this.score =       builder.score;
        this.resetButton = builder.resetButton;
        this.rightScene =  builder.rightScene;
        this.grid =        builder.grid;
        this.scene =       builder.scene;

    }

    public AnchorPane getRoot() {
        return root;
    }
    public HBox gethBox() {
        return hBox;
    }
    public VBox getvBox() {
        return vBox;
    }
    public Label getScore() {
        return score;
    }
    public Button getResetButton() {
        return resetButton;
    }
    public AnchorPane getRightScene() {
        return rightScene;
    }
    public GridPane getGrid() {
        return grid;
    }
    public Scene getScene() {
        return scene;
    }
}
