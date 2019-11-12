package towerdefense.GameMap;

import javafx.scene.image.Image;

import static towerdefense.config.pathImg;

public class Road extends TitleMap {


    public Road(){
        this.setImg(new Image(pathImg + "towerDefense_tile060.png"));
    }
    public Road(int i, int j){
        super(i, j);
        this.setImg(new Image(pathImg + "towerDefense_tile060.png"));
    }
}
