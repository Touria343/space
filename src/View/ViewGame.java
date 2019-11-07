package View;

import Controller.ControllerJeux;
import Model.Menu;
import Tools.Path;
import javafx.animation.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Bounds;
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

import java.util.ArrayList;

public class ViewGame {


    private MediaPlayer videoBackground;
    private Group root;
    private Menu model;
    private MediaView viewer;
    private ImageView barreCentrale;
    private Text vieJ1;
    private Text vieJ2;
    private double positionVaissJ1;
    private Timeline timelineGoLeftJ2 = null;


    private ImageView vaissJ1;
    private ImageView vaissJ2;
    private ImageView vaissJ1Face;
    private ImageView vaissJ2Face;
    private double positionVaissJ2;
    private Timeline timelineGoRightJ2 = null;
    private Animation animTextMenuArrivee;
    private ImageView missil1;
    private Bounds tirFBound;
    private PauseTransition delayExploTouch;
    private int puissanceTir;
    private int cote;


    private Timeline timelineGoLeftJ1;
    private int vieintJ1 = 1000;
    private int indiVaissJ1;
    private int indiVaissJ2;
    private ArrayList<ImageView> tabImageVaiss0J1;

    public Timeline getTimelineGoRightJ1() {
        return timelineGoRightJ1;
    }

    private Timeline timelineGoRightJ1;

    public Timeline getTimelineGoLeftJ1() {
        return timelineGoLeftJ1;
    }

    public Timeline getTimelineGoLeftJ2() {
        return timelineGoLeftJ2;
    }

    public Animation getAnimTextMenuArrivee() {
        return animTextMenuArrivee;
    }

    public Timeline getTimelineGoRightJ2() {
        return timelineGoRightJ2;
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


        setVueCompleteMenu(indiVaissJ1, indiVaissJ2);
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
        vieJ1.setFill(Color.WHITE);
        vieJ1.setOpacity(0);
    }

    private void initTextVieJ2() {
        vieJ2 = new Text(1300, 30, "Life : 1000");
        vieJ2.setFont(Font.font("Dead Kansas", FontWeight.SEMI_BOLD, 25));
        vieJ2.setFill(Color.WHITE);
        vieJ2.setOpacity(0);
    }

    private void initVaisseauxJ1() {

        if (indiVaissJ2 == 0) {
            tabImageVaissJ1 = new ArrayList<>();
            tabImageVaissJ1.add(new ImageView(Path.vaissJ2BackTurnLeft1));
            tabImageVaissJ1.add(new ImageView(Path.vaissJ1BackTurnLeft2));
            tabImageVaissJ1.add(new ImageView(Path.vaissJ1BackTurnLeft1));
            tabImageVaissJ1.add(new ImageView(Path.vaissJ1Back));
            tabImageVaissJ1.add(new ImageView(Path.stats4));

        } else if (indiVaissJ2 == 1) {
            tabImageVaissJ1 = new ArrayList<>();
            tabImageVaissJ1.add(new ImageView(Path.vaissJ2BackTurnLeft1));
            tabImageVaissJ1.add(new ImageView(Path.vaissJ1BackTurnLeft2));
            tabImageVaissJ1.add(new ImageView(Path.vaissJ1BackTurnLeft1));
            tabImageVaissJ1.add(new ImageView(Path.vaissJ1Back));
            tabImageVaissJ1.add(new ImageView(Path.stats4));

        } else if (indiVaissJ2 == 2) {
            tabImageVaissJ1 = new ArrayList<>();
            tabImageVaissJ1.add(new ImageView(Path.vaissJ2BackTurnLeft1));
            tabImageVaissJ1.add(new ImageView(Path.vaissJ1BackTurnLeft2));
            tabImageVaissJ1.add(new ImageView(Path.vaissJ1BackTurnLeft1));
            tabImageVaissJ1.add(new ImageView(Path.vaissJ1Back));
            tabImageVaissJ1.add(new ImageView(Path.stats4));

        } else if (indiVaissJ2 == 3) {
            tabImageVaissJ1 = new ArrayList<>();
            tabImageVaissJ1.add(new ImageView(Path.vaissJ2BackTurnLeft1));
            tabImageVaissJ1.add(new ImageView(Path.vaissJ1BackTurnLeft2));
            tabImageVaissJ1.add(new ImageView(Path.vaissJ1BackTurnLeft1));
            tabImageVaissJ1.add(new ImageView(Path.vaissJ1Back));
            tabImageVaissJ1.add(new ImageView(Path.stats4));
        }

        vaissJ1 = new ImageView(tabImageVaiss0J1[indiVaissJ1]);
        vaissJ1.setX(200);
        vaissJ1.setY(700);
        vaissJ1.setFitWidth(300);
        vaissJ1.setPreserveRatio(true);
        vaissJ1.setOpacity(0);
        vaissJ1.setPickOnBounds(false);
    }

