package Model;

import Tools.Path;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class VFaucon extends Vaisseaux {

    private  ArrayList<Image> tabImageVaiss = new ArrayList<Image>();

    private double vitesse = 0.7;
    private String nomVaiss = "Red - Faucon";
    private int life = 1000;
    private int puissanceTir = 1;


    public VFaucon() {
        super();
        vitesse = 0.7;
        nomVaiss = "Géo-croiseur génésis t-16";
        life = 1000;
        puissanceTir = 1;
        tabImageVaiss = initArrayListVaiss();
    }

    public ArrayList initArrayListVaiss(){

        tabImageVaiss.add(new Image(Path.redBG3));
        tabImageVaiss.add(new Image(Path.redBG2));
        tabImageVaiss.add(new Image(Path.redBG1));
        tabImageVaiss.add(new Image(Path.redB));
        tabImageVaiss.add(new Image(Path.redBD1));
        tabImageVaiss.add(new Image(Path.redBD2));
        tabImageVaiss.add(new Image(Path.redBD3));
        return tabImageVaiss;
    }


    public double getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public String getNomVaiss() {
        return nomVaiss;
    }

    public void setNomVaiss(String nomVaiss) {
        this.nomVaiss = nomVaiss;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getPuissanceTir() {
        return puissanceTir;
    }

    public void setPuissanceTir(int puissanceTir) {
        this.puissanceTir = puissanceTir;
    }

    public ArrayList getTabImageVaiss() {
        return tabImageVaiss;
    }

}
