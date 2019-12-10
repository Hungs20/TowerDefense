package towerdefense.Entity.menu;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import towerdefense.GameField;
import towerdefense.GameStage;
import towerdefense.Player;
import towerdefense.Sound.Sound;

import static towerdefense.config.*;

public class GameOverPanel {
    private ImageView panelBg = new ImageView();
    private Label title = new Label();
    private Label info = new Label();
    private ImageView home = new ImageView();
    private ImageView playAgain = new ImageView();
    private ImageView exit = new ImageView();
    private Sound clickSound = new Sound("src/towerdefense/Sound/sounds/7_click.mp3");
    public GameOverPanel(){
        title.setText("VICTORY :)");
        title.setLayoutX(SCREEN_WIDTH/2 - 80);
        title.setLayoutY(SCREEN_HEIGHT/5 + 20);
        title.setId("titleGameOver");

        panelBg.setImage(new Image(pathImg + "panel.png"));
        panelBg.setX(SCREEN_WIDTH/2 - 120);
        panelBg.setY(SCREEN_HEIGHT/5);
        panelBg.setOpacity(0.7);
        panelBg.setFitHeight(200);
        panelBg.setFitWidth(300);

        home.setImage(new Image(pathImg + "menu.png"));
        home.setX(SCREEN_WIDTH/2 - 80);
        home.setY(SCREEN_HEIGHT/5 + 100);

        playAgain.setImage(new Image(pathImg + "replay.png"));
        playAgain.setX(SCREEN_WIDTH/2);
        playAgain.setY(SCREEN_HEIGHT/5 + 100);

        exit.setImage(new Image(pathImg + "exit.png"));
        exit.setX(SCREEN_WIDTH/2 + 80);
        exit.setY(SCREEN_HEIGHT/5 + 100);


    }
    public void clear(){
        if(root.getChildren().indexOf(panelBg) >= 0) root.getChildren().remove(panelBg);
        if(root.getChildren().indexOf(title) >= 0) root.getChildren().remove(title);
        if(root.getChildren().indexOf(home) >= 0) root.getChildren().remove(home);
        if(root.getChildren().indexOf(playAgain) >= 0) root.getChildren().remove(playAgain);
        if(root.getChildren().indexOf(exit) >= 0) root.getChildren().remove(exit);
    }
    public void render(){
        if(Player.Instance().getLifes() <= 0 || (Player.Instance().getLevel() > Player.Instance().getMAX_LEVEL() && GameField.enemyList.isEmpty()))
        {
            isPlay = false;
            if(Player.Instance().getLifes() <= 0) title.setText("LOSS !!");
            else title.setText("VICTORY !");
            if(root.getChildren().indexOf(panelBg) < 0) root.getChildren().add(panelBg);
            if(root.getChildren().indexOf(title) < 0) root.getChildren().add(title);
            if(root.getChildren().indexOf(home) < 0) root.getChildren().add(home);
            if(root.getChildren().indexOf(playAgain) < 0) root.getChildren().add(playAgain);
            if(root.getChildren().indexOf(exit) < 0) root.getChildren().add(exit);
        }

    }
    public void update(){
        home.setOnMouseClicked(event -> {
            clear();
            clickSound.play();
            GameField.getInstance().newGame();
            GameStage.choose = START_MENU;
        });

        playAgain.setOnMouseClicked(event -> {
            clear();
            clickSound.play();
            GameField.getInstance().newGame();
            GameStage.choose = GAME_START;
        });
        exit.setOnMouseClicked(event -> {
            clickSound.play();
            Platform.exit();
        });
    }
}
