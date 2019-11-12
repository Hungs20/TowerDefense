package towerdefense;

public class Player {
    private int level;
    private int coin;
    private int health;
    private static Player instance;

    private Player(){
        level = 0;
        coin= 100;
        health = 10;
    }

    public static Player Instance()
    {
        if (instance == null) instance = new Player();
        return instance;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
