package towerdefense.Entity.menu;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import towerdefense.Entity.menu.Button.Button;
import towerdefense.Entity.menu.Button.ButtonGameOver;
import towerdefense.Entity.menu.Button.ButtonStart;
import towerdefense.Entity.menu.Button.ItemTower;
import towerdefense.Entity.tower.NormalTower;
import towerdefense.Entity.tower.SniperTower;
import towerdefense.Player;

import java.util.ArrayList;
import java.util.List;

import static towerdefense.config.*;

public class Menu {
    private static Menu instance;
    private List<ItemTower> itemMenuList = new ArrayList<>();
    private List<Label> listLabelInfor = new ArrayList<>();
    private Label labelPlayer;
    private List<Button> buttonList = new ArrayList<>();
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

    private Menu()
    {
        createItemTower();
        showMenu();
    }

    public void createItemTower(){

        addMenuItem(new ItemTower(new NormalTower(),MAP_WIDTH,0));


        addMenuItem(new ItemTower( new SniperTower(),MAP_WIDTH+1,0));


        buttonList.add(ButtonStart.Instance());
        buttonList.add(ButtonGameOver.Instance());
    }

    public void showMenu()
    {
        itemMenuList.forEach(g -> g.render());
        buttonList.forEach(g->g.render());
    }

    public void printInfor(ItemTower tower)
    {
        Text info = new Text();
        info.setText(tower.getTower().getInfo());
    }

   /* public void prinInforPlayer()
    {
        labelPlayer.setTextFill(Color.RED);
        labelPlayer.setText("Life: " + Player.Instance().getLifes() + "      Coin: " + Player.Instance().getCoin() + "         Level: " + Player.Instance().getLevel());
    }*/
}
