package towerdefense.GameMap;

import javafx.scene.image.Image;

import static towerdefense.config.pathImg;

public class Land extends TitleMap{
    public Land(){
        this.setImg(new Image(pathImg + "towerDefense_tile024.png"));
    }
    public Land(int i, int j){
        super(i, j);
        this.setImg(new Image(pathImg + "towerDefense_tile024.png"));
    }
}
