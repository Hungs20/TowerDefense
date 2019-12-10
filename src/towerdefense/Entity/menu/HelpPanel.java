package towerdefense.Entity.menu;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import towerdefense.GameStage;
import towerdefense.Sound.Sound;

import static towerdefense.config.*;

public class HelpPanel {
    private ImageView background = new ImageView();
    private Label text = new Label();
    private String helpText = new String();
    private Button backButton = new Button();
    private Label title = new Label();
    private ImageView panelBg = new ImageView();
    private Sound clickSound = new Sound("src/towerdefense/Sound/sounds/7_click.mp3");
    public HelpPanel(){
        background.setImage(new Image(pathImg + "background.png"));

        title.setText("Help");
        title.setLayoutX(SCREEN_WIDTH/2 - 40);
        title.setLayoutY(SCREEN_HEIGHT/5 + 20);
        title.setId("title");

        panelBg.setImage(new Image(pathImg + "panel.png"));
        panelBg.setX(SCREEN_WIDTH/2 - 120);
        panelBg.setY(SCREEN_HEIGHT/5);
        panelBg.setOpacity(0.7);
        panelBg.setFitHeight(400);
        panelBg.setFitWidth(300);


        helpText = "Use mouse to buy, upgrade \ntower\n\n\n Kill enemy to defense \nyour tower.";
        text.setText(helpText);
        text.setId("helpPanel");
        text.setLayoutX(SCREEN_WIDTH/2 - 100);
        text.setLayoutY(SCREEN_HEIGHT/3 + 20);

        backButton.setText("Back");
        backButton.setLayoutX(SCREEN_WIDTH/2 - 20);
        backButton.setLayoutY(SCREEN_HEIGHT/3 + 250);

    }
    public void clear(){
        if(root.getChildren().indexOf(background) >= 0) root.getChildren().remove(background);
        if(root.getChildren().indexOf(panelBg) >= 0) root.getChildren().remove(panelBg);
        if(root.getChildren().indexOf(title) >= 0) root.getChildren().remove(title);
        if(root.getChildren().indexOf(text) >= 0) root.getChildren().remove(text);
        if(root.getChildren().indexOf(backButton) >= 0) root.getChildren().remove(backButton);
    }
    public void render(){
        if(root.getChildren().indexOf(background) < 0) {
            root.getChildren().add(background);
        }
        if(root.getChildren().indexOf(panelBg) < 0) root.getChildren().add(panelBg);
        if(root.getChildren().indexOf(title) < 0) root.getChildren().add(title);
        if(root.getChildren().indexOf(text) < 0) root.getChildren().add(text);

        if(root.getChildren().indexOf(backButton) < 0) root.getChildren().add(backButton);
    }
    public void update(){
        backButton.setOnMouseClicked(event -> {
            clear();
            clickSound.play();
            GameStage.choose = START_MENU;
        });
    }
}
