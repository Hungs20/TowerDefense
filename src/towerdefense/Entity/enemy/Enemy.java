package towerdefense.Entity.enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import towerdefense.Animation;
import towerdefense.GameEntity;
import towerdefense.Player;
import towerdefense.Point;

import java.util.List;

import static towerdefense.GameField.*;
import static towerdefense.config.*;

public abstract class Enemy extends GameEntity {
    private double speed;
    private Direction direction;
    private int health;
    private int reward;
    private int armor;
    private Image gunImg;
    private int gunRotation;
    private ImageView explosion = new ImageView();

    public ImageView getExplosion() {
        return explosion;
    }

    public abstract double getMaxHealth();

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public Image getGunImg() {
        return gunImg;
    }

    public void setGunImg(Image gunImg) {
        this.gunImg = gunImg;
    }

    public int getGunRotation() {
        return gunRotation;
    }

    public void setGunRotation(int gunRotation) {
        this.gunRotation = gunRotation;
    }

    int wayPointIndex = 0;
    public Point getNextWayPoint() {
        int _wayPointIndex = wayPointIndex;
        while (_wayPointIndex < roadList.size() -1 ) {
            _wayPointIndex++;
            Point point = new Point(roadList.get(_wayPointIndex).getX(), roadList.get(_wayPointIndex).getY());
            if(roadList.get(_wayPointIndex).getX() != roadList.get(wayPointIndex).getX() || roadList.get(_wayPointIndex).getY() != roadList.get(wayPointIndex).getY()) {
                wayPointIndex = _wayPointIndex;
                return point;
            }
        }
        wayPointIndex = _wayPointIndex;
        return null;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.strokeRect(this.getX() + TILE_SIZE/4,this.getY(),TILE_SIZE/2,5);
        gc.setFill(Color.BLUE);
        gc.fillRect(this.getX() + TILE_SIZE/4,this.getY(),TILE_SIZE/2,5);
        gc.setFill(Color.RED);
        gc.fillRect(this.getX() + TILE_SIZE/4,this.getY(),TILE_SIZE*(this.getHealth()/getMaxHealth())/2,5);
        drawRotatedImage(gc, this.getImg(), this.direction.getDegree(), this.getX(), this.getY());
        drawRotatedImage(gc, this.getGunImg(), this.direction.getDegree(), this.getX(), this.getY());


    }

    void calculateDirection() {
        // Tinh huong di tiep theo cho Object
        if (wayPointIndex >= roadList.size()) {
            enemyList.remove(this);
            // Enemy den way point cuoi
            return;
        }

        Point currentWP = new Point(roadList.get(wayPointIndex).getX(), roadList.get(wayPointIndex).getY());
        if (distance(this.getX(), this.getY(), currentWP.getX(), currentWP.getY()) <= speed) {
            this.setX(currentWP.getX());
            this.setY(currentWP.getY());
            Point nextWayPoint = getNextWayPoint();
            if (nextWayPoint == null) {
                this.setX(SCREEN_WIDTH + 1);
                this.setY(SCREEN_HEIGHT + 1);
                target.getEnemiInTarget().add(this);
                return;
            }
            double deltaX = nextWayPoint.getX() - this.getX();
            double deltaY = nextWayPoint.getY() - this.getY();
            if (deltaX > speed) direction = Direction.RIGHT;
            else if (deltaX < -speed) direction = Direction.LEFT;
            else if (deltaY > speed) direction = Direction.DOWN;
            else if (deltaY <= -speed) direction = Direction.UP;
        }
    }

    @Override
    public void update() {

        calculateDirection();

        switch (direction) {
            case UP:
                this.setY((int) (this.getY() - speed));
                break;
            case DOWN:
                this.setY((int) (this.getY() + speed));
                break;
            case LEFT:
                this.setX((int) (this.getX() - speed));
                break;
            case RIGHT:
                this.setX((int) (this.getX() + speed));
                break;
        }
    }

}

