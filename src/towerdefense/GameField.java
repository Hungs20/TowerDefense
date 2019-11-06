package towerdefense;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import towerdefense.Entity.Bullet;
import towerdefense.Entity.enemy.Enemy;
import towerdefense.Entity.enemy.NormalEnemy;
import towerdefense.Entity.menu.ItemTower;
import towerdefense.Entity.menu.Menu;
import towerdefense.Entity.tower.NormalTower;
import towerdefense.Entity.tower.Tower;

import java.util.ArrayList;
import java.util.List;

import static towerdefense.config.*;
import static towerdefense.config.MAP_SPRITES;

public class GameField {
    private GraphicsContext gc;


    public static List<GameEntity> enemyList = new ArrayList<>();
    public static List<GameEntity> towerList = new ArrayList<>();
    public static List<ItemTower> itemTowerList = new ArrayList<>();
    public static List<GameEntity> bulletList = new ArrayList<>();


    public GraphicsContext getGc() {
        return gc;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }




    private void drawMap() {
        for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                gc.drawImage(new Image(pathImg + "towerDefense_tile" + MAP_SPRITES[i][j] + ".png"), j * TILE_SIZE, i * TILE_SIZE);
            }
        }
    }

    private void drawMenu(){
        Menu menu = new Menu();
        menu.createItemTower();
        menu.showMenu(gc);
    }

    public void update() {
        for(int i = 0; i < bulletList.size(); i++){
            boolean isCol = false;
            for(int j = 0; j < enemyList.size(); j++){
                GameEntity bullet = (Bullet)bulletList.get(i);
                GameEntity enemy = (Enemy)enemyList.get(j);
                if(bullet.isCollision(enemy)){
                    ((Enemy) enemy).setHealth(((Enemy) enemy).getHealth() - ((Bullet) bullet).getDamage());
                    if(((Enemy) enemy).getHealth() <= 0) enemyList.remove(j);
                    bulletList.remove(i);
                    isCol = true;
                    break;
                }
            }
            if(isCol == true) break;
        }

        bulletList.forEach(GameEntity::update);
        for(int i = 0; i < bulletList.size(); i++) {
            Bullet bullet = (Bullet) bulletList.get(i);
            if(bullet.getDistance() > bullet.getMaxDistance()) bulletList.remove(i);
        }
        enemyList.forEach(GameEntity::update);
        towerList.forEach(GameEntity::update);
    }

    public void render() {
        drawMap();
        drawMenu();
        bulletList.forEach(g -> g.render(gc));
        enemyList.forEach(g -> g.render(gc));
        towerList.forEach(g -> g.render(gc));
    }

    public Enemy createEnemy(int i, int j, Enemy _newEnemy) {
        Enemy newEnemy = _newEnemy;
        newEnemy.setI(i);
        newEnemy.setJ(j);
        newEnemy.setX(newEnemy.getI() * TILE_SIZE + TILE_SIZE/2);
        newEnemy.setY(newEnemy.getJ() * TILE_SIZE);

        return newEnemy;
    }

    public Tower createTower(int i, int j, Tower _newTower){
        Tower newTower = _newTower;
        newTower.setI(i);
        newTower.setJ(j);
        newTower.setX(newTower.getI() * TILE_SIZE);
        newTower.setY(newTower.getJ() * TILE_SIZE);

        return newTower;
    }

    public void addEnemy(){
        enemyList.add(createEnemy(0, 6, new NormalEnemy()));
        enemyList.add(createEnemy(0, 10, new NormalEnemy()));
        enemyList.add(createEnemy(0, 12, new NormalEnemy()));


    }
    public void addTower(){
        towerList.add(createTower(3,5, new NormalTower()));
        towerList.add(createTower(7,6, new NormalTower()));
    }
}
