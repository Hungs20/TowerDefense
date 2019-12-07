package towerdefense.Entity;

import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import towerdefense.GameEntity;
import towerdefense.Point;

import static towerdefense.GameField.enemyList;

public class Bullet extends GameEntity {
    private int damage;
    private int speed = 40;
    private double maxDistance;
    private double distance;
    private double angle;
    private boolean isHas;

    public boolean getIsHas() {
        return isHas;
    }

    public void setIsHas(boolean isHas) {
        this.isHas = isHas;
    }

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

    public Bullet(Image img, int damage, int speed, int maxDistance, double angle) {
        this.setImg(img);
        this.damage = damage;
        this.speed = speed;
        this.maxDistance = maxDistance;
        this.angle = angle;
    }

    public Bullet() {

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

    public void updateNewPos(){
       this.setX((int) (Math.cos(Math.toRadians(angle - 90)) * speed + this.getX()));
       this.setY((int) (Math.sin(Math.toRadians(angle - 90)) * speed + this.getY()));
        distance += speed;
    }
    @Override
    public void render(GraphicsContext gc) {
        this.drawRotatedImage(gc, this.getImg(), this.angle, this.getX(), this.getY());
    }

    @Override
    public void update() {
        updateNewPos();
    }


}
