package towerdefense.Entity.menu;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import towerdefense.Entity.tower.NormalTower;
import towerdefense.Entity.tower.Tower;
import towerdefense.GameEntity;
import towerdefense.GameField;
import towerdefense.GameStage;
import towerdefense.Player;

import static towerdefense.config.*;

public class ItemTower extends GameEntity {
    private int price;
    private String name;
    private int damage;
    private int speed;
    private double area;
    private int level;
    private Tower tower;
    private boolean isCreate = false;
    private ImageView imageView;
    private  ImageView imgView; // cai nay dung de hien thi thap khi di chuot


    public ItemTower() {
    }

    public Tower getTower() {
        return tower;
    }

    public void setTower(Tower tower) {
        this.tower = tower;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCreate(boolean create) {
        isCreate = create;
    }

    public void buyTower(int i, int j){
        if(Player.Instance().getCoin() >= price){
            Player.Instance().setCoin(Player.Instance().getCoin() - price);
            GameField.getTowerList().add(GameField.getInstance().createTower(i, j, getTower()));
        }
    }

    @Override
    public void render(GraphicsContext gc) {
        if(root.getChildren().indexOf(this.imageView) < 0)
        {
            imageView = createImageView(this.getImg(),this.getX(),this.getY());
            imgView = createImageView(this.getImg(),this.getX(),this.getY());
            root.getChildren().addAll(this.imageView);

            imageView.setOnMousePressed(event -> {
                isCreate = !isCreate;
                root.getChildren().addAll(imgView);
                imgView.setX(event.getX()-TILE_SIZE/2);
                imgView.setY(event.getY()-TILE_SIZE/2);
                for(int i = 0; i < GameField.itemMenuList.size(); i++)
                {
                    if(!GameField.itemMenuList.get(i).equals(this)){
                        GameField.itemMenuList.get(i).setCreate(false);
                    }
                }

                root.setOnMouseDragged(event1 -> {
                    //System.out.println("aaaa");
                    if(root.getChildren().indexOf(imgView) >= 0)
                    {
                        imgView.setX(event1.getX()-TILE_SIZE/2);
                        imgView.setY(event1.getY()-TILE_SIZE/2);
                    }

                });

                root.setOnMouseClicked(event1 -> {
                    if(root.getChildren().indexOf(imgView) >= 0)
                    {
                        buyTower((int)event1.getX()/TILE_SIZE,(int)event1.getY()/TILE_SIZE);
                        //GameField.getTowerList().add(GameField.getInstance().createTower((int)event.getX()/TILE_SIZE,(int)event.getY()/TILE_SIZE,new NormalTower()));
                        isCreate=!isCreate;
                    }

                });
            });
        }
    }

    @Override
    public void update() {
        if(!isCreate) root.getChildren().remove(imgView);
    }


}
