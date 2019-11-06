package towerdefense;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javafx.geometry.Rectangle2D;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.io.IOException;

public abstract class GameEntity {
    private int i, j;
    private int x;
    private int y;
    private Image img;



    public abstract void render(GraphicsContext gc);
    public abstract void update();

    // Tao hinh chu nhat bao quanh
    public Rectangle2D getBoundary() {
        try {
            Rectangle2D rectangle2D = new Rectangle2D(x, y, img.getWidth(), img.getHeight());
            return rectangle2D;
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        return null;
    }

    ///kiem tra va cham
    public boolean isCollision(GameEntity other)  {
        try {
            return other.getBoundary().intersects(this.getBoundary());
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return false;
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
