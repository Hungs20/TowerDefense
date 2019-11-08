package towerdefense;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
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

    public double getAngle(Point target){

        int deltaX = target.getX() - x;
        int deltaY = y - target.getY();
        double angle = Math.atan2(deltaY, deltaX);

        if(angle < 0){
            angle = Math.abs(angle);
        }
        else angle = 2 * Math.PI - angle;

        return Math.toDegrees(angle);
    }

    public double getDistance(Point target){
        return Math.sqrt(Math.pow(target.getX() - x, 2) + Math.pow(target.getY() - y, 2));
    }



    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}