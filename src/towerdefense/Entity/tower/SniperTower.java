package towerdefense.Entity.tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import towerdefense.Entity.enemy.BossEnemy;
import towerdefense.Entity.enemy.NormalEnemy;
import towerdefense.Entity.enemy.SmallerEnemy;
import towerdefense.Entity.enemy.TankerEnemy;
import towerdefense.Sound.Sound;

import static towerdefense.config.*;
import static towerdefense.config.pathImg;

public class SniperTower extends Tower {

    public SniperTower(){
        this.setSpeed(SPEED_SNIPER_TOWER);
        this.setRadius(130);
        this.setDamage(80);
        this.setPrice(40);
        this.setName("Sniper");
        this.setLevel(0);
        this.setImg(new Image(pathImg + "towerDefense_tile203.png"));
        this.setBgImg(new Image(pathImg + "towerDefense_tile180.png"));
        this.setBulletImg(new Image(pathImg + "towerDefense_tile295.png"));
        this.getListEnemyType().add(new BossEnemy());
        this.setShottingSound(new Sound("src/towerdefense/Sound/sounds/4_t1shot.mp3"));
    }
    @Override
    public void resetSpeed() {
        this.setSpeed(SPEED_SNIPER_TOWER);
    }
    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }

    @Override
    public void update() {
        super.update();
        if(this.getSpeed() <= 0){

        }
    }

    @Override
    public void upgrade(){
        super.upgrade();
        if(this.getLevel() == 2) {
            this.setImg(new Image(pathImg + "towerDefense_tile204.png"));
            this.setBulletImg(new Image(pathImg + "towerDefense_tile251.png"));
            this.setBgImg(new Image(pathImg + "towerDefense_tile181.png"));
        }
        if(this.getLevel() == 3) {
            this.setImg(new Image(pathImg + "towerDefense_tile205.png"));
            this.setBulletImg(new Image(pathImg + "towerDefense_tile251.png"));
            this.setBgImg(new Image(pathImg + "towerDefense_tile182.png"));
        }
        if(this.getLevel() == 4) {
            this.setImg(new Image(pathImg + "towerDefense_tile206.png"));
            this.setBulletImg(new Image(pathImg + "towerDefense_tile252.png"));
            this.setBgImg(new Image(pathImg + "towerDefense_tile183.png"));
        }
        this.getImgView().setImage(this.getImg());
    }
}
