package View;

import Controller.ControllerJeux;
import Model.Menu;
import Tools.Path;
import javafx.animation.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Group;
import javafx.scene.image.Image;
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
    private double positionVaissJ1;
    private Timeline timelineGoLeft = null;


    private ImageView vaissJ1;
    private ImageView vaissJ2;
    private ImageView vaissJ1Face;
    private ImageView vaissJ2Face;
    private double positionVaissJ2;
    private Timeline timelineGoRight = null;
    private Animation animTextMenuArrivee;
    private ImageView missil1;


    public Timeline getTimelineGoLeft() {
        return timelineGoLeft;
    }

    public Animation getAnimTextMenuArrivee() {
        return animTextMenuArrivee;
    }
    public Timeline getTimelineGoRight() {
        return timelineGoRight;
    }

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
            initVaisseauxJ1();
            initVaisseauxJ2();
            initVaisseauxJ1Face();
            initVaisseauxJ2Face();
            initMissil1();


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

    private void initVaisseauxJ1() {
        vaissJ1= new ImageView(Path.vaissJ1Back);
        vaissJ1.setX(200);
        vaissJ1.setY(700);
        vaissJ1.setFitWidth(300);
        vaissJ1.setPreserveRatio(true);
        vaissJ1.setOpacity(0);
    }

    private void initVaisseauxJ2() {
        vaissJ2= new ImageView(Path.vaissJ2Back);
        vaissJ2.setX(950);
        vaissJ2.setY(700);
        vaissJ2.setFitWidth(300);
        vaissJ2.setPreserveRatio(true);
        vaissJ2.setOpacity(0);
    }


    private void initVaisseauxJ1Face() {
        vaissJ1Face= new ImageView(Path.vaissJ1Face);
        vaissJ1Face.setX(1050);
        vaissJ1Face.setY(300);
        vaissJ1Face.setFitWidth(75);
        vaissJ1Face.setPreserveRatio(true);
        vaissJ1Face.setOpacity(0);
    }

    private void initVaisseauxJ2Face() {
        vaissJ2Face= new ImageView(Path.vaissJ2Face);
        vaissJ2Face.setX(300);
        vaissJ2Face.setY(300);
        vaissJ2Face.setFitWidth(75);
        vaissJ2Face.setPreserveRatio(true);
        vaissJ2Face.setOpacity(0);
    }

    private void initMissil1() {
        missil1 = new ImageView(Path.missil1);
        missil1 .setX(600);
        missil1 .setY(700);
        missil1 .setFitWidth(100);
        missil1 .setPreserveRatio(true);
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
        root.getChildren().add(vaissJ1);
        root.getChildren().add(vaissJ2);
        root.getChildren().add(vaissJ1Face);
        root.getChildren().add(vaissJ2Face);
root.getChildren().add(missil1);



        final Animation animTextMenuArrivee = new Transition() {
            {
                setCycleDuration(Duration.millis(6000));
            }
            protected void interpolate(double frac) {
                vieJ1.setOpacity(frac);
                vieJ2.setOpacity(frac);
                vaissJ1.setOpacity(frac);
                vaissJ2.setOpacity(frac);
                vaissJ1Face.setOpacity(frac);
                vaissJ2Face.setOpacity(frac);
            }
        };
        videoBackground.play();
        animTextMenuArrivee.play();
    }




    void setEvents(ControllerJeux cj) {

        root.getScene().setOnKeyPressed(cj);
        root.getScene().setOnKeyReleased(cj);



        //choixVaiss.setOnMouseClicked(mc);
       // jouer.setOnMouseClicked(mc);


        //monLezard.setOnMouseClicked(mc);
        //spider.setOnMouseEntered(mc);

    }



    public void j1goRight() {


        if (vaissJ1.getX()<= 500) {

            positionVaissJ1 = vaissJ1.getX();
            double newPosition = positionVaissJ1 + 20;
            vaissJ1.setX(newPosition);

            double positionVaissJ2Face = vaissJ1Face.getX();
            double newPositionFace = positionVaissJ2Face - 20;
            vaissJ1Face.setX(newPositionFace);
        }
    }

    public void j1goLeft() {

        if (vaissJ1.getX()>= -60){
            positionVaissJ1 = vaissJ1.getX();
            double newPosition = positionVaissJ1 - 20;
            vaissJ1.setX(newPosition);

            double positionVaissJ2Face = vaissJ1Face.getX();
            double newPositionFace = positionVaissJ2Face + 20;
            vaissJ1Face.setX(newPositionFace);}
    }



    public void j2goRight() {


        if (vaissJ2.getX()<= 1250) {

            Image vaissJ2droite1 = new Image(Path.vaissJ2BackTurnRight1);
            Image vaissJ2droite2 = new Image(Path.vaissJ2BackTurnRight2);
            Image vaissJ2droite3 = new Image(Path.vaissJ2BackTurnRight3);

            Image vaissJ2normal = new Image(Path.vaissJ2Back);

            if(vaissJ2.getX() < 700){
                vaissJ2.setImage(vaissJ2droite3);

            }else if (vaissJ2.getX() < 850){
                vaissJ2.setImage(vaissJ2droite2);
            }else {
                vaissJ2.setImage(vaissJ2droite1);
            }


            final KeyFrame goRightStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2.xProperty(), vaissJ2.getX()));
           // final KeyFrame changeVaisse = new KeyFrame(Duration.seconds(0.25), new KeyValue(vaissJ2.imageProperty(), vaissJ2droite2));

            final KeyFrame goRightEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(vaissJ2.xProperty(), 1250));

            final KeyFrame goRightStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2Face.xProperty(), vaissJ2Face.getX()));
            final KeyFrame goRightEndFace = new KeyFrame(Duration.seconds(0.5), new KeyValue(vaissJ2Face.xProperty(), 680));

         if (vaissJ2.getX()>= 1200){
                vaissJ2.setImage(vaissJ2normal);
            }

            timelineGoRight = new Timeline(goRightStart, goRightStartFace, /*changeVaisse,*/ goRightEnd, goRightEndFace);
            timelineGoRight.setCycleCount(1);


           /* animTextMenuArrivee = new Transition() {
                {
                    setCycleDuration(Duration.millis(1));
                }

                protected void interpolate(double frac) {
                    positionVaissJ2 = vaissJ2.getX();
                    double newPosition = positionVaissJ2 + 80;
                    vaissJ2.setX(newPosition);
                                //this.stop();
                }

            };

            animTextMenuArrivee.play();*/

          //  vaissJ2.setX(newPosition);


            /*double positionVaissJ2Face = vaissJ2Face.getX();
            double newPositionFace = positionVaissJ2Face - 20;
            vaissJ2Face.setX(newPositionFace);*/
        }
    }

    public void j2goLeft() {

        if (vaissJ2.getX()>= 600){

            Image vaissJ2gauche1 = new Image(Path.vaissJ2BackTurnLeft1);
            Image vaissJ2gauche2 = new Image(Path.vaissJ2BackTurnLeft2);
            Image vaissJ2gauche3 = new Image(Path.vaissJ2BackTurnLeft3);

            Image vaissJ2normal = new Image(Path.vaissJ2Back);


                if(vaissJ2.getX() > 1150){
                    vaissJ2.setImage(vaissJ2gauche3);

                }else if (vaissJ2.getX() > 1000){
                    vaissJ2.setImage(vaissJ2gauche2);
                }else {
                    vaissJ2.setImage(vaissJ2gauche1);
                }


            final KeyFrame goLeftStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2.xProperty(), vaissJ2.getX()));
            final KeyFrame goLeftEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(vaissJ2.xProperty(), 600));


            final KeyFrame goLeftStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2Face.xProperty(), vaissJ2Face.getX()));
            final KeyFrame goLeftEndFace = new KeyFrame(Duration.seconds(0.5), new KeyValue(vaissJ2Face.xProperty(), -30));

            timelineGoLeft = new Timeline(goLeftStart, goLeftStartFace, goLeftEnd, goLeftEndFace);
            timelineGoLeft.setCycleCount(1);

        }
    }

    public void retourNormalBack() {
        Image vaissJ2normal = new Image(Path.vaissJ2Back);
        vaissJ2.setImage(vaissJ2normal);
    }
}

