package towerdefense.Entity.tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static towerdefense.config.*;
import static towerdefense.config.pathImg;

public class RocketTower extends Tower {

    public RocketTower(){
        this.setSpeed(SPEED_ROCKET_TOWER);
        this.setRadius(130);
        this.setDamage(120);
        this.setPrice(24);
        this.setName("Rocket Tower");
        this.setLevel(0);
        this.setImg(new Image(pathImg + "towerDefense_tile206.png"));
        this.setBgImg(new Image(pathImg + "towerDefense_tile182.png"));
        this.setBulletImg(new Image(pathImg + "towerDefense_tile251.png"));
    }
    @Override
    public void resetSpeed() {
        this.setSpeed(SPEED_ROCKET_TOWER);
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
