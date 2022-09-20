package my.tetris.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import my.tetris.Controller;
import my.tetris.utils.GridCoords;

import java.util.List;

public class Gui {
    private final static int GUI_WIDTH = 455;
    private final static int GUI_HEIGHT = 710;
    private final static int LEFT_PANEL_WIDTH = 100;
    private final static int LEFT_PANEL_HEIGHT = 700;
    private final static int VBOX_SPACING = 610;
    private final static int SCORE_WIDTH = 90;
    private final static int SCORE_HEIGHT = 40;
    private final static int RESET_BUTTON_WIDTH = SCORE_WIDTH;
    private final static int RESET_BUTTON_HEIGHT = SCORE_HEIGHT;
    private final static int RIGHT_SCENE_WIDTH = 350;
    private final static int RIGHT_SCENE_HEIGHT = 708;
    private final static int GRID_WIDTH = RIGHT_SCENE_WIDTH;
    private final static int GRID_HEIGHT = RESET_BUTTON_HEIGHT;
    private final static int FONT_SIZE = 16;
    private final static int NUM_OF_GRID_COLUMNS = 10;
    private final static int NUM_OF_GRID_ROWS = 20;
    private final static int CELL_SIZE = 35;

    private final Stage stage;
    private Controller controller;

    private final AnchorPane root;
    private final HBox hBox;
    private final VBox vBox;
    private final Label score;
    private final Button resetButton;
    private final AnchorPane rightScene;
    private final GridPane grid;
    private final Scene scene;


    public Gui(Stage stage) {
        this.stage = stage;

        root = buildRoot();
        hBox = buildHBox();
        vBox = buildVbox();
        score = buildScore();
        resetButton = buildResetButton();
        rightScene = buildRightScene();
        grid = buildGrid();
        scene = buildScene(root);

        root.getChildren().add(hBox);
        hBox.getChildren().addAll(vBox, rightScene);
        vBox.getChildren().addAll(score, resetButton);
        rightScene.getChildren().add(grid);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void launch() {
        stage.setScene(scene);
        stage.show();
    }

    private AnchorPane buildRoot() {
        AnchorPane root = new AnchorPane();
        root.setMinSize(GUI_WIDTH, GUI_HEIGHT);
        root.setMaxSize(GUI_WIDTH, GUI_HEIGHT);
        root.setPrefSize(GUI_WIDTH, GUI_HEIGHT);
        root.setStyle("-fx-background-color: #f2d597;");
        return root;
    }

    private HBox buildHBox() {
        HBox hBox = new HBox();
        hBox.setMinSize(GUI_WIDTH, GUI_HEIGHT);
        hBox.setMaxSize(GUI_WIDTH, GUI_HEIGHT);
        hBox.setPrefSize(GUI_WIDTH, GUI_HEIGHT);
        return hBox;
    }
    private VBox buildVbox() {
        VBox vBox = new VBox();
        vBox.setMinSize(LEFT_PANEL_WIDTH, LEFT_PANEL_HEIGHT);
        vBox.setMaxSize(LEFT_PANEL_WIDTH, LEFT_PANEL_HEIGHT);
        vBox.setPrefSize(LEFT_PANEL_WIDTH, LEFT_PANEL_HEIGHT);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(VBOX_SPACING);
        return vBox;
    }
    private Label buildScore() {
        Label scoreLabel = new Label();
        scoreLabel.setMinSize(SCORE_WIDTH, SCORE_HEIGHT);
        scoreLabel.setMaxSize(SCORE_WIDTH, SCORE_HEIGHT);
        scoreLabel.setPrefSize(SCORE_WIDTH, SCORE_HEIGHT);

        scoreLabel.setAlignment(Pos.CENTER);
        scoreLabel.setFont(Font.font(FONT_SIZE));
        scoreLabel.setText("Score: " + 0);
        return scoreLabel;
    }
    private Button buildResetButton() {
        Button resetButton = new Button();
        resetButton.setMinSize(RESET_BUTTON_WIDTH, RESET_BUTTON_HEIGHT);
        resetButton.setMaxSize(RESET_BUTTON_WIDTH, RESET_BUTTON_HEIGHT);
        resetButton.setPrefSize(RESET_BUTTON_WIDTH, RESET_BUTTON_HEIGHT);

        resetButton.setAlignment(Pos.CENTER);
        resetButton.setFont(Font.font(FONT_SIZE));
        resetButton.setText("Reset");
        return resetButton;
    }
    private AnchorPane buildRightScene() {
        AnchorPane rightScene = new AnchorPane();
        rightScene.setMinSize(RIGHT_SCENE_WIDTH, RIGHT_SCENE_HEIGHT);
        rightScene.setMaxSize(RIGHT_SCENE_WIDTH, RIGHT_SCENE_HEIGHT);
        rightScene.setPrefSize(RIGHT_SCENE_WIDTH, RIGHT_SCENE_HEIGHT);
        rightScene.setStyle("-fx-border-color: #000000;\n");
        return rightScene;
    }
    private GridPane buildGrid() {
        GridPane grid = new GridPane();
        grid.setMinSize(GRID_WIDTH, GRID_HEIGHT);
        grid.setMaxSize(GRID_WIDTH, GRID_HEIGHT);
        grid.setPrefSize(GRID_WIDTH, GRID_HEIGHT);
        grid.setLayoutY(3);


        for (int i = 0; i < NUM_OF_GRID_COLUMNS; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setMinWidth(CELL_SIZE);
            columnConstraints.setMaxWidth(CELL_SIZE);
            columnConstraints.setPrefWidth(CELL_SIZE);
            grid.getColumnConstraints().add(columnConstraints);
        }

        for (int i = 0; i < NUM_OF_GRID_ROWS; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setMinHeight(CELL_SIZE);
            rowConstraints.setMaxHeight(CELL_SIZE);
            rowConstraints.setPrefHeight(CELL_SIZE);
            grid.getRowConstraints().add(rowConstraints);
        }
        return grid;

    }
    private Scene buildScene(AnchorPane root) {
        return new Scene(root, GUI_WIDTH, GUI_HEIGHT);
    }



    public void initializeMoving() {
        scene.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {
                case E:
                    controller.processRotateLeft();
                    break;
                case Q:
                    List<GridCoords> coordsRotatedToLeft = getRotatedFigureCoords(Math.toRadians(-90));
                    rotateFigure(coordsRotatedToLeft);
                    break;
                case D:
                    GridCoords rightSideIncrement = new GridCoords(1, 0);
                    moveFigureToSide(rightSideIncrement);
                    break;
                case A:
                    GridCoords leftSideIncrement = new GridCoords(-1, 0);
                    moveFigureToSide(leftSideIncrement);
                    break;
                case S:
                    moveFigureToTheBottom();
                    break;
                default:
                    break;
            }
        });
    }

}
