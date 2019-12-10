package towerdefense.Entity.tower;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import towerdefense.Entity.Bullet;
import towerdefense.Entity.enemy.NormalEnemy;
import towerdefense.Entity.enemy.SmallerEnemy;
import towerdefense.Entity.enemy.TankerEnemy;
import towerdefense.Entity.menu.Button.SellButton;
import towerdefense.GameEntity;
import towerdefense.GameField;
import towerdefense.Point;

import java.util.ArrayList;
import java.util.List;

import static towerdefense.config.*;

public class NormalTower extends Tower {

    public NormalTower(){
        this.setSpeed(SPEED_NORMAL_TOWER);
        this.setRadius(150);
        this.setDamage(10);
        this.setPrice(15);
        this.setName("Normal Tower");
        this.setLevel(0);
        this.setImg(new Image(pathImg + "towerDefense_tile249.png"));
        this.setBgImg(new Image(pathImg + "towerDefense_tile180.png"));
        this.setBulletImg(new Image(pathImg + "towerDefense_tile272.png"));
        this.getListEnemyType().add(new NormalEnemy());
        this.getListEnemyType().add(new SmallerEnemy());
        this.getListEnemyType().add(new TankerEnemy());
    }

    @Override
    public void resetSpeed() {
        this.setSpeed(SPEED_NORMAL_TOWER);
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void upgrade(){
        super.upgrade();
        if(this.getLevel() == 2) {
            this.setBulletImg(new Image(pathImg + "towerDefense_tile273.png"));
            this.setBgImg(new Image(pathImg + "towerDefense_tile181.png"));
        }
        if(this.getLevel() == 3) {
            this.setBulletImg(new Image(pathImg + "towerDefense_tile274.png"));
            this.setBgImg(new Image(pathImg + "towerDefense_tile182.png"));
        }
        if(this.getLevel() == 4) {
            this.setBulletImg(new Image(pathImg + "towerDefense_tile275.png"));
            this.setBgImg(new Image(pathImg + "towerDefense_tile183.png"));
        }
    }
}
