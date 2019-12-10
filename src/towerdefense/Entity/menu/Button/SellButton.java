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
        this.setY(5);
        this.tower = tower;
    }

    @Override
    public void actionClicked(MouseEvent event) {
        tower.sell(tower.getI(), tower.getJ());
        hide();
        Menu.getInstance().removeButton(this);
        tower.getUpgradeButton().hide();
        Menu.getInstance().removeButton(tower.getUpgradeButton());
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
