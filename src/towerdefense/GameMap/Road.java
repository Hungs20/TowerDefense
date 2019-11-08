package towerdefense.GameMap;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static towerdefense.config.TILE_SIZE;
import static towerdefense.config.pathImg;

public class Road extends TitleMap {
    private TitleMap right_Road;
    private TitleMap left_Road;

    @Override
    public void render(GraphicsContext gc)
    {
        right_Road.render(gc);
        left_Road.render(gc);
    }

    public Road(String path_Left,int x_left, int y_left, String path_Right, int x_right, int y_right)
    {
        this.left_Road.setImg(new Image(pathImg + path_Left));
        this.left_Road.setX(x_left*TILE_SIZE);
        this.left_Road.setY(y_left*TILE_SIZE);
        this.right_Road.setImg(new Image(pathImg+path_Right));
        this.right_Road.setX(x_right*TILE_SIZE);
        this.right_Road.setY(y_right*TILE_SIZE);
    }
}
