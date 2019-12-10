package towerdefense.Entity.enemy;

import javafx.scene.image.Image;
import towerdefense.Player;

import static towerdefense.config.pathImg;

public class SmallerEnemy extends Enemy {
    private final double SPEED = 4;
    private final Direction DIRECTION = Direction.UP;
    private final int HEALTH = 80;
    private final int ARMOR = 10;
    private final int REWARD = 10;

    public SmallerEnemy(){
        this.setSpeed(SPEED + (Player.Instance().getLevel() - 1) * 10 * SPEED / 100);
        this.setDirection(DIRECTION);
        this.setHealth(HEALTH + (Player.Instance().getLevel() - 1) * 10 * HEALTH/100);
        this.setArmor(ARMOR + (Player.Instance().getLevel() - 1) * 5 * ARMOR/100);
        this.setReward(REWARD + (Player.Instance().getLevel() - 1) * 10 * REWARD/100);
        if(Player.Instance().getLevel() % 4 == 0) this.setImg(new Image(pathImg + "towerDefense_tile245.png"));
        else if(Player.Instance().getLevel() % 4 == 1) this.setImg(new Image(pathImg + "towerDefense_tile246.png"));
        else if(Player.Instance().getLevel() % 4 == 2) this.setImg(new Image(pathImg + "towerDefense_tile247.png"));
        else if(Player.Instance().getLevel() % 4 == 3) this.setImg(new Image(pathImg + "towerDefense_tile248.png"));
       // this.setGunImg(new Image(pathImg + "towerDefense_tile292.png"));
    }
    @Override
    public String toString(){
        return "SmallerEnemy";
    }
    @Override
    public double getMaxHealth() {
        return HEALTH + (Player.Instance().getLevel() - 1) * 10 * HEALTH/100;
    }
}
