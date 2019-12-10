package towerdefense.GameMap;

import javafx.scene.image.Image;
import towerdefense.Entity.enemy.*;
import towerdefense.Player;
import towerdefense.Point;

import static towerdefense.GameField.enemyList;
import static towerdefense.config.*;

public class Spawner extends TitleMap{
    private int numEnemy = NUM_ENEMY;
    public Spawner() {
        this.setImg(new Image(pathImg + "towerDefense_tile059.png"));
        if(levelMap == 0) {
            this.setI(1);this.setJ(1);
        }
        else if(levelMap == 1){
            this.setI(1);
            this.setJ(1);
        }
        else {
            this.setI(0);
            this.setJ(MAP_HEIGHT/2);
        }
        this.setX(this.getI() * TILE_SIZE);
        this.setY(this.getJ() * TILE_SIZE);

    }

    public Spawner(int i, int j) {
        super(i, j);
        this.setImg(new Image(pathImg + "towerDefense_tile059.png"));
    }

    public void update(){
        addEnemy();
        if(enemyList.size() == 0){
            numEnemy = NUM_ENEMY;
            Player.Instance().setLevel(Player.Instance().getLevel()+1);
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

    public void addEnemy() {
        while (numEnemy > 0) {
            if (enemyList.isEmpty() || new Point(enemyList.get(enemyList.size() - 1).getX(), enemyList.get(enemyList.size() - 1).getY()).getDistance(new Point(this.getX(), this.getY())) >= enemyList.get(enemyList.size() - 1).getImg().getWidth() * (Math.random() * 3 + 1) ) {
                if (Player.Instance().getLevel() % 5 == 0 && Player.Instance().getLevel() > 0) {
                    enemyList.add(createEnemy(this.getI(), this.getJ(), new BossEnemy()));
                    numEnemy--;
                } else {
                    int randNormal = (int) (Math.random() * 2);
                    int randTanker = (int) (Math.random() * 2);
                    int randSmall = (int) (Math.random() * 2);
                    if (randTanker == 1) enemyList.add(createEnemy(this.getI(), this.getJ(), new TankerEnemy()));
                    if (randNormal == 1) enemyList.add(createEnemy(this.getI(), this.getJ(), new NormalEnemy()));
                    if (randSmall == 1) enemyList.add(createEnemy(this.getI(), this.getJ(), new SmallerEnemy()));

                    numEnemy = numEnemy - randNormal - randTanker - randSmall;
                }
            }
            else break;
        }
    }

}
