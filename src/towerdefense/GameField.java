package towerdefense;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import towerdefense.Entity.enemy.Enemy;
import towerdefense.Entity.menu.Menu;
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
    ImageView iconPause = new ImageView(new Image(pathImg + "pause.png"));

    public static List<Enemy> enemyList = new ArrayList<>();
    public static List<Tower> towerList = new ArrayList<>();

    public static List<Land> landList = new ArrayList<>();
    public static List<Road> roadList = new ArrayList<>();

    public static Spawner spawner = new Spawner();
    public static Target target = new Target();
    public static List<TitleMap> otherTileList = new ArrayList<>();



    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }


    public void update() {
        Map.Instance().update();
        enemyList.forEach(GameEntity::update);
        towerList.forEach(GameEntity::update);
        iconPause.setOnMouseClicked(eventPause ->{
            isPlay = !isPlay;
            if(isPlay) iconPause.setImage(new Image(pathImg + "pause.png"));
            else iconPause.setImage(new Image(pathImg + "play.png"));
        });
    }

    public void render() {
        Map.Instance().render(gc);
        enemyList.forEach(g -> g.render(gc));
        towerList.forEach(g -> g.render(gc));
        Menu.getInstance().showMenu();
        Player.Instance().showInfoPlayer(gc);

        //icon pause

        iconPause.setX(35);iconPause.setY(0);
        if(root.getChildren().indexOf(iconPause) < 0) root.getChildren().add(iconPause);

    }


    public static List<Tower> getTowerList() {
        return towerList;
    }


    public void newGame()
    {
        isPlay = true;
        iconPause.setImage(new Image(pathImg + "pause.png"));
        spawner = new Spawner();
        target = new Target();
        Map.Instance().createNewMap();
        Player.Instance().newGame();
        enemyList.clear();
        towerList.forEach(g->root.getChildren().remove(g.getImgView()));
        towerList.clear();
        Menu.getInstance().clearAll();
    }
}
