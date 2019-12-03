package towerdefense.Sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import towerdefense.config;

import java.io.File;

public class Sound {
    private Media sound;
    private String linkSound = new String();
    private MediaPlayer player;
    public Sound(){

    }
    public Sound(String linkSound) {
        this.linkSound = linkSound;
        File fileSound = new File(linkSound);
        this.sound = new Media(fileSound.toURI().toString());
        player = new MediaPlayer(sound);
    }
    public void play(){
        if(config.isSound) player.setVolume(1);
        else player.setVolume(0);
        player.play();
        player.seek(Duration.ZERO);
    }
    public void playBackground(){
        if(config.isSound) player.setVolume(1);
        else player.setVolume(0);
        player.setOnEndOfMedia(new Runnable() {
            public void run() {
                player.seek(Duration.ZERO);
            }
        });
        player.play();
    }
}
