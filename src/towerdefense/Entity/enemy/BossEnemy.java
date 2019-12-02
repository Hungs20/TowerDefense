package towerdefense.Entity.enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import static towerdefense.config.TILE_SIZE;
import static towerdefense.config.pathImg;

public class BossEnemy extends Enemy {
    private final double SPEED = 1;
    private final Direction DIRECTION = Direction.UP;
    private final int HEALTH = 1000;
    private final int ARMOR = 1000;
    private final int REWARD = 100;

    public BossEnemy(){
        this.setSpeed(SPEED);
        this.setDirection(DIRECTION);
        this.setHealth(HEALTH);
        this.setArmor(ARMOR);
        this.setReward(REWARD);
        this.setImg(new Image(pathImg + "towerDefense_tile270.png"));
        this.setGunImg(new Image(pathImg + "towerDefense_tile293.png"));

    }


    @Override
    public double getMaxHealth() {
        return HEALTH;
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
        drawRotatedImage(gc, this.getImg(), super.getDirection().getDegree(), this.getX(), this.getY());
        drawRotatedImage(gc, this.getGunImg(), super.getDirection().getDegree(), this.getX() - TILE_SIZE/3, this.getY()+TILE_SIZE/3);
    }
}
