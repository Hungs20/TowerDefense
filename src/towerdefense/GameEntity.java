package towerdefense;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javafx.geometry.Rectangle2D;

public abstract class GameEntity {
    private int i, j;
    private int x;
    private int y;
    private Image img;

    public abstract void render(GraphicsContext gc);
    public abstract void update();

    // Tao hinh chu nhat bao quanh
    public Rectangle2D getBoundary(){
        return new Rectangle2D(x, y, img.getWidth(), img.getHeight());
    }

    ///kiem tra va cham
    public boolean isCollision(GameEntity other){
        return other.getBoundary().intersects(this.getBoundary());
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
