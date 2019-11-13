package Music;

import Tools.Path;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.nio.file.Paths;

public class MusicJeux {

    private static final String MAIN_MENU_THEME = "src/Asset/Sons/New Life.wav";
    private static final String GAME_THEME = "src/Asset/Sons/vent.mp3";
    private static final String effetLaserr = "src/Asset/Images/Sons_Laser/sonlaserr.mp3";
    private static final String effetexplo = "src/Asset/Images/Sons_Laser/explo1.mp3";
    private static final String effetRocket = "src/Asset/Images/Sons_Laser/2222.mp3";
    private static final String effetexpl2 = "src/Asset/Images/Sons_Laser/explo3.mp3";


    private static MediaPlayer mediaPlayer;
    private static double volume = 1;
    private static MediaPlayer music;
    private static MediaView viewer;

    private static MediaPlayer effetLaser;
    private static MediaPlayer effetexplo1;
    private static MediaPlayer effetRockett;
    private static MediaPlayer effetexplo2;


    public static void startMainMenuMusic() {
       // if( music != null ) music.stop();

       /* mediaPlayer = new MediaPlayer(new Media(Paths.get(MAIN_MENU_THEME).toUri().toString()));
        mediaPlayer.setCycleCount(-1);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();*/

       // music = new MediaPlayer(new Media(music.getClass().getResource(Path.son).toExternalForm()));
        music = new MediaPlayer(new Media(Paths.get(MAIN_MENU_THEME).toUri().toString()));
        viewer = new MediaView(music);
       // music.setAutoPlay(true);
        music.play();
        music.setVolume(0.4);


    }

    public static void stopMainMenuMusic() {

        music.stop();


    }

    public static void startGameMusic() {
        mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(new Media(Paths.get(GAME_THEME).toUri().toString()));
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    public static void setVolume(double volume) {
        MusicJeux.volume = volume;
        if(mediaPlayer!=null) mediaPlayer.setVolume(0.4);
    }

    public static void effetSonorLaser() {
       // if( effetLaser != null ) effetLaser.stop();

        effetLaser = new MediaPlayer(new Media(Paths.get(effetLaserr).toUri().toString()));
        viewer = new MediaView(effetLaser);
        effetLaser.setVolume(volume);
        effetLaser.play();
    }

    public static void effetSonorRocket() {
        // if( effetLaser != null ) effetLaser.stop();

        effetRockett = new MediaPlayer(new Media(Paths.get(effetRocket).toUri().toString()));
        viewer = new MediaView(effetRockett);
        effetRockett.setVolume(0.7);
        effetRockett.play();
    }

    public static void effetexplo() {
      //  if( effetLaser != null ) effetLaser.stop();

        effetexplo1 = new MediaPlayer(new Media(Paths.get(effetexplo).toUri().toString()));
        viewer = new MediaView(effetexplo1);
        effetexplo1.setVolume(2);
        effetexplo1.play();
    }

    public static void effetexplo2() {
        //  if( effetLaser != null ) effetLaser.stop();

        effetexplo2 = new MediaPlayer(new Media(Paths.get(effetexpl2).toUri().toString()));
        viewer = new MediaView(effetexplo2);
        effetexplo2.setVolume(2);
        effetexplo2.play();
    }

}