    private void initVaisseauxJ2() {
        if (indiVaissJ2 == 0) {
            tabImageVaissJ2 = new ArrayList<>();
            tabImageVaissJ2.add(new ImageView(Path.vaissJ2BackTurnLeft1));
            tabImageVaissJ2.add(new ImageView(Path.vaissJ1BackTurnLeft2));
            tabImageVaissJ2.add(new ImageView(Path.vaissJ1BackTurnLeft1));
            tabImageVaissJ2.add(new ImageView(Path.vaissJ1Back));
            tabImageVaissJ2.add(new ImageView(Path.stats4));
        } else if (indiVaissJ2 == 1) {
            tabImageVaissJ2 = new ArrayList<>();
            tabImageVaissJ2.add(new ImageView(Path.vaissJ2BackTurnLeft1));
            tabImageVaissJ2.add(new ImageView(Path.vaissJ1BackTurnLeft2));
            tabImageVaissJ2.add(new ImageView(Path.vaissJ1BackTurnLeft1));
            tabImageVaissJ2.add(new ImageView(Path.vaissJ1Back));
            tabImageVaissJ2.add(new ImageView(Path.stats4));
        } else if (indiVaissJ2 == 2) {
            tabImageVaissJ2 = new ArrayList<>();
            tabImageVaissJ2.add(new ImageView(Path.vaissJ2BackTurnLeft1));
            tabImageVaissJ2.add(new ImageView(Path.vaissJ1BackTurnLeft2));
            tabImageVaissJ2.add(new ImageView(Path.vaissJ1BackTurnLeft1));
            tabImageVaissJ2.add(new ImageView(Path.vaissJ1Back));
            tabImageVaissJ2.add(new ImageView(Path.stats4));
        } else if (indiVaissJ2 == 3) {
            tabImageVaissJ2 = new ArrayList<>();
            tabImageVaissJ2.add(new ImageView(Path.vaissJ2BackTurnLeft1));
            tabImageVaissJ2.add(new ImageView(Path.vaissJ1BackTurnLeft2));
            tabImageVaissJ2.add(new ImageView(Path.vaissJ1BackTurnLeft1));
            tabImageVaissJ2.add(new ImageView(Path.vaissJ1Back));
            tabImageVaissJ2.add(new ImageView(Path.stats4));
        }

        vaissJ2 = new ImageView(tabImageVaiss0J1[indiVaissJ1]);
        vaissJ2.setX(950);
        vaissJ2.setY(700);
        vaissJ2.setFitWidth(300);
        vaissJ2.setPreserveRatio(true);
        vaissJ2.setOpacity(0);
        vaissJ2.setPickOnBounds(false);
    }


    private void initVaisseauxJ1Face() {
        vaissJ1Face = new ImageView(Path.vaissJ1Face);
        vaissJ1Face.setX(1050);
        vaissJ1Face.setY(300);
        vaissJ1Face.setFitWidth(75);
        vaissJ1Face.setPreserveRatio(true);
        vaissJ1Face.setOpacity(0);
        vaissJ1Face.setPickOnBounds(false);

    }

    private void initVaisseauxJ2Face() {
        vaissJ2Face = new ImageView(Path.vaissJ2Face);
        vaissJ2Face.setX(300);
        vaissJ2Face.setY(300);
        vaissJ2Face.setFitWidth(75);
        vaissJ2Face.setPreserveRatio(true);
        vaissJ2Face.setOpacity(0);
        vaissJ2Face.setPickOnBounds(false);

    }

    public MediaPlayer getVideoBackground() {
        return videoBackground;
    }

    public Text getVieJ1() {
        return vieJ1;
    }

    public Text getVieJ2() {
        return vieJ2;
    }

    private void initBackground() {
        videoBackground = new MediaPlayer(new Media(this.getClass().getResource(Path.videobackground4).toExternalForm()));
        videoBackground.setCycleCount(MediaPlayer.INDEFINITE);
        viewer = new MediaView(videoBackground);

        videoBackground.stop();

        //change width and height to fit video
        DoubleProperty width = viewer.fitWidthProperty();
        DoubleProperty height = viewer.fitHeightProperty();

        width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
        viewer.setPreserveRatio(false);
    }

