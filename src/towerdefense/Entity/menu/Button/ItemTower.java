package towerdefense.Entity.menu.Button;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import towerdefense.Entity.menu.Button.Button;
import towerdefense.Entity.menu.Menu;
import towerdefense.Entity.tower.NormalTower;
import towerdefense.Entity.tower.SniperTower;
import towerdefense.Entity.tower.Tower;
import towerdefense.GameEntity;
import towerdefense.GameField;
import towerdefense.GameMap.Map;
import towerdefense.GameStage;
import towerdefense.Player;

import static towerdefense.config.*;

public class ItemTower extends Button {
    private int price;
    private String name;
    private Tower tower;
    private boolean isCreate;

    private  ImageView imgView; // cai nay dung de hien thi thap khi di chuot


    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Tower getTower() {
        return tower;
    }


    public ItemTower(Image image, String name, Tower tower, int x, int y, int price) {
        this.setImage(image);
        this.name = name;
        this.tower = tower;
        this.setX(x);
        this.setY(y);
        this.price = price;
    }

    /*-------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------*/

    public void buyTower(int i, int j){
        if(Map.Instance().isOnRoad(i,j) == false)
        {
            if(Player.Instance().getCoin() >= price){
                Player.Instance().setCoin(Player.Instance().getCoin() - price);
                if(tower instanceof NormalTower) tower = new NormalTower((NormalTower)tower);
                if(tower instanceof SniperTower) tower = new SniperTower((SniperTower)tower);
                GameField.getTowerList().add(GameField.getInstance().createTower(i, j, tower));
            }
        }
    }

    public void render(){
        super.render();
        if(root.getChildren().indexOf(imgView) < 0)
        {
            imgView = createImageView(getImage(),this.getX(),this.getY());
        }
    }

    @Override
    public void actionPressed(MouseEvent event) {
        isCreate = !isCreate;
        root.getChildren().addAll(imgView);
        imgView.setX(event.getX()-TILE_SIZE/2);
        imgView.setY(event.getY()-TILE_SIZE/2);

        root.setOnMouseDragged(event1 -> {
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
                root.getChildren().remove(imgView);
                isCreate=!isCreate;
            }

        });
    }

    @Override
    public void actionMoved(MouseEvent event) {
        Menu.getInstance().printInfor(this);
    }

    @Override
    public void actionClicked(MouseEvent event) {

    }

    @Override
    public void actionDragged(MouseEvent event) {
    }

}
