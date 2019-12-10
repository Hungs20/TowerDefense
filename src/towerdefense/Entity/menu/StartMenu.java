package towerdefense.Entity.menu;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import towerdefense.GameStage;
import towerdefense.Sound.GameSound;
import towerdefense.Sound.Sound;

import static towerdefense.config.*;

public class StartMenu {
    private Button startButton = new Button();
    private Button exitButton = new Button();
    private Button settingButton = new Button();
    private Button helpButton = new Button();
    private ImageView background = new ImageView();

    private ImageView panelBg = new ImageView();
    private Sound clickSound = new Sound("src/towerdefense/Sound/sounds/7_click.mp3");
    public StartMenu(){
        background.setImage(new Image(pathImg + "background.png"));

        panelBg.setImage(new Image(pathImg + "panel.png"));
        panelBg.setX(SCREEN_WIDTH/2 - 120);
        panelBg.setY(SCREEN_HEIGHT/5);
        panelBg.setOpacity(0.7);

        startButton.setText("Play");
        startButton.setLayoutX(SCREEN_WIDTH/2 - 50);
        startButton.setLayoutY(SCREEN_HEIGHT/3);

        settingButton.setText("Level");
        settingButton.setLayoutX(SCREEN_WIDTH/2 - 50);
        settingButton.setLayoutY(SCREEN_HEIGHT/3 + 50);

        helpButton.setText("Help");
        helpButton.setLayoutX(SCREEN_WIDTH/2 - 50);
        helpButton.setLayoutY(SCREEN_HEIGHT/3 + 100);

        exitButton.setText("Exit");
        exitButton.setLayoutX(SCREEN_WIDTH/2 - 50);
        exitButton.setLayoutY(SCREEN_HEIGHT/3 + 150);
    }
    public void render(){
        if(root.getChildren().indexOf(background) < 0) root.getChildren().add(background);
        if(root.getChildren().indexOf(panelBg) < 0) root.getChildren().add(panelBg);
        if(root.getChildren().indexOf(startButton) < 0) root.getChildren().add(startButton);
        if(root.getChildren().indexOf(settingButton) < 0) root.getChildren().add(settingButton);
        if(root.getChildren().indexOf(helpButton) < 0) root.getChildren().add(helpButton);
        if(root.getChildren().indexOf(exitButton) < 0) root.getChildren().add(exitButton);
    }
    public void clearButton(){
        if(root.getChildren().indexOf(background) >= 0) root.getChildren().remove(background);
        if(root.getChildren().indexOf(panelBg) >= 0) root.getChildren().remove(panelBg);
        if(root.getChildren().indexOf(startButton) >= 0) root.getChildren().remove(startButton);
        if(root.getChildren().indexOf(helpButton) >= 0) root.getChildren().remove(helpButton);
        if(root.getChildren().indexOf(settingButton) >= 0) root.getChildren().remove(settingButton);
        if(root.getChildren().indexOf(exitButton) >= 0) root.getChildren().remove(exitButton);
    }
    public void updatẹ(){

        startButton.setOnMouseClicked(event -> {
            clickSound.play();
            clearButton();
            GameStage.choose = GAME_START; //Start Game
        });

        settingButton.setOnMouseClicked(event -> {
            clickSound.play();
            clearButton();
            GameStage.choose = LEVEL_PANEL;
        });
        helpButton.setOnMouseClicked(event -> {
            clickSound.play();
            clearButton();
            GameStage.choose = HELP_PANEL;
        });
        exitButton.setOnMouseClicked(event -> {
            clickSound.play();
            clearButton();
            GameStage.choose = GAME_EXIT; //Exit game
        });
    }
}
