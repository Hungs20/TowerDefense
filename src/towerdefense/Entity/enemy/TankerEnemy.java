package towerdefense.Entity.enemy;

import javafx.scene.image.Image;

import static towerdefense.config.pathImg;

public class TankerEnemy extends Enemy {
    private final double SPEED = 4;
    private final Direction DIRECTION = Direction.UP;
    private final int HEALTH = 300;
    private final int ARMOR = 100;
    private final int REWARD = 10;

    public TankerEnemy(){
        this.setSpeed(SPEED);
        this.setDirection(DIRECTION);
        this.setHealth(HEALTH);
        this.setArmor(ARMOR);
        this.setReward(REWARD);
        this.setImg(new Image(pathImg + "towerDefense_tile269.png"));
        this.setGunImg(new Image(pathImg + "towerDefense_tile292.png"));
    }
    @Override
    public String toString(){
        return "TankerEnemy";
    }
    @Override
    public double getMaxHealth() {
        return HEALTH;
    }
}
