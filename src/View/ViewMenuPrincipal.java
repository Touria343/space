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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;


public class ViewMenuPrincipal {

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
    private Text choixVaiss;
    private Text quitter;
    private Text jouer;
    private ImageView triangle;
    private ImageView triangle1;

    /**
     * Constructeur du menu principal
     *
     * @param model (Modèle correspondant au menu)
     * @param root  (Groupe principal de la vue)
     */
    ViewMenuPrincipal(Menu model, Group root) {
        this.root = root;
        this.model = model;

      //  initListeImage();

      initBackground();
        initTextChoixVaisseaux();
        initTextJouer();
        initTexteQuitter();
        initTriangle();
        initTriangle1();
       // initVaisseauxCoin();
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

    private void initTexteQuitter() {
        quitter = new Text(1000, 850, "- Quitter  -");
        quitter.setFont(Font.font("Dead Kansas", 35));
        quitter.setFill (Color.WHITE);
        quitter.setOpacity(0);
    }

   private void initVaisseauxCoin() {
        spider = new ImageView(Path.vaisseauxChoix1);
        spider.setRotate(-6);
        spider.setX(-250);
        spider.setY(-300);
        spider.setFitWidth(900);
        spider.setFitHeight(900);

    }

    private void initTextChoixVaisseaux(){

        choixVaiss = new Text(554, 850, "- Choix des vaisseaux  -");
        choixVaiss.setFont(Font.font("Dead Kansas", 35));
        choixVaiss.setFill (Color.WHITE);
        choixVaiss.setOpacity(0);

    }


private void initTextJouer(){

    jouer = new Text(300, 850, "- Jouer -");
    jouer.setFont(Font.font("Dead Kansas", 35));
    jouer.setFill (Color.WHITE);
    jouer.setOpacity(0);


}

    private void initTriangle() {
        triangle = new ImageView(Path.triangle);
        triangle.setRotate(-110);
        triangle.setX(-150);
        triangle.setY(-550);
        triangle.setFitWidth(600);
        triangle.setFitHeight(800);
        triangle.setOpacity(0.95);
    }

    private void initTriangle1() {
        triangle1 = new ImageView(Path.triangle1);
        triangle1.setRotate(-290);
        triangle1.setX(1000);
        triangle1.setY(800);
        triangle1.setFitWidth(900);
        triangle1.setFitHeight(900);
        triangle1.setOpacity(0.7);
    }

    private void initTitre() {
        titre = new Text(10, 220, "La guerre des lezards");
        Font policeTitre = Font.loadFont(getClass().getResourceAsStream(Path.fontHeadCase), 80);
        titre.setFont(policeTitre);
        titre.setRotate(-20);
    }




    /**
     * Mise en place de l'image de fond en fonction de la taille de l'écran de l'utilisateur
     */

    private void initBackground() {
        //imgBg = new ImageView("Asset/Images/fond_menu.jpg");
      //  Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran
       // imgBg.setFitHeight((int) primaryScreenBounds.getHeight());
       // imgBg.setFitWidth((int) primaryScreenBounds.getWidth());

     /*   videoBackground = new MediaPlayer(new Media(this.getClass().getResource(Path.videobackground1).toExternalForm()));

        videoBackground.setAutoPlay(true);

        media.setMediaPlayer(videoBackground);

       media.setFitHeight((int) primaryScreenBounds.getHeight());
        media.setFitWidth((int) primaryScreenBounds.getWidth());
*/
        videoBackground = new MediaPlayer(new Media(this.getClass().getResource(Path.videobackground1).toExternalForm()));

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
      //root.getChildren().add(imgBg);
      //root.getChildren().add(media);

        root.getChildren().add(viewer);

        root.getChildren().add(jouer);
        root.getChildren().add(quitter);

        root.getChildren().add(choixVaiss);


        final Animation animTextMenuArrivee = new Transition() {
            {
                setCycleDuration(Duration.millis(8000));
            }

            protected void interpolate(double frac) {

                jouer.setOpacity(frac);
                choixVaiss.setOpacity(frac);
                quitter.setOpacity(frac);

               //this.stop();
            }

        };

        animTextMenuArrivee.play();




        root.getChildren().add(triangle);
        root.getChildren().add(triangle1);

        //root.getChildren().add(titre);
      //root.getChildren().add(monLezard);
       //root.getChildren().add(spider);
    }

    void setEvents(ControllerMenu mc) {
      choixVaiss.setOnMouseClicked(mc);
        jouer.setOnMouseClicked(mc);
        quitter.setOnMouseClicked(mc);


        //monLezard.setOnMouseClicked(mc);
      //spider.setOnMouseEntered(mc);

    }

    public Text getTitre() {
        return titre;
    }

    public Text getChoixVaiss() {
        return choixVaiss;
    }

    public Text getJouer() {
        return jouer;
    }

    public Text getQuitter() {
        return quitter;
    }

    public void setRandomColorForTitle() {
        titre.setFill(new Color(Math.random(), Math.random(), Math.random(), Math.random()));

    }


    }
