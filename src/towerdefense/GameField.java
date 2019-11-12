package towerdefense;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import towerdefense.Entity.Bullet;
import towerdefense.Entity.enemy.Enemy;
import towerdefense.Entity.enemy.NormalEnemy;
import towerdefense.Entity.enemy.TankerEnemy;
import towerdefense.Entity.menu.ItemTower;
import towerdefense.Entity.menu.Menu;
import towerdefense.Entity.tower.NormalTower;
import towerdefense.Entity.tower.Tower;
import towerdefense.GameMap.*;

import java.util.ArrayList;
import java.util.List;

import static towerdefense.config.*;
//import static towerdefense.config.MAP_SPRITES;

public class GameField {
    private static GameField instance;
    public static GameField getInstance(){
        if(instance==null)instance= new GameField();
        return instance;
    }

    private GraphicsContext gc;


    public static List<Enemy> enemyList = new ArrayList<>();
    public static List<GameEntity> towerList = new ArrayList<>();

    public static List<Land> landList = new ArrayList<>();
    public static List<Road> roadList = new ArrayList<>();
    public static Spawner spawner = new Spawner(0,1);
    public static Target target = new Target(MAP_WIDTH - 1, MAP_HEIGHT - 1);
    public static List<TitleMap> otherTileList = new ArrayList<>();



    public GraphicsContext getGc() {
        return gc;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }


    public void update() {
        Map.Instance().update();
        enemyList.forEach(GameEntity::update);
        towerList.forEach(GameEntity::update);
        Menu.getInstance().prinInforPlayer();
    }

    public void render() {
        Map.Instance().render(gc);
        enemyList.forEach(g -> g.render(gc));
        towerList.forEach(g -> g.render(gc));
    }

    public Tower createTower(int i, int j, Tower _newTower){
        Tower newTower = _newTower;
        newTower.setI(i);
        newTower.setJ(j);
        newTower.setX(newTower.getI() * TILE_SIZE);
        newTower.setY(newTower.getJ() * TILE_SIZE);
        return newTower;
    }

    public static List<GameEntity> getTowerList() {
        return towerList;
    }

    public void addTower(){
        Menu.getInstance().createItemTower();
        towerList.add(createTower(9,6, new NormalTower()));
    }
}
