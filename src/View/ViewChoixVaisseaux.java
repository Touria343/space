package View;


import Controller.ControllerMenu;
import Model.Menu;
import Tools.Path;
import javafx.animation.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

import static javafx.scene.text.FontWeight.EXTRA_BOLD;
import static javafx.scene.text.FontWeight.SEMI_BOLD;

public class ViewChoixVaisseaux {

    private Text titre;
    private Menu model;
    private ImageView imgBg;
    private Group root;
    private ArrayList<ImageView> tabImage;
    private ImageView monLezard;
    private int currentIndice;
    private ImageView spider;
    private int i =1;
    private MediaPlayer videoBackground;
    private MediaView media;
    private Stage stage;
    private MediaView viewer;
    private ImageView stats;
    private ImageView bandeTop;
    private ImageView bandeFond;
    private ImageView chevron;
    private ImageView bandeBottom;
    private ImageView chevrondroit;
    private Text joueur1;
    private Text geoCroiseur;
    private Text retour;
    private ViewHandler launcher;
    private ImageView leVaisseauxSelectionne;
    private ArrayList<ImageView> tabImageVaisseaux;
    private int indice = 0;
    private ArrayList<ImageView> tabImageStats;
    private ImageView statsSelectionne;
    private ArrayList<Text> tabTitreVaisseaux;
    private Text titreSelectionne;
    private ImageView joueurNum1;


    /**
     * Constructeur du menu principal
     *
     * @param model (Modèle correspondant au menu)
     * @param root  (Groupe principal de la vue)
     */
    ViewChoixVaisseaux(Menu model, Group root) {
        this.root = root;
        this.model = model;

        initBackground();
        initBandeTop();
        initBandeBottom();
        initChevron();
        initChevronDroit();
        initStats();
        initTextChangerVaisseaux();
        initVaisseauxChoix();
        initTextGeoCroiseur();
        initJoueur1();
        setVueCompleteMenu();


    }

   /* private void initListeImage() {
        tabImage = new ArrayList<>();
        tabImage.add(new ImageView(Path.lezardBlue1));
        tabImage.add(new ImageView(Path.lezardBlue2));
        tabImage.add(new ImageView(Path.lezardBlue3));
        tabImage.add(new ImageView(Path.lezardBlue4));
        monLezard = tabImage.get(0);
        monLezard.setX(500);
        monLezard.setY(500);
        monLezard.setScaleX(0.2);
        monLezard.setScaleY(0.2);
    }*/

    private void initTextGeoCroiseur() {
         geoCroiseur = new Text(50, 180, "- G  é  o  -  c  r  o  i  s  e  u  r \n      G  é  n  é  s  i  s   T-16 -");
        geoCroiseur.setFont(Font.font("Dead Kansas", EXTRA_BOLD, 60));
        geoCroiseur.setFill (Color.WHITE);
        geoCroiseur.setOpacity(0);
        Reflection r = new Reflection();
        r.setFraction(0.5f);
        geoCroiseur.setEffect(r);
    }
    private void initVaisseauxChoix() {

        spider = new ImageView(Path.vaisseauxChoix1);
        spider.setX(600);
        spider.setY(200);
        spider.setFitHeight(750);
        spider.setFitWidth(850);
        spider.setPreserveRatio(false);
       spider.setOpacity(0);


   }
    private void initJoueur1() {

        joueurNum1 = new ImageView(Path.joueur1);
        joueurNum1.setX(1200);
        joueurNum1.setY(150);
        joueurNum1.setOpacity(0);
        joueurNum1.setFitWidth(250);
        joueurNum1.setPreserveRatio(true);




    }

