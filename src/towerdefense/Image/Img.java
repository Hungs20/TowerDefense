package towerdefense.Image;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import towerdefense.location.Location;

public class Img {
    private Location location;
    private double height = 0;
    private double width = 0;
    private String path ;

    public Img(String path, Location location, double height, double width){
        this.location = location;
        this.height = height;
        this.width = width;
        this.path = path;
    }

    public Img(String path, Location location){
        this.location = location;
        this.path = path;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void draw(GraphicsContext gc){
        Image img = new Image(this.path);
        if(this.width == 0 || this.height == 0) gc.drawImage(img, location.getX(), location.getY());
        else gc.drawImage(img, location.getX(), location.getY(), this.width, this.height);
    }
}
