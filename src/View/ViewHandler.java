package View;

import Controller.ControllerJeux;
import Controller.ControllerMenu;
import Model.Menu;
import Music.MusicJeux;
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
    private ViewGame game;
    private ControllerJeux controllerJeux;


    public Scene getMenuDemarrage() {
        return menuDemarrage;
    }

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
        mo = new ViewChoixVaisseaux(model, root);
        game = new ViewGame(model, root);



        controllerMenu = new ControllerMenu(this, model);
        controllerJeux = new ControllerJeux(this, model);

        MusicJeux.startMainMenuMusic();
        afficherMenuPrincipal(true);
        //afficherGame();
        // gestion de l'affichage au lancement
        primaryStage.setScene(menuDemarrage);
        //primaryStage.show();
        //   primaryStage.setFullScreenExitHint("");
        primaryStage.setResizable(true);
        primaryStage.setMaxHeight(980);
        primaryStage.setMaxWidth(1520);
        primaryStage.setFullScreen(true);
        // primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    public void afficherMenuPrincipal(Boolean reloadMusic) {

        mp.setVueCompleteMenu();

    }

    public void setEventHandlerMenu(ControllerMenu cm) {
        mp.setEvents(cm);
        mo.setEvents(cm);
        // game.setEvents(cm);

    }

    public void setEventHandlerGame(ControllerJeux cj) {

        game.setEvents(cj);

    }

    public void afficherOption() {
    }


    public void goQuitter() {
        System.exit(0);
    }

    // GETTERS AND SETTERS
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ViewMenuPrincipal getMp() {
        return mp;
    }

    public ViewGame getGame() {
        return game;
    }

    public ViewChoixVaisseaux getMo() {
        return mo;
    }

    public void afficherJeux() {
        mo.setVueCompleteMenu();
    }

    public void afficherGame(int indiceVaissJ1, int indiceVaissJ2) {
        game.setVueCompleteMenu(indiceVaissJ1, indiceVaissJ2);
    }


}
