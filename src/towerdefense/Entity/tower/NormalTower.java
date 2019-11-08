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
import towerdefense.GameEntity;
import towerdefense.GameField;
import towerdefense.Point;

import java.util.ArrayList;
import java.util.List;

import static towerdefense.config.SPEED_NORMAL_TOWER;
import static towerdefense.config.pathImg;

public class NormalTower extends Tower {
    public NormalTower(){
        this.setSpeed(SPEED_NORMAL_TOWER);
        this.setRadius(150);
        this.setDamage(100);
        this.setImg(new Image(pathImg + "towerDefense_tile249.png"));
        this.setBgImg(new Image(pathImg + "towerDefense_tile180.png"));
        this.setBulletImg(new Image(pathImg + "towerDefense_tile251.png"));
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
}
