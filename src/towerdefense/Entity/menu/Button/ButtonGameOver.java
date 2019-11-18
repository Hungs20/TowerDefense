package towerdefense.Entity.menu.Button;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import towerdefense.GameField;
import towerdefense.Player;

import static towerdefense.config.*;

public class ButtonGameOver extends Button{
    private static ButtonGameOver instance;

    public static ButtonGameOver Instance(){
        if(instance == null) instance = new ButtonGameOver();
        return instance;
    }

    private ButtonGameOver(){
        this.setImage(new Image(pathImg + "gameOver.png"));
        this.setX(4);
        this.setY(3);
    }

    public void render(){
        if(Player.Instance().getLifes() <= 0 && root.getChildren().indexOf(getButtonImg()) < 0)
        {
            ButtonStart.Instance().setStart(false);
            setButtonImg(createImageView(getImage(),getX(),getY()));
            root.getChildren().addAll(getButtonImg());
            update();
        }
        if(ButtonStart.Instance().isStart() == true)
        {
            root.getChildren().remove(getButtonImg());
        }
    }

    @Override
    public void actionClicked(MouseEvent event) {
        ButtonStart.Instance().setStart(true);
        root.getChildren().remove(getButtonImg());
        GameField.getInstance().newGame();
    }

    @Override
    public void actionDragged(MouseEvent event) {

    }

    @Override
    public void actionPressed(MouseEvent event) {

    }

    @Override
    public void actionMoved(MouseEvent event) {

    }
}
