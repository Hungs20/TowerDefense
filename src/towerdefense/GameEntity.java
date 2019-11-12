package towerdefense;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

import static towerdefense.config.TILE_SIZE;

public abstract class GameEntity  {
    private int i, j;
    private int x;
    private int y;
    private Image img;

    public GameEntity(){

    }
    public GameEntity(int i, int j){
        this.i = i;
        this.j = j;
        this.x = i * TILE_SIZE;
        this.y = j * TILE_SIZE;
    }
    public abstract void render(GraphicsContext gc);
    public abstract void update();
    // Tao hinh chu nhat bao quanh
    public Rectangle2D getBoundary(){
       if(this.getImg() == null) return null;
        return new Rectangle2D(x, y, img.getWidth(), img.getHeight());
    }


    ///kiem tra va cham
    public boolean isCollision(GameEntity other)  {
        if(other.getBoundary() == null || getBoundary() == null) return false;
        return other.getBoundary().intersects(this.getBoundary());
    }
    public void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }
    public void drawRotatedImage(GraphicsContext gc, Image image, double angle, double tlpx, double tlpy) {
        gc.save(); // saves the current state on stack, including the current transform
        rotate(gc, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
        gc.drawImage(image, tlpx, tlpy);
        gc.restore(); // back to original state (before rotation)
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
