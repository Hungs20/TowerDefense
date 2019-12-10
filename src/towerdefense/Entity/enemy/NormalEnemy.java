package towerdefense.Entity.enemy;


import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import towerdefense.Player;

import static towerdefense.config.pathImg;

public class NormalEnemy extends Enemy {

    private final double SPEED = 3;
    private final Direction DIRECTION = Direction.UP;
    private final int HEALTH = 100;
    private final int ARMOR = 100;
    private final int REWARD = 10;

    public NormalEnemy(){
        this.setSpeed(SPEED + (Player.Instance().getLevel() - 1) * 10 * SPEED / 100);
        this.setDirection(DIRECTION);
        this.setHealth(HEALTH + (Player.Instance().getLevel() - 1) * 10 * HEALTH/100);
        this.setArmor(ARMOR + (Player.Instance().getLevel() - 1) * 5 * ARMOR/100);
        this.setReward(REWARD + (Player.Instance().getLevel() - 1) * 10 * REWARD/100);
        this.setImg(new Image(pathImg + "towerDefense_tile268.png"));
        this.setGunImg(new Image(pathImg + "towerDefense_tile291.png"));
    }

    @Override
    public String toString(){
        return "NormalEnemy";
    }
    @Override
    public double getMaxHealth() {
        return HEALTH + (Player.Instance().getLevel() - 1) * 10 * HEALTH/100;
    }
}
