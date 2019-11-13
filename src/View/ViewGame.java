package View;

import Controller.ControllerJeux;
import Model.*;
import Tools.Path;
import javafx.animation.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.effect.Reflection;
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


    private VFaucon vaissJoueur2fauc;
    private VR22 vaissJoueur2r22;
    private VCorvette vaissJoueur2corv;
    private VGeocroiseur vaissJoueur2geo;
    private VCorvette vaissJoueur1corv;
    private VFaucon vaissJoueur1fauc;
    private VR22 vaissJoueur1r22;
    private  VGeocroiseur vaissJoueur1geo;
    private MediaPlayer videoBackground;
    private Group root;
    private Menu model;
    private MediaView viewer;
    private ImageView barreCentrale;
    private int vieJ1;
    private int vieJ2;
    private double positionVaissJ1;
    private Timeline timelineGoLeftJ2 = null;
    private ImageView vaissJ1 = null;
    private ImageView vaissJ2 = null;
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
    private Timeline timelineGoLeftJ1 = null;
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
    private Image vaissJ1ggg;
    private Image vaissJ2ggg;
    private int vieintJ2;
    private int viejoueur2 = 1000;
    private int degatJ2 = 0;
    private int viejoueur1=1000;
    private int degatJ1=0;
    private VR22 vaissJ2R22F;
    private VFaucon vaissJ2ObjF;
    private Text vieJ1Text;
    private Text vieJ2Text;
    private Image vaissJ1face;
    private Image vaissJ2face;
    private Image vaissJ2ggg2;
    private int vieintJ22;
    private Timeline timelineGoRightJ1 = null;
    private boolean fin;
    private Image imageVaissF;
    private boolean tirEnCour1 = true;
    private boolean tirEnCour2 = true;
    private boolean tirEnCour3 = true;
    private boolean tirEnCour4 = true;

    public void setIndiVaissJ1(int indiVaissJ1) {this.indiVaissJ1 = indiVaissJ1; }
    public void setIndiVaissJ2(int indiVaissJ2) { this.indiVaissJ2 = indiVaissJ2;}
    public int getIndiVaissJ1() { return indiVaissJ1; }
    public int getIndiVaissJ2() { return indiVaissJ2; }
    public Group getRoot() {
        return root;
    }
    public Object getVaissJ2Obj() {
        return vaissJ2Obj;
    }
    public Object getVaissJ1Obj() { return vaissJ1Obj; }
    public Timeline getTimelineGoRightJ1() {return timelineGoRightJ1; }
    public Timeline getTimelineGoLeftJ1() {
        return timelineGoLeftJ1;
    }
    public Timeline getTimelineGoLeftJ2() { return timelineGoLeftJ2; }
    public Animation getAnimTextMenuArrivee() {
        return animTextMenuArrivee;
    }
    public Timeline getTimelineGoRightJ2() {
        return timelineGoRightJ2;
    }
    public Text getVieJ1Text() {
        return vieJ1Text;
    }
    public Text getVieJ2() {
        return vieJ2Text;
    }

    /**
     * Constructeur du menu principal
     *
     * @param model (Modèle correspondant au menu)
     * @param root  (Groupe principal de la vue)
     */
    ViewGame(Menu model, Group root, VGeocroiseur geocJ1, VR22 r22J1, VCorvette corvJ1, VFaucon faucJ1, VGeocroiseur geocJ2, VR22 r22J2, VCorvette corvJ2, VFaucon faucJ2) {
        this.root = root;
        this.model = model;

            vaissJoueur1geo = new VGeocroiseur();
            this.vaissJoueur1geo = geocJ1;
            vaissJoueur1corv= new VCorvette();
            this.vaissJoueur1corv = corvJ1;
            vaissJoueur1r22 = new VR22();
            this.vaissJoueur1r22 = r22J1;
            vaissJoueur1fauc = new VFaucon();
            this.vaissJoueur1fauc = faucJ1;

            vaissJoueur2geo = new VGeocroiseur();
            this.vaissJoueur2geo = geocJ2;
            vaissJoueur2corv= new VCorvette();
            this.vaissJoueur2corv = corvJ2;
            vaissJoueur2r22 = new VR22();
            this.vaissJoueur2r22 = r22J2;
            vaissJoueur2fauc = new VFaucon();
            this.vaissJoueur2fauc = faucJ2;

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
            vieJ1 = vaissJoueur1geo.getLife();
            vaissJ1ggg = (Image) vaissJoueur1geo.getTabImageVaissBack().get(3);
            vaissJ1 = new ImageView();

            vaissJ1.setImage(vaissJ1ggg);
        } else if (indiVaissJ1 == 1) {
            vieJ1 = vaissJoueur1corv.getLife();

            vaissJ1ggg = (Image) vaissJoueur1corv.getTabImageVaissBack().get(3);
            vaissJ1 = new ImageView();

            vaissJ1.setImage(vaissJ1ggg);
        } else if (indiVaissJ1 == 2) {
            vieJ1 = vaissJoueur1r22.getLife();
            vaissJ1ggg = (Image) vaissJoueur1r22.getTabImageVaissBack().get(3);
            vaissJ1 = new ImageView();

            vaissJ1.setImage(vaissJ1ggg);
        } else if (indiVaissJ1 == 3) {
            vieJ1 = vaissJoueur1fauc.getLife();
            vaissJ1ggg = (Image) vaissJoueur1fauc.getTabImageVaissBack().get(3);
            vaissJ1 = new ImageView();
            vaissJ1.setImage(vaissJ1ggg);
        }
        vaissJ1.setX(200);
        vaissJ1.setY(700);
        vaissJ1.setFitWidth(300);
        vaissJ1.setPreserveRatio(true);
        vaissJ1.setOpacity(0);
        vaissJ1.setPickOnBounds(false);
    }

    public void initVaisseauxJ2() {
        if (indiVaissJ2 == 0) {
            vieJ2 = vaissJoueur2geo.getLife();

            vaissJ2ggg2 = (Image) vaissJoueur2geo.getTabImageVaissBack().get(3);
            vaissJ2 = new ImageView();

            vaissJ2.setImage(vaissJ2ggg2);
        } else if (indiVaissJ2 == 1) {
            vieJ2 = vaissJoueur2corv.getLife();

            vaissJ2ggg2 = (Image) vaissJoueur2corv.getTabImageVaissBack().get(3);
            vaissJ2 = new ImageView();

            vaissJ2.setImage(vaissJ2ggg2);
        } else if (indiVaissJ2 == 2) {
            vieJ2 = vaissJoueur2r22.getLife();

            vaissJ2ggg2 = (Image) vaissJoueur2r22.getTabImageVaissBack().get(3);
            vaissJ2 = new ImageView();

            vaissJ2.setImage(vaissJ2ggg2);
        } else if (indiVaissJ2 == 3) {
            vieJ2 = vaissJoueur2fauc.getLife();

            vaissJ2ggg2 = (Image) vaissJoueur2fauc.getTabImageVaissBack().get(3);
            vaissJ2 = new ImageView();

            vaissJ2.setImage(vaissJ2ggg2);
        }
        vaissJ2.setX(950);
        vaissJ2.setY(700);
        vaissJ2.setFitWidth(300);
        vaissJ2.setPreserveRatio(true);
        vaissJ2.setOpacity(0);
        vaissJ2.setPickOnBounds(false);

        // return vaissJ2Obj;
    }

    public void initVaisseauxJ1Face() {

        if (indiVaissJ1 == 0) {

            vaissJ1face = (Image) vaissJoueur1geo.getTabImageVaissFace().get(3);
            vaissJ1F = new ImageView();

            vaissJ1F.setImage(vaissJ1face);

        } else if (indiVaissJ1 == 1) {

            vaissJ1face = (Image) vaissJoueur1corv.getTabImageVaissFace().get(3);
            vaissJ1F = new ImageView();

            vaissJ1F.setImage(vaissJ1face);

        } else if (indiVaissJ1 == 2) {
            vaissJ1face = (Image) vaissJoueur1r22.getTabImageVaissFace().get(3);
            vaissJ1F = new ImageView();

            vaissJ1F.setImage(vaissJ1face);
        } else if (indiVaissJ1 == 3) {
            vaissJ1face = (Image) vaissJoueur1fauc.getTabImageVaissFace().get(3);
            vaissJ1F = new ImageView();

            vaissJ1F.setImage(vaissJ1face);
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

            vaissJ2face = (Image) vaissJoueur2geo.getTabImageVaissFace().get(3);
            vaissJ2F = new ImageView();

            vaissJ2F.setImage(vaissJ2face);

        } else if (indiVaissJ2 == 1) {

            vaissJ2face = (Image) vaissJoueur2corv.getTabImageVaissFace().get(3);
            vaissJ2F = new ImageView();

            vaissJ2F.setImage(vaissJ2face);


        } else if (indiVaissJ2 == 2) {
            vaissJ2face = (Image) vaissJoueur2r22.getTabImageVaissFace().get(3);
            vaissJ2F = new ImageView();

            vaissJ2F.setImage(vaissJ2face);

        } else if (indiVaissJ2 == 3) {
            vaissJ2face = (Image) vaissJoueur2fauc.getTabImageVaissFace().get(3);

            vaissJ2F = new ImageView();

            vaissJ2F.setImage(vaissJ2face);

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

<<<<<<< HEAD

    public void j1goRight(double vitesse) {



        if (vaissJ1.getX() <= 601) {

            if (vaissJ1.getX() < 50) {
                if (indiVaissJ1 == 0) {
                    imageVaiss = (Image) vaissJoueur1geo.getTabImageVaissBack().get(6);
                } else if (indiVaissJ1 == 1) {
                    imageVaiss = (Image) vaissJoueur1corv.getTabImageVaissBack().get(6);
                } else if (indiVaissJ1 == 2) {
                    imageVaiss = (Image) vaissJoueur1r22.getTabImageVaissBack().get(6);
                } else if (indiVaissJ1 == 3) {
                    imageVaiss = (Image) vaissJoueur1fauc.getTabImageVaissBack().get(6);
                }

                vaissJ1.setImage(imageVaiss);
            } else if (vaissJ1.getX() < 150) {
                if (indiVaissJ1 == 0) {
                    imageVaiss = (Image) vaissJoueur1geo.getTabImageVaissBack().get(5);
                } else if (indiVaissJ1 == 1) {
                    imageVaiss = (Image) vaissJoueur1corv.getTabImageVaissBack().get(5);
                } else if (indiVaissJ1 == 2) {
                    imageVaiss = (Image) vaissJoueur1r22.getTabImageVaissBack().get(5);
                } else if (indiVaissJ1 == 3) {
                    imageVaiss = (Image) vaissJoueur1fauc.getTabImageVaissBack().get(5);
                }

                vaissJ1.setImage(imageVaiss);
            } else {

                if (indiVaissJ1 == 0) {
                    imageVaiss = (Image) vaissJoueur2geo.getTabImageVaissBack().get(4);
                } else if (indiVaissJ1 == 1) {
                    imageVaiss = (Image) vaissJoueur2corv.getTabImageVaissBack().get(4);
                } else if (indiVaissJ1 == 2) {
                    imageVaiss = (Image) vaissJoueur2r22.getTabImageVaissBack().get(4);
                } else if (indiVaissJ1 == 3) {
                    imageVaiss = (Image) vaissJoueur2fauc.getTabImageVaissBack().get(4);
                }

                vaissJ1.setImage(imageVaiss);
            }

            if (vaissJ1F.getX() > 1200) {
                if (indiVaissJ1 == 0) {
                    imageVaissF = (Image) vaissJoueur1geo.getTabImageVaissFace().get(6);
                } else if (indiVaissJ1 == 1) {
                    imageVaissF = (Image) vaissJoueur1corv.getTabImageVaissFace().get(6);
                } else if (indiVaissJ1 == 2) {
                    imageVaissF = (Image) vaissJoueur1r22.getTabImageVaissFace().get(6);
                } else if (indiVaissJ1 == 3) {
                    imageVaissF = (Image) vaissJoueur1fauc.getTabImageVaissFace().get(6);
                }
                vaissJ1F.setImage(imageVaissF);
            } else if (vaissJ1F.getX() > 1000) {
                if (indiVaissJ1 == 0) {
                    imageVaissF = (Image) vaissJoueur1geo.getTabImageVaissFace().get(5);
                } else if (indiVaissJ1 == 1) {
                    imageVaissF = (Image) vaissJoueur1corv.getTabImageVaissFace().get(5);
                } else if (indiVaissJ1 == 2) {
                    imageVaissF = (Image) vaissJoueur1r22.getTabImageVaissFace().get(5);
                } else if (indiVaissJ1 == 3) {
                    imageVaissF = (Image) vaissJoueur1fauc.getTabImageVaissFace().get(5);
                }
                vaissJ2F.setImage(imageVaissF);

            } else {
                if (indiVaissJ2 == 0) {
                    imageVaissF = (Image) vaissJoueur2geo.getTabImageVaissFace().get(4);
                } else if (indiVaissJ2 == 1) {
                    imageVaissF = (Image) vaissJoueur2corv.getTabImageVaissFace().get(4);
                } else if (indiVaissJ2 == 2) {
                    imageVaissF = (Image) vaissJoueur2r22.getTabImageVaissFace().get(4);
                } else if (indiVaissJ2 == 3) {
                    imageVaissF = (Image) vaissJoueur2fauc.getTabImageVaissFace().get(4);
                }
                vaissJ2F.setImage(imageVaissF);

            final KeyFrame goLeftStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ1.xProperty(), vaissJ1.getX()));
            final KeyFrame goLeftEnd = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ1.xProperty(), 500, Interpolator.LINEAR));

            final KeyFrame goLeftStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ1F.xProperty(), vaissJ1F.getX()));
            final KeyFrame goLeftEndFace = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ1F.xProperty(), 800, Interpolator.LINEAR));

            timelineGoRightJ1 = new Timeline(goLeftStart, goLeftStartFace, goLeftEnd, goLeftEndFace);

            timelineGoRightJ1.setCycleCount(1);
        }
    }
}

    public void j1goLeft(double vitesse) {

         if (vaissJ1.getX() >= 400) {


             if (indiVaissJ1 == 0) {
                 imageVaiss = (Image) vaissJoueur1geo.getTabImageVaissBack().get(0);
             } else if (indiVaissJ1 == 1) {
                 imageVaiss = (Image) vaissJoueur1corv.getTabImageVaissBack().get(0);
             } else if (indiVaissJ1 == 2) {
                 imageVaiss = (Image) vaissJoueur1r22.getTabImageVaissBack().get(0);
             } else if (indiVaissJ1 == 3) {
                 imageVaiss = (Image) vaissJoueur1fauc.getTabImageVaissBack().get(0);
             }

            vaissJ1.setImage(imageVaiss);
        } else if (vaissJ1.getX() > 300) {

             if (indiVaissJ1 == 0) {
                 imageVaiss = (Image) vaissJoueur1geo.getTabImageVaissBack().get(1);
             } else if (indiVaissJ1 == 1) {
                 imageVaiss = (Image) vaissJoueur1corv.getTabImageVaissBack().get(1);
             } else if (indiVaissJ1 == 2) {
                 imageVaiss = (Image) vaissJoueur1r22.getTabImageVaissBack().get(1);
             } else if (indiVaissJ1 == 3) {
                 imageVaiss = (Image) vaissJoueur1fauc.getTabImageVaissBack().get(1);
             }

            vaissJ1.setImage(imageVaiss);
        } else {

             if (indiVaissJ1 == 0) {
                 imageVaiss = (Image) vaissJoueur1geo.getTabImageVaissBack().get(2);
             } else if (indiVaissJ1 == 1) {
                 imageVaiss = (Image) vaissJoueur1corv.getTabImageVaissBack().get(2);
             } else if (indiVaissJ1 == 2) {
                 imageVaiss = (Image) vaissJoueur1r22.getTabImageVaissBack().get(2);
             } else if (indiVaissJ1 == 3) {
                 imageVaiss = (Image) vaissJoueur1fauc.getTabImageVaissBack().get(2);
             }

            vaissJ1.setImage(imageVaiss);
        }

        if (vaissJ1F.getX() < 1200) {
            if (indiVaissJ1 == 0) {
                imageVaissF = (Image) vaissJoueur1geo.getTabImageVaissFace().get(6);
            } else if (indiVaissJ1 == 1) {
                imageVaissF = (Image) vaissJoueur1corv.getTabImageVaissFace().get(6);
            } else if (indiVaissJ1 == 2) {
                imageVaissF = (Image) vaissJoueur1r22.getTabImageVaissFace().get(6);
            } else if (indiVaissJ1 == 3) {
                imageVaissF = (Image) vaissJoueur1fauc.getTabImageVaissFace().get(6);
            }
            vaissJ1F.setImage(imageVaissF);
        } else if (vaissJ1F.getX() < 1000) {
            if (indiVaissJ1 == 0) {
                imageVaissF = (Image) vaissJoueur1geo.getTabImageVaissFace().get(5);
            } else if (indiVaissJ1 == 1) {
                imageVaissF = (Image) vaissJoueur1corv.getTabImageVaissFace().get(5);
            } else if (indiVaissJ1 == 2) {
                imageVaissF = (Image) vaissJoueur1r22.getTabImageVaissFace().get(5);
            } else if (indiVaissJ1 == 3) {
                imageVaissF = (Image) vaissJoueur1fauc.getTabImageVaissFace().get(5);
            }
            vaissJ2F.setImage(imageVaissF);

        } else {
            if (indiVaissJ2 == 0) {
                imageVaissF = (Image) vaissJoueur2geo.getTabImageVaissFace().get(4);
            } else if (indiVaissJ2 == 1) {
                imageVaissF = (Image) vaissJoueur2corv.getTabImageVaissFace().get(4);
            } else if (indiVaissJ2 == 2) {
                imageVaissF = (Image) vaissJoueur2r22.getTabImageVaissFace().get(4);
            } else if (indiVaissJ2 == 3) {
                imageVaissF = (Image) vaissJoueur2fauc.getTabImageVaissFace().get(4);
            }
            vaissJ2F.setImage(imageVaissF);

        }


        final KeyFrame goLeftStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ1.xProperty(), vaissJ1.getX()));
        final KeyFrame goLeftEnd = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ1.xProperty(), -100, Interpolator.LINEAR));

        final KeyFrame goLeftStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ1F.xProperty(), vaissJ1F.getX()));
        final KeyFrame goLeftEndFace = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ1F.xProperty(), 1250, Interpolator.LINEAR));

        timelineGoLeftJ1 = new Timeline(goLeftStart, goLeftStartFace, goLeftEnd, goLeftEndFace);
        timelineGoLeftJ1.setCycleCount(1);
    }

    public void j2goRight(double vitesse) {


        if (vaissJ2.getX() <= 1251) {

            if (vaissJ2.getX() < 700) {

                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJoueur2geo.getTabImageVaissBack().get(6);
                    imageVaissF = (Image) vaissJoueur2geo.getTabImageVaissFace().get(6);
                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJoueur2corv.getTabImageVaissBack().get(6);
                    imageVaissF = (Image) vaissJoueur2corv.getTabImageVaissFace().get(6);

                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJoueur2r22.getTabImageVaissBack().get(6);
                    imageVaissF = (Image) vaissJoueur2r22.getTabImageVaissFace().get(6);

                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJoueur2fauc.getTabImageVaissBack().get(6);
                    imageVaissF = (Image) vaissJoueur2fauc.getTabImageVaissFace().get(6);
                }


                vaissJ2.setImage(imageVaiss);
                vaissJ2F.setImage(imageVaissF);

            } else if (vaissJ2.getX() < 850) {
                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJoueur2geo.getTabImageVaissBack().get(5);
                    imageVaissF = (Image) vaissJoueur2geo.getTabImageVaissFace().get(5);

                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJoueur2corv.getTabImageVaissBack().get(5);
                    imageVaissF = (Image) vaissJoueur2corv.getTabImageVaissFace().get(5);

                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJoueur2r22.getTabImageVaissBack().get(5);
                    imageVaissF = (Image) vaissJoueur2r22.getTabImageVaissFace().get(5);

                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJoueur2fauc.getTabImageVaissBack().get(5);
                    imageVaissF = (Image) vaissJoueur2fauc.getTabImageVaissFace().get(5);

                }
                vaissJ2.setImage(imageVaiss);
                vaissJ2F.setImage(imageVaissF);

            } else {
                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJoueur2geo.getTabImageVaissBack().get(4);
                    imageVaissF = (Image) vaissJoueur2r22.getTabImageVaissFace().get(4);

                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJoueur2corv.getTabImageVaissBack().get(4);
                    imageVaissF = (Image) vaissJoueur2r22.getTabImageVaissFace().get(4);

                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJoueur2r22.getTabImageVaissBack().get(4);
                    imageVaissF = (Image) vaissJoueur2r22.getTabImageVaissFace().get(4);

                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJoueur2fauc.getTabImageVaissBack().get(4);
                    imageVaissF = (Image) vaissJoueur2fauc.getTabImageVaissFace().get(4);

                }
                vaissJ2.setImage(imageVaiss);
                vaissJ2F.setImage(imageVaissF);

            }

            final KeyFrame goRightStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2.xProperty(), vaissJ2.getX()));
            final KeyFrame goRightEnd = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ2.xProperty(), 1250, Interpolator.LINEAR));

            final KeyFrame goRightStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2F.xProperty(), vaissJ2F.getX()));
            final KeyFrame goRightEndFace = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ2F.xProperty(), 70, Interpolator.LINEAR));

            timelineGoRightJ2 = new Timeline(goRightStart, goRightStartFace, /*changeVaisse,*/ goRightEnd, goRightEndFace);
            timelineGoRightJ2.setCycleCount(1);
        }
    }

    public void j2goLeft(double vitesse) {


            if (vaissJ2.getX() >= 601) {

            if (vaissJ2.getX() > 1200) {
                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJoueur2geo.getTabImageVaissBack().get(0);

                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJoueur2corv.getTabImageVaissBack().get(0);

                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJoueur2r22.getTabImageVaissBack().get(0);

                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJoueur2fauc.getTabImageVaissBack().get(0);

                }

                vaissJ2.setImage(imageVaiss);

            } else if (vaissJ2.getX() > 1000) {
                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJoueur2geo.getTabImageVaissBack().get(1);

                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJoueur2corv.getTabImageVaissBack().get(1);

                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJoueur2r22.getTabImageVaissBack().get(1);

                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJoueur2fauc.getTabImageVaissBack().get(1);

                }

                vaissJ2.setImage(imageVaiss);

            } else {
                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJoueur2geo.getTabImageVaissBack().get(2);

                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJoueur2corv.getTabImageVaissBack().get(2);

                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJoueur2r22.getTabImageVaissBack().get(2);

                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJoueur2fauc.getTabImageVaissBack().get(2);

                }
                vaissJ2.setImage(imageVaiss);
            }


                if (vaissJ2F.getX() < 50) {
                    if (indiVaissJ2 == 0) {
                        imageVaissF = (Image) vaissJoueur2geo.getTabImageVaissFace().get(6);
                    } else if (indiVaissJ2 == 1) {
                        imageVaissF = (Image) vaissJoueur2corv.getTabImageVaissFace().get(6);
                    } else if (indiVaissJ2 == 2) {
                        imageVaissF = (Image) vaissJoueur2r22.getTabImageVaissFace().get(6);
                    } else if (indiVaissJ2 == 3) {
                        imageVaissF = (Image) vaissJoueur2fauc.getTabImageVaissFace().get(6);
                    }
                    vaissJ2F.setImage(imageVaissF);
                } else if (vaissJ2F.getX() < 150) {
                    if (indiVaissJ2 == 0) {
                        imageVaissF = (Image) vaissJoueur2geo.getTabImageVaissFace().get(5);
                    } else if (indiVaissJ2 == 1) {
                        imageVaissF = (Image) vaissJoueur2corv.getTabImageVaissFace().get(5);
                    } else if (indiVaissJ2 == 2) {
                        imageVaissF = (Image) vaissJoueur2r22.getTabImageVaissFace().get(5);
                    } else if (indiVaissJ2 == 3) {
                        imageVaissF = (Image) vaissJoueur2fauc.getTabImageVaissFace().get(5);
                    }
                    vaissJ2F.setImage(imageVaissF);
                } else {
                    if (indiVaissJ2 == 0) {
                        imageVaissF = (Image) vaissJoueur2geo.getTabImageVaissFace().get(4);
                    } else if (indiVaissJ2 == 1) {
                        imageVaissF = (Image) vaissJoueur2corv.getTabImageVaissFace().get(4);
                    } else if (indiVaissJ2 == 2) {
                        imageVaissF = (Image) vaissJoueur2r22.getTabImageVaissFace().get(4);
                    } else if (indiVaissJ2 == 3) {
                        imageVaissF = (Image) vaissJoueur2fauc.getTabImageVaissFace().get(4);
                    }
                    vaissJ2F.setImage(imageVaissF);

                }

            final KeyFrame goLeftStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2.xProperty(), vaissJ2.getX()));
            final KeyFrame goLeftEnd = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ2.xProperty(), 600, Interpolator.LINEAR));

            final KeyFrame goLeftStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2F.xProperty(), vaissJ2F.getX()));
            final KeyFrame goLeftEndFace = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ2F.xProperty(), 550, Interpolator.LINEAR));

            timelineGoLeftJ2 = new Timeline(goLeftStart, goLeftStartFace, goLeftEnd, goLeftEndFace);
            timelineGoLeftJ2.setCycleCount(1);

        }
    }
    public void retourNormalBackJ2() {
        Image vaissJ2normal = null;
        if (indiVaissJ2 == 0) {
            vaissJ2normal = (Image) vaissJoueur2geo.getTabImageVaissBack().get(3);
        } else if (indiVaissJ2 == 1) {
            vaissJ2normal = (Image) vaissJoueur2corv.getTabImageVaissBack().get(3);
        } else if (indiVaissJ2 == 2) {
            vaissJ2normal = (Image) vaissJoueur2r22.getTabImageVaissBack().get(3);

        } else if (indiVaissJ2 == 3) {
            vaissJ2normal = (Image) vaissJoueur2fauc.getTabImageVaissBack().get(3);
        }

        vaissJ2.setImage(vaissJ2normal);
    }

    public void retourNormalFrontJ2() {
        Image vaissJ2Fnormal = null;
        if (indiVaissJ2 == 0) {
            vaissJ2Fnormal = (Image) vaissJoueur2geo.getTabImageVaissFace().get(3);
        } else if (indiVaissJ2 == 1) {
            vaissJ2Fnormal = (Image) vaissJoueur2corv.getTabImageVaissFace().get(3);
        } else if (indiVaissJ2 == 2) {
            vaissJ2Fnormal = (Image) vaissJoueur2r22.getTabImageVaissFace().get(3);

        } else if (indiVaissJ2 == 3) {
            vaissJ2Fnormal = (Image) vaissJoueur2fauc.getTabImageVaissFace().get(3);
        }

        vaissJ2F.setImage(vaissJ2Fnormal);
    }


    public int getViejoueur2() {
        return viejoueur2;
    }

    public int getViejoueur1() {
        return viejoueur1;
    }