    private void initChevron() {

        chevron = new ImageView(Path.chevrongauche);
        chevron.setX(500);
        chevron.setY(775);
        chevron.setFitHeight(80);
        chevron.setFitWidth(80);
        chevron.setPreserveRatio(false);
        chevron.setOpacity(0);
        chevron.setPickOnBounds(true);



    }
    private void initChevronDroit() {

        chevrondroit = new ImageView(Path.chevrondroit);
        chevrondroit.setX(890);
        chevrondroit.setY(765);
        chevrondroit.setFitHeight(80);
        chevrondroit.setFitWidth(80);
        chevrondroit.setPreserveRatio(false);
        chevrondroit.setOpacity(0);
        chevrondroit.setPickOnBounds(true);


    }
    private void initBandeTop() {

        bandeTop = new ImageView(Path.bandeTop);
        bandeTop.setX(-300);
        bandeTop.setY(0);
        bandeTop.setFitWidth(1500);
        bandeTop.setPreserveRatio(true);
    }
    private void initBandeBottom() {

        bandeBottom = new ImageView(Path.bandeBottom);
        bandeBottom.setX(500);
        bandeBottom.setY(930);
        bandeBottom.setFitWidth(1500);
        bandeBottom.setPreserveRatio(true);
    }
    private void initStats() {

        stats = new ImageView(Path.stats1);
        stats.setX(80);
        stats.setY(430);
        stats.setFitWidth(800);
        stats.setPreserveRatio(true);
        stats.setOpacity(0);


    }
    private void initTextChangerVaisseaux() {

        joueur1 = new Text(600, 820, "Vaisseau suivant");
        joueur1.setFont(Font.font("Dead Kansas", SEMI_BOLD, 37));
        joueur1.setFill (Color.BLUE);

        Reflection r = new Reflection();
        r.setFraction(0.5f);
        joueur1.setEffect(r);
    }
    private void initBackground() {
        //imgBg = new ImageView("Asset/Images/fond_menu.jpg");
        //Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran
        //imgBg.setFitHeight((int) primaryScreenBounds.getHeight());
        //imgBg.setFitWidth((int) primaryScreenBounds.getWidth());

        videoBackground = new MediaPlayer(new Media(this.getClass().getResource(Path.videobackground2).toExternalForm()));
        videoBackground.setAutoPlay(true);
        videoBackground.setCycleCount(MediaPlayer.INDEFINITE);
        viewer = new MediaView(videoBackground);
        videoBackground.play();

        //change width and height to fit video
        DoubleProperty width = viewer.fitWidthProperty();
        DoubleProperty height = viewer.fitHeightProperty();

        width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
        viewer.setPreserveRatio(false);

   /*  if (viewer.isPreserveRatio()) {
            if (getHeight() > getWidth()) {
                viewer.setFitWidth(getWidth());
                imageView.setFitHeight(0);
            } else {
                imageView.setFitWidth(0);
                imageView.setFitHeight(getHeight());
            }
                } else {
                        imageView.setFitWidth(getWidth());
                        imageView.setFitHeight(getHeight());
        }
*/
    }

    public void setVueCompleteMenu() {

        root.getChildren().clear();
        root.getChildren().add(viewer);
        root.getChildren().add(stats);
        root.getChildren().add(chevron);
        root.getChildren().add(chevrondroit);
        root.getChildren().add(bandeTop);
        root.getChildren().add(bandeBottom);
        root.getChildren().add(spider);
        root.getChildren().add(joueur1);
        root.getChildren().add(joueurNum1);
        root.getChildren().add(geoCroiseur);

        final Animation animTextMenuArrivee = new Transition() {
            {
                setCycleDuration(Duration.millis(2500));
            }
            protected void interpolate(double frac) {
                geoCroiseur.setOpacity(frac);
                spider.setOpacity(frac);
                chevron.setOpacity(frac);
                chevrondroit.setOpacity(frac);

            }
        };
        


        final Animation animTextMenu = new Transition() {
            {
                setCycleDuration(Duration.millis(5000));
            }
            protected void interpolate(double frac) {
                stats.setOpacity(frac);
                joueurNum1.setOpacity(frac);


            }
        };

        animTextMenu.play();

        animTextMenuArrivee.play();


    }

