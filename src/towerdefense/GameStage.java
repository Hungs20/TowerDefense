package towerdefense;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import towerdefense.Entity.enemy.Enemy;
import towerdefense.Entity.enemy.NormalEnemy;
import towerdefense.Entity.menu.Menu;
import towerdefense.Entity.tower.NormalTower;
import towerdefense.Entity.tower.Tower;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static towerdefense.config.*;

public class GameStage extends Application {

    private GraphicsContext gc;




    @Override
    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Tower Defense");
        // Tao Canvas
        Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        gc = canvas.getGraphicsContext2D();



        // Tao root container
        Group root = new Group();

        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();




        GameField gameField = new GameField();
        gameField.setGc(gc);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                gameField.render();
                gameField.update();
            }
        };
        timer.start();

        gameField.addEnemy();
        gameField.addTower();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
