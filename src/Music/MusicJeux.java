package Music;

import Tools.Path;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.nio.file.Paths;

public class MusicJeux {

    private static final String MAIN_MENU_THEME = "src/Asset/Sons/New Life.wav";
    private static final String GAME_THEME = "src/Asset/Sons/vent.mp3";
    private static MediaPlayer mediaPlayer;
    private static double volume = 0.5;
    private static MediaPlayer music;
    private static MediaView viewer;

    public static void startMainMenuMusic() {
        if( music != null ) music.stop();

       /* mediaPlayer = new MediaPlayer(new Media(Paths.get(MAIN_MENU_THEME).toUri().toString()));
        mediaPlayer.setCycleCount(-1);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();*/

       // music = new MediaPlayer(new Media(music.getClass().getResource(Path.son).toExternalForm()));
        music = new MediaPlayer(new Media(Paths.get(MAIN_MENU_THEME).toUri().toString()));
        viewer = new MediaView(music);
       // music.setAutoPlay(true);
        music.play();


    }

    public static void startGameMusic() {
        mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(new Media(Paths.get(GAME_THEME).toUri().toString()));
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    public static void setVolume(double volume) {
        MusicJeux.volume = volume;
        if(mediaPlayer!=null) mediaPlayer.setVolume(volume);
    }




}
