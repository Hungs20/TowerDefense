package towerdefense.Entity.tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import towerdefense.Entity.enemy.NormalEnemy;
import towerdefense.Entity.enemy.SmallerEnemy;
import towerdefense.Entity.enemy.TankerEnemy;

import static towerdefense.config.SPEED_MACHINE_TOWER;
import static towerdefense.config.pathImg;

public class MachineGunTower extends Tower {

    public MachineGunTower(){
        this.setSpeed(SPEED_MACHINE_TOWER);
        this.setRadius(200);
        this.setDamage(105);
        this.setPrice(20);
        this.setName("MachineGun Tower");
        this.setLevel(0);
        this.setImg(new Image(pathImg + "towerDefense_tile250.png"));
        this.setBgImg(new Image(pathImg + "towerDefense_tile180.png"));
        this.setBulletImg(new Image(pathImg + "towerDefense_tile295.png"));
        this.getListEnemyType().add(new NormalEnemy());
        this.getListEnemyType().add(new SmallerEnemy());
        this.getListEnemyType().add(new TankerEnemy());
    }

    @Override
    public void resetSpeed() {
        this.setSpeed(SPEED_MACHINE_TOWER);
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }

    @Override
    public void update() {
        super.update();
    }

    public void upgrade(){
        super.upgrade();
        if(this.getLevel() == 2) {
            this.setBulletImg(new Image(pathImg + "towerDefense_tile296.png"));
            this.setBgImg(new Image(pathImg + "towerDefense_tile181.png"));
        }
        if(this.getLevel() == 3) {
            this.setBulletImg(new Image(pathImg + "towerDefense_tile297.png"));
            this.setBgImg(new Image(pathImg + "towerDefense_tile182.png"));
        }
        if(this.getLevel() == 4) {
            this.setBulletImg(new Image(pathImg + "towerDefense_tile298.png"));
            this.setBgImg(new Image(pathImg + "towerDefense_tile183.png"));
        }
    }
}
