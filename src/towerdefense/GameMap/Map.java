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
    private final int LAND = 0;
    private final int ROAD = 1;
    private final int OTHER = 2;
    private final int LEFT = 3;
    private final int RIGHT = 4;
    private final int UP = 5;
    private final int DOWN = 6;
    private final int RIGHT_DOWN = 7;
    private final int RIGHT_UP = 8;
    private final int LEFT_UP = 9;
    private final int LEFT_DOWN = 10;

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
    public boolean isOnLand(int i, int j)
    {
        if(i >= MAP_WIDTH) return false;
        if(j >= MAP_HEIGHT) return false;
        return ( mapArr[j][i] == LAND);
    }
    public void setOnLand(int i, int j, int value){
        if(i >= 0 && i < MAP_WIDTH && j >= 0 && j < MAP_HEIGHT) mapArr[j][i] = value;
    }
    public void Create2Land() {
        for(int i = 1; i < roadList.size()-1; i++){
            int u = roadList.get(i).getI();
            int v = roadList.get(i).getJ();

            int uPre = roadList.get(i-1).getI();
            int vPre = roadList.get(i-1).getJ();
            int uNext = roadList.get(i+1).getI();
            int vNext = roadList.get(i+1).getJ();
            if(vPre == vNext){
             //   otherTileList.add(new TitleMap(u, v - 1, new Image(pathImg + "towerDefense_tile070.png")));
             //   otherTileList.add(new TitleMap(u, v + 1, new Image(pathImg + "towerDefense_tile116.png")));
                if(v > 0 && mapArr[v - 1][u] != LEFT_DOWN && mapArr[v - 1][u] != LEFT_UP) mapArr[v - 1][u] = LEFT;
                if(v + 1 < MAP_HEIGHT && mapArr[v + 1][u] != RIGHT_UP && mapArr[v + 1][u] != RIGHT_DOWN) mapArr[v + 1][u] = RIGHT;

            }
            else if(uPre == uNext){
               // otherTileList.add(new TitleMap(u - 1, v, new Image(pathImg + "towerDefense_tile092.png")));
               // otherTileList.add(new TitleMap(u + 1, v, new Image(pathImg + "towerDefense_tile094.png")));
                if(u > 0 && mapArr[v][u - 1] != LEFT_DOWN && mapArr[v][u - 1] != RIGHT_DOWN) mapArr[v][u - 1] = DOWN;
                if(u + 1 < MAP_WIDTH && mapArr[v][u + 1] != LEFT_UP && mapArr[v][u + 1] != RIGHT_UP) mapArr[v][u + 1] = UP;

            }
            else if((uPre - uNext) * (vPre - vNext) < 0){
               if(vPre < v || vNext < v) {
                   if(u > 0 && v + 1 < MAP_HEIGHT) mapArr[v+1][u - 1] = RIGHT_UP;//otherTileList.add(new TitleMap(u - 1, v + 1, new Image(pathImg + "towerDefense_tile095.png")));
               }
                else {
                    if(u + 1 < MAP_WIDTH && v + 1 < MAP_HEIGHT) mapArr[v + 1][u + 1] = RIGHT_DOWN;//otherTileList.add(new TitleMap(u + 1, v + 1, new Image(pathImg + "towerDefense_tile072.png")));
               }
            }
            else if((uPre - uNext) * (vPre - vNext) > 0){
                if(vPre < v || vNext < v) {
                    if(u > 0 && v > 0) mapArr[v - 1][u - 1] = LEFT_UP;//otherTileList.add(new TitleMap(u - 1, v - 1, new Image(pathImg + "towerDefense_tile096.png")));
                }
                else {
                    if(u + 1 < MAP_WIDTH && v > 0) mapArr[v - 1][u + 1] = LEFT_DOWN;//otherTileList.add(new TitleMap(u + 1, v - 1, new Image(pathImg + "towerDefense_tile073.png")));
                }
            }
        }

        for (int i = 0; i < MAP_HEIGHT; i++){
            for (int j = 0; j < MAP_WIDTH; j++){
                if(mapArr[i][j] == DOWN) otherTileList.add(new TitleMap(j, i, new Image(pathImg + "towerDefense_tile092.png"))) ;
                else if(mapArr[i][j] == UP) otherTileList.add(new TitleMap(j, i, new Image(pathImg + "towerDefense_tile094.png")));
                else if(mapArr[i][j] == LEFT) otherTileList.add(new TitleMap(j, i, new Image(pathImg + "towerDefense_tile070.png")));
                else if(mapArr[i][j] == RIGHT) otherTileList.add(new TitleMap(j, i, new Image(pathImg + "towerDefense_tile116.png")));
                else if(mapArr[i][j] == LEFT_DOWN) otherTileList.add(new TitleMap(j, i, new Image(pathImg + "towerDefense_tile073.png")));
                else if(mapArr[i][j] == LEFT_UP) otherTileList.add(new TitleMap(j, i, new Image(pathImg + "towerDefense_tile096.png")));
                else if(mapArr[i][j] == RIGHT_DOWN) otherTileList.add(new TitleMap(j, i, new Image(pathImg + "towerDefense_tile072.png")));
                else if(mapArr[i][j] == RIGHT_UP) otherTileList.add(new TitleMap(j, i, new Image(pathImg + "towerDefense_tile095.png")));

            }
        }
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
            mapArr[i][j] = LAND;
        }
        int u = target.getI();
        int v = target.getJ();
        while (true){
            mapArr[v][u] = ROAD;
            roadList.add(new Road(u,v));
            if(root[v][u] == -1) break;
            int _u = u - dir[0][root[v][u]];
            int _v = v - dir[1][root[v][u]];
            u = _u;
            v = _v;
        }
        Collections.reverse(roadList);

    }
    public void createEasyMap(){
        for(int i = 0; i < MAP_HEIGHT; i++) for(int j = 0; j < MAP_WIDTH; j++) mapArr[i][j] = (int)((Math.random() * 100) * (Math.random() * 100)) + 1;
        BFS_CreateRandomMap();
    }
    public void createNormalMap(){

        int u = (int)(Math.random() * MAP_WIDTH/2) + 3;
        for(int i = spawner.getI(); i <= u; i++){
            mapArr[spawner.getJ()][i] = ROAD;
            roadList.add(new Road(i, spawner.getJ()));
        }
        for(int i = spawner.getJ(); i <= target.getJ(); i++){
            mapArr[i][u] = ROAD;
            roadList.add(new Road(u,i));
        }
        for(int i = u + 1; i <= target.getI(); i++){
            mapArr[target.getJ()][i] = ROAD;
            roadList.add(new Road(i, target.getJ()));
        }

    }
    public void createHardMap(){
        for(int i = spawner.getI(); i <= target.getI(); i++){
            mapArr[spawner.getJ()][i] = ROAD;
            roadList.add(new Road(i, spawner.getJ()));
        }
    }
    public void createNewMap(){

        roadList.clear();
        landList.clear();
        otherTileList.clear();
        for(int i = 0; i < MAP_HEIGHT; i++) for(int j = 0; j < MAP_WIDTH; j++) mapArr[i][j] = LAND;
        if(levelMap == 0) createEasyMap();
        else if(levelMap == 1) createNormalMap();
        else createHardMap();
         // Create2Land();
        int numOtherTile = (int)(Math.random() * 10) + 5;
        while (numOtherTile > 0){
            int i = (int)(Math.random() * (MAP_WIDTH - 1));
            int j = (int)(Math.random() * (MAP_HEIGHT - 1));
            if(mapArr[j][i] == LAND){
                String item = String.valueOf((int)(Math.random() * (endOtherTile - startOtherTile)) + startOtherTile);
                otherTileList.add(new Land(i, j));
                otherTileList.add(new TitleMap(i, j, new Image(pathImg + "towerDefense_tile" + item + ".png")));
                mapArr[j][i] = OTHER;
                numOtherTile--;
            }
        }
        for(int i = 0; i < MAP_HEIGHT; i++){
            for(int j = 0; j < MAP_WIDTH; j++){
                if(mapArr[i][j] == LAND) landList.add(new Land(j, i));
            }
        }
    }
    private Map(){
        createNewMap();
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

