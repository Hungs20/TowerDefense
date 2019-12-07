package towerdefense;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Animation extends AnimationTimer {
    private ImageView imageView = new ImageView();
    private int totalFrames;
    private float fps;
    private int col;
    private int row;
    private int frameWidth;
    private int frameHeight;

    private int currentCol = 0;
    private int currentRow = 0;
    private long lastFrame = 0;

    public Animation(ImageView imageView, Image image, int col, int row, int totalFrames, int frameWidth, int frameHeight, float fps){
        this.imageView = imageView;
        imageView.setImage(image);
        imageView.setViewport(new Rectangle2D(0, 0, frameWidth, frameHeight));
        this.col = col;
        this.row = row;
        this.totalFrames = totalFrames;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.fps = fps;

        lastFrame = System.nanoTime();

    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    @Override
    public void handle(long now){
        int frameJump = (int) Math.floor((now - lastFrame) / (1000000000 / fps)); //Determine how many frames we need to advance to maintain frame rate independence

        //Do a bunch of math to determine where the viewport needs to be positioned on the sprite sheet
        if (frameJump >= 1) {
            lastFrame = now;
            int addRows = (int) Math.floor((float) frameJump / (float) col);
            int frameAdd = frameJump - (addRows * col);

            if (currentCol + frameAdd >= col) {
                currentRow += addRows + 1;
                currentCol = frameAdd - (col - currentCol);
            } else {
                currentRow += addRows;
                currentCol += frameAdd;
            }
            currentRow = (currentRow >= row) ? currentRow - ((int) Math.floor((float) currentRow / row) * row) : currentRow;

            //The last row may or may not contain the full number of columns
            if ((currentRow * col) + currentCol >= totalFrames) {
                currentRow = 0;
                currentCol = Math.abs(currentCol - (totalFrames - (int) (Math.floor((float) totalFrames / col) * col)));
            }

            imageView.setViewport(new Rectangle2D(currentCol * frameWidth, currentRow * frameHeight, frameWidth, frameHeight));
        }

    }
}
