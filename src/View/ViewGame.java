package View;

import Controller.ControllerJeux;
import Model.*;
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
import java.util.Objects;

public class ViewGame {


    private MediaPlayer videoBackground;
    private Group root;
    private Menu model;
    private MediaView viewer;
    private ImageView barreCentrale;
    private int vieJ1;
    private int vieJ2;
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
    private VGeocroiseur vaissJ1geo;
    private VCorvette vaissJ1Corv;
    private VR22 vaissJ1R22;
    private VGeocroiseur vaissJ2geo;
    private VCorvette vaissJ2Corv;
    private VR22 vaissJ2R22;
    private VFaucon vaissJ2Faucon;
    private VFaucon vaissJ1Faucon;
    private Object vaissJ2Obj;
    private Object vaissJ1Obj;
    private ImageView vaissJ1F;
    private VGeocroiseur vaissJ2geoF;
    private VCorvette vaissJ2CorvF;
    private VFaucon vaissJ2FauconF;
    private VGeocroiseur vaissJ1geoF;
    private VCorvette vaissJ1CorvF;
    private VR22 vaissJ1R22F;
    private VFaucon vaissJ1FauconF;
    private ImageView vaissJ2F;
    private Image imageVaiss;

    public void setIndiVaissJ1(int indiVaissJ1) {
        this.indiVaissJ1 = indiVaissJ1;
    }

    public void setIndiVaissJ2(int indiVaissJ2) {
        this.indiVaissJ2 = indiVaissJ2;
    }

    private VR22 vaissJ2R22F;
    private VFaucon vaissJ2ObjF;
    private Text vieJ1Text;
    private Text vieJ2Text;

    public int getIndiVaissJ1() {
        return indiVaissJ1;
    }

    public int getIndiVaissJ2() {
        return indiVaissJ2;
    }

    public Group getRoot() {
        return root;
    }

    public Object getVaissJ2Obj() {
        return vaissJ2Obj;
    }

