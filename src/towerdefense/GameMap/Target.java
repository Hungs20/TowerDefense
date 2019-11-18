package towerdefense.GameMap;

import javafx.scene.image.Image;
import towerdefense.Entity.enemy.Enemy;
import towerdefense.Entity.menu.Button.ButtonStart;
import towerdefense.Entity.menu.Menu;
import towerdefense.GameField;
import towerdefense.Player;

import java.util.ArrayList;
import java.util.List;

import static towerdefense.GameField.enemyList;
import static towerdefense.config.*;

public class Target extends TitleMap{
    private List<Enemy> enemiInTarget = new ArrayList<>();

    public List<Enemy> getEnemiInTarget() {
        return enemiInTarget;
    }

    public void setEnemiInTarget(List<Enemy> enemiInTarget) {
        this.enemiInTarget = enemiInTarget;
    }

    public void update(){
        for(int i = 0; i < enemiInTarget.size(); i++){
            Player.Instance().setLifes(Player.Instance().getLifes()-1);
            enemyList.remove(enemiInTarget.get(i));
        }
        enemiInTarget.clear();
    }

    public Target() {
        this.setImg(new Image(pathImg + "towerDefense_tile049.png"));
        int rand = (int)(Math.random()*4) + 1;
        int valX = (int)(Math.random() * MAP_WIDTH);
        int valY = (int)(Math.random() * MAP_HEIGHT);
        this.setI(valX);
        this.setJ(valY);
        /*switch (rand){
            case 1: // Left
                this.setI(0);
                this.setJ(valY);
                break;
            case 2: // Right
                this.setI(MAP_WIDTH - 1);
                this.setJ(valY);
                break;
            case 3: // UP
                this.setI(valX);
                this.setJ(0);
            case 4: //down
                this.setI(valX);
                this.setJ(MAP_HEIGHT - 1);

        }*/
        this.setX(this.getI() * TILE_SIZE);
        this.setY(this.getJ() * TILE_SIZE);

    }

    public Target(int i, int j) {
        super(i, j);
        this.setImg(new Image(pathImg + "towerDefense_tile049.png"));
    }

}
