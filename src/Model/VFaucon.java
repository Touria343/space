package Model;

import Tools.Path;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class VFaucon extends Vaisseaux {

    private  ArrayList<Image> tabImageVaissBack = new ArrayList<Image>();

    private double vitesse = 0.7;
    private String nomVaiss = "Red - Faucon";
    private int life = 1000;
    private int puissanceTir = 1;
    private ArrayList <Image> tabImageVaissFace = new ArrayList<Image>();


    public VFaucon() {
        super();
        vitesse = 0.7;
        nomVaiss = "Géo-croiseur génésis t-16";
        life = 1000;
        puissanceTir = 1;
        tabImageVaissBack = initArrayListVaissBack();
        tabImageVaissFace = initArrayListVaissFace();

    }

    public ArrayList<Image> getTabImageVaissFace() {
        return tabImageVaissFace;
    }

    public ArrayList initArrayListVaissBack(){

        tabImageVaissBack.add(new Image(Path.redBG3));
        tabImageVaissBack.add(new Image(Path.redBG2));
        tabImageVaissBack.add(new Image(Path.redBG1));
        tabImageVaissBack.add(new Image(Path.redB));
        tabImageVaissBack.add(new Image(Path.redBD1));
        tabImageVaissBack.add(new Image(Path.redBD2));
        tabImageVaissBack.add(new Image(Path.redBD3));
        return tabImageVaissBack;
    }

    public ArrayList initArrayListVaissFace() {

        tabImageVaissFace.add(new Image(Path.redFG3));
        tabImageVaissFace.add(new Image(Path.redFG2));
        tabImageVaissFace.add(new Image(Path.redFG1));
        tabImageVaissFace.add(new Image(Path.redF));
        tabImageVaissFace.add(new Image(Path.redFD1));
        tabImageVaissFace.add(new Image(Path.redFD2));
        tabImageVaissFace.add(new Image(Path.redFD3));

        return tabImageVaissFace;
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

    public ArrayList getTabImageVaissBack() {
        return tabImageVaissBack;
    }

}
