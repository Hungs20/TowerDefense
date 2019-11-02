package towerdefense;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import towerdefense.Entity.enemy.Direction;
import towerdefense.Entity.enemy.Enemy;
import towerdefense.Entity.enemy.NormalEnemy;
import towerdefense.Image.Img;
import towerdefense.location.Location;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static towerdefense.config.*;

public class GameStage extends Application {

    GraphicsContext gc;
    List<GameEntity> gameEntities = new ArrayList<>();
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Tower Defense");
        // Tao Canvas
        Canvas canvas = new Canvas(TILE_SIZE * 10, TILE_SIZE * 7);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();



        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();
        gameEntities.add(createEnemy());
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void drawMap(GraphicsContext gc) {
        for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                gc.drawImage(new Image(pathImg + "towerDefense_tile" + MAP_SPRITES[i][j] + ".png"), j * TILE_SIZE, i * TILE_SIZE);
            }
        }
    }
    public void update() {
        gameEntities.forEach(GameEntity::update);
    }

    public void render() {
        drawMap(gc);
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
}
