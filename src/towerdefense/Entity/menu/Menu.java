package towerdefense.Entity.menu;

import towerdefense.Entity.menu.Button.Button;
import towerdefense.Entity.menu.Button.ItemTower;
import towerdefense.Entity.tower.NormalTower;
import towerdefense.Entity.tower.SniperTower;
import towerdefense.Entity.tower.MachineGunTower;

import java.util.ArrayList;
import java.util.List;

import static towerdefense.config.*;

public class Menu {
    private static Menu instance;
    private List<ItemTower> itemMenuList = new ArrayList<>();
    private List<Button> buttonList = new ArrayList<>();
    private GameOverPanel gameOverPanel = new GameOverPanel();
    public static Menu getInstance()
    {
        if(instance == null)instance = new Menu();
        return instance;
    }

    public void addMenuItem(ItemTower item){
        itemMenuList.add(item);
    }
    public void addButton(Button button){buttonList.add(button);}
    public void removeButton(Button button){buttonList.remove(button);}
    public void clearAll(){
        for(Button button : buttonList) button.hide();
        buttonList.clear();
    }
    public List<Button> getButtonList() {
        return buttonList;
    }

    private Menu()
    {
        createItemTower();
        showMenu();
    }

    public void createItemTower(){

        addMenuItem(new ItemTower(new NormalTower(),MAP_WIDTH,0));


        addMenuItem(new ItemTower( new MachineGunTower(),MAP_WIDTH+1,0));

        addMenuItem(new ItemTower( new SniperTower(),MAP_WIDTH+2,0));

    }

    public void showMenu()
    {
        itemMenuList.forEach(g -> g.render());
        buttonList.forEach(g->g.render());
        gameOverPanel.render();
        gameOverPanel.update();
    }


}
