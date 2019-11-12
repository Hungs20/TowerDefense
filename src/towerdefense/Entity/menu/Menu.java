package towerdefense.Entity.menu;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import towerdefense.GameEntity;
import towerdefense.GameField;
import towerdefense.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static towerdefense.config.*;

public class Menu {
    private static Menu instance;
    private List<ItemTower> itemMenuList = new ArrayList<>();
    private List<Label> listLabelInfor = new ArrayList<>();
    private Label labelPlayer;
    private ImageView btStart;
    private ImageView btGameOver;
    private boolean isStart;
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


    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        if(!start)
            root.getChildren().addAll(btStart);
        else {
            root.getChildren().remove(btStart);
            root.getChildren().remove(btGameOver);
        }

        isStart = start;
    }

    public void gameOver()
    {
        root.getChildren().addAll(btGameOver);
        isStart = false;
        GameField.getTowerList().clear();
        GameField.enemyList.clear();
        Player.Instance().newGame();
    }

    public void createItemTower(){
        isStart = false;

        ItemTower normalTower = new ItemNormalTower();
        normalTower.setI(MAP_WIDTH);
        normalTower.setJ(0);
        normalTower.setX(normalTower.getI() * TILE_SIZE);
        normalTower.setY(normalTower.getJ() * TILE_SIZE);
        addMenuItem(normalTower);

        ItemTower sniperTower = new ItemSniperTower();
        sniperTower.setI(MAP_WIDTH+1);
        sniperTower.setJ(0);
        sniperTower.setX(sniperTower.getI() * TILE_SIZE);
        sniperTower.setY(sniperTower.getJ() * TILE_SIZE);
        addMenuItem(sniperTower);

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

        btGameOver = createImageView(new Image(pathImg + "buttonGameOver.png"),6*TILE_SIZE,4*TILE_SIZE);
        btGameOver.setOnMouseClicked(event -> {
            setStart(true);
            Player.Instance().setLifes(10);
        });

        btStart = createImageView(new Image(pathImg + "buttonStart.png"), 6*TILE_SIZE,4*TILE_SIZE);
        root.getChildren().addAll(btStart);
        btStart.setOnMouseClicked(event -> {
            setStart(true);
        });
    }

    public void showMenu()
    {
        itemMenuList.forEach(g -> g.render());
    }

    public void printInfor(ItemTower tower)
    {
        listLabelInfor.forEach(g -> g.setOpacity(1));
        listLabelInfor.get(0).setText("   " +tower.getName());
        listLabelInfor.get(1).setText("   DAMAGE:    " + tower.getDamage());
        listLabelInfor.get(2).setText("   RANGE:     " + tower.getArea());
        listLabelInfor.get(3).setText("   PRICE:     " + tower.getPrice());
    }

    public void prinInforPlayer()
    {
        labelPlayer.setTextFill(Color.RED);
        labelPlayer.setText("Life: " + Player.Instance().getLifes() + "      Coin: " + Player.Instance().getCoin() + "         Level: " + Player.Instance().getLevel());
    }
}
