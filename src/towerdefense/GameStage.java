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
import javafx.stage.Screen;
import javafx.stage.Stage;
import towerdefense.Entity.enemy.Enemy;
import towerdefense.Entity.enemy.NormalEnemy;
import towerdefense.Entity.menu.Button.ButtonStart;
import towerdefense.Entity.menu.Menu;
import towerdefense.Entity.tower.NormalTower;
import towerdefense.Entity.tower.Tower;
import towerdefense.GameMap.Spawner;
import towerdefense.Sound.GameSound;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static towerdefense.config.*;

public class GameStage extends Application {

    private GraphicsContext gc;

    public static MouseEvent event;
    public static Scene scene;
    public static Label infoLable;

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Tower Defense");
        // Tao Canvas
        Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        gc = canvas.getGraphicsContext2D();
        infoLable = new Label();
        root.getChildren().addAll(canvas, infoLable);

        // Tao scene
         scene = new Scene(root);

        // Them scene vao stage
        scene.setFill(Color.LIGHTGREY);
        stage.setScene(scene);
        stage.show();
        GameField.getInstance().setGc(gc);
         AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long l) {
                gc.clearRect(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);
                GameSound.Instance().backgroundSound();
                GameField.getInstance().render();
                if(ButtonStart.Instance().isStart())
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