    public void setEvents(ControllerMenu mc) {
      chevron.setOnMouseEntered(mc);
      chevrondroit.setOnMouseEntered(mc);
      chevron.setOnMouseExited(mc);
      chevrondroit.setOnMouseExited(mc);
      chevron.setOnMouseClicked(mc);
      chevrondroit.setOnMouseClicked(mc);
    }

    public void grandissementChevron(){
                chevron.setFitHeight(110);
                chevron.setFitWidth(110);
                chevron.setY(762);
                chevron.setX(490);
    //    launcher.getMenuDemarrage().setCursor(Cursor.HAND);
    }

    public void grandissementChevronDroit(){
                chevrondroit.setY(752);
                chevrondroit.setFitHeight(110);
                chevrondroit.setFitWidth(110);
                chevrondroit.setX(876);
     //   launcher.getMenuDemarrage().setCursor(Cursor.HAND);
    }

    public void retourNormalChevronGauche() {
        chevron.setFitHeight(80);
        chevron.setFitWidth(80);
        chevron.setY(775);
        chevron.setX(500);
   //     launcher.getMenuDemarrage().setCursor(Cursor.DEFAULT);
    }

    public void retourNormalChevronDroit() {
        chevrondroit.setFitHeight(80);
        chevrondroit.setFitWidth(80);
        chevrondroit.setY(765);
        chevrondroit.setX(890);
    //    launcher.getMenuDemarrage().setCursor(Cursor.DEFAULT);
    }

    public ImageView getChevron() {
        return chevron;
    }
    public ImageView getChevrondroit() {
        return chevrondroit;
    }


