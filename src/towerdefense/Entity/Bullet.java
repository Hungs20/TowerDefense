package towerdefense.Entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import towerdefense.GameEntity;
import towerdefense.Point;

import static towerdefense.GameField.bulletList;
import static towerdefense.GameField.enemyList;

public class Bullet extends GameEntity {
    private Image bulletImg;
    private int damage;
    private int speed = 20;
    private double maxDistance;
    private double distance;
    private double angle;

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Bullet(Image bulletImg, int damage, int speed, int maxDistance, double angle) {
        this.bulletImg = bulletImg;
        this.damage = damage;
        this.speed = speed;
        this.maxDistance = maxDistance;
        this.angle = angle;
    }

    public Bullet() {

    }

    public Image getBulletImg() {
        return bulletImg;
    }

    public void setBulletImg(Image bulletImg) {
        this.bulletImg = bulletImg;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
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
        gc.save();
        gc.rotate(angle);
        gc.drawImage(bulletImg, this.getX(), this.getY());
        gc.restore();
    }

    @Override
    public void update() {
        Point currentPos = new Point(this.getX(), this.getY());
        this.setX((int) (this.getX() + speed * Math.cos(angle)));
        this.setY((int) (this.getY() + speed * Math.sin(angle)));
        Point newPos = new Point(this.getX(), this.getY());
        distance += currentPos.getDistance(newPos);
    }
}
