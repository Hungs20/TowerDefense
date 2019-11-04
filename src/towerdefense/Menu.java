package towerdefense;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<GameEntity> listMenu = new ArrayList<GameEntity>();

    public void addMenuItem(GameEntity item){
        listMenu.add(item);
    }
    public List<GameEntity> getListMenu(){
        return this.listMenu;
    }
   /* public void drawMenu(GraphicsContext gc){
        for (int i = 0; i < listMenu.size(); i++){
            gc.drawImage(this.listMenu.get(i).getImg());
        }
    }*/
}
