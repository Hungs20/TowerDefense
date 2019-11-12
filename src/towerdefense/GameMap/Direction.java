package towerdefense.GameMap;

import javafx.util.Pair;

import static towerdefense.config.*;
import static towerdefense.config.TILE_SIZE;

public enum Direction{
    LEFT(-1, 0), UP(0, -1), RIGHT(1, 0), DOWN(0, 1);
    private int xDir, yDir;

    Direction(int i, int j) {
        xDir = i;
        yDir = j;
    }


    public int getxDir() {
        return xDir;
    }
    public int getyDir(){
        return yDir;
    }
    public void createRandomDir(){
        int randDir = (int)(Math.random() * 4) + 1;
        switch (randDir) {
            case 1:
                 xDir = -1;
                 yDir = 0;
                 break;
            case 2:
                xDir = 0;
                yDir = -1;
                break;
            case 3:
                xDir = 1;
                yDir = 0;
                break;
            case 4:
                xDir = 0;
                yDir = 1;
                break;
        }
    }
}