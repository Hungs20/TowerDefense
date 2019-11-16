package towerdefense.Entity.menu.Button;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import towerdefense.Entity.menu.Menu;
import towerdefense.Entity.tower.Tower;
import towerdefense.GameField;
import towerdefense.Player;

import static towerdefense.config.*;

public class SellButton extends Button{
    private Tower tower;
    public SellButton(Tower tower){
        this.setImage(new Image(pathImg + "sellButton.png"));
        this.setX(MAP_WIDTH);
        this.setY(6);
        this.tower = tower;
    }

    @Override
    public void actionClicked(MouseEvent event) {
        Player.Instance().setCoin(Player.Instance().getCoin()+tower.getPrice());
        tower.remove();
        hide();
        Menu.getInstance().removeButton(this);
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
