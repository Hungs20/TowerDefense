package towerdefense.Entity.menu.Button;

import javafx.event.Event;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import towerdefense.GameField;
import towerdefense.Player;
import towerdefense.config.*;

import java.awt.*;

import static towerdefense.config.*;

public class ButtonStart extends Button {
    private static ButtonStart instance;

    private boolean isStart;

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    private ButtonStart(){
        this.setImage(new Image(pathImg + "start.png"));
        this.setX(MAP_WIDTH);
        this.setY(7);
    }

    public static ButtonStart Instance()
    {
        if(instance == null) {
            instance = new ButtonStart();
        }
        return instance;
    }

    @Override
    public void actionClicked(MouseEvent event) {
        if(Player.Instance().getLifes() <= 0) GameField.getInstance().newGame();
        isStart = !isStart;
    }

    @Override
    public void actionDragged(MouseEvent event) { }

    @Override
    public void actionPressed(MouseEvent event) { }

    @Override
    public void actionMoved(MouseEvent event) { }
}
