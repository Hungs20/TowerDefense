package towerdefense;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import towerdefense.Entity.enemy.Enemy;
import towerdefense.Entity.enemy.NormalEnemy;
import towerdefense.Entity.tower.NormalTower;
import towerdefense.Entity.tower.Tower;

import java.util.ArrayList;
import java.util.List;

import static towerdefense.config.*;
import static towerdefense.config.MAP_SPRITES;

public class GameField {
    private GraphicsContext gc;


    public static List<GameEntity> gameEntities = new ArrayList<>();

    public GraphicsContext getGc() {
        return gc;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }


    public void setGameEntities(List<GameEntity> gameEntities) {
        this.gameEntities = gameEntities;
    }

    private void drawMap() {
        for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                gc.drawImage(new Image(pathImg + "towerDefense_tile" + MAP_SPRITES[i][j] + ".png"), j * TILE_SIZE, i * TILE_SIZE);
            }
        }
    }

    private void drawMenu(){
        for(int i = 0; i < MENU_SPRITES.length; i++){
            for(int j = 0; j < MENU_SPRITES[i].length; j++){
                gc.drawImage(new Image(pathImg + "towerDefense_tile" + MENU_SPRITES[i][j] + ".png"), (j + 10) * TILE_SIZE, i * TILE_SIZE);
            }
        }
    }

    public void update() {
        gameEntities.forEach(GameEntity::update);
    }

    public void render() {
        drawMap();
        drawMenu();
        gameEntities.forEach(g -> g.render(gc));
    }

    public Enemy createEnemy() {
        Enemy normalEnemy = new NormalEnemy();
        normalEnemy.setI(0);
        normalEnemy.setJ(6);
        normalEnemy.setX(normalEnemy.getI() * TILE_SIZE + TILE_SIZE/2);
        normalEnemy.setY(normalEnemy.getJ() * TILE_SIZE);

        return normalEnemy;
    }

    public Tower createTower(){
        Tower normalTower = new NormalTower();
        normalTower.setI(3);
        normalTower.setJ(5);
        normalTower.setX(normalTower.getI() * TILE_SIZE + TILE_SIZE/2);
        normalTower.setY(normalTower.getJ() * TILE_SIZE);

        return normalTower;
    }

    public void addEnemy(){
        gameEntities.add(createEnemy());
    }
    public void addTower(){
        gameEntities.add(createTower());
    }
}
