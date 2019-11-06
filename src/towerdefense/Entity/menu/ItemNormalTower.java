package towerdefense.Entity.menu;

import javafx.scene.image.Image;

import static towerdefense.config.pathImg;

public class ItemNormalTower extends ItemTower {
    public ItemNormalTower() {
        this.setSpeed(100);
        this.setArea(200);
        this.setDamage(100);
        this.setImg(new Image(pathImg + "towerDefense_tile249.png"));
        this.setName("Normal Tower");
        this.setPrice(100);
        this.setLevel(1);
    }
}
