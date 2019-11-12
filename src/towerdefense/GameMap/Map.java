package towerdefense.GameMap;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static towerdefense.GameField.*;
import static towerdefense.config.MAP_HEIGHT;
import static towerdefense.config.MAP_WIDTH;

public class Map {

    private int[][] mapArr = new int[MAP_WIDTH][MAP_HEIGHT];
    private int[][] dir = new int[][] {
            {-1, 1, 0, 0},
            {0, 0, -1, 1}
    };

    public Map(){

        //Arrays.fill(mapArr, 0);
        for(int i = 0; i < MAP_WIDTH; i++) for(int j = 0; j < MAP_HEIGHT; j++) mapArr[i][j] = 0;

        int roadI = spawner.getI();
        int roadJ = spawner.getJ();
        int targetI = target.getI();
        int targetJ = target.getJ();
        mapArr[roadI][roadJ] = 1;
        roadList.add(new Road(roadI, roadJ));
        int type = 0;// UP
        for(int j = 0; j < 3; j++){
            int val = (int)(Math.random() * 4) + 2;
            switch (j){
                case 0: case 2:
                    for(int i = 0; i < val; i++) {
                        roadJ--;
                        if(roadJ < 0) break;
                        mapArr[roadI][roadJ] = 1;
                        roadList.add(new Road(roadI, roadJ));
                    }
                    break;
                case 1:
                    for(int i = 0; i < val; i++){
                        roadI++;
                        if(roadI >= MAP_WIDTH) break;
                        mapArr[roadI][roadJ] = 1;
                        roadList.add(new Road(roadI, roadJ));
                    }
                    break;
            }
        }
        for(int i = roadI; i < targetI; i++){
            mapArr[++roadI][roadJ] = 1;
            roadList.add(new Road(roadI, roadJ));
        }
        for(int i = roadJ; i > targetJ; i--) {
            mapArr[roadI][roadJ--] = 1;
            roadList.add(new Road(roadI, roadJ));
        }

        roadList.add(new Road(targetI, targetJ));



        for(int i = 0; i < MAP_WIDTH; i++){
            for(int j = 0; j < MAP_HEIGHT; j++){
                if(mapArr[i][j] == 0) landList.add(new Land(i, j));
            }
        }
    }
    public void render(GraphicsContext gc){
        landList.forEach(g ->g.render(gc));
        roadList.forEach(g ->g.render(gc));
        spawner.render(gc);
        target.render(gc);
    }
    public void update(){
        spawner.update();
        target.update();
    }

}