    void setVueCompleteMenu(int indiceVaissJ1, int indiceVaissJ2) {
        indiVaissJ1 = indiceVaissJ1;
        indiVaissJ2 = indiceVaissJ2;

        root.getChildren().clear();
        root.getChildren().add(viewer);
        root.getChildren().add(barreCentrale);
        root.getChildren().add(vieJ1);
        root.getChildren().add(vieJ2);
        root.getChildren().add(vaissJ1);
        root.getChildren().add(vaissJ2);
        root.getChildren().add(vaissJ1Face);
        root.getChildren().add(vaissJ2Face);

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

    public void j1goRight(int vitesse) {

        if (vaissJ1.getX() <= 601) {

            Image vaissJ2gauche1 = new Image(Path.vaissJ2BackTurnLeft1);
            Image vaissJ2gauche2 = new Image(Path.vaissJ2BackTurnLeft2);
            Image vaissJ2gauche3 = new Image(Path.vaissJ2BackTurnLeft3);

            if (vaissJ2.getX() < 150) {
                vaissJ1.setImage(vaissJ2gauche3);
            } else if (vaissJ1.getX() < 350) {
                vaissJ1.setImage(vaissJ2gauche2);
            } else {
                vaissJ1.setImage(vaissJ2gauche1);
            }

            final KeyFrame goLeftStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ1.xProperty(), vaissJ1.getX()));
            final KeyFrame goLeftEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(vaissJ1.xProperty(), 500));

