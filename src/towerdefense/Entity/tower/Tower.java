package towerdefense.Entity.tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import towerdefense.Entity.Bullet;
import towerdefense.GameEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower extends GameEntity {
    private double speed;
    private double area;
    private int damage;
    private Image gunImg;
    private List<Bullet> bulletList = new ArrayList<>();

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
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

    @Override
    public void render(GraphicsContext gc) {

    }

    @Override
    public void update() {

    }
}
