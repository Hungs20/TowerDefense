package towerdefense;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class config {
    public static final Group root = new Group();
    public static final String pathImg = "file:src/towerdefense/data/";
    public static final int TILE_SIZE = 64;
    public static final int MAP_WIDTH = 15;
    public static final int MAP_HEIGHT = 9;
    public static final int MENU_WIDTH = 3;
    public static final int MENU_HEIGHT = 10;

    public static final int SPEED_NORMAL_TOWER = 10;
    public static final int SPEED_SNIPER_TOWER = 5;

    public static final int SCREEN_WIDTH = TILE_SIZE * MAP_WIDTH + TILE_SIZE * MENU_WIDTH;
    public static final int SCREEN_HEIGHT = TILE_SIZE * MAP_HEIGHT;

    public static final String[][] MAP_SPRITES = new String[][] {
            { "024", "024", "003", "047", "047", "047", "004", "024", "024", "024" , "024", "024", "024"},
            { "024", "024", "025", "299", "001", "002", "023", "024", "024", "024", "024", "024", "024" },
            { "024", "024", "025", "023", "024", "025", "023", "024", "024", "024", "024", "024", "024" },
            { "003", "047", "048", "023", "024", "025", "023", "024", "024", "024" , "024", "024", "024"},
            { "025", "299", "001", "027", "024", "025", "046", "047", "047", "047", "047", "047", "047" },
            { "025", "023", "024", "024", "024", "026", "001", "001", "001", "001", "001", "001", "001" },
            { "025", "023", "024", "024", "024", "026", "001", "001", "001", "001", "001", "001", "001" },
            { "025", "023", "024", "024", "024", "026", "001", "001", "001", "001", "001", "001", "001" },
            { "025", "023", "024", "024", "024", "024", "024", "024", "024", "024" , "024", "024", "024"},
    };

   /* public static final Point[] wayPoints = new Point[] {
            new Point(0 * 64 + 32, 6 * 64 + 00),
            new Point(0 * 64 + 32, 3 * 64 + 32),
            new Point(2 * 64 + 32, 3 * 64 + 32),
            new Point(2 * 64 + 32, 0 * 64 + 32),
            new Point(5 * 64 + 32, 0 * 64 + 32),
            new Point(5 * 64 + 32, 5 * 64 - 32),
            new Point(9 * 64 + 32, 5 * 64 - 32),
    };*/

    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }


    public static ImageView createImageView(Image image, int X, int Y)
    {
        ImageView imageView = new ImageView(image);
        imageView.setX(X);
        imageView.setY(Y);
        return imageView;
    }
}