    public Object getVaissJ1Obj() {
        return vaissJ1Obj;
    }

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


    }

    public void initBarreCentrale() {
        barreCentrale = new ImageView(Path.barreCentrale);
        barreCentrale.setX(700);
        barreCentrale.setY(0);
        barreCentrale.setFitHeight(1000);
        barreCentrale.setOpacity(0.5);
    }

    public void initTextVieJ1() {
        vieJ1Text = new Text(50, 30, "Life :" + vieJ1);
        vieJ1Text.setFont(Font.font("Dead Kansas", FontWeight.SEMI_BOLD, 25));
        vieJ1Text.setFill(Color.WHITE);
        vieJ1Text.setOpacity(0);
    }

    public void initTextVieJ2() {
        vieJ2Text = new Text(1300, 30, "Life :" + vieJ2);
        vieJ2Text.setFont(Font.font("Dead Kansas", FontWeight.SEMI_BOLD, 25));
        vieJ2Text.setFill(Color.WHITE);
        vieJ2Text.setOpacity(0);
    }

    public void initVaisseauxJ1() {
        if (indiVaissJ1 == 0) {
            vaissJ1geo = new VGeocroiseur();
            vaissJ1Obj = vaissJ2geo;

            vieJ1 = vaissJ1geo.getLife();
            vaissJ1 = (ImageView) vaissJ1geo.getTabImageVaiss().get(3);
        } else if (indiVaissJ1 == 1) {
            vaissJ1Corv = new VCorvette();
            vaissJ1Obj = vaissJ2Corv;

            vieJ1 = vaissJ1Corv.getLife();
            vaissJ1 = (ImageView) vaissJ1Corv.getTabImageVaiss().get(3);
        } else if (indiVaissJ1 == 2) {
            vaissJ1R22 = new VR22();
            vaissJ1Obj = vaissJ2R22;

            vieJ1 = vaissJ1R22.getLife();
            vaissJ1 = (ImageView) vaissJ1R22.getTabImageVaiss().get(3);
        } else if (indiVaissJ1 == 3) {
            vaissJ1Faucon = new VFaucon();
            vaissJ1Obj = vaissJ2Faucon;

            vieJ1 = vaissJ1Faucon.getLife();
            vaissJ1 = (ImageView) vaissJ1Faucon.getTabImageVaiss().get(3);
        }
        vaissJ1.setX(200);
        vaissJ1.setY(700);
        vaissJ1.setFitWidth(300);
        vaissJ1.setPreserveRatio(true);
        vaissJ1.setOpacity(0);
        vaissJ1.setPickOnBounds(false);
    }

    public Object initVaisseauxJ2() {
        if (indiVaissJ2 == 0) {
            vaissJ2geoF = new VGeocroiseur();
            vaissJ2Obj = vaissJ2geo;

            vieJ2 = vaissJ2geoF.getLife();

            vaissJ2 = (ImageView) vaissJ2geoF.getTabImageVaiss().get(3);
        } else if (indiVaissJ2 == 1) {
            vaissJ2CorvF = new VCorvette();
            vaissJ2Obj = vaissJ2Corv;

            vieJ2 = vaissJ2CorvF.getLife();
            vaissJ2 = (ImageView) vaissJ2CorvF.getTabImageVaiss().get(3);
        } else if (indiVaissJ2 == 2) {
            vaissJ2R22F = new VR22();
            vaissJ2Obj = vaissJ2R22;

            vieJ2 = vaissJ2R22F.getLife();
            vaissJ2 = (ImageView) vaissJ2R22F.getTabImageVaiss().get(3);
        } else if (indiVaissJ2 == 3) {
            vaissJ2FauconF = new VFaucon();
            vaissJ2ObjF = vaissJ2Faucon;

            vieJ2 = vaissJ2FauconF.getLife();
            vaissJ2 = (ImageView) vaissJ2FauconF.getTabImageVaiss().get(3);
        }
        vaissJ2.setX(950);
        vaissJ2.setY(700);
        vaissJ2.setFitWidth(300);
        vaissJ2.setPreserveRatio(true);
        vaissJ2.setOpacity(0);
        vaissJ2.setPickOnBounds(false);

        return vaissJ2Obj;
    }


    public void initVaisseauxJ1Face() {

        if (indiVaissJ1 == 0) {
            vaissJ1geoF = new VGeocroiseur();
            vaissJ1Obj = vaissJ1geo;

            vieJ1 = vaissJ1geoF.getLife();

            vaissJ1F = (ImageView) vaissJ1geoF.getTabImageVaiss().get(3);
        } else if (indiVaissJ1 == 1) {
            vaissJ1CorvF = new VCorvette();
            vaissJ1Obj = vaissJ1Corv;

            vieJ1 = vaissJ1Corv.getLife();

            vaissJ1F = (ImageView) vaissJ1CorvF.getTabImageVaiss().get(3);
        } else if (indiVaissJ1 == 2) {
            vaissJ1R22F = new VR22();
            vaissJ1Obj = vaissJ1R22;

            vieJ1 = vaissJ1R22F.getLife();

            vaissJ1F = (ImageView) vaissJ1R22F.getTabImageVaiss().get(3);
        } else if (indiVaissJ1 == 3) {
            vaissJ1FauconF = new VFaucon();
            vaissJ1Obj = vaissJ1Faucon;

            vieJ1 = vaissJ1FauconF.getLife();

            vaissJ1F = (ImageView) vaissJ1FauconF.getTabImageVaiss().get(3);
        }


        vaissJ1F.setX(1050);
        vaissJ1F.setY(300);
        vaissJ1F.setFitWidth(75);
        vaissJ1F.setPreserveRatio(true);
        vaissJ1F.setOpacity(0);
        vaissJ1F.setPickOnBounds(false);

    }

    public void initVaisseauxJ2Face() {


        if (indiVaissJ2 == 0) {
            vaissJ2geoF = new VGeocroiseur();
            vaissJ2Obj = vaissJ2geo;

            vieJ2 = vaissJ2geoF.getLife();

            vaissJ2F = (ImageView) vaissJ2geoF.getTabImageVaiss().get(3);
        } else if (indiVaissJ2 == 1) {
            vaissJ2CorvF = new VCorvette();
            vaissJ2Obj = vaissJ2Corv;

            vieJ2 = vaissJ2Corv.getLife();

            vaissJ2F = (ImageView) vaissJ2CorvF.getTabImageVaiss().get(3);
        } else if (indiVaissJ2 == 2) {
            vaissJ2R22F = new VR22();
            vaissJ2Obj = vaissJ2R22;

            vieJ2 = vaissJ2R22F.getLife();

            vaissJ2F = (ImageView) vaissJ2R22F.getTabImageVaiss().get(3);
        } else if (indiVaissJ2 == 3) {
            vaissJ2FauconF = new VFaucon();
            vaissJ2Obj = vaissJ2Faucon;

            vieJ2 = vaissJ2FauconF.getLife();

            vaissJ2F = (ImageView) vaissJ2FauconF.getTabImageVaiss().get(3);
        }


        vaissJ2F.setX(300);
        vaissJ2F.setY(300);
        vaissJ2F.setFitWidth(75);
        vaissJ2F.setPreserveRatio(true);
        vaissJ2F.setOpacity(0);
        vaissJ2F.setPickOnBounds(false);

    }

    public MediaPlayer getVideoBackground() {
        return videoBackground;
    }

    public Text getVieJ1Text() {
        return vieJ1Text;
    }

    public Text getVieJ2() {
        return vieJ2Text;
    }

    public void initBackground() {
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

    public void setVueCompleteMenu() {

        root.getChildren().clear();
        root.getChildren().add(viewer);

        root.getChildren().add(barreCentrale);

        root.getChildren().add(vieJ1Text);
        root.getChildren().add(vieJ2Text);
        root.getChildren().add(vaissJ1);
        root.getChildren().add(vaissJ2);
        root.getChildren().add(vaissJ1F);
        root.getChildren().add(vaissJ2F);

        final Animation animTextMenuArrivee = new Transition() {
            {
                setCycleDuration(Duration.millis(6000));
            }

            protected void interpolate(double frac) {
                vieJ1Text.setOpacity(frac);
                vieJ2Text.setOpacity(frac);
                vaissJ1.setOpacity(frac);
                vaissJ2.setOpacity(frac);
                vaissJ1F.setOpacity(frac);
                vaissJ2F.setOpacity(frac);
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

    public void j1goRight(double vitesse) {

        if (indiVaissJ1 == 0) {
            vaissJ1geo = new VGeocroiseur();
        } else if (indiVaissJ1 == 1) {
            vaissJ1Corv = new VCorvette();
        } else if (indiVaissJ1 == 2) {
            vaissJ1R22 = new VR22();
        } else if (indiVaissJ2 == 3) {
            vaissJ1Faucon = new VFaucon();
        }

        if (vaissJ1.getX() <= 601) {

            if (vaissJ2.getX() < 150) {

                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJ2geo.getTabImageVaiss().get(6);
                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJ2Corv.getTabImageVaiss().get(6);
                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJ2R22.getTabImageVaiss().get(6);
                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJ2Faucon.getTabImageVaiss().get(6);
                }

                vaissJ1.setImage(imageVaiss);
            } else if (vaissJ1.getX() < 350) {

                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJ2geo.getTabImageVaiss().get(5);
                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJ2Corv.getTabImageVaiss().get(5);
                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJ2R22.getTabImageVaiss().get(5);
                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJ2Faucon.getTabImageVaiss().get(5);
                }

                vaissJ1.setImage(imageVaiss);
            } else {

                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJ2geo.getTabImageVaiss().get(2);
                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJ2Corv.getTabImageVaiss().get(2);
                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJ2R22.getTabImageVaiss().get(2);
                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJ2Faucon.getTabImageVaiss().get(2);
                }

                vaissJ1.setImage(imageVaiss);
            }

            final KeyFrame goLeftStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ1.xProperty(), vaissJ1.getX()));
            final KeyFrame goLeftEnd = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ1.xProperty(), 500));

            final KeyFrame goLeftStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ1Face.xProperty(), vaissJ1Face.getX()));
            final KeyFrame goLeftEndFace = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ1Face.xProperty(), 800));

            timelineGoRightJ1 = new Timeline(goLeftStart, goLeftStartFace, goLeftEnd, goLeftEndFace);
            timelineGoRightJ1.setCycleCount(1);
        }
    }

    public void j1goLeft(double vitesse) {

        if (indiVaissJ2 == 0) {
            vaissJ2geo = new VGeocroiseur();
        } else if (indiVaissJ2 == 1) {
            vaissJ2Corv = new VCorvette();
        } else if (indiVaissJ2 == 2) {
            vaissJ2R22 = new VR22();
        } else if (indiVaissJ2 == 3) {
            vaissJ2Faucon = new VFaucon();
        }

        if (vaissJ1.getX() >= -101) {


                if (indiVaissJ1 == 0) {
                    imageVaiss = (Image) vaissJ2geo.getTabImageVaiss().get(0);
                } else if (indiVaissJ1 == 1) {
                    imageVaiss = (Image) vaissJ2Corv.getTabImageVaiss().get(0);
                } else if (indiVaissJ1 == 2) {
                    imageVaiss = (Image) vaissJ2R22.getTabImageVaiss().get(0);
                } else if (indiVaissJ1 == 3) {
                    imageVaiss = (Image) vaissJ2Faucon.getTabImageVaiss().get(0);
                }

                vaissJ1.setImage(imageVaiss);
            } else if (vaissJ1.getX() > 550) {

                if (indiVaissJ1 == 0) {
                    imageVaiss = (Image) vaissJ2geo.getTabImageVaiss().get(1);
                } else if (indiVaissJ1 == 1) {
                    imageVaiss = (Image) vaissJ2Corv.getTabImageVaiss().get(1);
                } else if (indiVaissJ1 == 2) {
                    imageVaiss = (Image) vaissJ2R22.getTabImageVaiss().get(1);
                } else if (indiVaissJ1 == 3) {
                    imageVaiss = (Image) vaissJ2Faucon.getTabImageVaiss().get(1);
                }

                vaissJ1.setImage(imageVaiss);
            } else {

                if (indiVaissJ1 == 0) {
                    imageVaiss = (Image) vaissJ2geo.getTabImageVaiss().get(2);
                } else if (indiVaissJ1 == 1) {
                    imageVaiss = (Image) vaissJ2Corv.getTabImageVaiss().get(2);
                } else if (indiVaissJ1 == 2) {
                    imageVaiss = (Image) vaissJ2R22.getTabImageVaiss().get(2);
                } else if (indiVaissJ1 == 3) {
                    imageVaiss = (Image) vaissJ2Faucon.getTabImageVaiss().get(2);
                }

                vaissJ1.setImage(imageVaiss);
            }

            final KeyFrame goLeftStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ1.xProperty(), vaissJ1.getX()));
            final KeyFrame goLeftEnd = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ1.xProperty(), -100));

            final KeyFrame goLeftStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ1Face.xProperty(), vaissJ1Face.getX()));
            final KeyFrame goLeftEndFace = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ1Face.xProperty(), 1250));

            timelineGoLeftJ1 = new Timeline(goLeftStart, goLeftStartFace, goLeftEnd, goLeftEndFace);
            timelineGoLeftJ1.setCycleCount(1);
        }


    public void j2goRight(double vitesse) {


        if (indiVaissJ2 == 0) {
            vaissJ2geo = new VGeocroiseur();
        } else if (indiVaissJ2 == 1) {
            vaissJ2Corv = new VCorvette();
        } else if (indiVaissJ2 == 2) {
            vaissJ2R22 = new VR22();
        } else if (indiVaissJ2 == 3) {
            vaissJ2Faucon = new VFaucon();
        }


        if (vaissJ2.getX() <= 1251) {

            if (vaissJ2.getX() < 700) {

                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJ2geo.getTabImageVaiss().get(6);
                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJ2Corv.getTabImageVaiss().get(6);
                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJ2R22.getTabImageVaiss().get(6);
                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJ2Faucon.getTabImageVaiss().get(6);
                }

                vaissJ2.setImage(imageVaiss);
            } else if (vaissJ2.getX() < 850) {
                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJ2geo.getTabImageVaiss().get(5);
                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJ2Corv.getTabImageVaiss().get(5);
                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJ2R22.getTabImageVaiss().get(5);
                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJ2Faucon.getTabImageVaiss().get(5);
                }
                vaissJ2.setImage(imageVaiss);
            } else {
                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJ2geo.getTabImageVaiss().get(2);
                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJ2Corv.getTabImageVaiss().get(2);
                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJ2R22.getTabImageVaiss().get(2);
                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJ2Faucon.getTabImageVaiss().get(2);
                }
                vaissJ2.setImage(imageVaiss);
            }

            final KeyFrame goRightStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2.xProperty(), vaissJ2.getX()));
            final KeyFrame goRightEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(vaissJ2.xProperty(), 1250));

            final KeyFrame goRightStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2Face.xProperty(), vaissJ2Face.getX()));
            final KeyFrame goRightEndFace = new KeyFrame(Duration.seconds(0.5), new KeyValue(vaissJ2Face.xProperty(), 70));

            timelineGoRightJ2 = new Timeline(goRightStart, goRightStartFace, /*changeVaisse,*/ goRightEnd, goRightEndFace);
            timelineGoRightJ2.setCycleCount(1);
        }
    }

    public void j2goLeft(double vitesse) {

        if (indiVaissJ2 == 0) {
            vaissJ2geo = new VGeocroiseur();
        } else if (indiVaissJ2 == 1) {
            vaissJ2Corv = new VCorvette();
        } else if (indiVaissJ2 == 2) {
            vaissJ2R22 = new VR22();
        } else if (indiVaissJ2 == 3) {
            vaissJ2Faucon = new VFaucon();
        }


        if (vaissJ2.getX() >= 601) {


            if (vaissJ2.getX() > 1150) {
                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJ2geo.getTabImageVaiss().get(0);
                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJ2Corv.getTabImageVaiss().get(0);
                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJ2R22.getTabImageVaiss().get(0);
                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJ2Faucon.getTabImageVaiss().get(0);
                }

                vaissJ2.setImage(imageVaiss);

            } else if (vaissJ2.getX() > 1000) {
                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJ2geo.getTabImageVaiss().get(1);
                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJ2Corv.getTabImageVaiss().get(1);
                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJ2R22.getTabImageVaiss().get(1);
                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJ2Faucon.getTabImageVaiss().get(1);
                }

                vaissJ2.setImage(imageVaiss);
            } else {
                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJ2geo.getTabImageVaiss().get(2);
                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJ2Corv.getTabImageVaiss().get(2);
                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJ2R22.getTabImageVaiss().get(2);
                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJ2Faucon.getTabImageVaiss().get(2);
                }

                vaissJ2.setImage(imageVaiss);

            }

            final KeyFrame goLeftStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2.xProperty(), vaissJ2.getX()));
            final KeyFrame goLeftEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(vaissJ2.xProperty(), 600));

            final KeyFrame goLeftStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2Face.xProperty(), vaissJ2Face.getX()));
            final KeyFrame goLeftEndFace = new KeyFrame(Duration.seconds(0.5), new KeyValue(vaissJ2Face.xProperty(), 550));

            timelineGoLeftJ2 = new Timeline(goLeftStart, goLeftStartFace, goLeftEnd, goLeftEndFace);
            timelineGoLeftJ2.setCycleCount(1);

        }
    }

    public void retourNormalBackJ2() {
        Image vaissJ2normal = null;
        if (indiVaissJ2 == 0) {
            vaissJ2geo = new VGeocroiseur();
            vaissJ2normal = (Image) vaissJ2geo.getTabImageVaiss().get(4);
        } else if (indiVaissJ2 == 1) {
            vaissJ2Corv = new VCorvette();
            vaissJ2normal = (Image) vaissJ2geo.getTabImageVaiss().get(4);
        } else if (indiVaissJ2 == 2) {
            vaissJ2R22 = new VR22();
            vaissJ2normal = (Image) vaissJ2geo.getTabImageVaiss().get(4);

        } else if (indiVaissJ2 == 3) {
            vaissJ2Faucon = new VFaucon();
            vaissJ2normal = (Image) vaissJ2geo.getTabImageVaiss().get(4);

        }


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
                    getVieJ1Text().setText("Life :" + (vieintJ1));

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
                    getVieJ1Text().setText("Life :" + (vieintJ1));

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
                    getVieJ1Text().setText("Life :" + (vieintJ1));

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
                    getVieJ1Text().setText("Life :" + (vieintJ1));

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
        Image vaissJ1normal = null;
        if (indiVaissJ1 == 0) {
            vaissJ1geo = new VGeocroiseur();
            vaissJ1normal = (Image) vaissJ1geo.getTabImageVaiss().get(4);
        } else if (indiVaissJ1 == 1) {
            vaissJ1Corv = new VCorvette();
            vaissJ1normal = (Image) vaissJ1geo.getTabImageVaiss().get(4);
        } else if (indiVaissJ1 == 2) {
            vaissJ1R22 = new VR22();
            vaissJ1normal = (Image) vaissJ1geo.getTabImageVaiss().get(4);

        } else if (indiVaissJ1 == 3) {
            vaissJ1Faucon = new VFaucon();
            vaissJ1normal = (Image) vaissJ1geo.getTabImageVaiss().get(4);

        }


        vaissJ1.setImage(vaissJ1normal);

    }
}

