package towerdefense.Sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class GameSound {
    private static Media sound = new Media(new File("src/towerdefense/Sound/sounds/8_music.mp3").toURI().toString());
    private static MediaPlayer player= new MediaPlayer(sound);

    private Media backgroundSound;
    private Media shotingShound;
    private Media turretBuildSound;
    private Media clickSound;

    private MediaPlayer backgroundSoundPlayer;
    private MediaPlayer shotingShoundPlayer;
    private MediaPlayer turretBuildSoundPlayer;
    private MediaPlayer clickSoundPlayer;

    private static GameSound instance;
    public static GameSound Instance(){
        if(instance == null) instance = new GameSound();
        return instance;
    }

    private GameSound(){
        backgroundSound = new Media(new File("src/towerdefense/Sound/sounds/8_music.mp3").toURI().toString());
        shotingShound = new Media(new File("src/towerdefense/Sound/sounds/4_t1shot.mp3").toURI().toString());
        turretBuildSound = new Media(new File("src/towerdefense/Sound/sounds/3_turretbuild.mp3").toURI().toString());
        clickSound = new Media(new File("src/towerdefense/Sound/sounds/7_click.mp3").toURI().toString());

        backgroundSoundPlayer = new MediaPlayer(backgroundSound);
        shotingShoundPlayer = new MediaPlayer(shotingShound);
        turretBuildSoundPlayer = new MediaPlayer(turretBuildSound);
        clickSoundPlayer = new MediaPlayer(clickSound);

        backgroundSoundPlayer.setVolume(0.5);
    }

    public void backgroundSound(){
        backgroundSoundPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                backgroundSoundPlayer.seek(Duration.ZERO);
            }
        });
        backgroundSoundPlayer.play();
    }

    public void shotingShound(){
        shotingShoundPlayer.play();
        shotingShoundPlayer.seek(Duration.ZERO);
    }

    public void TurretBuildSound(){
        turretBuildSoundPlayer.play();
        turretBuildSoundPlayer.seek(Duration.ZERO);
    }

    public void clickSound(){
        clickSoundPlayer.play();
        clickSoundPlayer.seek(Duration.ZERO);
    }
}
