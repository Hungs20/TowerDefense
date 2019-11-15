package towerdefense.Entity.menu.Button;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import static towerdefense.config.*;

public  abstract class Button {
    private Image image;
    private ImageView buttonImg;
    private int x;
    private int y;

    public ImageView getButtonImg() {
        return buttonImg;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x*TILE_SIZE;
    }

    public void setY(int y) {
        this.y = y*TILE_SIZE;
    }

    public void setButtonImg(ImageView buttonImg) {
        this.buttonImg = buttonImg;
    }

    public void isClicked(){
        buttonImg.setOnMouseClicked(event -> {
            actionClicked(event);
        });
    }

    public void isPressed(){
        buttonImg.setOnMousePressed(event -> {
            actionPressed(event);
        });
    }

    public void isDragged(){
        buttonImg.setOnMouseDragged(event -> {
            actionDragged(event);
        });
    }

    public void isMoved(){
        buttonImg.setOnMouseMoved(event -> {
            actionMoved(event);
        });
    }

    public abstract void actionClicked(MouseEvent event);
    public abstract void actionDragged(MouseEvent event);
    public abstract void actionPressed(MouseEvent event);
    public abstract void actionMoved(MouseEvent event);

    public void update(){
        isClicked();
        isDragged();
        isPressed();
        isMoved();
    }
    public void render(){
        if(root.getChildren().indexOf(buttonImg) < 0)
        {
            buttonImg = createImageView(image,x,y);
            root.getChildren().addAll(buttonImg);
        }
        update();
    }
    public void hide(){
        root.getChildren().remove(buttonImg);
    }
}
