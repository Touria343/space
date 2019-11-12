package Model;

import Tools.Path;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class VGeocroiseur extends Vaisseaux{

    private double vitesse ;
    private String nomVaiss;
    private int life;
    private int puissanceTir;
    private  ArrayList<Image> tabImageVaissBack = new ArrayList<Image>();
    private ArrayList <Image> tabImageVaissFace = new ArrayList<Image>();


    public VGeocroiseur() {
        super();
        vitesse = 0.8;
        nomVaiss = "Géo-croiseur génésis t-16";
        life = 1700;
        puissanceTir = 2;
        tabImageVaissBack = initArrayListVaissBack();
        tabImageVaissFace = initArrayListVaissFace();

    }

    public ArrayList initArrayListVaissBack(){

        tabImageVaissBack.add(new Image(Path.croiBG3));
        tabImageVaissBack.add(new Image(Path.croiBG2));
        tabImageVaissBack.add(new Image(Path.croiBG1));
        tabImageVaissBack.add(new Image(Path.croiB));
        tabImageVaissBack.add(new Image(Path.croiBD1));
        tabImageVaissBack.add(new Image(Path.croiBD2));
        tabImageVaissBack.add(new Image(Path.croiBD3));
        return tabImageVaissBack;
    }

    public ArrayList<Image> getTabImageVaissFace() {
        return tabImageVaissFace;
    }

    public ArrayList initArrayListVaissFace() {

        tabImageVaissFace.add(new Image(Path.croiFG3));
        tabImageVaissFace.add(new Image(Path.croiFG2));
        tabImageVaissFace.add(new Image(Path.croiFG1));
        tabImageVaissFace.add(new Image(Path.croiF));
        tabImageVaissFace.add(new Image(Path.croiFD1));
        tabImageVaissFace.add(new Image(Path.croiFD2));
        tabImageVaissFace.add(new Image(Path.croiFD3));

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

    public void setTabImageVaissBack(ArrayList tabImageVaissBack) {
        this.tabImageVaissBack = tabImageVaissBack;
    }

}
