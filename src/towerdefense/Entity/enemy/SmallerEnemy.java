package towerdefense.Entity.enemy;

import javafx.scene.image.Image;

import static towerdefense.config.pathImg;

public class SmallerEnemy extends Enemy {
    private final double SPEED = 8;
    private final Direction DIRECTION = Direction.UP;
    private final int HEALTH = 100;
    private final int ARMOR = 10;
    private final int REWARD = 10;

    public SmallerEnemy(){
        this.setSpeed(SPEED);
        this.setDirection(DIRECTION);
        this.setHealth(HEALTH);
        this.setArmor(ARMOR);
        this.setReward(REWARD);
        this.setImg(new Image(pathImg + "towerDefense_tile245.png"));
       // this.setGunImg(new Image(pathImg + "towerDefense_tile292.png"));
    }
    @Override
    public String toString(){
        return "SmallerEnemy";
    }
    @Override
    public double getMaxHealth() {
        return HEALTH;
    }
}
