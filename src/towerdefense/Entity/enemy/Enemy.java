package towerdefense.Entity.enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import towerdefense.GameEntity;
import towerdefense.Point;

import static towerdefense.config.*;

public abstract class Enemy extends GameEntity {
    private double speed;
    private Direction direction;
    private int health;
    private int reward;
    private int armor;
    private Image gunImg;
    private int gunRotation;

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
        if (wayPointIndex < wayPoints.length - 1)
            return wayPoints[++wayPointIndex];
        return null;
    }

    @Override
    public void render(GraphicsContext gc) {

        drawRotatedImage(gc, this.getImg(), this.direction.getDegree(), this.getX(), this.getY());
        drawRotatedImage(gc, this.getGunImg(), this.direction.getDegree(), this.getX(), this.getY());

    }

    void calculateDirection() {
        // Tinh huong di tiep theo cho Object
        if (wayPointIndex >= wayPoints.length) {
            // Enemy den way point cuoi
            return;
        }

        Point currentWP = wayPoints[wayPointIndex];
        if (distance(this.getX(), this.getY(), currentWP.getX(), currentWP.getY()) <= speed) {
            this.setX(currentWP.getX());
            this.setY(currentWP.getY());
            Point nextWayPoint = getNextWayPoint();
            if (nextWayPoint == null) return;
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

