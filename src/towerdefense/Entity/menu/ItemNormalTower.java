package towerdefense.Entity.menu;

import javafx.scene.image.Image;
import towerdefense.Entity.tower.NormalTower;
import towerdefense.Entity.tower.Tower;

import static towerdefense.config.pathImg;

public class ItemNormalTower extends ItemTower {
    public ItemNormalTower() {
        this.setSpeed(100);
        this.setArea(200);
        this.setDamage(100);
        this.setImg(new Image(pathImg + "towerDefense_tile249.png"));
        this.setName("Normal Tower");
        this.setPrice(10);
        this.setLevel(1);
        this.setTower(new NormalTower());
    }

    @Override
    public Tower getTower()
    {
        return new NormalTower();
    }
}
