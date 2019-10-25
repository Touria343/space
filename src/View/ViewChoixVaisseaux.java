package View;


import Controller.ControllerMenu;
import Model.Menu;
import Tools.Path;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
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
        initTextJoueur1();
        initVaisseauxChoix();
        initTextGeoCroiseur();
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

    private void initChevron() {

        chevron = new ImageView(Path.chevrongauche);
        chevron.setX(520);
        chevron.setY(755);
        chevron.setFitHeight(80);
        chevron.setFitWidth(80);
        chevron.setPreserveRatio(false);
        chevron.setOpacity(0);


    }

    private void initChevronDroit() {

        chevrondroit = new ImageView(Path.chevrondroit);
        chevrondroit.setX(850);
        chevrondroit.setY(745);
        chevrondroit.setFitHeight(80);
        chevrondroit.setFitWidth(80);
        chevrondroit.setPreserveRatio(false);
        chevrondroit.setOpacity(0);


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
        bandeBottom.setY(900);
        bandeBottom.setFitWidth(1500);
        bandeBottom.setPreserveRatio(true);
    }

    private void initBandeFond() {

        bandeFond = new ImageView(Path.bandefond);
        bandeFond.setX(0);
        bandeFond.setY(-300);
        bandeFond.setFitWidth(1500);
        bandeFond.setPreserveRatio(true);
    }

    private void initStats() {

        stats = new ImageView(Path.stats1);
        stats.setX(80);
        stats.setY(430);
        stats.setFitWidth(800);
        stats.setPreserveRatio(true);
        stats.setOpacity(0);


    }

    public void initTextJoueur1() {

        joueur1 = new Text(630, 800, "- Joueur - 1");
        joueur1.setFont(Font.font("Dead Kansas", SEMI_BOLD, 37));
        joueur1.setFill (Color.DARKRED);

        Reflection r = new Reflection();
        r.setFraction(0.7f);
        joueur1.setEffect(r);
    }

    private void initTitre() {

        titre = new Text(10, 220, "La guerre des lezards");
        Font policeTitre = Font.loadFont(getClass().getResourceAsStream(Path.fontHeadCase), 80);
        titre.setFont(policeTitre);
        titre.setRotate(-20);

    }

    private void initRetour() {

        retour = new Text(600, 600, "Retour");
        Font policeTitre = Font.loadFont(getClass().getResourceAsStream(Path.fontHeadCase), 30);

        titre.setFont(policeTitre);
        titre.setRotate(-20);

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

    /**
     * Ajoute a la vue tous les éléments composant le menu
     */
    void setVueCompleteMenu() {

        root.getChildren().clear();
        root.getChildren().add(viewer);
        root.getChildren().add(stats);
        root.getChildren().add(chevron);
        root.getChildren().add(chevrondroit);
        root.getChildren().add(bandeTop);
        root.getChildren().add(bandeBottom);
        root.getChildren().add(spider);
        root.getChildren().add(joueur1);
        root.getChildren().add(geoCroiseur);

        final Animation animTextMenuArrivee = new Transition() {
            {
                setCycleDuration(Duration.millis(1500));
            }
            protected void interpolate(double frac) {
                geoCroiseur.setOpacity(frac);
                spider.setOpacity(frac);
                chevron.setOpacity(frac);
                chevrondroit.setOpacity(frac);
            }
        };
        
        final Animation animTextMenucligno = new Transition() {
            {
                setCycleDuration(Duration.millis(1500));
            }
            protected void interpolate(double frac) {
                double fracnegatif = 0 - frac;
                geoCroiseur.setOpacity(fracnegatif);
                spider.setOpacity(fracnegatif);
            }
        };

        final Animation animTextMenu = new Transition() {
            {
                setCycleDuration(Duration.millis(3000));
            }
            protected void interpolate(double frac) {
                stats.setOpacity(1);
                chevron.setOpacity(frac);
                chevrondroit.setOpacity(frac);
            }
        };

        animTextMenu.play();

        animTextMenuArrivee.play();


    }

    void setEvents(ControllerMenu mc) {
      chevron.setOnMouseClicked(mc);
        chevrondroit.setOnMouseClicked(mc);



        //monLezard.setOnMouseClicked(mc);
        //spider.setOnMouseEntered(mc);

    }

    public Text getTitre() {
        return titre;
    }

    public ImageView getChevron() {
        return chevron;
    }

    public ImageView getChevrondroit() {
        return chevrondroit;
    }
    public ImageView ViewChoixVaisseaux() {
        return spider;
    }


    public void setRandomColorForTitle() {
        titre.setFill(new Color(Math.random(), Math.random(), Math.random(), Math.random()));
    }

    public void grandissementChevron(){


        chevron.setFitHeight(100);
        chevron.setFitWidth(100);
        chevrondroit.setFitHeight(100);
        chevrondroit.setFitWidth(100);


    /*    final Animation animTextMenucligno = new Transition() {
            {
                setCycleDuration(Duration.millis(500));
            }
            protected void interpolate(double frac) {

            }
        };
*/



    }


}
