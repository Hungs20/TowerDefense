package towerdefense;

public class Player {
    private int level;
    private int coin;
    private int lifes;

    private static Player instance;

    private Player(){
        level = 0;
        coin= 100;
        lifes = 10;
    }

    public static Player Instance()
    {
        if (instance == null) instance = new Player();
        return instance;
    }

    public void newGame()
    {
        level = 0;
        coin= 100;
        lifes = 10;
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

    public int getLifes() {
        return lifes;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
    }
}
