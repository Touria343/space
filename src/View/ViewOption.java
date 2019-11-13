package View;

import Controller.ControllerMenu;
import Model.Menu;
import Tools.Path;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;



public class ViewOption {

    private Text titre;
    private Text volume;
    private Menu model;
    private ImageView planete;
    private ImageView speaker;



    private Group root;


    ViewOption(Menu model, Group root) {
        this.root = root;
        this.model = model;

        initTitre();
        initBackground();
        initBackground1();
        initTitre1();

        setVueCompleteMenu();

    }


    private void initTitre() {
        titre = new Text(50, 240, "- E  f  f  e  t \n S  p  é  c  i  a  u  x -");
        Font policeTitre = Font.loadFont(getClass().getResourceAsStream(Path.fontMotionPicture), 80);
        titre.setFont(policeTitre);
        titre.setFill (Color.WHITE);


    }

    private void initTitre1() {
        volume = new Text(800, 670, "- Volume -");
        Font policeTitre = Font.loadFont(getClass().getResourceAsStream(Path.fontMotionPicture), 50);
        volume.setFont(policeTitre);
        volume.setFill (Color.WHITE);


    }

    private void initBackground() {
        planete = new ImageView("Asset//Images//planete.png");
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds();
        planete.setFitHeight((int) primaryScreenBounds.getHeight());
        planete.setFitWidth((int) primaryScreenBounds.getWidth());



    }

    private void initBackground1() {
        speaker = new ImageView("Asset//Images//speaker.gif");
        speaker.setFitWidth(120);
        speaker.setY(800);
        speaker.setX(100);
        speaker.setFitHeight(120);
        speaker.setOpacity(0.95);

    }


    void setVueCompleteMenu() {
        root.getChildren().clear();
        root.getChildren().add(planete);
        root.getChildren().add(speaker);
        root.getChildren().add(titre);
        root.getChildren().add(volume);


    }

    void setEvents(ControllerMenu mc) {
        titre.setOnMouseEntered(mc);

    }

    public Text getTitre() {
        return titre;
    }


    public void setRandomColorForTitle() {
        titre.setFill(new Color(Math.random(), Math.random(), Math.random(), Math.random()));
    }
}










