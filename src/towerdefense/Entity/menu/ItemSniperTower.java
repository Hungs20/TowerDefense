package towerdefense.Entity.menu;

import javafx.scene.image.Image;
import towerdefense.Entity.tower.NormalTower;
import towerdefense.Entity.tower.SniperTower;
import towerdefense.Entity.tower.Tower;

import static towerdefense.config.SPEED_SNIPER_TOWER;
import static towerdefense.config.pathImg;

public class ItemSniperTower extends ItemTower {
    public ItemSniperTower() {
        this.setSpeed(SPEED_SNIPER_TOWER);
        this.setArea(150);
        this.setDamage(150);
        this.setImg(new Image(pathImg + "towerDefense_tile250.png"));
        this.setName("Sniper Tower");
        this.setPrice(15);
        this.setLevel(1);
        this.setTower(new SniperTower());
    }

    @Override
    public Tower getTower()
    {
        return new SniperTower();
    }
}
