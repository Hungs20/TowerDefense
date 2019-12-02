package towerdefense.Entity.menu;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import towerdefense.GameStage;

import static towerdefense.config.*;

public class HelpPanel {
    private ImageView background = new ImageView();
    private Label text = new Label();
    private String helpText = new String();
    private Button backButton = new Button();
    private Label title = new Label();
    public HelpPanel(){
        background.setImage(new Image(pathImg + "blackBackground.jpg"));

        title.setText("HELP");
        title.setLayoutX(SCREEN_WIDTH/3);
        title.setLayoutY(4);
        title.setId("title");

        helpText = "Sử dụng chuột mua, bán , nâng cấp tháp pháo \nđể tiêu diệt toàn bộ quân địch trên đường đi.";
        text.setText(helpText);
        text.setId("helpPanle");
        text.setLayoutX(SCREEN_WIDTH/4);
        text.setLayoutY(SCREEN_HEIGHT/3);

        backButton.setText("Back");
        backButton.setLayoutX(SCREEN_WIDTH/2  - 20);
        backButton.setLayoutY(SCREEN_HEIGHT/2 + 100);

    }
    public void clear(){
        if(root.getChildren().indexOf(background) >= 0) root.getChildren().remove(background);
        if(root.getChildren().indexOf(title) >= 0) root.getChildren().remove(title);
        if(root.getChildren().indexOf(text) >= 0) root.getChildren().remove(text);
        if(root.getChildren().indexOf(backButton) >= 0) root.getChildren().remove(backButton);
    }
    public void render(){
        if(root.getChildren().indexOf(background) < 0) {
            root.getChildren().add(background);
        }
        if(root.getChildren().indexOf(title) < 0) root.getChildren().add(title);
        if(root.getChildren().indexOf(text) < 0) root.getChildren().add(text);

        if(root.getChildren().indexOf(backButton) < 0) root.getChildren().add(backButton);
    }
    public void update(){
        backButton.setOnMouseClicked(event -> {
            clear();
            GameStage.choose = START_MENU;
        });
    }
}
