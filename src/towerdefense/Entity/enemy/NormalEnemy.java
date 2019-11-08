package towerdefense.Entity.enemy;


import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static towerdefense.config.pathImg;

public class NormalEnemy extends Enemy {

    private final double SPEED = 10;
    private final Direction DIRECTION = Direction.UP;
    private final int HEALTH = 100;
    private final int ARMOR = 100;
    private final int REWARD = 10;

    public NormalEnemy(){
        this.setSpeed(SPEED);
        this.setDirection(DIRECTION);
        this.setHealth(HEALTH);
        this.setArmor(ARMOR);
        this.setReward(REWARD);
        this.setImg(new Image(pathImg + "towerDefense_tile268.png"));
        this.setGunImg(new Image(pathImg + "towerDefense_tile291.png"));
    }


}
