package towerdefense.Entity.menu.Button;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import towerdefense.Entity.tower.NormalTower;
import towerdefense.Entity.tower.SniperTower;
import towerdefense.Entity.tower.MachineGunTower;
import towerdefense.Entity.tower.Tower;


import static towerdefense.config.*;

public class ItemTower extends Button {
    private Tower tower;
    private Circle rangle;
    private boolean isCreate;

    private  ImageView imgView; // cai nay dung de hien thi thap khi di chuot


    public Tower getTower() {
        return tower;
    }


    public ItemTower(Tower tower, int x, int y) {
        this.tower = tower;
        this.setImage(tower.getImg());
        this.setX(x);
        this.setY(y);
    }

    /*-------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------*/


    public void render(){
        super.render();
        if(root.getChildren().indexOf(imgView) < 0)
        {
            imgView = createImageView(this.getImage(),this.getX(),this.getY());
            rangle = new Circle();
            rangle.setRadius(tower.getRadius());
            rangle.setCenterX(imgView.getX()+TILE_SIZE/2);
            rangle.setCenterY(imgView.getY()+TILE_SIZE/2);
            rangle.setFill(Color.RED);
            rangle.setOpacity(0.4);
        }
    }

    @Override
    public void actionPressed(MouseEvent event) {
        isCreate = !isCreate;
        root.getChildren().addAll(imgView);
        root.getChildren().addAll(rangle);
        imgView.setX(event.getX()-TILE_SIZE/2);
        imgView.setY(event.getY()-TILE_SIZE/2);

        root.setOnMouseDragged(event1 -> {
            if(root.getChildren().indexOf(imgView) >= 0)
            {
                imgView.setX(event1.getX()-TILE_SIZE/2);
                imgView.setY(event1.getY()-TILE_SIZE/2);
                rangle.setCenterX(imgView.getX()+TILE_SIZE/2);
                rangle.setCenterY(imgView.getY()+TILE_SIZE/2);

            }
        });

        root.setOnMouseClicked(event1 -> {
            if(root.getChildren().indexOf(imgView) >= 0)
            {
                Tower newTower = tower;
                if(tower instanceof NormalTower) newTower = new NormalTower();
                if(tower instanceof MachineGunTower) newTower = new MachineGunTower();
                if(tower instanceof SniperTower) newTower = new SniperTower();
                newTower.buy((int)event1.getX()/TILE_SIZE,(int)event1.getY()/TILE_SIZE);
                root.getChildren().remove(imgView);
                root.getChildren().remove(rangle);
                isCreate=!isCreate;
            }

        });
    }

    @Override
    public void actionMoved(MouseEvent event) {
        tower.showInfo();
    }

    @Override
    public void actionClicked(MouseEvent event) {

    }

    @Override
    public void actionDragged(MouseEvent event) {
    }

}
