package towerdefense;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


import static towerdefense.config.*;

public class Player {
    private final int NUM_HEART = 5;
    private final int MAX_LEVEL = 20;
    private int level;
    private int coin;
    private int lifes;

    private Label infoPlayer = new Label();
    private Label infoLevel = new Label();
    private static Player instance;
    private Player(){
        level = 1;
        coin= 100;
        lifes = NUM_HEART;
    }

    public static Player Instance()
    {
        if (instance == null) instance = new Player();
        return instance;
    }

    public void newGame()
    {
        this.level = 1;
        this.coin= 100;
        this.lifes = 5;
    }
    public String getInfo(){
        String info = "";
        info += coin + "\n";
        return info;
    }
    public void showInfoPlayer(GraphicsContext gc){
        infoPlayer.setText(getInfo());
        infoPlayer.setLayoutY(0);
        infoPlayer.setLayoutX((MAP_WIDTH - 2.5) * TILE_SIZE);
        infoPlayer.setId("coinPlayer");

        Image coinIcon = new Image(pathImg + "money.png");
        gc.drawImage(coinIcon, (MAP_WIDTH - 3) * TILE_SIZE, 0);

        Image heart = new Image(pathImg + "heart.png");
        Image heart_die = new Image(pathImg + "heart-die.png");
        for(int i = 0; i < NUM_HEART; i++){
            gc.drawImage(heart_die, (MAP_WIDTH - 4) * TILE_SIZE  - i * heart_die.getWidth(), 0);
        }
        for(int i = 0; i < lifes; i++){
            gc.drawImage(heart, (MAP_WIDTH - 4) * TILE_SIZE  - i * heart.getWidth(), 0);
        }
        if(root.getChildren().indexOf(infoPlayer) < 0) root.getChildren().addAll(infoPlayer);

        infoLevel.setText("Level : " + String.valueOf(this.level) + " / " + String.valueOf(MAX_LEVEL));
        infoLevel.setId("levelPlayer");
        infoLevel.setLayoutX((MAP_WIDTH + MENU_WIDTH/4) * TILE_SIZE);
        infoLevel.setLayoutY((MAP_HEIGHT - 2) * TILE_SIZE);
        if(root.getChildren().indexOf(infoLevel) < 0) root.getChildren().addAll(infoLevel);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getLifes() {
        return lifes;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    public int getMAX_LEVEL() {
        return MAX_LEVEL;
    }
}
