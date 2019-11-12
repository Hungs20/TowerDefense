package towerdefense.GameMap;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import towerdefense.GameEntity;


public class TitleMap extends GameEntity {
    public TitleMap(){ }
    public TitleMap(int i, int j){
        super(i, j);
    }
    public TitleMap(int i, int j, Image img){
        super(i, j);
        this.setImg(img);
    }
    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(this.getImg(), this.getX(), this.getY());
    }

    @Override
    public void update() {
    }

}