=======
>>>>>>> origin/nouvelleTentative
    public void tir(int vieVaiss, int puissanceTir, int cote) {

        if (puissanceTir == 1 && cote == 2) {
            if(tirEnCour1 == true){
            tirEnCour1 = false;
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
                tirEndXajust = new KeyFrame(Duration.seconds(1), new KeyValue(tir.xProperty(), vaissJ2.getX() + 200));
                tir.setRotate(6);
            } else if (vaissJ2.getX() < 850) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(1), new KeyValue(tir.xProperty(), vaissJ2.getX() + 190));
                tir.setRotate(4);
            } else if (vaissJ2.getX() > 1050) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(1), new KeyValue(tir.xProperty(), vaissJ2.getX() + 70));
                tir.setRotate(-5);

            } else if (vaissJ2.getX() > 1200) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(1), new KeyValue(tir.xProperty(), vaissJ2.getX() + 60));
                tir.setRotate(-7);
            } else {

                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 105));
                tirEndXajust = new KeyFrame(Duration.seconds(1), new KeyValue(tir.xProperty(), vaissJ2.getX() + 140));
                tir.setRotate(0);

            }

            final KeyFrame tirStartY = new KeyFrame(Duration.ZERO, new KeyValue(tir.yProperty(), 700));
            final KeyFrame tirEndY = new KeyFrame(Duration.seconds(1), new KeyValue(tir.yProperty(), 250));

            final KeyFrame tirStartWidth = new KeyFrame(Duration.ZERO, new KeyValue(tir.fitWidthProperty(), 80));
            final KeyFrame tirEndWidth = new KeyFrame(Duration.seconds(1), new KeyValue(tir.fitWidthProperty(), 1));

            final Timeline timelineTir = new Timeline(tirStartY, tirStartWidth, tirStartXajust, tirEndY, tirEndWidth, tirEndXajust);

            timelineTir.play();

            ImageView tirF = new ImageView(Path.laserBleu1Back);
            tirF.setX(vaissJ2F.getX() + 30);
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
            final KeyFrame tirEndYF = new KeyFrame(Duration.seconds(1.5), new KeyValue(tirF.yProperty(), 1100));

            final KeyFrame tirStartXajustF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.xProperty(), vaissJ2F.getX() + 30));
            final KeyFrame tirEndXajustF = new KeyFrame(Duration.seconds(1.5), new KeyValue(tirF.xProperty(), vaissJ2F.getX() + 10));

            final KeyFrame tirStartWidthF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.fitWidthProperty(), 1));
            final KeyFrame tirEndWidthF = new KeyFrame(Duration.seconds(1.5), new KeyValue(tirF.fitWidthProperty(), 60));

            final Timeline timelineTirF = new Timeline(tirStartYF, tirStartWidthF, tirStartXajustF, tirEndYF, tirEndWidthF, tirEndXajustF);

            timelineTirF.play();

            tirFBound = tir.getBoundsInParent();

            delayExploTouch = new PauseTransition(Duration.seconds(0.8));
            delayExploTouch.setOnFinished(event -> {

                if (tir.getBoundsInParent().intersects(vaissJ1F.getBoundsInParent())) {

                    viejoueur1 = vieVaiss - degatJ1;
                    viejoueur1 = viejoueur1 - 30;
                    degatJ1 = degatJ1 +30;

                    if(viejoueur1 > 0){
                        getVieJ1Text().setText("Life :" + (viejoueur1));
                    }else{
                        getVieJ1Text().setText("You are DEAD!");

                        Text t = new Text();
                        t.setX(630);
                        t.setY(550);
                        t.setCache(true);
                        t.setText("Le Joueur 1 ");
                        t.setFill(Color.WHITE);
                        t.setFont(Font.font(null, FontWeight.BOLD, 30));


                        Text t2 = new Text();
                        t2.setX(570);
                        t2.setY(600);
                        t2.setCache(true);
                        t2.setText("est mort carbonisé ");
                        t2.setFill(Color.WHITE);
                        t2.setFont(Font.font(null, FontWeight.BOLD, 30));




                        Reflection r = new Reflection();
                        r.setFraction(0.4f);

                        t.setEffect(r);
                        t2.setEffect(r);
                        // t.setTranslateY(400);

                        ImageView gameOver = new ImageView("Asset//Images//gameover.png");
                        gameOver.setX(200);
                        gameOver.setY(300);
                        gameOver.setFitWidth(1000);
                        gameOver.setPreserveRatio(true);
                        gameOver.setEffect(r);
                        fin = true;
                        root.getChildren().add(gameOver);
                        root.getChildren().add(t);
                        root.getChildren().add(t2);


                    }

                    if(viejoueur1 <=0){
                        ImageView explosFinale = new ImageView(Path.exploFinale);
                        explosFinale.setX(vaissJ1.getX());
                        explosFinale.setY(750);
                        explosFinale.setFitWidth(250);
                        explosFinale.setPreserveRatio(true);
                        explosFinale.setOpacity(0.6);
                        root.getChildren().add(explosFinale);
                    }


                    ImageView toucheExplos = new ImageView(Path.toucheExploBleu1);
                    toucheExplos.setX(vaissJ1.getX());
                    toucheExplos.setY(670);
                    toucheExplos.setFitWidth(300);
                    toucheExplos.setPreserveRatio(true);
                    toucheExplos.setOpacity(0.7);


                    ImageView toucheExplosF = new ImageView(Path.toucheExploBleu1);
                    toucheExplosF.setX(vaissJ1F.getX() + 10);
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

                PauseTransition delayPourRetier1 = new PauseTransition(Duration.seconds(0.15));
                delayPourRetier1.setOnFinished(event -> {
                    tirEnCour1 = true;
                });
                delayPourRetier1.play();

        }


        }
        else if (puissanceTir == 2 && cote == 2) {

            if(tirEnCour2 == true) {

                tirEnCour2 = false;

                ImageView tir = new ImageView(Path.missil1);
                tir.setX(vaissJ2.getX() + 130);
                tir.setY(700);
                tir.setFitWidth(20);
                tir.setPreserveRatio(true);
                root.getChildren().remove(vaissJ2);
                root.getChildren().add(tir);
                root.getChildren().add(vaissJ2);

                final KeyFrame tirStartXajust;
                final KeyFrame tirEndXajust;

                if (vaissJ2.getX() < 700) {
                    tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 130));
                    tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 200));
                    tir.setRotate(6);
                } else if (vaissJ2.getX() < 850) {
                    tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 130));
                    tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 190));
                    tir.setRotate(4);
                } else if (vaissJ2.getX() > 1050) {
                    tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 130));
                    tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 70));
                    tir.setRotate(-5);

                } else if (vaissJ2.getX() > 1200) {
                    tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 130));
                    tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 60));
                    tir.setRotate(-7);
                } else {

                    tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ2.getX() + 130));
                    tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ2.getX() + 140));
                    tir.setRotate(-1);

                }

                final KeyFrame tirStartY = new KeyFrame(Duration.ZERO, new KeyValue(tir.yProperty(), 700));
                // final KeyFrame changeVaisse = new KeyFrame(Duration.seconds(0.25), new KeyValue(vaissJ2.imageProperty(), vaissJ2droite2));
                final KeyFrame tirEndY = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.yProperty(), 250));

                final KeyFrame tirStartWidth = new KeyFrame(Duration.ZERO, new KeyValue(tir.fitWidthProperty(), 20));
                final KeyFrame tirEndWidth = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.fitWidthProperty(), 1));

                final Timeline timelineTir = new Timeline(tirStartY, tirStartWidth, tirStartXajust, tirEndY, tirEndWidth, tirEndXajust);

                timelineTir.play();

                ImageView tirF = new ImageView(Path.missil1F);
                tirF.setX(vaissJ2F.getX() + 30);
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

                final KeyFrame tirStartXajustF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.xProperty(), vaissJ2F.getX() + 30));
                final KeyFrame tirEndXajustF = new KeyFrame(Duration.seconds(4), new KeyValue(tirF.xProperty(), vaissJ2F.getX() + 10));

                final KeyFrame tirStartWidthF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.fitWidthProperty(), 1));
                final KeyFrame tirEndWidthF = new KeyFrame(Duration.seconds(4), new KeyValue(tirF.fitWidthProperty(), 25));

                final Timeline timelineTirF = new Timeline(tirStartYF, tirStartWidthF, tirStartXajustF, tirEndYF, tirEndWidthF, tirEndXajustF);

                timelineTirF.play();

                tirFBound = tirF.getBoundsInParent();

                delayExploTouch = new PauseTransition(Duration.seconds(2));
                delayExploTouch.setOnFinished(event -> {

                    if (tir.getBoundsInParent().intersects(vaissJ1F.getBoundsInParent())) {

                        viejoueur1 = vieVaiss - degatJ1;
                        viejoueur1 = viejoueur1 - 100;
                        degatJ1 = degatJ1 + 100;

                        if (viejoueur1 > 0) {
                            getVieJ1Text().setText("Life :" + (viejoueur1));


                        } else {
                            getVieJ1Text().setText("You are DEAD!");


                            Text t = new Text();
                            t.setX(630);
                            t.setY(550);
                            t.setCache(true);
                            t.setText("Le Joueur 1 ");
                            t.setFill(Color.WHITE);
                            t.setFont(Font.font(null, FontWeight.BOLD, 30));


                            Text t2 = new Text();
                            t2.setX(570);
                            t2.setY(600);
                            t2.setCache(true);
                            t2.setText("est mort carbonisé ");
                            t2.setFill(Color.WHITE);
                            t2.setFont(Font.font(null, FontWeight.BOLD, 30));


                            Reflection r = new Reflection();
                            r.setFraction(0.4f);

                            t.setEffect(r);
                            t2.setEffect(r);
                            // t.setTranslateY(400);

                            ImageView gameOver = new ImageView("Asset//Images//gameover.png");
                            gameOver.setX(200);
                            gameOver.setY(300);
                            gameOver.setFitWidth(1000);
                            gameOver.setPreserveRatio(true);
                            gameOver.setEffect(r);
                            fin = true;
                            root.getChildren().add(gameOver);
                            root.getChildren().add(t);
                            root.getChildren().add(t2);


                        }


                        if (viejoueur1 <= 0) {
                            ImageView explosFinale = new ImageView(Path.exploFinale);
                            explosFinale.setX(vaissJ1.getX() + 50);
                            explosFinale.setY(650);
                            explosFinale.setFitWidth(250);
                            explosFinale.setPreserveRatio(true);
                            explosFinale.setOpacity(0.6);
                            root.getChildren().add(explosFinale);
                        }


                        ImageView toucheExplos = new ImageView(Path.toucheExplo1);
                        toucheExplos.setX(vaissJ1.getX() + 40);
                        toucheExplos.setY(600);
                        toucheExplos.setFitWidth(300);
                        toucheExplos.setPreserveRatio(true);
                        toucheExplos.setOpacity(0.7);


                        ImageView toucheExplosF = new ImageView(Path.toucheExplo1);
                        toucheExplosF.setX(vaissJ1F.getX());
                        toucheExplosF.setY(270);
                        toucheExplosF.setFitWidth(100);
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
                PauseTransition delayPourRetier2 = new PauseTransition(Duration.seconds(0.6));
                delayPourRetier2.setOnFinished(event -> {
                    tirEnCour2 = true;
                });
                delayPourRetier2.play();
            }


        }
        else if (puissanceTir == 1 && cote == 1) {
            if(tirEnCour3 == true) {

                tirEnCour3 = false;

                ImageView tir = new ImageView(Path.laserBleu1Back);
                tir.setX(vaissJ1.getX() + 130);
                tir.setY(700);
                tir.setFitWidth(80);
                tir.setPreserveRatio(true);
                root.getChildren().remove(vaissJ1);
                root.getChildren().add(tir);
                root.getChildren().add(vaissJ1);

                final KeyFrame tirStartXajust;
                final KeyFrame tirEndXajust;

                if (vaissJ1.getX() < 50) {
                    tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ1.getX() + 105));
                    tirEndXajust = new KeyFrame(Duration.seconds(1), new KeyValue(tir.xProperty(), vaissJ1.getX() + 220));
                    tir.setRotate(6);
                } else if (vaissJ1.getX() < 150) {
                    tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ1.getX() + 105));
                    tirEndXajust = new KeyFrame(Duration.seconds(1), new KeyValue(tir.xProperty(), vaissJ1.getX() + 190));
                    tir.setRotate(4);
                } else if (vaissJ1.getX() > 350) {
                    tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ1.getX() + 105));
                    tirEndXajust = new KeyFrame(Duration.seconds(1), new KeyValue(tir.xProperty(), vaissJ1.getX() + 70));
                    tir.setRotate(-5);

                } else if (vaissJ1.getX() > 450) {
                    tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ1.getX() + 105));
                    tirEndXajust = new KeyFrame(Duration.seconds(1), new KeyValue(tir.xProperty(), vaissJ1.getX() + 60));
                    tir.setRotate(-7);
                } else {

                    tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ1.getX() + 105));
                    tirEndXajust = new KeyFrame(Duration.seconds(1), new KeyValue(tir.xProperty(), vaissJ1.getX() + 140));
                    tir.setRotate(0);

                }

                final KeyFrame tirStartY = new KeyFrame(Duration.ZERO, new KeyValue(tir.yProperty(), 700));
                // final KeyFrame changeVaisse = new KeyFrame(Duration.seconds(0.25), new KeyValue(vaissJ2.imageProperty(), vaissJ2droite2));
                final KeyFrame tirEndY = new KeyFrame(Duration.seconds(1), new KeyValue(tir.yProperty(), 250));

                final KeyFrame tirStartWidth = new KeyFrame(Duration.ZERO, new KeyValue(tir.fitWidthProperty(), 80));
                final KeyFrame tirEndWidth = new KeyFrame(Duration.seconds(1), new KeyValue(tir.fitWidthProperty(), 1));

                final Timeline timelineTir = new Timeline(tirStartY, tirStartWidth, tirStartXajust, tirEndY, tirEndWidth, tirEndXajust);

                timelineTir.play();

                ImageView tirF = new ImageView(Path.laserBleu1Back);
                tirF.setX(vaissJ1F.getX() + 30);
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
                final KeyFrame tirEndYF = new KeyFrame(Duration.seconds(1.5), new KeyValue(tirF.yProperty(), 1100));

                final KeyFrame tirStartXajustF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.xProperty(), vaissJ1F.getX() + 30));
                final KeyFrame tirEndXajustF = new KeyFrame(Duration.seconds(1.5), new KeyValue(tirF.xProperty(), vaissJ1F.getX() + 10));

                final KeyFrame tirStartWidthF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.fitWidthProperty(), 1));
                final KeyFrame tirEndWidthF = new KeyFrame(Duration.seconds(1.5), new KeyValue(tirF.fitWidthProperty(), 60));

                final Timeline timelineTirF = new Timeline(tirStartYF, tirStartWidthF, tirStartXajustF, tirEndYF, tirEndWidthF, tirEndXajustF);

                timelineTirF.play();

                tirFBound = tirF.getBoundsInParent();

                delayExploTouch = new PauseTransition(Duration.seconds(0.8));
                delayExploTouch.setOnFinished(event -> {

                    if (tir.getBoundsInParent().intersects(vaissJ2F.getBoundsInParent())) {
                        viejoueur2 = vieVaiss - degatJ2;
                        viejoueur2 = viejoueur2 - 30;
                        degatJ2 = degatJ2 + 30;

                        if (viejoueur2 > 0) {
                            getVieJ2Text().setText("Life :" + (viejoueur2));

                        } else {
                            getVieJ2Text().setText("You are DEAD!");

                            vieJ2Text.setX(1250);

                            Text t = new Text();
                            t.setX(630);
                            t.setY(550);
                            t.setCache(true);
                            t.setText("Le Joueur 2 ");
                            t.setFill(Color.WHITE);
                            t.setFont(Font.font(null, FontWeight.BOLD, 30));


                            Text t2 = new Text();
                            t2.setX(570);
                            t2.setY(600);
                            t2.setCache(true);
                            t2.setText("est mort déchiqueté");
                            t2.setFill(Color.WHITE);
                            t2.setFont(Font.font(null, FontWeight.BOLD, 30));


                            Reflection r = new Reflection();
                            r.setFraction(0.4f);

                            t.setEffect(r);
                            t2.setEffect(r);
                            // t.setTranslateY(400);

                            ImageView gameOver = new ImageView("Asset//Images//gameover.png");
                            gameOver.setX(200);
                            gameOver.setY(300);
                            gameOver.setFitWidth(1000);
                            gameOver.setPreserveRatio(true);
                            gameOver.setEffect(r);
                            fin = true;
                            root.getChildren().add(gameOver);
                            root.getChildren().add(t);
                            root.getChildren().add(t2);


                        }

                        if (viejoueur2 <= 0) {
                            ImageView explosFinale = new ImageView(Path.exploFinale);
                            explosFinale.setX(vaissJ2.getX() + 50);
                            explosFinale.setY(650);
                            explosFinale.setFitWidth(250);
                            explosFinale.setPreserveRatio(true);
                            explosFinale.setOpacity(0.6);
                            root.getChildren().add(explosFinale);
                        }


                        ImageView toucheExplos = new ImageView(Path.toucheExploBleu1);
                        toucheExplos.setX(vaissJ2.getX());
                        toucheExplos.setY(670);
                        toucheExplos.setFitWidth(300);
                        toucheExplos.setPreserveRatio(true);
                        toucheExplos.setOpacity(0.7);


                        ImageView toucheExplosF = new ImageView(Path.toucheExploBleu1);
                        toucheExplosF.setX(vaissJ2F.getX() + 10);
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

                PauseTransition delayPourRetier3 = new PauseTransition(Duration.seconds(0.15));
                delayPourRetier3.setOnFinished(event -> {
                    tirEnCour3 = true;
                });
                delayPourRetier3.play();


            }



        }
        else if (puissanceTir == 2 && cote == 1) {
            if(tirEnCour4 == true) {

                tirEnCour4 = false;

                ImageView tir = new ImageView(Path.missil1);
            tir.setX(vaissJ1.getX() + 130);
            tir.setY(700);
            tir.setFitWidth(20);
            tir.setPreserveRatio(true);
            root.getChildren().remove(vaissJ1);
            root.getChildren().add(tir);
            root.getChildren().add(vaissJ1);

            final KeyFrame tirStartXajust;
            final KeyFrame tirEndXajust;

            if (vaissJ1.getX() < 50) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ1.getX() + 130));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ1.getX() + 200));
                tir.setRotate(6);
            } else if (vaissJ1.getX() < 150) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ1.getX() + 130));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ1.getX() + 190));
                tir.setRotate(4);
            } else if (vaissJ1.getX() > 350) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ1.getX() + 130));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ1.getX() + 70));
                tir.setRotate(-5);

            } else if (vaissJ1.getX() > 450) {
                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ1.getX() + 130));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ1.getX() + 60));
                tir.setRotate(-7);
            } else {

                tirStartXajust = new KeyFrame(Duration.ZERO, new KeyValue(tir.xProperty(), vaissJ1.getX() + 130));
                tirEndXajust = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.xProperty(), vaissJ1.getX() + 130));
                tir.setRotate(0);

            }

            final KeyFrame tirStartY = new KeyFrame(Duration.ZERO, new KeyValue(tir.yProperty(), 700));
            // final KeyFrame changeVaisse = new KeyFrame(Duration.seconds(0.25), new KeyValue(vaissJ2.imageProperty(), vaissJ2droite2));
            final KeyFrame tirEndY = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.yProperty(), 250));

            final KeyFrame tirStartWidth = new KeyFrame(Duration.ZERO, new KeyValue(tir.fitWidthProperty(), 20));
            final KeyFrame tirEndWidth = new KeyFrame(Duration.seconds(2.3), new KeyValue(tir.fitWidthProperty(), 1));

            final Timeline timelineTir = new Timeline(tirStartY, tirStartWidth, tirStartXajust, tirEndY, tirEndWidth, tirEndXajust);

            timelineTir.play();

            ImageView tirF = new ImageView(Path.missil1F);
            tirF.setX(vaissJ1F.getX() + 60);
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

            final KeyFrame tirStartXajustF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.xProperty(), vaissJ1F.getX() + 60));
            final KeyFrame tirEndXajustF = new KeyFrame(Duration.seconds(4), new KeyValue(tirF.xProperty(), vaissJ1F.getX() + 40));

            final KeyFrame tirStartWidthF = new KeyFrame(Duration.ZERO, new KeyValue(tirF.fitWidthProperty(), 1));
            final KeyFrame tirEndWidthF = new KeyFrame(Duration.seconds(4), new KeyValue(tirF.fitWidthProperty(), 25));

            final Timeline timelineTirF = new Timeline(tirStartYF, tirStartWidthF, tirStartXajustF, tirEndYF, tirEndWidthF, tirEndXajustF);

            timelineTirF.play();

            tirFBound = tirF.getBoundsInParent();

            delayExploTouch = new PauseTransition(Duration.seconds(2));
            delayExploTouch.setOnFinished(event -> {

                if (tir.getBoundsInParent().intersects(vaissJ2F.getBoundsInParent())) {

                    viejoueur2 = vieVaiss - degatJ2;
                    viejoueur2 = viejoueur2 - 100;
                    degatJ2 = degatJ2 +100;


                    if(viejoueur2 > 0){
                        getVieJ2Text().setText("Life :" + (viejoueur2));

                    }else{
                        getVieJ2Text().setText("You are DEAD!");

                        vieJ2Text.setX(1250);

                        Text t = new Text();
                        t.setX(630);
                        t.setY(550);
                        t.setCache(true);
                        t.setText("Le Joueur 2 ");
                        t.setFill(Color.WHITE);
                        t.setFont(Font.font(null, FontWeight.BOLD, 30));


                        Text t2 = new Text();
                        t2.setX(570);
                        t2.setY(600);
                        t2.setCache(true);
                        t2.setText("est mort déchiqueté");
                        t2.setFill(Color.WHITE);
                        t2.setFont(Font.font(null, FontWeight.BOLD, 30));




                        Reflection r = new Reflection();
                        r.setFraction(0.4f);

                        t.setEffect(r);
                        t2.setEffect(r);
                        // t.setTranslateY(400);

                        ImageView gameOver = new ImageView("Asset//Images//gameover.png");
                        gameOver.setX(200);
                        gameOver.setY(300);
                        gameOver.setFitWidth(1000);
                        gameOver.setPreserveRatio(true);
                        gameOver.setEffect(r);
                        fin = true;
                        root.getChildren().add(gameOver);
                        root.getChildren().add(t);
                        root.getChildren().add(t2);


                    }



                    if(viejoueur2 <=0){
                        ImageView explosFinale = new ImageView(Path.exploFinale);
                        explosFinale.setX(vaissJ2.getX() + 50);
                        explosFinale.setY(650);
                        explosFinale.setFitWidth(250);
                        explosFinale.setPreserveRatio(true);
                        explosFinale.setOpacity(0.6);
                        root.getChildren().add(explosFinale);
                    }


                    ImageView toucheExplos = new ImageView(Path.toucheExplo1);
                    toucheExplos.setX(vaissJ2.getX()+10);
                    toucheExplos.setY(600);
                    toucheExplos.setFitWidth(300);
                    toucheExplos.setPreserveRatio(true);
                    toucheExplos.setOpacity(0.7);


                    ImageView toucheExplosF = new ImageView(Path.toucheExplo1);
                    toucheExplosF.setX(vaissJ2F.getX() -10);
                    toucheExplosF.setY(250);
                    toucheExplosF.setFitWidth(100);
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
                PauseTransition delayPourRetier4 = new PauseTransition(Duration.seconds(0.6));
                delayPourRetier4.setOnFinished(event -> {
                    tirEnCour4 = true;
                });
                delayPourRetier4.play();
        }


        }
    }

    public void j1goRight(double vitesse) {



        if (vaissJ1.getX() <= 601) {

            if (vaissJ1.getX() < 50) {
                if (indiVaissJ1 == 0) {
                    imageVaiss = (Image) vaissJoueur1geo.getTabImageVaissBack().get(6);
                } else if (indiVaissJ1 == 1) {
                    imageVaiss = (Image) vaissJoueur1corv.getTabImageVaissBack().get(6);
                } else if (indiVaissJ1 == 2) {
                    imageVaiss = (Image) vaissJoueur1r22.getTabImageVaissBack().get(6);
                } else if (indiVaissJ1 == 3) {
                    imageVaiss = (Image) vaissJoueur1fauc.getTabImageVaissBack().get(6);
                }

                vaissJ1.setImage(imageVaiss);
            } else if (vaissJ1.getX() < 150) {
                if (indiVaissJ1 == 0) {
                    imageVaiss = (Image) vaissJoueur1geo.getTabImageVaissBack().get(5);
                } else if (indiVaissJ1 == 1) {
                    imageVaiss = (Image) vaissJoueur1corv.getTabImageVaissBack().get(5);
                } else if (indiVaissJ1 == 2) {
                    imageVaiss = (Image) vaissJoueur1r22.getTabImageVaissBack().get(5);
                } else if (indiVaissJ1 == 3) {
                    imageVaiss = (Image) vaissJoueur1fauc.getTabImageVaissBack().get(5);
                }

                vaissJ1.setImage(imageVaiss);
            } else {

                if (indiVaissJ1 == 0) {
                    imageVaiss = (Image) vaissJoueur2geo.getTabImageVaissBack().get(4);
                } else if (indiVaissJ1 == 1) {
                    imageVaiss = (Image) vaissJoueur2corv.getTabImageVaissBack().get(4);
                } else if (indiVaissJ1 == 2) {
                    imageVaiss = (Image) vaissJoueur2r22.getTabImageVaissBack().get(4);
                } else if (indiVaissJ1 == 3) {
                    imageVaiss = (Image) vaissJoueur2fauc.getTabImageVaissBack().get(4);
                }

                vaissJ1.setImage(imageVaiss);
            }

            if (vaissJ1F.getX() > 1000) {
                if (indiVaissJ1 == 0) {
                    imageVaissF = (Image) vaissJoueur1geo.getTabImageVaissFace().get(0);
                } else if (indiVaissJ1 == 1) {
                    imageVaissF = (Image) vaissJoueur1corv.getTabImageVaissFace().get(0);
                } else if (indiVaissJ1 == 2) {
                    imageVaissF = (Image) vaissJoueur1r22.getTabImageVaissFace().get(0);
                } else if (indiVaissJ1 == 3) {
                    imageVaissF = (Image) vaissJoueur1fauc.getTabImageVaissFace().get(0);
                }
                vaissJ1F.setImage(imageVaissF);
            } else if (vaissJ1F.getX() > 1200) {
                if (indiVaissJ1 == 0) {
                    imageVaissF = (Image) vaissJoueur1geo.getTabImageVaissFace().get(1);
                } else if (indiVaissJ1 == 1) {
                    imageVaissF = (Image) vaissJoueur1corv.getTabImageVaissFace().get(1);
                } else if (indiVaissJ1 == 2) {
                    imageVaissF = (Image) vaissJoueur1r22.getTabImageVaissFace().get(1);
                } else if (indiVaissJ1 == 3) {
                    imageVaissF = (Image) vaissJoueur1fauc.getTabImageVaissFace().get(1);
                }
                vaissJ1F.setImage(imageVaissF);
            } else {
                if (indiVaissJ1 == 0) {
                    imageVaissF = (Image) vaissJoueur1geo.getTabImageVaissFace().get(2);
                } else if (indiVaissJ1 == 1) {
                    imageVaissF = (Image) vaissJoueur1corv.getTabImageVaissFace().get(2);
                } else if (indiVaissJ1 == 2) {
                    imageVaissF = (Image) vaissJoueur1r22.getTabImageVaissFace().get(2);
                } else if (indiVaissJ1 == 3) {
                    imageVaissF = (Image) vaissJoueur1fauc.getTabImageVaissFace().get(2);
                }
                vaissJ1F.setImage(imageVaissF);

            }


            final KeyFrame goLeftStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ1.xProperty(), vaissJ1.getX()));
            final KeyFrame goLeftEnd = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ1.xProperty(), 500, Interpolator.LINEAR));

            final KeyFrame goLeftStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ1F.xProperty(), vaissJ1F.getX()));
            final KeyFrame goLeftEndFace = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ1F.xProperty(), 800, Interpolator.LINEAR));

            timelineGoRightJ1 = new Timeline(goLeftStart, goLeftStartFace, goLeftEnd, goLeftEndFace);

            timelineGoRightJ1.setCycleCount(1);
        }
    }

    public void j1goLeft(double vitesse) {

         if (vaissJ1.getX() >= 400) {

             if (indiVaissJ1 == 0) {
                 imageVaiss = (Image) vaissJoueur1geo.getTabImageVaissBack().get(0);
             } else if (indiVaissJ1 == 1) {
                 imageVaiss = (Image) vaissJoueur1corv.getTabImageVaissBack().get(0);
             } else if (indiVaissJ1 == 2) {
                 imageVaiss = (Image) vaissJoueur1r22.getTabImageVaissBack().get(0);
             } else if (indiVaissJ1 == 3) {
                 imageVaiss = (Image) vaissJoueur1fauc.getTabImageVaissBack().get(0);
             }
            vaissJ1.setImage(imageVaiss);

        } else if (vaissJ1.getX() > 300) {

             if (indiVaissJ1 == 0) {
                 imageVaiss = (Image) vaissJoueur1geo.getTabImageVaissBack().get(1);
             } else if (indiVaissJ1 == 1) {
                 imageVaiss = (Image) vaissJoueur1corv.getTabImageVaissBack().get(1);
             } else if (indiVaissJ1 == 2) {
                 imageVaiss = (Image) vaissJoueur1r22.getTabImageVaissBack().get(1);
             } else if (indiVaissJ1 == 3) {
                 imageVaiss = (Image) vaissJoueur1fauc.getTabImageVaissBack().get(1);
             }

            vaissJ1.setImage(imageVaiss);
        } else {

             if (indiVaissJ1 == 0) {
                 imageVaiss = (Image) vaissJoueur1geo.getTabImageVaissBack().get(2);
             } else if (indiVaissJ1 == 1) {
                 imageVaiss = (Image) vaissJoueur1corv.getTabImageVaissBack().get(2);
             } else if (indiVaissJ1 == 2) {
                 imageVaiss = (Image) vaissJoueur1r22.getTabImageVaissBack().get(2);
             } else if (indiVaissJ1 == 3) {
                 imageVaiss = (Image) vaissJoueur1fauc.getTabImageVaissBack().get(2);
             }

            vaissJ1.setImage(imageVaiss);
        }

        if (vaissJ1F.getX() > 1100) {
            if (indiVaissJ1 == 0) {
                imageVaissF = (Image) vaissJoueur1geo.getTabImageVaissFace().get(4);
            } else if (indiVaissJ1 == 1) {
                imageVaissF = (Image) vaissJoueur1corv.getTabImageVaissFace().get(4);
            } else if (indiVaissJ1 == 2) {
                imageVaissF = (Image) vaissJoueur1r22.getTabImageVaissFace().get(4);
            } else if (indiVaissJ1 == 3) {
                imageVaissF = (Image) vaissJoueur1fauc.getTabImageVaissFace().get(4);
            }
            vaissJ1F.setImage(imageVaissF);
        } else if (vaissJ1F.getX() > 900) {
            if (indiVaissJ1 == 0) {
                imageVaissF = (Image) vaissJoueur1geo.getTabImageVaissFace().get(5);
            } else if (indiVaissJ1 == 1) {
                imageVaissF = (Image) vaissJoueur1corv.getTabImageVaissFace().get(5);
            } else if (indiVaissJ1 == 2) {
                imageVaissF = (Image) vaissJoueur1r22.getTabImageVaissFace().get(5);
            } else if (indiVaissJ1 == 3) {
                imageVaissF = (Image) vaissJoueur1fauc.getTabImageVaissFace().get(5);
            }
            vaissJ1F.setImage(imageVaissF);
        } else {
            if (indiVaissJ1 == 0) {
                imageVaissF = (Image) vaissJoueur1geo.getTabImageVaissFace().get(6);
            } else if (indiVaissJ1 == 1) {
                imageVaissF = (Image) vaissJoueur1corv.getTabImageVaissFace().get(6);
            } else if (indiVaissJ1 == 2) {
                imageVaissF = (Image) vaissJoueur1r22.getTabImageVaissFace().get(6);
            } else if (indiVaissJ1 == 3) {
                imageVaissF = (Image) vaissJoueur1fauc.getTabImageVaissFace().get(6);
            }
        }
            vaissJ1F.setImage(imageVaissF);



        final KeyFrame goLeftStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ1.xProperty(), vaissJ1.getX()));
        final KeyFrame goLeftEnd = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ1.xProperty(), -100, Interpolator.LINEAR));

        final KeyFrame goLeftStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ1F.xProperty(), vaissJ1F.getX()));
        final KeyFrame goLeftEndFace = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ1F.xProperty(), 1250, Interpolator.LINEAR));

        timelineGoLeftJ1 = new Timeline(goLeftStart, goLeftStartFace, goLeftEnd, goLeftEndFace);
        timelineGoLeftJ1.setCycleCount(1);
    }

    public void j2goRight(double vitesse) {


        if (vaissJ2.getX() <= 1251) {

            if (vaissJ2.getX() < 700) {

                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJoueur2geo.getTabImageVaissBack().get(6);
                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJoueur2corv.getTabImageVaissBack().get(6);

                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJoueur2r22.getTabImageVaissBack().get(6);

                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJoueur2fauc.getTabImageVaissBack().get(6);
                }

                vaissJ2.setImage(imageVaiss);

            } else if (vaissJ2.getX() < 850) {
                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJoueur2geo.getTabImageVaissBack().get(5);
                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJoueur2corv.getTabImageVaissBack().get(5);
                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJoueur2r22.getTabImageVaissBack().get(5);
                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJoueur2fauc.getTabImageVaissBack().get(5);
                }
                vaissJ2.setImage(imageVaiss);

            } else {
                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJoueur2geo.getTabImageVaissBack().get(4);

                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJoueur2corv.getTabImageVaissBack().get(4);

                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJoueur2r22.getTabImageVaissBack().get(4);

                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJoueur2fauc.getTabImageVaissBack().get(4);

                }
                vaissJ2.setImage(imageVaiss);

            }

            if (vaissJ2F.getX() > 300) {
                if (indiVaissJ2 == 0) {
                    imageVaissF = (Image) vaissJoueur2geo.getTabImageVaissFace().get(0);
                } else if (indiVaissJ2 == 1) {
                    imageVaissF = (Image) vaissJoueur2corv.getTabImageVaissFace().get(0);
                } else if (indiVaissJ2 == 2) {
                    imageVaissF = (Image) vaissJoueur2r22.getTabImageVaissFace().get(0);
                } else if (indiVaissJ2 == 3) {
                    imageVaissF = (Image) vaissJoueur2fauc.getTabImageVaissFace().get(0);
                }
                vaissJ2F.setImage(imageVaissF);
            } else if (vaissJ2F.getX() > 550) {
                if (indiVaissJ2 == 0) {
                    imageVaissF = (Image) vaissJoueur2geo.getTabImageVaissFace().get(1);
                } else if (indiVaissJ2 == 1) {
                    imageVaissF = (Image) vaissJoueur2corv.getTabImageVaissFace().get(1);
                } else if (indiVaissJ2 == 2) {
                    imageVaissF = (Image) vaissJoueur2r22.getTabImageVaissFace().get(1);
                } else if (indiVaissJ2 == 3) {
                    imageVaissF = (Image) vaissJoueur2fauc.getTabImageVaissFace().get(1);
                }
                vaissJ2F.setImage(imageVaissF);
            } else {
                if (indiVaissJ2 == 0) {
                    imageVaissF = (Image) vaissJoueur2geo.getTabImageVaissFace().get(2);
                } else if (indiVaissJ2 == 1) {
                    imageVaissF = (Image) vaissJoueur2corv.getTabImageVaissFace().get(2);
                } else if (indiVaissJ2 == 2) {
                    imageVaissF = (Image) vaissJoueur2r22.getTabImageVaissFace().get(2);
                } else if (indiVaissJ2 == 3) {
                    imageVaissF = (Image) vaissJoueur2fauc.getTabImageVaissFace().get(2);
                }
                vaissJ2F.setImage(imageVaissF);

            }


            final KeyFrame goRightStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2.xProperty(), vaissJ2.getX()));
            final KeyFrame goRightEnd = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ2.xProperty(), 1250, Interpolator.LINEAR));

            final KeyFrame goRightStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2F.xProperty(), vaissJ2F.getX()));
            final KeyFrame goRightEndFace = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ2F.xProperty(), 70, Interpolator.LINEAR));

            timelineGoRightJ2 = new Timeline(goRightStart, goRightStartFace, /*changeVaisse,*/ goRightEnd, goRightEndFace);
            timelineGoRightJ2.setCycleCount(1);
        }
    }

    public void j2goLeft(double vitesse) {


            if (vaissJ2.getX() >= 601) {

            if (vaissJ2.getX() > 1200) {
                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJoueur2geo.getTabImageVaissBack().get(0);

                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJoueur2corv.getTabImageVaissBack().get(0);

                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJoueur2r22.getTabImageVaissBack().get(0);

                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJoueur2fauc.getTabImageVaissBack().get(0);

                }

                vaissJ2.setImage(imageVaiss);

            } else if (vaissJ2.getX() > 1000) {
                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJoueur2geo.getTabImageVaissBack().get(1);

                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJoueur2corv.getTabImageVaissBack().get(1);

                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJoueur2r22.getTabImageVaissBack().get(1);

                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJoueur2fauc.getTabImageVaissBack().get(1);

                }

                vaissJ2.setImage(imageVaiss);

            } else {
                if (indiVaissJ2 == 0) {
                    imageVaiss = (Image) vaissJoueur2geo.getTabImageVaissBack().get(2);

                } else if (indiVaissJ2 == 1) {
                    imageVaiss = (Image) vaissJoueur2corv.getTabImageVaissBack().get(2);

                } else if (indiVaissJ2 == 2) {
                    imageVaiss = (Image) vaissJoueur2r22.getTabImageVaissBack().get(2);

                } else if (indiVaissJ2 == 3) {
                    imageVaiss = (Image) vaissJoueur2fauc.getTabImageVaissBack().get(2);

                }
                vaissJ2.setImage(imageVaiss);
            }


                if (vaissJ2F.getX() < 150) {
                    if (indiVaissJ2 == 0) {
                        imageVaissF = (Image) vaissJoueur2geo.getTabImageVaissFace().get(6);
                    } else if (indiVaissJ2 == 1) {
                        imageVaissF = (Image) vaissJoueur2corv.getTabImageVaissFace().get(6);
                    } else if (indiVaissJ2 == 2) {
                        imageVaissF = (Image) vaissJoueur2r22.getTabImageVaissFace().get(6);
                    } else if (indiVaissJ2 == 3) {
                        imageVaissF = (Image) vaissJoueur2fauc.getTabImageVaissFace().get(6);
                    }
                    vaissJ2F.setImage(imageVaissF);
                } else if (vaissJ2F.getX() < 350) {
                    if (indiVaissJ2 == 0) {
                        imageVaissF = (Image) vaissJoueur2geo.getTabImageVaissFace().get(5);
                    } else if (indiVaissJ2 == 1) {
                        imageVaissF = (Image) vaissJoueur2corv.getTabImageVaissFace().get(5);
                    } else if (indiVaissJ2 == 2) {
                        imageVaissF = (Image) vaissJoueur2r22.getTabImageVaissFace().get(5);
                    } else if (indiVaissJ2 == 3) {
                        imageVaissF = (Image) vaissJoueur2fauc.getTabImageVaissFace().get(5);
                    }
                    vaissJ2F.setImage(imageVaissF);
                } else {
                    if (indiVaissJ2 == 0) {
                        imageVaissF = (Image) vaissJoueur2geo.getTabImageVaissFace().get(4);
                    } else if (indiVaissJ2 == 1) {
                        imageVaissF = (Image) vaissJoueur2corv.getTabImageVaissFace().get(4);
                    } else if (indiVaissJ2 == 2) {
                        imageVaissF = (Image) vaissJoueur2r22.getTabImageVaissFace().get(4);
                    } else if (indiVaissJ2 == 3) {
                        imageVaissF = (Image) vaissJoueur2fauc.getTabImageVaissFace().get(4);
                    }
                    vaissJ2F.setImage(imageVaissF);

                }

            final KeyFrame goLeftStart = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2.xProperty(), vaissJ2.getX()));
            final KeyFrame goLeftEnd = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ2.xProperty(), 600, Interpolator.LINEAR));

            final KeyFrame goLeftStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ2F.xProperty(), vaissJ2F.getX()));
            final KeyFrame goLeftEndFace = new KeyFrame(Duration.seconds(vitesse), new KeyValue(vaissJ2F.xProperty(), 550, Interpolator.LINEAR));

            timelineGoLeftJ2 = new Timeline(goLeftStart, goLeftStartFace, goLeftEnd, goLeftEndFace);
            timelineGoLeftJ2.setCycleCount(1);

        }
    }

    public void retourNormalBackJ2() {
        Image vaissJ2normal = null;
        if (indiVaissJ2 == 0) {
            vaissJ2normal = (Image) vaissJoueur2geo.getTabImageVaissBack().get(3);
        } else if (indiVaissJ2 == 1) {
            vaissJ2normal = (Image) vaissJoueur2corv.getTabImageVaissBack().get(3);
        } else if (indiVaissJ2 == 2) {
            vaissJ2normal = (Image) vaissJoueur2r22.getTabImageVaissBack().get(3);

        } else if (indiVaissJ2 == 3) {
            vaissJ2normal = (Image) vaissJoueur2fauc.getTabImageVaissBack().get(3);
        }

        vaissJ2.setImage(vaissJ2normal);
    }

    public void retourNormalFrontJ2() {
        Image vaissJ2Fnormal = null;
        if (indiVaissJ2 == 0) {
            vaissJ2Fnormal = (Image) vaissJoueur2geo.getTabImageVaissFace().get(3);
        } else if (indiVaissJ2 == 1) {
            vaissJ2Fnormal = (Image) vaissJoueur2corv.getTabImageVaissFace().get(3);
        } else if (indiVaissJ2 == 2) {
            vaissJ2Fnormal = (Image) vaissJoueur2r22.getTabImageVaissFace().get(3);

        } else if (indiVaissJ2 == 3) {
            vaissJ2Fnormal = (Image) vaissJoueur2fauc.getTabImageVaissFace().get(3);
        }

        vaissJ2F.setImage(vaissJ2Fnormal);
    }


    public int getViejoueur2() {
        return viejoueur2;
    }

    public int getViejoueur1() {
        return viejoueur1;
    }



    private Text getVieJ2Text() {
            return vieJ2Text;
        }

    public void retourNormalBackJ1() {
        Image vaissJ1normal = null;
        if (indiVaissJ1 == 0) {
            vaissJ1normal = (Image) vaissJoueur1geo.getTabImageVaissBack().get(3);
        } else if (indiVaissJ1 == 1) {
            vaissJ1normal = (Image) vaissJoueur1corv.getTabImageVaissBack().get(3);
        } else if (indiVaissJ1 == 2) {
            vaissJ1normal = (Image) vaissJoueur1r22.getTabImageVaissBack().get(3);

        } else if (indiVaissJ1 == 3) {
            vaissJ1normal = (Image) vaissJoueur1fauc.getTabImageVaissBack().get(3);

        }


        vaissJ1.setImage(vaissJ1normal);

    }

    public void retourNormalFrontJ1() {
        Image vaissJ1Fnormal = null;
        if (indiVaissJ1 == 0) {
            vaissJ1Fnormal = (Image) vaissJoueur1geo.getTabImageVaissFace().get(3);
        } else if (indiVaissJ1 == 1) {
            vaissJ1Fnormal = (Image) vaissJoueur1corv.getTabImageVaissFace().get(3);
        } else if (indiVaissJ1 == 2) {
            vaissJ1Fnormal = (Image) vaissJoueur1r22.getTabImageVaissFace().get(3);

        } else if (indiVaissJ1 == 3) {
            vaissJ1Fnormal = (Image) vaissJoueur1fauc.getTabImageVaissFace().get(3);

        }


        vaissJ1F.setImage(vaissJ1Fnormal);


    }
}

