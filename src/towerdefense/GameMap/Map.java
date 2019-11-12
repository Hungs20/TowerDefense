package towerdefense.GameMap;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Pair;
import towerdefense.GameField;
import towerdefense.Point;

import java.util.*;

import static towerdefense.GameField.*;
import static towerdefense.config.*;

public class Map {
    private static Map instance;
    private int[][] mapArr = new int[MAP_HEIGHT][MAP_WIDTH];
    private int[][] dir = new int[][] {
            {-1, 1, 0, 0},
            {0, 0, -1, 1}
    };

    private final int startOtherTile = 130;
    private final int endOtherTile = 137;

    public static Map Instance()
    {
        if(instance == null) instance = new Map();
        return instance;
    }
    public boolean isOnRoad(int i, int j)
    {
        if(i >= MAP_WIDTH) return true;
        if(j >= MAP_HEIGHT) return true;
        return ( mapArr[j][i] == 1);
    }

    private void BFS_CreateRandomMap(){
        int[][] root = new int[MAP_HEIGHT][MAP_WIDTH];
        for(int i = 0; i < MAP_HEIGHT; i++){
            for(int j = 0; j < MAP_WIDTH; j++){
                root[i][j] = -1;
            }
        }
        PriorityQueue<pointMap> priorityQueue = new PriorityQueue<>(new pointMapCompare());
        pointMap newPointMap = new pointMap(spawner.getI(), spawner.getJ(), -mapArr[spawner.getJ()][spawner.getI()]);
        priorityQueue.add(newPointMap);
        pointMap endPoint = new pointMap(target.getI(), target.getJ(), -mapArr[target.getJ()][target.getI()]);
        int buffer[][] = new int[MAP_HEIGHT][MAP_WIDTH];
        for(int i = 0; i < MAP_HEIGHT; i++) for(int j = 0; j < MAP_WIDTH; j++) {
            buffer[i][j] = 999999999;
        }
        buffer[spawner.getJ()][spawner.getI()] = mapArr[spawner.getJ()][spawner.getI()];

        while(!priorityQueue.isEmpty()){
            pointMap headPoint = priorityQueue.remove();
            if(headPoint.x == endPoint.x && headPoint.y == endPoint.y) break;
            for(int i = 0; i < 4; i++){
                int _x = headPoint.x + dir[0][i];
                int _y = headPoint.y + dir[1][i];

                if(_x >= 0 && _x < MAP_WIDTH && _y >= 0 && _y < MAP_HEIGHT){
                    int _val = -headPoint.value + mapArr[_y][_x];
                    if(_val < buffer[_y][_x]){
                        buffer[_y][_x] = _val;
                        pointMap bufP = new pointMap(_x, _y, -buffer[_y][_x]);
                        root[_y][_x] = i;
                        priorityQueue.add(bufP);
                    }
                }
            }
        }
        for(int i= 0; i < MAP_HEIGHT; i++) for(int j = 0; j < MAP_WIDTH; j++){
            mapArr[i][j] = 0;
        }
        int u = target.getI();
        int v = target.getJ();
        while (true){
            mapArr[v][u] = 1;
            roadList.add(new Road(u,v));
            if(root[v][u] == -1) break;
            int _u = u - dir[0][root[v][u]];
            int _v = v - dir[1][root[v][u]];
            u = _u;
            v = _v;
        }
        Collections.reverse(roadList);

    }
    private Map(){

        for(int i = 0; i < MAP_HEIGHT; i++) for(int j = 0; j < MAP_WIDTH; j++) mapArr[i][j] = (int)((Math.random() * 100) * (Math.random() * 100)) + 1;
        BFS_CreateRandomMap();
        int numOtherTile = (int)(Math.random() * 10) + 5;
        while (numOtherTile > 0){
            int i = (int)(Math.random() * (MAP_WIDTH - 1));
            int j = (int)(Math.random() * (MAP_HEIGHT - 1));
            if(mapArr[j][i] == 0){
                String item = String.valueOf((int)(Math.random() * (endOtherTile - startOtherTile)) + startOtherTile);
                otherTileList.add(new TitleMap(i, j, new Image(pathImg + "towerDefense_tile" + item + ".png")));
                mapArr[j][i] = 2;
                numOtherTile--;
            }
        }
        for(int i = 0; i < MAP_HEIGHT; i++){
            for(int j = 0; j < MAP_WIDTH; j++){
                if(mapArr[i][j] == 0 || mapArr[i][j] == 2) landList.add(new Land(j, i));
            }
        }
    }
    public void render(GraphicsContext gc){
        landList.forEach(g ->g.render(gc));
        roadList.forEach(g ->g.render(gc));
        otherTileList.forEach(g ->g.render(gc));
        spawner.render(gc);
        target.render(gc);
    }
    public void update(){
        spawner.update();
        target.update();
    }

}
class pointMap{
    int x;
    int y;
    int value;
    pointMap(int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
class pointMapCompare implements Comparator<pointMap>{

    public int compare(pointMap s1, pointMap s2) {
        if (s1.value < s2.value)
            return 1;
        else if (s1.value > s2.value)
            return -1;
        return 0;
    }
}

