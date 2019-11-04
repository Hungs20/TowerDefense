package towerdefense;

public class config {
    public static final String pathImg = "file:src/towerdefense/data/";
    public static final int SCREEN_WIDTH = 960;
    public static final int SCREEN_HEIGHT = 640;
    public static final int TILE_SIZE = 64;

    public static final String[][] MAP_SPRITES = new String[][] {
            { "024", "024", "003", "047", "047", "047", "004", "024", "024", "024" },
            { "024", "024", "025", "299", "001", "002", "023", "024", "024", "024" },
            { "024", "024", "025", "023", "024", "025", "023", "024", "024", "024" },
            { "003", "047", "048", "023", "024", "025", "023", "024", "024", "024" },
            { "025", "299", "001", "027", "024", "025", "046", "047", "047", "047" },
            { "025", "023", "024", "024", "024", "026", "001", "001", "001", "001" },
            { "025", "023", "024", "024", "024", "024", "024", "024", "024", "024" },
    };

    public static final String[][] MENU_SPRITES = new String[][]{
            {"267", "267", "267"},
            {"267", "267", "267"},
            {"267", "267", "267"},
            {"267", "267", "267"},
            {"267", "267", "267"},
            {"267", "267", "267"},
            {"267", "267", "267"},
    };

    public static final Point[] wayPoints = new Point[] {
            new Point(0 * 64 + 32, 6 * 64 + 00),
            new Point(0 * 64 + 32, 3 * 64 + 32),
            new Point(2 * 64 + 32, 3 * 64 + 32),
            new Point(2 * 64 + 32, 0 * 64 + 32),
            new Point(5 * 64 + 32, 0 * 64 + 32),
            new Point(5 * 64 + 32, 5 * 64 - 32),
            new Point(9 * 64 + 32, 5 * 64 - 32),
    };

    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

     public static double getRadius(Point a, Point b){
        Point n = new Point(-b.getY() + a.getY(), b.getX() - a.getX());
        double k = (double)-n.getX()/(double)n.getY();
        //System.out.println(a.toString() + b.toString() + " k = " + Math.toDegrees(Math.atan(k)));
        System.out.println(k);

        return  270-Math.toDegrees(Math.atan(k)) ;

     }
}
