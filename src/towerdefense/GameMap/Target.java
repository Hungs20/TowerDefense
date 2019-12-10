package towerdefense.GameMap;

import javafx.scene.image.Image;
import towerdefense.Entity.enemy.Enemy;
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
        if(levelMap == 0){
            this.setI(MAP_WIDTH - 2);
            this.setJ(MAP_HEIGHT - 2);
        }
        else if(levelMap == 1){
            this.setI(MAP_WIDTH - 2);
            this.setJ(MAP_HEIGHT - 2);
        }
        else
        {
            this.setI(MAP_WIDTH - 1);
            this.setJ(MAP_HEIGHT/2);
        }

    }

    public Target(int i, int j) {
        super(i, j);
        this.setImg(new Image(pathImg + "towerDefense_tile049.png"));
    }

}
