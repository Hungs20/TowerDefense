package towerdefense.Entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import towerdefense.GameEntity;
import towerdefense.Point;

import static towerdefense.GameField.bulletList;
import static towerdefense.GameField.enemyList;

public class Bullet extends GameEntity {
    private Image gunImg;
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

    public Bullet(Image gunImg, int damage, int speed, int maxDistance, double angle) {
        this.gunImg = gunImg;
        this.damage = damage;
        this.speed = speed;
        this.maxDistance = maxDistance;
        this.angle = angle;
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
        gc.drawImage(gunImg, this.getX(), this.getY());
    }

    @Override
    public void update() {
        Point currentPos = new Point(this.getX(), this.getY());
        this.setX((int) (this.getX() + speed * Math.sin(angle)));
        this.setY((int) (this.getY() + speed * Math.cos(angle)));
        Point newPos = new Point(this.getX(), this.getY());
        distance += currentPos.getDistance(newPos);
       // distance = speed;
        System.out.println(speed + " " + maxDistance + " " + currentPos.getDistance(newPos));
    }
}
