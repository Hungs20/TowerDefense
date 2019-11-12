package towerdefense.GameMap;

import javafx.scene.image.Image;
import towerdefense.Entity.enemy.Enemy;
import towerdefense.Entity.enemy.NormalEnemy;
import towerdefense.Entity.enemy.TankerEnemy;
import towerdefense.Player;

import java.util.Random;

import static towerdefense.GameField.enemyList;
import static towerdefense.config.*;

public class Spawner extends TitleMap{

    public Spawner() {
        this.setImg(new Image(pathImg + "towerDefense_tile059.png"));
        int rand = (int)(Math.random()*4) + 1;
        int valX = (int)(Math.random() * MAP_WIDTH);
        int valY = (int)(Math.random() * MAP_HEIGHT);
        switch (rand){
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

        }
        this.setX(this.getI() * TILE_SIZE);
        this.setY(this.getJ() * TILE_SIZE);

    }

    public Spawner(int i, int j) {
        super(i, j);
        this.setImg(new Image(pathImg + "towerDefense_tile059.png"));
    }

    public void update(){
        if(enemyList.size() == 0){
            Player.Instance().setLevel(Player.Instance().getLevel() + 1);
            addEnemy();
        }
    }

    public Enemy createEnemy(int i, int j, Enemy _newEnemy) {
        Enemy newEnemy = _newEnemy;
        newEnemy.setI(i);
        newEnemy.setJ(j);
        newEnemy.setX(newEnemy.getI() * TILE_SIZE);
        newEnemy.setY(newEnemy.getJ() * TILE_SIZE);

        return newEnemy;
    }

    public void addEnemy(){
        for(int i = 0; i <= 6; i++) {
            if(Player.Instance().getLevel() % 2 == 0) enemyList.add(createEnemy(this.getI(), this.getJ() + i * 6, new NormalEnemy()));
            else enemyList.add(createEnemy(this.getI(), this.getJ() + i * 6, new TankerEnemy()));
        }
    }
}
