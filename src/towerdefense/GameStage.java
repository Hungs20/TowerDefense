package towerdefense;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import towerdefense.Entity.enemy.Enemy;
import towerdefense.Entity.enemy.NormalEnemy;
import towerdefense.Entity.menu.Menu;
import towerdefense.Entity.tower.NormalTower;
import towerdefense.Entity.tower.Tower;
import towerdefense.GameMap.Spawner;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static towerdefense.config.*;

public class GameStage extends Application {

    private GraphicsContext gc;

    public static MouseEvent event;


    @Override
    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Tower Defense");
        // Tao Canvas
        Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        gc = canvas.getGraphicsContext2D();


        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        scene.setFill(Color.LIGHTGREY);
        stage.setScene(scene);
        stage.show();

        GameField.getInstance().setGc(gc);
         AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                GameField.getInstance().render();
                if(Menu.getInstance().isStart())
                {
                    GameField.getInstance().update();
                }
            }
        };
        timer.start();

    }


    public static void main(String[] args) {
        launch(args);
    }

}
