package my.tetris.gui;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import my.tetris.Controller;

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
    private final AnchorPane root;
    private final HBox panelAndRightSceneContainer;
    private final VBox buttonScoreContainer;
    private final Label score;
    private final Button resetButton;
    private final AnchorPane rightScene;
    private final GridPane grid;
    private final Scene scene;

    private Controller controller;


    public Gui(Stage stage) {
        this.stage = stage;
        this.root = buildRoot();
        this.scene = buildScene(root);

        this.panelAndRightSceneContainer = buildPanelAndRightSceneContainer();
        this.buttonScoreContainer = buildButtonScoreContainer();
        this.score = buildScore();
        this.resetButton = buildResetButton();
        this.rightScene = buildRightScene();
        this.grid = buildGrid();

        root.getChildren().add(panelAndRightSceneContainer);
        panelAndRightSceneContainer.getChildren().addAll(buttonScoreContainer, rightScene);
        buttonScoreContainer.getChildren().addAll(score, resetButton);
        rightScene.getChildren().add(grid);
    }

    public void launch() {
        stage.setScene(scene);
        stage.show();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void initializeTimeline() {
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500), actionEvent -> {
            controller.processMoveDown();
            controller.updateScoreIfNeeded();
        });
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void initializeMoving() {
        scene.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {
                case E:
                    controller.processRotateLeft();
                    break;
                case Q:
                    controller.processRotateRight();
                    break;
                case A:
                    controller.processMoveLeft();
                    break;
                case D:
                    controller.processMoveRight();
                    break;
                case S:
                    controller.processMoveToBottom();
                    break;
                default:
                    break;
            }
        });
    }


    private AnchorPane buildRoot() {
        AnchorPane root = new AnchorPane();
        root.setMinSize(GUI_WIDTH, GUI_HEIGHT);
        root.setMaxSize(GUI_WIDTH, GUI_HEIGHT);
        root.setPrefSize(GUI_WIDTH, GUI_HEIGHT);
        root.setStyle("-fx-background-color: #f2d597;");
        return root;
    }

    private HBox buildPanelAndRightSceneContainer() {
        HBox hBox = new HBox();
        hBox.setMinSize(GUI_WIDTH, GUI_HEIGHT);
        hBox.setMaxSize(GUI_WIDTH, GUI_HEIGHT);
        hBox.setPrefSize(GUI_WIDTH, GUI_HEIGHT);
        return hBox;
    }

    private VBox buildButtonScoreContainer() {
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
        scoreLabel.setOnMouseClicked(mouseEvent -> controller.resetGame());

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


    public Label getScore() {
        return score;
    }

    public GridPane getGrid() {
        return grid;
    }

}
