package towerdefense.Entity.menu;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import towerdefense.GameEntity;
import towerdefense.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static towerdefense.GameField.itemMenuList;
import static towerdefense.config.*;

public class Menu {
    private static Menu instance;
    private Label labelInfor;
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
    }

    public void createItemTower(){
        labelInfor = new Label();
        labelInfor.setMinSize(3*TILE_SIZE, 2*TILE_SIZE);
        labelInfor.setLayoutX((MAP_WIDTH -2)*TILE_SIZE);
        labelInfor.setLayoutY(3*TILE_SIZE);
        labelInfor.setText("oahubwivmw");
        root.getChildren().addAll(labelInfor);

        ItemTower normalTower = new ItemNormalTower();
        normalTower.setI(MAP_WIDTH -2);
        normalTower.setJ(0);
        normalTower.setX(normalTower.getI() * TILE_SIZE);
        normalTower.setY(normalTower.getJ() * TILE_SIZE);
        addMenuItem(normalTower);

        ItemTower sniperTower = new ItemSniperTower();
        sniperTower.setI(MAP_WIDTH - 1);
        sniperTower.setJ(0);
        sniperTower.setX(sniperTower.getI() * TILE_SIZE);
        sniperTower.setY(sniperTower.getJ() * TILE_SIZE);
        addMenuItem(sniperTower);
    }

}
