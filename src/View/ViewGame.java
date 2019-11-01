package View;

import Controller.ControllerMenu;
import Model.Menu;
import Tools.Path;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ViewGame {


    private MediaPlayer videoBackground;
    private Group root;
    private Menu model;
    private MediaView viewer;
    private ImageView barreCentrale;
    private Text vieJ1;
    private Text vieJ2;

    /**
         * Constructeur du menu principal
         *
         * @param model (Modèle correspondant au menu)
         * @param root  (Groupe principal de la vue)
         */
        ViewGame(Menu model, Group root) {
            this.root = root;
            this.model = model;

            initBackground();
            initBarreCentrale();
initTextVieJ1();
initTextVieJ2();

            setVueCompleteMenu();
        }

    private void initBarreCentrale() {
        barreCentrale = new ImageView(Path.barreCentrale);
        barreCentrale.setX(700);
        barreCentrale.setY(0);
        barreCentrale.setFitHeight(1000);
        barreCentrale.setOpacity(0.5);
    }

    private void initTextVieJ1() {
        vieJ1 = new Text(50, 30, "Life : 1000");
        vieJ1.setFont(Font.font("Dead Kansas", FontWeight.SEMI_BOLD, 25));
        vieJ1.setFill (Color.WHITE);
        vieJ1.setOpacity(0);
    }

    private void initTextVieJ2() {
        vieJ2 = new Text(1300, 30, "Life : 1000");
        vieJ2.setFont(Font.font("Dead Kansas", FontWeight.SEMI_BOLD, 25));
        vieJ2.setFill (Color.WHITE);
        vieJ2.setOpacity(0);
    }


    private void initBackground() {
            videoBackground = new MediaPlayer(new Media(this.getClass().getResource(Path.videobackground4).toExternalForm()));
            videoBackground.setAutoPlay(true);
            videoBackground.setCycleCount(MediaPlayer.INDEFINITE);
            viewer = new MediaView(videoBackground);


            //change width and height to fit video
            DoubleProperty width = viewer.fitWidthProperty();
            DoubleProperty height = viewer.fitHeightProperty();

            width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
            height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
            viewer.setPreserveRatio(false);
        }



    void setVueCompleteMenu() {
        root.getChildren().clear();
        root.getChildren().add(viewer);
        root.getChildren().add(barreCentrale);
        root.getChildren().add(vieJ1);
        root.getChildren().add(vieJ2);



        final Animation animTextMenuArrivee = new Transition() {
            {
                setCycleDuration(Duration.millis(6000));
            }
            protected void interpolate(double frac) {
                vieJ1.setOpacity(frac);
                vieJ2.setOpacity(frac);
            }
        };
        videoBackground.play();
        animTextMenuArrivee.play();
    }




    void setEvents(ControllerMenu mc) {
        //choixVaiss.setOnMouseClicked(mc);
       // jouer.setOnMouseClicked(mc);


        //monLezard.setOnMouseClicked(mc);
        //spider.setOnMouseEntered(mc);

    }

}

