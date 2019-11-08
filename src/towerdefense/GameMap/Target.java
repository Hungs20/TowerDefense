package towerdefense.GameMap;

public class Target extends TitleMap{
    private static Target instance;
    private Target(){}

    public static Target getTarget(){
        if(instance == null) instance = new Target();
        return instance;
    }
    private void removeEnemy(){}
    @Override
    public void update(){

    }
}
