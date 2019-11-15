package towerdefense.Entity.menu;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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

    private Menu()
    {
        createItemTower();
        showMenu();
    }

    public void createItemTower(){

        addMenuItem(new ItemTower(new Image(pathImg+"towerDefense_tile249.png"),"Nomal Tower", new NormalTower(),MAP_WIDTH,0,20));


        addMenuItem(new ItemTower(new Image(pathImg+"towerDefense_tile250.png"),"Sniper Tower", new SniperTower(),MAP_WIDTH+1,0, 10));

        for(int i = 1; i <= 4; i++)
        {
            Label labelInfor = new Label();
            labelInfor.setMinSize(3*TILE_SIZE, TILE_SIZE);
            labelInfor.setLayoutX((MAP_WIDTH)*TILE_SIZE);
            labelInfor.setLayoutY((i+1)*TILE_SIZE);
            labelInfor.setFont(new Font("Arial",20));
            labelInfor.setWrapText(false);
            labelInfor.setOpacity(0);
            labelInfor.setTextFill(Color.BLUE);
            labelInfor.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
            listLabelInfor.add(labelInfor);
            root.getChildren().addAll(labelInfor);
        }

        labelPlayer = new Label();
        labelPlayer.setFont(new Font("Arial",20));
        root.getChildren().addAll(labelPlayer);

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
        listLabelInfor.forEach(g -> g.setOpacity(1));
        listLabelInfor.get(0).setText("   " +tower.getName());
        listLabelInfor.get(1).setText("   DAMAGE:    " + tower.getTower().getDamage());
        listLabelInfor.get(2).setText("   RANGE:     " + tower.getTower().getRadius());
        listLabelInfor.get(3).setText("   PRICE:     " + tower.getPrice());
    }

    public void prinInforPlayer()
    {
        labelPlayer.setTextFill(Color.RED);
        labelPlayer.setText("Life: " + Player.Instance().getLifes() + "      Coin: " + Player.Instance().getCoin() + "         Level: " + Player.Instance().getLevel());
    }
}