            final KeyFrame goLeftStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ1Face.xProperty(), vaissJ1Face.getX()));
            final KeyFrame goLeftEndFace = new KeyFrame(Duration.seconds(0.5), new KeyValue(vaissJ1Face.xProperty(), 800));

            timelineGoRightJ1 = new Timeline(goLeftStart, goLeftStartFace, goLeftEnd, goLeftEndFace);
            timelineGoRightJ1.setCycleCount(1);
        }
    }

    public void j1goLeft(int vitesse) {

        if (vaissJ1.getX() >= -101) {

            Image vaissJ2gauche1 = new Image(Path.vaissJ2BackTurnLeft1);
            Image vaissJ2gauche2 = new Image(Path.vaissJ2BackTurnLeft2);
            Image vaissJ2gauche3 = new Image(Path.vaissJ2BackTurnLeft3);

            if (vaissJ2.getX() > 750) {
                vaissJ1.setImage(vaissJ2gauche3);
            } else if (vaissJ1.getX() > 550) {
                vaissJ1.setImage(vaissJ2gauche2);
            } else {
                vaissJ1.setImage(vaissJ2gauche1);
            }

            final KeyFrame goLeftStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ1.xProperty(), vaissJ1.getX()));
            final KeyFrame goLeftEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(vaissJ1.xProperty(), -100));

            final KeyFrame goLeftStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ1Face.xProperty(), vaissJ1Face.getX()));
            final KeyFrame goLeftEndFace = new KeyFrame(Duration.seconds(0.5), new KeyValue(vaissJ1Face.xProperty(), 1250));

            timelineGoLeftJ1 = new Timeline(goLeftStart, goLeftStartFace, goLeftEnd, goLeftEndFace);
            timelineGoLeftJ1.setCycleCount(1);
        }
    }

    public void j2goRight(int vitesse) {

        if (vaissJ2.getX() <= 1251) {

            Image vaissJ2droite1 = new Image(Path.vaissJ2BackTurnRight1);
            Image vaissJ2droite2 = new Image(Path.vaissJ2BackTurnRight2);
            Image vaissJ2droite3 = new Image(Path.vaissJ2BackTurnRight3);

            if (vaissJ2.getX() < 700) {
                vaissJ2.setImage(vaissJ2droite3);
            } else if (vaissJ2.getX() < 850) {
                vaissJ2.setImage(vaissJ2droite2);
            } else {
                vaissJ2.setImage(vaissJ2droite1);
            }

            final KeyFrame goRightStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2.xProperty(), vaissJ2.getX()));
            final KeyFrame goRightEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(vaissJ2.xProperty(), 1250));

            final KeyFrame goRightStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2Face.xProperty(), vaissJ2Face.getX()));
            final KeyFrame goRightEndFace = new KeyFrame(Duration.seconds(0.5), new KeyValue(vaissJ2Face.xProperty(), 70));

            timelineGoRightJ2 = new Timeline(goRightStart, goRightStartFace, /*changeVaisse,*/ goRightEnd, goRightEndFace);
            timelineGoRightJ2.setCycleCount(1);
        }
    }

    public void j2goLeft(int vitesse) {

        if (vaissJ2.getX() >= 601) {

            Image vaissJ2gauche1 = new Image(Path.vaissJ2BackTurnLeft1);
            Image vaissJ2gauche2 = new Image(Path.vaissJ2BackTurnLeft2);
            Image vaissJ2gauche3 = new Image(Path.vaissJ2BackTurnLeft3);

            if (vaissJ2.getX() > 1150) {
                vaissJ2.setImage(vaissJ2gauche3);
            } else if (vaissJ2.getX() > 1000) {
                vaissJ2.setImage(vaissJ2gauche2);
            } else {
                vaissJ2.setImage(vaissJ2gauche1);
            }

            final KeyFrame goLeftStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2.xProperty(), vaissJ2.getX()));
            final KeyFrame goLeftEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(vaissJ2.xProperty(), 600));

            final KeyFrame goLeftStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2Face.xProperty(), vaissJ2Face.getX()));
            final KeyFrame goLeftEndFace = new KeyFrame(Duration.seconds(0.5), new KeyValue(vaissJ2Face.xProperty(), 550));

            timelineGoLeftJ2 = new Timeline(goLeftStart, goLeftStartFace, goLeftEnd, goLeftEndFace);
            timelineGoLeftJ2.setCycleCount(1);

        }
    }

    public void retourNormalBack() {
        Image vaissJ2normal = new Image(Path.vaissJ2Back);
        vaissJ2.setImage(vaissJ2normal);
    }

    public void tir(int vieVaiss, int puissanceTir, int cote) {

        if (puissanceTir == 1 && cote == 2) {
            ImageView tir = new ImageView(Path.laserBleu1Back);
            tir.setX(vaissJ2.getX() + 130);
            tir.setY(700);
            tir.setFitWidth(80);
            tir.setPreserveRatio(true);
            root.getChildren().remove(vaissJ2);
            root.getChildren().add(tir);
            root.getChildren().add(vaissJ2);

            final KeyFrame tirStartXajust;
            final KeyFrame tirEndXajust;

            if (vaissJ2.getX() < 700) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 200));
                tir.setRotate(6);
            } else if (vaissJ2.getX() < 850) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 190));
                tir.setRotate(4);
            } else if (vaissJ2.getX() > 1050) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 70));
                tir.setRotate(-5);

            } else if (vaissJ2.getX() > 1200) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 60));
                tir.setRotate(-7);
            } else {

                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 140));
                tir.setRotate(0);

            }

            final KeyFrame tirStartY = new KeyFrame(Duration.ZERO, new KeyValue(tir.yProperty(), 700));
            // final KeyFrame changeVaisse = new KeyFrame(Duration.seconds(0.25), new KeyValue(vaissJ2.imageProperty(), vaissJ2droite2));
            final KeyFrame tirEndY = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.yProperty(), 250));

            final KeyFrame tirStartWidth = new KeyFrame(Duration.ZERO, new KeyValue(tir.fitWidthProperty(), 80));
            final KeyFrame tirEndWidth = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.fitWidthProperty(), 1));

            final Timeline timelineTir = new Timeline(tirStartY, tirStartWidth, tirStartXajust, tirEndY, tirEndWidth, tirEndXajust);

            timelineTir.play();

            ImageView tirF = new ImageView(Path.missil1F);
            tirF.setX(vaissJ2Face.getX() + 30);
            tirF.setY(700);
            tirF.setFitWidth(10);
            tirF.setPreserveRatio(true);
            tirF.setRotate(-2);
            root.getChildren().remove(vaissJ2);
            root.getChildren().remove(vaissJ1);

            root.getChildren().add(tirF);
            root.getChildren().add(vaissJ2);
            root.getChildren().add(vaissJ1);


            PauseTransition delayRemoveTir = new PauseTransition(Duration.seconds(3));
            delayRemoveTir.setOnFinished(event -> {
                root.getChildren().remove(tir);
                root.getChildren().remove(tirF);


            });
            delayRemoveTir.play();


            final KeyFrame tirStartYF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.yProperty(), 320));
            // final KeyFrame changeVaisse = new KeyFrame(Duration.seconds(0.25), new KeyValue(vaissJ2.imageProperty(), vaissJ2droite2));
            final KeyFrame tirEndYF = new KeyFrame(Duration.seconds(4.7), new KeyValue(tirF.yProperty(), 1100));

            final KeyFrame tirStartXajustF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.xProperty(), vaissJ2Face.getX() + 30));
            final KeyFrame tirEndXajustF = new KeyFrame(Duration.seconds(4), new KeyValue(tirF.xProperty(), vaissJ2Face.getX() + 10));

            final KeyFrame tirStartWidthF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.fitWidthProperty(), 1));
            final KeyFrame tirEndWidthF = new KeyFrame(Duration.seconds(4), new KeyValue(tirF.fitWidthProperty(), 25));

            final Timeline timelineTirF = new Timeline(tirStartYF, tirStartWidthF, tirStartXajustF, tirEndYF, tirEndWidthF, tirEndXajustF);

            timelineTirF.play();

            tirFBound = tirF.getBoundsInParent();

            delayExploTouch = new PauseTransition(Duration.seconds(2));
            delayExploTouch.setOnFinished(event -> {

                if (tir.getBoundsInParent().intersects(vaissJ1Face.getBoundsInParent())) {

                    vieintJ1 = vieintJ1 - 30;
                    getVieJ1().setText("Life :" + (vieintJ1));

                    //  if(vieintJ1 <=0){
                    ImageView explosFinale = new ImageView(Path.exploFinale);
                    explosFinale.setX(vaissJ1.getX() + 50);
                    explosFinale.setY(650);
                    explosFinale.setFitWidth(250);
                    explosFinale.setPreserveRatio(true);
                    explosFinale.setOpacity(0.6);
                    root.getChildren().add(explosFinale);
                    //   }


                    ImageView toucheExplos = new ImageView(Path.toucheExplo1);
                    toucheExplos.setX(vaissJ1.getX() + 40);
                    toucheExplos.setY(570);
                    toucheExplos.setFitWidth(300);
                    toucheExplos.setPreserveRatio(true);
                    toucheExplos.setOpacity(0.7);


                    ImageView toucheExplosF = new ImageView(Path.toucheExploBleu1);
                    toucheExplosF.setX(vaissJ1Face.getX() + 10);
                    toucheExplosF.setY(300);
                    toucheExplosF.setFitWidth(40);
                    toucheExplosF.setPreserveRatio(true);
                    toucheExplosF.setOpacity(0.6);


                    //root.getChildren().remove(vaissJ2);
                    root.getChildren().add(toucheExplosF);
                    root.getChildren().add(toucheExplos);
                    //root.getChildren().add(vaissJ2);
                    //game over
                    root.getChildren().remove(tir);
                    root.getChildren().remove(tirF);

                    PauseTransition delayExplodispar = new PauseTransition(Duration.seconds(0.8));
                    delayExplodispar.setOnFinished(event2 -> {

                        root.getChildren().remove(toucheExplos);
                        root.getChildren().remove(toucheExplosF);

                    });
                    delayExplodispar.play();


                }
            });
            delayExploTouch.play();
        } else if (puissanceTir == 2 && cote == 2) {

            ImageView tir = new ImageView(Path.laserBleu1Back);
            tir.setX(vaissJ2.getX() + 130);
            tir.setY(700);
            tir.setFitWidth(80);
            tir.setPreserveRatio(true);
            root.getChildren().remove(vaissJ2);
            root.getChildren().add(tir);
            root.getChildren().add(vaissJ2);

            final KeyFrame tirStartXajust;
            final KeyFrame tirEndXajust;

            if (vaissJ2.getX() < 700) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 200));
                tir.setRotate(6);
            } else if (vaissJ2.getX() < 850) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 190));
                tir.setRotate(4);
            } else if (vaissJ2.getX() > 1050) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 70));
                tir.setRotate(-5);

            } else if (vaissJ2.getX() > 1200) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 60));
                tir.setRotate(-7);
            } else {

                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 140));
                tir.setRotate(0);

            }

            final KeyFrame tirStartY = new KeyFrame(Duration.ZERO, new KeyValue(tir.yProperty(), 700));
            // final KeyFrame changeVaisse = new KeyFrame(Duration.seconds(0.25), new KeyValue(vaissJ2.imageProperty(), vaissJ2droite2));
            final KeyFrame tirEndY = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.yProperty(), 250));

            final KeyFrame tirStartWidth = new KeyFrame(Duration.ZERO, new KeyValue(tir.fitWidthProperty(), 80));
            final KeyFrame tirEndWidth = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.fitWidthProperty(), 1));

            final Timeline timelineTir = new Timeline(tirStartY, tirStartWidth, tirStartXajust, tirEndY, tirEndWidth, tirEndXajust);

            timelineTir.play();

            ImageView tirF = new ImageView(Path.missil1F);
            tirF.setX(vaissJ2Face.getX() + 30);
            tirF.setY(700);
            tirF.setFitWidth(10);
            tirF.setPreserveRatio(true);
            tirF.setRotate(-2);
            root.getChildren().remove(vaissJ2);
            root.getChildren().remove(vaissJ1);

            root.getChildren().add(tirF);
            root.getChildren().add(vaissJ2);
            root.getChildren().add(vaissJ1);


            PauseTransition delayRemoveTir = new PauseTransition(Duration.seconds(3));
            delayRemoveTir.setOnFinished(event -> {
                root.getChildren().remove(tir);
                root.getChildren().remove(tirF);


            });
            delayRemoveTir.play();


            final KeyFrame tirStartYF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.yProperty(), 320));
            // final KeyFrame changeVaisse = new KeyFrame(Duration.seconds(0.25), new KeyValue(vaissJ2.imageProperty(), vaissJ2droite2));
            final KeyFrame tirEndYF = new KeyFrame(Duration.seconds(4.7), new KeyValue(tirF.yProperty(), 1100));

            final KeyFrame tirStartXajustF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.xProperty(), vaissJ2Face.getX() + 30));
            final KeyFrame tirEndXajustF = new KeyFrame(Duration.seconds(4), new KeyValue(tirF.xProperty(), vaissJ2Face.getX() + 10));

            final KeyFrame tirStartWidthF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.fitWidthProperty(), 1));
            final KeyFrame tirEndWidthF = new KeyFrame(Duration.seconds(4), new KeyValue(tirF.fitWidthProperty(), 25));

            final Timeline timelineTirF = new Timeline(tirStartYF, tirStartWidthF, tirStartXajustF, tirEndYF, tirEndWidthF, tirEndXajustF);

            timelineTirF.play();

            tirFBound = tirF.getBoundsInParent();

            delayExploTouch = new PauseTransition(Duration.seconds(2));
            delayExploTouch.setOnFinished(event -> {

                if (tir.getBoundsInParent().intersects(vaissJ1Face.getBoundsInParent())) {

                    vieintJ1 = vieintJ1 - 30;
                    getVieJ1().setText("Life :" + (vieintJ1));

                    //  if(vieintJ1 <=0){
                    ImageView explosFinale = new ImageView(Path.exploFinale);
                    explosFinale.setX(vaissJ1.getX() + 50);
                    explosFinale.setY(650);
                    explosFinale.setFitWidth(250);
                    explosFinale.setPreserveRatio(true);
                    explosFinale.setOpacity(0.6);
                    root.getChildren().add(explosFinale);
                    //   }


                    ImageView toucheExplos = new ImageView(Path.toucheExplo1);
                    toucheExplos.setX(vaissJ1.getX() + 40);
                    toucheExplos.setY(570);
                    toucheExplos.setFitWidth(300);
                    toucheExplos.setPreserveRatio(true);
                    toucheExplos.setOpacity(0.7);


                    ImageView toucheExplosF = new ImageView(Path.toucheExploBleu1);
                    toucheExplosF.setX(vaissJ1Face.getX() + 10);
                    toucheExplosF.setY(300);
                    toucheExplosF.setFitWidth(40);
                    toucheExplosF.setPreserveRatio(true);
                    toucheExplosF.setOpacity(0.6);


                    //root.getChildren().remove(vaissJ2);
                    root.getChildren().add(toucheExplosF);
                    root.getChildren().add(toucheExplos);
                    //root.getChildren().add(vaissJ2);
                    //game over
                    root.getChildren().remove(tir);
                    root.getChildren().remove(tirF);

                    PauseTransition delayExplodispar = new PauseTransition(Duration.seconds(0.8));
                    delayExplodispar.setOnFinished(event2 -> {

                        root.getChildren().remove(toucheExplos);
                        root.getChildren().remove(toucheExplosF);

                    });
                    delayExplodispar.play();


                }
            });
            delayExploTouch.play();


        } else if (puissanceTir == 1 && cote == 1) {
            ImageView tir = new ImageView(Path.laserBleu1Back);
            tir.setX(vaissJ2.getX() + 130);
            tir.setY(700);
            tir.setFitWidth(80);
            tir.setPreserveRatio(true);
            root.getChildren().remove(vaissJ2);
            root.getChildren().add(tir);
            root.getChildren().add(vaissJ2);

            final KeyFrame tirStartXajust;
            final KeyFrame tirEndXajust;

            if (vaissJ2.getX() < 700) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 200));
                tir.setRotate(6);
            } else if (vaissJ2.getX() < 850) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 190));
                tir.setRotate(4);
            } else if (vaissJ2.getX() > 1050) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 70));
                tir.setRotate(-5);

            } else if (vaissJ2.getX() > 1200) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 60));
                tir.setRotate(-7);
            } else {

                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 140));
                tir.setRotate(0);

            }

            final KeyFrame tirStartY = new KeyFrame(Duration.ZERO, new KeyValue(tir.yProperty(), 700));
            // final KeyFrame changeVaisse = new KeyFrame(Duration.seconds(0.25), new KeyValue(vaissJ2.imageProperty(), vaissJ2droite2));
            final KeyFrame tirEndY = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.yProperty(), 250));

            final KeyFrame tirStartWidth = new KeyFrame(Duration.ZERO, new KeyValue(tir.fitWidthProperty(), 80));
            final KeyFrame tirEndWidth = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.fitWidthProperty(), 1));

            final Timeline timelineTir = new Timeline(tirStartY, tirStartWidth, tirStartXajust, tirEndY, tirEndWidth, tirEndXajust);

            timelineTir.play();

            ImageView tirF = new ImageView(Path.missil1F);
            tirF.setX(vaissJ2Face.getX() + 30);
            tirF.setY(700);
            tirF.setFitWidth(10);
            tirF.setPreserveRatio(true);
            tirF.setRotate(-2);
            root.getChildren().remove(vaissJ2);
            root.getChildren().remove(vaissJ1);

            root.getChildren().add(tirF);
            root.getChildren().add(vaissJ2);
            root.getChildren().add(vaissJ1);


            PauseTransition delayRemoveTir = new PauseTransition(Duration.seconds(3));
            delayRemoveTir.setOnFinished(event -> {
                root.getChildren().remove(tir);
                root.getChildren().remove(tirF);


            });
            delayRemoveTir.play();


            final KeyFrame tirStartYF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.yProperty(), 320));
            // final KeyFrame changeVaisse = new KeyFrame(Duration.seconds(0.25), new KeyValue(vaissJ2.imageProperty(), vaissJ2droite2));
            final KeyFrame tirEndYF = new KeyFrame(Duration.seconds(4.7), new KeyValue(tirF.yProperty(), 1100));

            final KeyFrame tirStartXajustF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.xProperty(), vaissJ2Face.getX() + 30));
            final KeyFrame tirEndXajustF = new KeyFrame(Duration.seconds(4), new KeyValue(tirF.xProperty(), vaissJ2Face.getX() + 10));

            final KeyFrame tirStartWidthF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.fitWidthProperty(), 1));
            final KeyFrame tirEndWidthF = new KeyFrame(Duration.seconds(4), new KeyValue(tirF.fitWidthProperty(), 25));

            final Timeline timelineTirF = new Timeline(tirStartYF, tirStartWidthF, tirStartXajustF, tirEndYF, tirEndWidthF, tirEndXajustF);

            timelineTirF.play();

            tirFBound = tirF.getBoundsInParent();

            delayExploTouch = new PauseTransition(Duration.seconds(2));
            delayExploTouch.setOnFinished(event -> {

                if (tir.getBoundsInParent().intersects(vaissJ1Face.getBoundsInParent())) {

                    vieintJ1 = vieintJ1 - 30;
                    getVieJ1().setText("Life :" + (vieintJ1));

                    //  if(vieintJ1 <=0){
                    ImageView explosFinale = new ImageView(Path.exploFinale);
                    explosFinale.setX(vaissJ1.getX() + 50);
                    explosFinale.setY(650);
                    explosFinale.setFitWidth(250);
                    explosFinale.setPreserveRatio(true);
                    explosFinale.setOpacity(0.6);
                    root.getChildren().add(explosFinale);
                    //   }


                    ImageView toucheExplos = new ImageView(Path.toucheExplo1);
                    toucheExplos.setX(vaissJ1.getX() + 40);
                    toucheExplos.setY(570);
                    toucheExplos.setFitWidth(300);
                    toucheExplos.setPreserveRatio(true);
                    toucheExplos.setOpacity(0.7);


                    ImageView toucheExplosF = new ImageView(Path.toucheExploBleu1);
                    toucheExplosF.setX(vaissJ1Face.getX() + 10);
                    toucheExplosF.setY(300);
                    toucheExplosF.setFitWidth(40);
                    toucheExplosF.setPreserveRatio(true);
                    toucheExplosF.setOpacity(0.6);


                    //root.getChildren().remove(vaissJ2);
                    root.getChildren().add(toucheExplosF);
                    root.getChildren().add(toucheExplos);
                    //root.getChildren().add(vaissJ2);
                    //game over
                    root.getChildren().remove(tir);
                    root.getChildren().remove(tirF);

                    PauseTransition delayExplodispar = new PauseTransition(Duration.seconds(0.8));
                    delayExplodispar.setOnFinished(event2 -> {

                        root.getChildren().remove(toucheExplos);
                        root.getChildren().remove(toucheExplosF);

                    });
                    delayExplodispar.play();


                }
            });
            delayExploTouch.play();
        } else if (puissanceTir == 2 && cote == 1) {

            ImageView tir = new ImageView(Path.laserBleu1Back);
            tir.setX(vaissJ2.getX() + 130);
            tir.setY(700);
            tir.setFitWidth(80);
            tir.setPreserveRatio(true);
            root.getChildren().remove(vaissJ2);
            root.getChildren().add(tir);
            root.getChildren().add(vaissJ2);

            final KeyFrame tirStartXajust;
            final KeyFrame tirEndXajust;

            if (vaissJ2.getX() < 700) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 200));
                tir.setRotate(6);
            } else if (vaissJ2.getX() < 850) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 190));
                tir.setRotate(4);
            } else if (vaissJ2.getX() > 1050) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 70));
                tir.setRotate(-5);

            } else if (vaissJ2.getX() > 1200) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 60));
                tir.setRotate(-7);
            } else {

                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 140));
                tir.setRotate(0);

            }

            final KeyFrame tirStartY = new KeyFrame(Duration.ZERO, new KeyValue(tir.yProperty(), 700));
            // final KeyFrame changeVaisse = new KeyFrame(Duration.seconds(0.25), new KeyValue(vaissJ2.imageProperty(), vaissJ2droite2));
            final KeyFrame tirEndY = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.yProperty(), 250));

            final KeyFrame tirStartWidth = new KeyFrame(Duration.ZERO, new KeyValue(tir.fitWidthProperty(), 80));
            final KeyFrame tirEndWidth = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.fitWidthProperty(), 1));

            final Timeline timelineTir = new Timeline(tirStartY, tirStartWidth, tirStartXajust, tirEndY, tirEndWidth, tirEndXajust);

            timelineTir.play();

            ImageView tirF = new ImageView(Path.missil1F);
            tirF.setX(vaissJ2Face.getX() + 30);
            tirF.setY(700);
            tirF.setFitWidth(10);
            tirF.setPreserveRatio(true);
            tirF.setRotate(-2);
            root.getChildren().remove(vaissJ2);
            root.getChildren().remove(vaissJ1);

            root.getChildren().add(tirF);
            root.getChildren().add(vaissJ2);
            root.getChildren().add(vaissJ1);


            PauseTransition delayRemoveTir = new PauseTransition(Duration.seconds(3));
            delayRemoveTir.setOnFinished(event -> {
                root.getChildren().remove(tir);
                root.getChildren().remove(tirF);


            });
            delayRemoveTir.play();


            final KeyFrame tirStartYF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.yProperty(), 320));
            // final KeyFrame changeVaisse = new KeyFrame(Duration.seconds(0.25), new KeyValue(vaissJ2.imageProperty(), vaissJ2droite2));
            final KeyFrame tirEndYF = new KeyFrame(Duration.seconds(4.7), new KeyValue(tirF.yProperty(), 1100));

            final KeyFrame tirStartXajustF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.xProperty(), vaissJ2Face.getX() + 30));
            final KeyFrame tirEndXajustF = new KeyFrame(Duration.seconds(4), new KeyValue(tirF.xProperty(), vaissJ2Face.getX() + 10));

            final KeyFrame tirStartWidthF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.fitWidthProperty(), 1));
            final KeyFrame tirEndWidthF = new KeyFrame(Duration.seconds(4), new KeyValue(tirF.fitWidthProperty(), 25));

            final Timeline timelineTirF = new Timeline(tirStartYF, tirStartWidthF, tirStartXajustF, tirEndYF, tirEndWidthF, tirEndXajustF);

            timelineTirF.play();

            tirFBound = tirF.getBoundsInParent();

            delayExploTouch = new PauseTransition(Duration.seconds(2));
            delayExploTouch.setOnFinished(event -> {

                if (tir.getBoundsInParent().intersects(vaissJ1Face.getBoundsInParent())) {

                    vieintJ1 = vieintJ1 - 30;
                    getVieJ1().setText("Life :" + (vieintJ1));

                    //  if(vieintJ1 <=0){
                    ImageView explosFinale = new ImageView(Path.exploFinale);
                    explosFinale.setX(vaissJ1.getX() + 50);
                    explosFinale.setY(650);
                    explosFinale.setFitWidth(250);
                    explosFinale.setPreserveRatio(true);
                    explosFinale.setOpacity(0.6);
                    root.getChildren().add(explosFinale);
                    //   }


                    ImageView toucheExplos = new ImageView(Path.toucheExplo1);
                    toucheExplos.setX(vaissJ1.getX() + 40);
                    toucheExplos.setY(570);
                    toucheExplos.setFitWidth(300);
                    toucheExplos.setPreserveRatio(true);
                    toucheExplos.setOpacity(0.7);


                    ImageView toucheExplosF = new ImageView(Path.toucheExploBleu1);
                    toucheExplosF.setX(vaissJ1Face.getX() + 10);
                    toucheExplosF.setY(300);
                    toucheExplosF.setFitWidth(40);
                    toucheExplosF.setPreserveRatio(true);
                    toucheExplosF.setOpacity(0.6);


                    //root.getChildren().remove(vaissJ2);
                    root.getChildren().add(toucheExplosF);
                    root.getChildren().add(toucheExplos);
                    //root.getChildren().add(vaissJ2);
                    //game over
                    root.getChildren().remove(tir);
                    root.getChildren().remove(tirF);

                    PauseTransition delayExplodispar = new PauseTransition(Duration.seconds(0.8));
                    delayExplodispar.setOnFinished(event2 -> {

                        root.getChildren().remove(toucheExplos);
                        root.getChildren().remove(toucheExplosF);

                    });
                    delayExplodispar.play();


                }
            });
            delayExploTouch.play();


        }
    }

    public void retourNormalBackJ1() {
        Image vaissJ1normal = new Image(Path.vaissJ1Back);
        vaissJ1.setImage(vaissJ1normal);

    }
}

