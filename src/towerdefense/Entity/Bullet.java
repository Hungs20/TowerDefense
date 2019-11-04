package towerdefense.Entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import towerdefense.GameEntity;

public class Bullet extends GameEntity {
    private Image gunImg;
    private int damage;
    private double speed;
    private double maxDistance;

    public Bullet(Image gunImg, int damage, double speed, int maxDistance) {
        this.gunImg = gunImg;
        this.damage = damage;
        this.speed = speed;
        this.maxDistance = maxDistance;
    }

    public Bullet() {

    }

    public Image getGunImg() {
        return gunImg;
    }

    public void setGunImg(Image gunImg) {
        this.gunImg = gunImg;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(gunImg, this.getX(), this.getY());
    }

    @Override
    public void update() {

    }
}
