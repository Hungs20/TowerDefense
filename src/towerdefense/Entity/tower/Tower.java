package towerdefense.Entity.tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import towerdefense.Entity.Bullet;
import towerdefense.Entity.enemy.Enemy;
import towerdefense.Entity.menu.Button.SellButton;
import towerdefense.Entity.menu.Button.UpgradeButton;
import towerdefense.Entity.menu.Menu;
import towerdefense.GameEntity;
import towerdefense.GameMap.Map;

import java.util.ArrayList;
import java.util.List;
import towerdefense.*;
import towerdefense.Point;
import towerdefense.Sound.GameSound;

import static towerdefense.GameStage.infoLable;
import static towerdefense.config.*;

public abstract class Tower extends GameEntity  {
    private int speed;
    private double radius;
    private int damage;
    private int price;
    private String name;
    private int level = 0;
    private Image bgImg;
    private Image bulletImg;
    private ImageView imgView;
    private boolean isClick = false;
    private SellButton sellButton = new SellButton(this);
    private UpgradeButton upgradeButton = new UpgradeButton(this);
    private Label info = new Label();
    private double angle = 0;
    private List<Bullet> bulletList = new ArrayList<>();

    public ImageView getImgView() {
        return imgView;
    }

    public List<Bullet> getBulletList() {
        return bulletList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setBulletList(List<Bullet> bulletList) {
        this.bulletList = bulletList;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setBulletImg(Image bulletImg) {
        this.bulletImg = bulletImg;
    }

    public Image getBgImg() {
        return bgImg;
    }

    public void setBgImg(Image bgImg) {
        this.bgImg = bgImg;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public SellButton getSellButton() {
        return sellButton;
    }

    public UpgradeButton getUpgradeButton() {
        return upgradeButton;
    }

    public void setSellButton(SellButton sellButton) {
        this.sellButton = sellButton;
    }

    public void setUpgradeButton(UpgradeButton upgradeButton) {
        this.upgradeButton = upgradeButton;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public Tower(Tower newTower)
    {
        this.setImg(newTower.getImg());
        this.speed = newTower.speed;
        this.damage = newTower.damage;
        this.radius = newTower.radius;
        this.price = newTower.price;
        this.bgImg = newTower.bgImg;
        this.bulletImg = newTower.bulletImg;
        this.level = 0;
    }

    public Tower(){}


    public Bullet createBullet(){
        Bullet bullet = new Bullet();
        bullet.setX(this.getX());
        bullet.setY(this.getY());
        bullet.setAngle(this.angle);
        bullet.setDistance(0);
        bullet.updateNewPos();
        bullet.setImg(bulletImg);
        bullet.setDamage(damage);
        bullet.setMaxDistance(radius);
        bullet.setIsHas(true);
        return bullet;
    }


    public abstract void resetSpeed();

    public String getInfo(){
        String info = "";
        info += "Name : " + name + "\n";
        info += "Dame : " + damage + "\n";
        info += "Range : " + radius + "\n";
        if(level > 0) info += "Level : " + level + "\n";
        if(level == 0) info += "Buy : " + price + "$";
        else {
            info += "Upgrade : " + 70 * price / 100 + "$\n";
            info += "Sell : " + 70 * price / 100 + "$";
        }
        return info;
    }
    public void showInfo(){
        infoLable.setText(getInfo());
        infoLable.setLayoutX((MAP_WIDTH + 0.2) * TILE_SIZE);
        infoLable.setLayoutY(2 * TILE_SIZE);
        infoLable.setVisible(true);
        infoLable.setTextFill(Color.BLUE);
        infoLable.setFont(Font.font("Consolas", 15));
    }


    public boolean buy(int i, int j){

        if(!Map.Instance().isOnLand(i,j)) return false;
        if(Player.Instance().getCoin() >= this.price){
            Player.Instance().setCoin(Player.Instance().getCoin() - this.price);
            this.setI(i);
            this.setJ(j);
            this.level = 1;
            GameField.getTowerList().add(this);
            GameSound.Instance().TurretBuildSound();
            Map.Instance().setOnLand(i, j, 1);
            return true;
        }
        return false;
    }
    public void sell(int i, int j){
        Player.Instance().setCoin(Player.Instance().getCoin() + 70 * this.price / 100);
        Map.Instance().setOnLand(i, j, 0);
        remove();
    }
    public void upgrade(){
        if(level >= 3) return;
        if(Player.Instance().getCoin() < 70 * this.price / 100) return;
        this.level++;
        this.damage = this.damage + this.level * this.damage / 5;
        this.radius = this.radius + this.level * this.radius / 5;
        this.speed = this.speed + this.level * this.speed / 5;
        Player.Instance().setCoin(Player.Instance().getCoin() - 70* this.price / 100);
        this.price = this.price + 70 * this.price / 100;

    }
    public void drawCircle(GraphicsContext gc){
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeOval(this.getX() + this.bgImg.getWidth()/2 - radius, this.getY() + this.bgImg.getHeight()/2 - radius, radius*2, radius*2);


    }

    public void remove(){
        root.getChildren().remove(this.getImgView());
        GameField.towerList.remove(this);
    }
    @Override
    public void render(GraphicsContext gc) {
        if(isClick){
            drawCircle(gc);
            showInfo();
        }
        gc.drawImage(getBgImg(), getX(), getY());
        //drawRotatedImage(gc, this.getImg(), getAngle(), this.getX(), this.getY());
        if(root.getChildren().indexOf(this.imgView) < 0)
        {
            this.imgView = createImageView(this.getImg(),this.getX(),this.getY());
            this.imgView.setOnMouseClicked(event -> {
                isClick=!isClick;
                if(isClick)
                {
                    Menu.getInstance().addButton(sellButton);
                    if(level < 3) Menu.getInstance().addButton(upgradeButton);
                }else {
                    sellButton.hide();
                    upgradeButton.hide();
                    Menu.getInstance().removeButton(sellButton);
                    Menu.getInstance().removeButton(upgradeButton);
                }
            });
            root.getChildren().addAll(this.imgView);
        }
        else this.getImgView().setRotate(getAngle());
        List<Bullet> bullets = this.getBulletList();
        if(bullets != null) bullets.forEach(g -> g.render(gc));

    }

    @Override
    public void update() {
        List<Enemy> enemies = GameField.enemyList;

        Point towerPoint = new Point(this.getX() ,  this.getY() );
        List<Bullet> bullets = getBulletList();
        for(int i = 0; i < enemies.size(); i++){

            Point enemyPoint = new Point(enemies.get(i).getX() , enemies.get(i).getY() );
            double _angle = towerPoint.getAngle(enemyPoint);

            double distance = enemyPoint.getDistance(towerPoint);
            if(distance <= this.getRadius()){
                if(this.getSpeed() <= 0) {
                    setAngle(_angle + 90);
                    Bullet _bullet = this.createBullet();
                    bullets.add(_bullet);
                    resetSpeed();
                    GameSound.Instance().shotingShound();
                }
            }
        }
        this.setSpeed(this.getSpeed() - 1);
        for(int i = bullets.size() - 1; i >= 0; i--){
            Bullet bullet = bullets.get(i);
            if(bullet == null) break;
            if(bullet.getDistance() > bullet.getMaxDistance() ) bullet.setIsHas(false);
            for(int j = GameField.enemyList.size() - 1; j >= 0; j--){
                Enemy enemy = GameField.enemyList.get(j);

                if(enemy == null) break;
                if(bullet.isCollision(enemy)) {
                    enemy.setHealth(enemy.getHealth() - this.damage);
                    if(enemy.getHealth() <= 0) {
                        Player.Instance().setCoin(Player.Instance().getCoin()+enemy.getReward());
                        GameField.enemyList.remove(enemy);

                        ///Animation explosion

                        enemy.getExplosion().setX(enemy.getX());
                        enemy.getExplosion().setY(enemy.getY());
                        Animation animation = new Animation(enemy.getExplosion(), new Image(pathImg + "exp.png"), 4, 4, 16, 64, 64, 60);
                        root.getChildren().add(enemy.getExplosion());
                        animation.start();

                           // if (root.getChildren().indexOf(enemy.getExplosion()) >= 0) root.getChildren().remove(enemy.getExplosion());

                    }
                    bullet.setIsHas(false);
                }
            }
            if(!bullet.getIsHas()) bullets.remove(i);
        }

        if(bullets != null) bullets.forEach(GameEntity::update);
        setBulletList(bullets);
    }
}
