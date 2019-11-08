package towerdefense.GameMap;

import towerdefense.Entity.enemy.Enemy;

import static towerdefense.GameField.enemyList;
import static towerdefense.config.TILE_SIZE;

public class Spawner extends TitleMap{
    private Road start;
    private static Spawner instance;

    private Spawner(int i_left, int j_left, int i_right, int j_right)
    {
        start = new Road("towerDefense_tile025.png",i_left ,j_left ,"towerDefense_tile023.png",i_right,j_right);
    }

    public static Spawner getSpawner()
    {
        if(instance == null) instance = new Spawner(0,8,1,8);
        return instance;
    }

    public void createEnemy(int i, int j, Enemy _newEnemy)
    {
        Enemy newEnemy = _newEnemy;
        newEnemy.setI(i);
        newEnemy.setJ(j);
        newEnemy.setX(newEnemy.getI() * TILE_SIZE + TILE_SIZE/2);
        newEnemy.setY(newEnemy.getJ() * TILE_SIZE);
        enemyList.add(newEnemy);
    }
}
