package towerdefense.Entity.tower;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import towerdefense.Entity.Bullet;
import towerdefense.Entity.enemy.Enemy;
import towerdefense.GameEntity;
import towerdefense.GameStage;

import java.util.ArrayList;
import java.util.List;
import towerdefense.*;

import static towerdefense.config.*;

public abstract class Tower extends GameEntity  {
    private int speed;
    private double radius;
    private int damage;
    private Image bgImg;
    private Image bulletImg;
    private ImageView imgView;
    private boolean isClick = false;


    private double angle = 0;
    private List<Bullet> bulletList = new ArrayList<>();

    public ImageView getImgView() {
        return imgView;
    }

    public void setImgView(ImageView imgView) {
        this.imgView = imgView;
    }


    public List<Bullet> getBulletList() {
        return bulletList;
    }

    public void setBulletList(List<Bullet> bulletList) {
        this.bulletList = bulletList;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

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


    public Bullet createBullet(){
        Bullet bullet = new Bullet();
        bullet.setX(this.getX());
        bullet.setY(this.getY());
        bullet.setAngle(this.angle);
        bullet.setDistance(0);
        bullet.updateNewPos();
        bullet.setImg(bulletImg);
        bullet.setDamage(damage);
        bullet.setMaxDistance(radius);
        bullet.setIsHas(true);
        return bullet;
    }


    public abstract void resetSpeed();

    public void drawCircle(GraphicsContext gc){
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeOval(this.getX() + this.bgImg.getWidth()/2 - radius, this.getY() + this.bgImg.getHeight()/2 - radius, radius*2, radius*2);
    }
    @Override
    public void render(GraphicsContext gc) {

        if(isClick)
        {
            drawCircle(gc);
        }
        gc.drawImage(getBgImg(), getX(), getY());
        //drawRotatedImage(gc, this.getImg(), getAngle(), this.getX(), this.getY());
        if(root.getChildren().indexOf(this.imgView) < 0)
        {
            this.imgView = createImageView(this.getImg(),this.getX(),this.getY());
            this.imgView.setOnMouseClicked(event -> {
                isClick=!isClick;
            });
            root.getChildren().addAll(this.imgView);
        }
        else this.getImgView().setRotate(getAngle());
        List<Bullet> bullets = this.getBulletList();
        if(bullets != null) bullets.forEach(g -> g.render(gc));

    }

    @Override
    public void update() {
        List<GameEntity> enemies = GameField.enemyList;

        Point towerPoint = new Point(this.getX() ,  this.getY() );
        List<Bullet> bullets = getBulletList();
        for(int i = 0; i < enemies.size(); i++){

            Point enemyPoint = new Point(enemies.get(i).getX() , enemies.get(i).getY() );
            double _angle = towerPoint.getAngle(enemyPoint);

            double distance = enemyPoint.getDistance(towerPoint);
            if(distance <= this.getRadius()){
                setAngle(_angle + 90);
                if(this.getSpeed() <= 0) {
                    Bullet _bullet = this.createBullet();
                    bullets.add(_bullet);
                    resetSpeed();
                }
            }
        }
        this.setSpeed(this.getSpeed() - 1);
        for(int i = bullets.size() - 1; i >= 0; i--){
            Bullet bullet = bullets.get(i);
            if(bullet == null) break;
            if(bullet.getDistance() > bullet.getMaxDistance() ) bullet.setIsHas(false);
            for(int j = GameField.enemyList.size() - 1; j >= 0; j--){
                Enemy enemy = (Enemy) GameField.enemyList.get(j);

                if(enemy == null) break;
                if(bullet.isCollision(enemy)) {
                    enemy.setHealth(enemy.getHealth() - this.damage);
                    if(enemy.getHealth() <= 0) GameField.enemyList.remove(enemy);
                    bullet.setIsHas(false);
                }
            }
            if(bullet.getIsHas() == false) bullets.remove(i);
        }

        if(bullets != null) bullets.forEach(GameEntity::update);
        setBulletList(bullets);
    }
}
