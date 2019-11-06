package towerdefense.Entity.tower;

import javafx.scene.image.Image;

import static towerdefense.config.pathImg;

public class NormalTower extends Tower {
    public NormalTower(){
        this.setSpeed(10);
        this.setRadius(300);
        this.setDamage(100);
        this.setGunImg(new Image(pathImg + "towerDefense_tile272.png"));
        this.setImg(new Image(pathImg + "towerDefense_tile249.png"));
        this.setBgImg(new Image(pathImg + "towerDefense_tile180.png"));
        this.setBulletImg(new Image(pathImg + "towerDefense_tile275.png"));
    }
    public void resetSpeed(){
        this.setSpeed(5);
    }
}
