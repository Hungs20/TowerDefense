package towerdefense.Entity.tower;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import towerdefense.Entity.Bullet;
import towerdefense.Entity.enemy.Enemy;
import towerdefense.GameEntity;
import towerdefense.GameStage;

import java.util.ArrayList;
import java.util.List;
import towerdefense.*;

import static towerdefense.config.getRadius;

public abstract class Tower extends GameEntity {
    private double speed;
    private double area;
    private int damage;
    private Image gunImg;
    private Image bgImg;

    public Image getBgImg() {
        return bgImg;
    }

    public void setBgImg(Image bgImg) {
        this.bgImg = bgImg;
    }

    public List<Bullet> getBulletList() {
        return bulletList;
    }

    public void setBulletList(List<Bullet> bulletList) {
        this.bulletList = bulletList;
    }

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

    public Bullet createBullet(){
        Bullet bullet = new Bullet();
        bullet.setX(this.getX());
        bullet.setY(this.getY());

        bullet.setGunImg(gunImg);
        bullet.setDamage(damage);
        bullet.setSpeed(speed);
        bullet.setMaxDistance(area);

        return bullet;
    }


    @Override
    public void render(GraphicsContext gc) {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);

        gc.drawImage(bgImg, this.getX(), this.getY());
        ImageView iv = new ImageView(this.getImg());
        List<GameEntity> gameEntityList = new ArrayList<GameEntity>();
        gameEntityList = GameField.gameEntities;
        for(int i = 0; i < gameEntityList.size(); i++){
            if(gameEntityList.get(i) instanceof Enemy){
                double value = getRadius(new Point(this.getX(), -this.getY()), new Point(gameEntityList.get(i).getX(), -gameEntityList.get(i).getY()));
                System.out.println(value);
                iv.setRotate(value);
            }
        }
        Image tower = iv.snapshot(params, null);
        gc.drawImage(tower, this.getX(), this.getY());

    }

    @Override
    public void update() {

    }
}
