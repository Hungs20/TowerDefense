package towerdefense.Entity.tower;

import javafx.geometry.Point2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import towerdefense.Entity.Bullet;
import towerdefense.Entity.enemy.Enemy;
import towerdefense.GameEntity;
import towerdefense.GameStage;

import java.util.ArrayList;
import java.util.List;
import towerdefense.*;

import static towerdefense.GameField.bulletList;
import static towerdefense.config.*;

public abstract class Tower extends GameEntity {
    private int speed;
    private double radius;
    private int damage;
    private Image gunImg;
    private Image bgImg;
    private Image bulletImg;

    public Image getBulletImg() {
        return bulletImg;
    }

    public void setBulletImg(Image bulletImg) {
        this.bulletImg = bulletImg;
    }

    public Image getBgImg() {
        return bgImg;
    }

    public void setBgImg(Image bgImg) {
        this.bgImg = bgImg;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public abstract void resetSpeed();
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Image getGunImg() {
        return gunImg;
    }

    public void setGunImg(Image gunImg) {
        this.gunImg = gunImg;
    }

    public Bullet createBullet(){
        Bullet bullet = new Bullet();
        bullet.setX((int) (this.getX() + this.getImg().getWidth()/2 - bulletImg.getWidth()/2));
        bullet.setY((int) (this.getY() + this.getImg().getHeight()/2 - bulletImg.getHeight()/2));

        bullet.setBulletImg(bulletImg);
        bullet.setDamage(damage);
        bullet.setMaxDistance(radius);

        return bullet;
    }


    private void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }
    private void drawRotatedImage(GraphicsContext gc, Image image, double angle, double tlpx, double tlpy) {
        gc.save(); // saves the current state on stack, including the current transform
        rotate(gc, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
        gc.drawImage(image, tlpx, tlpy);
        gc.restore(); // back to original state (before rotation)
    }
    @Override
    public void render(GraphicsContext gc) {

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeOval(this.getX() + this.bgImg.getWidth()/2 - radius, this.getY() + this.bgImg.getHeight()/2 - radius, radius*2, radius*2);

        gc.drawImage(bgImg, this.getX(), this.getY());
        List<GameEntity> enemies = GameField.enemyList;
        double angle = 0;
        Point towerPoint = new Point(this.getX() + (int)this.getImg().getWidth()/2,  this.getY() + (int)this.getImg().getHeight()/2);

        for(int i = 0; i < enemies.size(); i++){

            Point enemyPoint = new Point(enemies.get(i).getX() + (int)enemies.get(i).getImg().getWidth()/2, enemies.get(i).getY() + (int)enemies.get(i).getImg().getHeight()/2);
            double distance = enemyPoint.getDistance(towerPoint);
            if(distance <= this.radius){
                 angle = towerPoint.getAngle(enemyPoint) + 90;
                if(speed <= 0) {
                    Bullet bullet = this.createBullet();
                    bullet.setAngle(angle + 45);
                    System.out.println(angle);
                    bulletList.add(bullet);
                    resetSpeed();
                }
                else speed--;
                break;
            }
        }
        drawRotatedImage(gc, this.getImg(), angle, this.getX(), this.getY());

    }

    @Override
    public void update() {

    }
}
