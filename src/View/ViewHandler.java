package View;

import Controller.ControllerMenu;
import Model.Menu;
import Tools.Path;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import java.nio.file.Paths;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.stage.StageStyle;

import static javafx.scene.text.FontWeight.*;

public class ViewHandler extends Application {
    private Stage primaryStage;
    private ViewMenuPrincipal mp;
    private ViewMenuOptions mo;
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
        Group root = new Group();
        Scene menuDemarrage = new Scene(root, Color.BLACK);

        model = new Menu();

        mp = new ViewMenuPrincipal(model, root);
        controllerMenu = new ControllerMenu(this, model);

        Group root2 = new Group();
        scene2 = new Scene(root2, Color.WHITE);

        Menu model = new Menu();
        mo = new ViewMenuOptions(model, root2);

        music = new MediaPlayer(new Media(this.getClass().getResource(Path.son).toExternalForm()));
        music.setAutoPlay(true);
        viewer = new MediaView(music);
        music.play();

        //  geoCroiseur.setEffect(ds);

        //  geoCroiseur.setEffect(is);


        /*

           choixVaiss.setOnMousePressed(mouseEvent -> {



           primaryStage.setScene(scene2);
           primaryStage.setFullScreen(true);

});*/
        // composition des scènes


        // gestion de l'affichage au lancement
        primaryStage.setScene(menuDemarrage);
        primaryStage.show();
        primaryStage.setFullScreenExitHint("");
        primaryStage.setScene(menuDemarrage);
        primaryStage.setResizable(true);

        primaryStage.setMaxHeight(980);
        primaryStage.setMaxWidth(1520);

        primaryStage.setFullScreen(true);
        // primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.show();


    }

    private Button initButton(int longeur, int largeur, String texteDuBouton) {

        // Création d'un bouton
        Button b = new Button();
        b.setLayoutX(longeur);
        b.setLayoutY(largeur);
        b.setText(texteDuBouton);
        return b;
        //set the Scene
        //Scene scenes = new Scene(root2, 500, 500, Color.BLACK);
    }

    public void setEventHandlerMenu(ControllerMenu cm) {
        mp.setEvents(cm);
    }

    public void setOption() {

        primaryStage.setScene(scene2);
        primaryStage.setFullScreen(true);

    }

    public void setJeux() {

        primaryStage.setScene(scene2);
        primaryStage.setFullScreen(true);

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
}
