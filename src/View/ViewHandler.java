package View;

import Controller.ControllerMenu;
import Model.Menu;
import Tools.Path;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.Media;

public class ViewHandler extends Application {
    private Stage primaryStage;
    private ViewMenuPrincipal mp;
    private ViewChoixVaisseaux mo;
    private Menu model;
    private ControllerMenu controllerMenu;
    private String Dir = System.getProperty("user.dir");
    private MediaPlayer videoBackground;
    private Button btn;
    private Button btn2, btn3, btn4;
    private Scene scene, scene2;
    private Text t;
    private ImageView img1;
    private Stage stage;
    private MediaPlayer music;
    private MediaView viewer;
    private Group root;
    private Scene menuDemarrage;


    /**
     * Permet le lancement de l'application : méthode obligatoire pour JavaFX
     *
     * @param primaryStage ()
     * @throws Exception ()
     */

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        // root représente le panel qui va être affiché : tout ce qui doit être affiché doit lui être ajouté
        root = new Group();
        menuDemarrage = new Scene(root, Color.BLACK);

        model = new Menu();

        mp = new ViewMenuPrincipal(model, root);

        controllerMenu = new ControllerMenu(this, model);

        music = new MediaPlayer(new Media(this.getClass().getResource(Path.son).toExternalForm()));
        music.setAutoPlay(true);
        viewer = new MediaView(music);
        music.play();
        // gestion de l'affichage au lancement
        primaryStage.setScene(menuDemarrage);
        primaryStage.show();
     //   primaryStage.setFullScreenExitHint("");
        primaryStage.setResizable(true);
        primaryStage.setMaxHeight(980);
        primaryStage.setMaxWidth(1520);
        primaryStage.setFullScreen(true);
        // primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    private Button initButton(int longeur, int largeur, String texteDuBouton) {
        Button b = new Button();
        b.setLayoutX(longeur);
        b.setLayoutY(largeur);
        b.setText(texteDuBouton);
        return b;
    }


    public void setEventHandlerMenu(ControllerMenu cm) {
        mp.setEvents(cm);
    }


    public void setOption() {
        mo = new ViewChoixVaisseaux(model, root);
        controllerMenu = new ControllerMenu(this, model);
    }

    public void setJeux() {
        mo = new ViewChoixVaisseaux(model, root);
        controllerMenu = new ControllerMenu(this, model);
    }

    public void setQuitter() {
        System.exit(0);
    }

    // GETTERS AND SETTERS
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ViewMenuPrincipal getMp() {
        return mp;
    }

    public ViewChoixVaisseaux getMo() {
        return mo;
    }

}
