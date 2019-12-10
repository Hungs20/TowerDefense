package towerdefense.Entity.menu;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import towerdefense.GameField;
import towerdefense.GameStage;
import towerdefense.Sound.Sound;

import static towerdefense.config.*;

public class LevelPanel {
    private Button easyButton = new Button();
    private Button normalButton = new Button();
    private Button hardButton = new Button();
    private Button backButton = new Button();
    private ImageView background = new ImageView();
    private ImageView panelBg = new ImageView();
    private Label title = new Label();
    private Sound clickSound = new Sound("src/towerdefense/Sound/sounds/7_click.mp3");
    public LevelPanel(){

        background.setImage(new Image(pathImg + "background.png"));

        panelBg.setImage(new Image(pathImg + "panel.png"));
        panelBg.setX(SCREEN_WIDTH/2 - 120);
        panelBg.setY(SCREEN_HEIGHT/5);
        panelBg.setOpacity(0.7);
        panelBg.setFitHeight(400);
        panelBg.setFitWidth(300);

        title.setText("Choose Level");
        title.setLayoutX(SCREEN_WIDTH/2 - 110);
        title.setLayoutY(SCREEN_HEIGHT/5 + 20);
        title.setId("title");


        easyButton.setText("Easy");
        easyButton.setLayoutX(SCREEN_WIDTH/2 - 60);
        easyButton.setLayoutY(SCREEN_HEIGHT/3 + 40);
        easyButton.setId("levelPanel");

        normalButton.setText("Normal");
        normalButton.setLayoutX(SCREEN_WIDTH/2 - 60);
        normalButton.setLayoutY(SCREEN_HEIGHT/3 + 100);
        normalButton.setId("levelPanel");

        hardButton.setText("Hard");
        hardButton.setLayoutX(SCREEN_WIDTH/2 - 60);
        hardButton.setLayoutY(SCREEN_HEIGHT/3 + 160);
        hardButton.setId("levelPanel");

        backButton.setText("Back");
        backButton.setLayoutX(SCREEN_WIDTH/2 - 20);
        backButton.setLayoutY(SCREEN_HEIGHT/3 + 250);
    }
    public void clear(){
        if(root.getChildren().indexOf(background) >= 0) root.getChildren().remove(background);

        if(root.getChildren().indexOf(panelBg) >= 0) root.getChildren().remove(panelBg);
        if(root.getChildren().indexOf(title) >= 0) root.getChildren().remove(title);
        if(root.getChildren().indexOf(easyButton) >= 0) root.getChildren().remove(easyButton);
        if(root.getChildren().indexOf(normalButton) >= 0) root.getChildren().remove(normalButton);
        if(root.getChildren().indexOf(hardButton) >= 0) root.getChildren().remove(hardButton);
        if(root.getChildren().indexOf(backButton) >= 0) root.getChildren().remove(backButton);
    }
    public void render(){

        if(root.getChildren().indexOf(background) < 0) root.getChildren().add(background);
        if(root.getChildren().indexOf(panelBg) < 0) root.getChildren().add(panelBg);
        if(root.getChildren().indexOf(title) < 0) root.getChildren().add(title);
        if(root.getChildren().indexOf(easyButton) < 0) root.getChildren().add(easyButton);
        if(root.getChildren().indexOf(normalButton) < 0) root.getChildren().add(normalButton);
        if(root.getChildren().indexOf(hardButton) < 0) root.getChildren().add(hardButton);
        if(root.getChildren().indexOf(backButton) < 0) root.getChildren().add(backButton);

    }
    public void update(){
        easyButton.setOnMouseClicked(event -> {
            clickSound.play();
            clear();
            levelMap = 0;
            GameField.getInstance().newGame();
            GameStage.choose = GAME_START;
        });
        normalButton.setOnMouseClicked(event -> {
            clickSound.play();
            clear();
            levelMap = 1;
            GameField.getInstance().newGame();
            GameStage.choose = GAME_START;
        });
        hardButton.setOnMouseClicked(event -> {
            clickSound.play();
            clear();
            levelMap = 2;
            GameField.getInstance().newGame();
            GameStage.choose = GAME_START;
        });
        backButton.setOnMouseClicked(event -> {
            clickSound.play();
            clear();
            GameStage.choose = START_MENU;
        });
    }
}
