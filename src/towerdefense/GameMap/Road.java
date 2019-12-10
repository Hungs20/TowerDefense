package towerdefense.GameMap;

import javafx.scene.image.Image;

import static towerdefense.config.pathImg;

public class Road extends TitleMap {


    public Road(){
        this.setImg(new Image(pathImg + "towerDefense_tile060.png"));
    }
    public Road(int i, int j){
        super(i, j);
        int rand = (int)(Math.random() * 4);
        switch (rand){
            case 0:
                this.setImg(new Image(pathImg + "towerDefense_tile060.png"));
                break;
            case 1:
                this.setImg(new Image(pathImg + "towerDefense_tile158.png"));
                break;
            case 2:
                this.setImg(new Image(pathImg + "towerDefense_tile167.png"));
                break;
            case 3:
                this.setImg(new Image(pathImg + "towerDefense_tile236.png"));
                break;
        }
    }
}
