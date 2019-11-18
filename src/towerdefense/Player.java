package towerdefense;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


import static towerdefense.config.*;

public class Player {
    private int level;
    private int coin;
    private int lifes;

    private Label infoPlayer = new Label();
    private static Player instance;
    private ImageView heart;
    private Player(){
        level = 0;
        coin= 100;
        lifes = 5;
    }

    public static Player Instance()
    {
        if (instance == null) instance = new Player();
        return instance;
    }

    public void newGame()
    {
        level = 0;
        coin= 100;
        lifes = 5;
    }
    public String getInfo(){
        String info = "";
        info += "Level : " + level + "\n";
        info += "Coin : " + coin + "\n";
        return info;
    }
    public void showInfoPlayer(GraphicsContext gc){
        infoPlayer.setText(getInfo());
        infoPlayer.setLayoutX((MAP_WIDTH + 0.2) * TILE_SIZE);
        infoPlayer.setLayoutY(5 * TILE_SIZE);
        infoPlayer.setTextFill(Color.GREEN);
        infoPlayer.setFont(Font.font("Consolas", 16));

        Image heart = new Image(pathImg + "heart.png");
        for(int i = 0; i < lifes; i++){
            gc.drawImage(heart, (MAP_WIDTH + 0.2) * TILE_SIZE  + i * heart.getWidth(), 6 * TILE_SIZE);
        }
        if(root.getChildren().indexOf(infoPlayer) < 0) root.getChildren().addAll(infoPlayer);
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
}
