package towerdefense.Entity.tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import towerdefense.Entity.menu.Button.SellButton;

import static towerdefense.config.SPEED_SNIPER_TOWER;
import static towerdefense.config.pathImg;

public class SniperTower extends Tower {
    public SniperTower(SniperTower sniperTower)
    {
        super(sniperTower);
    }

    public SniperTower(){
        this.setSpeed(SPEED_SNIPER_TOWER);
        this.setRadius(200);
        this.setDamage(105);
        this.setPrice(20);
        this.setName("Sniper Tower");
        this.setLevel(0);
        this.setImg(new Image(pathImg + "towerDefense_tile250.png"));
        this.setBgImg(new Image(pathImg + "towerDefense_tile182.png"));
        this.setBulletImg(new Image(pathImg + "towerDefense_tile251.png"));
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
    }
}