    public void swipeVaisseaux(Boolean chevronDeDroite) {

        tabImageVaisseaux = new ArrayList<>();
        tabImageVaisseaux.add(new ImageView(Path.vaisseauxChoix1));
        tabImageVaisseaux.add(new ImageView(Path.vaisseauxChoix2));
        tabImageVaisseaux.add(new ImageView(Path.vaisseauxChoix3));
        tabImageVaisseaux.add(new ImageView(Path.vaisseauxChoix4));

        if (chevronDeDroite == true){
            if(indice < (tabImageVaisseaux.size()-1)){
                indice++;
                System.out.println("indice++");
            }else{
                indice=0;
                System.out.println("indice = 0");
            }
        }else{
            if(indice == 0){
                indice= (tabImageVaisseaux.size()-1);
                System.out.println("indice = tabimagesize()");

            }else{
                indice--;
                System.out.println("indice--;");
            }
           }

        tabImageStats = new ArrayList<>();
        tabImageStats.add(new ImageView(Path.stats1));
        tabImageStats.add(new ImageView(Path.stats2));
        tabImageStats.add(new ImageView(Path.stats3));
        tabImageStats.add(new ImageView(Path.stats4));

        tabTitreVaisseaux = new ArrayList<>();
        tabTitreVaisseaux.add(new Text(50, 180, "- G  é  o  -  c  r  o  i  s  e  u  r \n      G  é  n  é  s  i  s   T-16 -"));
        tabTitreVaisseaux.add(new Text(50, 180, "- T  o  u  r  i  a -\n      C  o  r  v  e  t  t  e  -  9 -"));
        tabTitreVaisseaux.add(new Text(50, 180, "- I  n  t  e  r  c  e  p  t  e  u  r -\n      M A X   -  R - 22 -"));
        tabTitreVaisseaux.add(new Text(50, 180, "- R E D  -\n     F  A  U  C  O  N -"));

        if(root.getChildren().contains(geoCroiseur)){

            final KeyFrame keyFrameAt0s = new KeyFrame(Duration.ZERO, new KeyValue(spider.xProperty(), 600));
            final KeyFrame keyFrameAt1s = new KeyFrame(Duration.seconds(2), new KeyValue(spider.xProperty(), 2500));
            final Timeline timeline = new Timeline(keyFrameAt0s, keyFrameAt1s);
            timeline.setCycleCount(1);
            timeline.playFromStart();

            final KeyFrame switchStatsAt0 = new KeyFrame(Duration.ZERO, new KeyValue(stats.xProperty(), 80));
            final KeyFrame switchStatsAt5 = new KeyFrame(Duration.seconds(1), new KeyValue(stats.xProperty(), -2500));
            final Timeline timelineswitchStats = new Timeline(switchStatsAt0, switchStatsAt5);
            timelineswitchStats.setCycleCount(1);
            timelineswitchStats.playFromStart();

            final KeyFrame switchTitre = new KeyFrame(Duration.ZERO, new KeyValue(geoCroiseur.yProperty(), 180));
            final KeyFrame switchtitreAt1 = new KeyFrame(Duration.seconds(4), new KeyValue(geoCroiseur.yProperty(), -2500));
            final Timeline timelineswitchTitre = new Timeline(switchTitre, switchtitreAt1);
            timelineswitchTitre.setCycleCount(1);
            timelineswitchTitre.playFromStart();

        }

        Timeline timeline3 = new Timeline(new KeyFrame(
                Duration.millis(1000),
                ae -> removePremierVaisseauxDuRoot()));
        timeline3.play();

        if(root.getChildren().contains(leVaisseauxSelectionne)){


            final KeyFrame switchVaisseauxChoisiStart = new KeyFrame(Duration.ZERO, new KeyValue(leVaisseauxSelectionne.xProperty(), 600));
            final KeyFrame switchvaisseauxChoisiEnd = new KeyFrame(Duration.seconds(0.6), new KeyValue(leVaisseauxSelectionne.xProperty(), 2500));
            final Timeline timelineswitchVaisseaux = new Timeline(switchVaisseauxChoisiStart, switchvaisseauxChoisiEnd);
            timelineswitchVaisseaux.setCycleCount(1);
            timelineswitchVaisseaux.playFromStart();

            final KeyFrame switchStatsStart = new KeyFrame(Duration.ZERO, new KeyValue(statsSelectionne.xProperty(), 80));
            final KeyFrame switchStatsEnd = new KeyFrame(Duration.seconds(0.6), new KeyValue(statsSelectionne.xProperty(), -2500));
            final Timeline timelineswitchStatschoisi = new Timeline(switchStatsStart, switchStatsEnd);
            timelineswitchStatschoisi.setCycleCount(1);
            timelineswitchStatschoisi.playFromStart();

            final KeyFrame switchTitreStart = new KeyFrame(Duration.ZERO, new KeyValue(titreSelectionne.yProperty(), 180));
            final KeyFrame switchtitreEnd = new KeyFrame(Duration.seconds(0.6), new KeyValue(titreSelectionne.yProperty(), -500));
            final Timeline timelineswitchTitreChoisi = new Timeline(switchTitreStart, switchtitreEnd);
            timelineswitchTitreChoisi.setCycleCount(1);
            timelineswitchTitreChoisi.playFromStart();


            final Animation animFonduSortie = new Transition() {
                {
                    setCycleDuration(Duration.millis(10));
                }

                protected void interpolate(double frac) {
                    double frac1 = -frac + 1;

                    leVaisseauxSelectionne.setOpacity(frac1);
                    statsSelectionne.setOpacity(frac1);
                    titreSelectionne.setOpacity(frac1);

                    //this.stop();
                }

            };
            animFonduSortie.play();


/*
            Timeline timeline4 = new Timeline(new KeyFrame(
                    Duration.millis(1000),
                    ae -> removeVaisseauxChoisi()));
            timeline4.play();
*/


        }

        leVaisseauxSelectionne = tabImageVaisseaux.get(indice);
        leVaisseauxSelectionne.setX(500);
        leVaisseauxSelectionne.setX(600);
        leVaisseauxSelectionne.setY(200);
        leVaisseauxSelectionne.setFitHeight(750);
        leVaisseauxSelectionne.setFitWidth(850);
        leVaisseauxSelectionne.setPreserveRatio(false);
        leVaisseauxSelectionne.setOpacity(0);

        statsSelectionne = tabImageStats.get(indice);

        statsSelectionne.setX(80);
        statsSelectionne.setY(430);
        statsSelectionne.setFitWidth(800);
        statsSelectionne.setOpacity(0);
        statsSelectionne.setPreserveRatio(true);


        titreSelectionne = tabTitreVaisseaux.get(indice);
        titreSelectionne.setFont(Font.font("Dead Kansas", EXTRA_BOLD, 60));
        titreSelectionne.setFill (Color.WHITE);
        titreSelectionne.setOpacity(0);
        Reflection r = new Reflection();
        r.setFraction(0.5f);
        titreSelectionne.setEffect(r);


        root.getChildren().remove(bandeTop);

        root.getChildren().add(statsSelectionne);
        root.getChildren().add(titreSelectionne);
        root.getChildren().add(leVaisseauxSelectionne);
        root.getChildren().add(bandeTop);


        final Animation animFonduEntree = new Transition() {
            {
                setCycleDuration(Duration.millis(1300));
            }

            protected void interpolate(double frac) {

                leVaisseauxSelectionne.setOpacity(frac);

                titreSelectionne.setOpacity(frac);

                //this.stop();
            }

        };
        animFonduEntree.play();


        final Animation animFonduEntree2 = new Transition() {
            {
                setCycleDuration(Duration.millis(1800));
            }

            protected void interpolate(double frac) {


                statsSelectionne.setOpacity(frac);


                //this.stop();
            }

        };
        animFonduEntree2.play();

        final KeyFrame switchVaisseauxChoisiStart = new KeyFrame(Duration.ZERO, new KeyValue(leVaisseauxSelectionne.xProperty(), 2500));
        final KeyFrame switchvaisseauxChoisiEnd = new KeyFrame(Duration.seconds(1), new KeyValue(leVaisseauxSelectionne.xProperty(), 600));
        final Timeline timelineswitchVaisseaux = new Timeline(switchVaisseauxChoisiStart, switchvaisseauxChoisiEnd);
        timelineswitchVaisseaux.setCycleCount(1);
        timelineswitchVaisseaux.playFromStart();

        final KeyFrame switchStatsStart = new KeyFrame(Duration.ZERO, new KeyValue(statsSelectionne.xProperty(), -2500));
        final KeyFrame switchStatsEnd = new KeyFrame(Duration.seconds(1), new KeyValue(statsSelectionne.xProperty(), 80));
        final Timeline timelineswitchStatschoisi = new Timeline(switchStatsStart, switchStatsEnd);
        timelineswitchStatschoisi.setCycleCount(1);
        timelineswitchStatschoisi.playFromStart();

        final KeyFrame switchTitreStart = new KeyFrame(Duration.ZERO, new KeyValue(titreSelectionne.yProperty(), -500));
        final KeyFrame switchtitreEnd = new KeyFrame(Duration.seconds(1), new KeyValue(titreSelectionne.yProperty(), 180));
        final Timeline timelineswitchTitreChoisi = new Timeline(switchTitreStart, switchtitreEnd);
        timelineswitchTitreChoisi.setCycleCount(1);
        timelineswitchTitreChoisi.playFromStart();

    }

    private void removeVaisseauxChoisi() {

        root.getChildren().remove(leVaisseauxSelectionne);
        root.getChildren().remove(titreSelectionne);
        root.getChildren().remove(statsSelectionne);
    }

    private void removePremierVaisseauxDuRoot() {

        root.getChildren().remove(spider);
        root.getChildren().remove(stats);
        root.getChildren().remove(geoCroiseur);
    }
}
