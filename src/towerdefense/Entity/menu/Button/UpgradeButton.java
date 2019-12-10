package towerdefense.Entity.menu.Button;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import towerdefense.Entity.menu.Menu;
import towerdefense.Entity.tower.Tower;
import towerdefense.GameField;
import towerdefense.Player;

import static towerdefense.config.*;

public class UpgradeButton extends Button{
    private Tower tower;
    public UpgradeButton(Tower tower){
        this.setImage(new Image(pathImg + "upgradeButton.png"));
        this.setX(MAP_WIDTH + 1);
        this.setY(4);
        this.tower = tower;
    }

    @Override
    public void actionClicked(MouseEvent event) {
        tower.upgrade() ;
        if(tower.getLevel() >= MAX_LEVEL_TOWER) {
            hide();
            Menu.getInstance().removeButton(this);
        }
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
