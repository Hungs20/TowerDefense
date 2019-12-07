package towerdefense.Entity.menu;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import towerdefense.GameStage;
import towerdefense.Sound.Sound;

import static towerdefense.config.*;

public class LevelPanel {
    private Button easyButton = new Button();
    private Button normalButton = new Button();
    private Button hardButton = new Button();
    private Button backButton = new Button();
    private ImageView background = new ImageView();
    private Label title = new Label();
    private Sound clickSound = new Sound("src/towerdefense/Sound/sounds/7_click.mp3");
    public LevelPanel(){

        background.setImage(new Image(pathImg + "levelPanel.png"));

        title.setText("CHOOSE LEVEL");
        title.setLayoutX(SCREEN_WIDTH/3);
        title.setLayoutY(4);
        title.setId("title");


        easyButton.setText("Easy");
        easyButton.setLayoutX(SCREEN_WIDTH/2 - 50);
        easyButton.setLayoutY(SCREEN_HEIGHT/4);
        easyButton.setId("levelPanel");

        normalButton.setText("Normal");
        normalButton.setLayoutX(SCREEN_WIDTH/2 - 50);
        normalButton.setLayoutY(SCREEN_HEIGHT/4 + 80);
        normalButton.setId("levelPanel");

        hardButton.setText("Hard");
        hardButton.setLayoutX(SCREEN_WIDTH/2 - 50);
        hardButton.setLayoutY(SCREEN_HEIGHT/4 + 160);
        hardButton.setId("levelPanel");

        backButton.setText("Back");
        backButton.setLayoutX(SCREEN_WIDTH/2 - 20);
        backButton.setLayoutY(SCREEN_HEIGHT/4 + 300);
    }
    public void clear(){
        if(root.getChildren().indexOf(background) >= 0) root.getChildren().remove(background);
        if(root.getChildren().indexOf(title) >= 0) root.getChildren().remove(title);
        if(root.getChildren().indexOf(easyButton) >= 0) root.getChildren().remove(easyButton);
        if(root.getChildren().indexOf(normalButton) >= 0) root.getChildren().remove(normalButton);
        if(root.getChildren().indexOf(hardButton) >= 0) root.getChildren().remove(hardButton);
        if(root.getChildren().indexOf(backButton) >= 0) root.getChildren().remove(backButton);
    }
    public void render(){

        if(root.getChildren().indexOf(background) < 0) root.getChildren().add(background);
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
            GameStage.choose = GAME_START;
        });
        normalButton.setOnMouseClicked(event -> {
            clickSound.play();
            clear();
            levelMap = 1;
            GameStage.choose = GAME_START;
        });
        hardButton.setOnMouseClicked(event -> {
            clickSound.play();
            clear();
            levelMap = 2;
            GameStage.choose = GAME_START;
        });
        backButton.setOnMouseClicked(event -> {
            clickSound.play();
            clear();
            GameStage.choose = START_MENU;
        });
    }
}
