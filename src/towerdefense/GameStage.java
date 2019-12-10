package towerdefense;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import towerdefense.Entity.menu.HelpPanel;
import towerdefense.Entity.menu.LevelPanel;
import towerdefense.Entity.menu.StartMenu;
import towerdefense.Sound.Sound;

import java.io.*;

import static towerdefense.config.*;

public class GameStage extends Application {

    public static GraphicsContext gc;

    public static MouseEvent event;
    private Scene scene;
    public static Label infoLable;
    public static Label nameTower;
    public static int choose;// 1 start 2
    private Sound bgSound = new Sound("src/towerdefense/Sound/sounds/8_music.mp3");
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Tower Defense");
        stage.getIcons().add(new Image(pathImg + "icon.png"));


        // Tao Canvas

        Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        gc = canvas.getGraphicsContext2D();
        infoLable = new Label();
        nameTower = new Label();
        root.getChildren().addAll(canvas, infoLable, nameTower);

        // Tao scene
         scene = new Scene(root);
        scene.setFill(Color.LIGHTGREY);


        //Add mouse image
        Image mouse = new Image(pathImg + "mouse.png");
        scene.setCursor(new ImageCursor(mouse));

        //Add css
        scene.getStylesheets().add(pathImg + "style.css");


        // Them scene vao stage
        stage.setScene(scene);
        stage.show();
        GameField.getInstance().setGc(gc);

        //icon sound
        ImageView iconSound = new ImageView(new Image(pathImg + "sound-off.png"));
        iconSound.setX(0);iconSound.setY(0);

        ///init menu
        StartMenu startMenu = new StartMenu();
        HelpPanel helpPanel = new HelpPanel();
        LevelPanel levelPanel = new LevelPanel();

        if(root.getChildren().indexOf(iconSound) < 0) root.getChildren().add(iconSound);


        iconSound.setOnMouseClicked(eventSound ->{
            isSound = !isSound;
            if(isSound) iconSound.setImage(new Image(pathImg + "sound-off.png"));
            else iconSound.setImage(new Image(pathImg + "sound-on.png"));
        });

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long l) {
                gc.clearRect(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);


                if(choose == START_MENU){
                    startMenu.render();
                    startMenu.update();
                }
                else if(choose == GAME_START) {
                    GameField.getInstance().render();
                    if(isPlay) GameField.getInstance().update();
                }
                else if(choose == HELP_PANEL){
                    helpPanel.render();
                    helpPanel.update();
                }
                else if (choose == LEVEL_PANEL){
                    levelPanel.render();
                    levelPanel.update();
                }
                else if(choose == GAME_EXIT){
                    Platform.exit();
                }
                if(root.getChildren().lastIndexOf(iconSound) < root.getChildren().size() - 1) {
                    root.getChildren().removeAll(iconSound);
                    root.getChildren().add(iconSound);
                }




                ///Play background sound


                bgSound.playBackground();
            }
        };
        timer.start();

    }


    public static void main(String[] args) {
        launch(args);
    }

}
