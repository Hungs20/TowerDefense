package towerdefense.Entity.enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import towerdefense.Player;

import static towerdefense.config.TILE_SIZE;
import static towerdefense.config.pathImg;

public class BossEnemy extends Enemy {
    private final double SPEED = 1;
    private final Direction DIRECTION = Direction.UP;
    private final int HEALTH = 300;
    private final int ARMOR = 100;
    private final int REWARD = 50;

    public BossEnemy(){
        this.setSpeed(SPEED + (Player.Instance().getLevel() - 1) * 10 * SPEED / 100);
        this.setDirection(DIRECTION);
        this.setHealth(HEALTH + (Player.Instance().getLevel() - 1) * 10 * HEALTH/100);
        this.setArmor(ARMOR + (Player.Instance().getLevel() - 1) * 5 * ARMOR/100);
        this.setReward(REWARD +(Player.Instance().getLevel() - 1) * 10 * REWARD/100);
        this.setImg(new Image(pathImg + "towerDefense_tile270.png"));
        this.setGunImg(new Image(pathImg + "towerDefense_tile293.png"));

    }


    @Override
    public double getMaxHealth() {
        return HEALTH + (Player.Instance().getLevel() - 1) * 10 * HEALTH/100;
    }
    @Override
    public String toString(){
        return "BossEnemy";
    }
    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
        drawRotatedImage(gc, this.getImg(), super.getDirection().getDegree(), this.getX(), this.getY());
        drawRotatedImage(gc, this.getGunImg(), super.getDirection().getDegree(), this.getX() - TILE_SIZE/3, this.getY()+TILE_SIZE/3);
    }
}
