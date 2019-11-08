package towerdefense.Entity.menu;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import towerdefense.GameEntity;

import java.util.ArrayList;
import java.util.List;

import static towerdefense.config.*;

public class Menu {
    private List<GameEntity> listMenu = new ArrayList<GameEntity>();

    public void addMenuItem(GameEntity item){
        listMenu.add(item);
    }
    public List<GameEntity> getListMenu(){
        return this.listMenu;
    }

    public void showMenu(GraphicsContext gc){
       /* for (int i = 0; i < listMenu.size(); i++){
          //  this.listMenu.get(i).addEventFilter(MouseEvent.MOUSE_CLICKED, listMenu.get(i).eventHandler)
            this.listMenu.get(i).render(gc, );
        }*/
    }

    public void createItemTower(){
        ItemTower normalTower = new ItemNormalTower();
        normalTower.setI(MAP_WIDTH + 1);
        normalTower.setJ(0);
        normalTower.setX(normalTower.getI() * TILE_SIZE);
        normalTower.setY(normalTower.getJ() * TILE_SIZE);
        addMenuItem(normalTower);
    }

}
