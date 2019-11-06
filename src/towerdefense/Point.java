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
        double angle = (double) Math.toDegrees(Math.atan2(target.getY() - y, target.getX() - x));

        if(angle < 0){
            angle += 360;
        }

        return angle;
    }

    public double getDistance(Point target){
        return Math.sqrt(Math.pow(target.getX() - x, 2) + Math.pow(target.getY() - y, 2));
    }

    public void draw(GraphicsContext gc){
        gc.save();
        gc.setFill(Color.BLACK);
        gc.fillOval(x, y, 10,10);
        gc.restore();
    }
    public void drawd(GraphicsContext gc){
        gc.save();
        gc.setFill(Color.RED);
        gc.fillOval(x, y, 10,10);
        gc.restore();
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}