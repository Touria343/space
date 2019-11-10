package Model;

import Tools.Path;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class VR22 extends Vaisseaux {



    private double vitesse;
    private String nomVaiss;
    private int life;
    private int puissanceTir;
    private  ArrayList<Image> tabImageVaiss = new ArrayList<Image>();


    public VR22() {
        super();
        vitesse = 0.5;
        nomVaiss = "Géo-croiseur génésis t-16";
        life = 800;
        puissanceTir = 1;
        tabImageVaiss = initArrayListVaiss();
    }

    public ArrayList initArrayListVaiss(){

        tabImageVaiss.add(new Image(Path.r22BG3));
        tabImageVaiss.add(new Image(Path.r22BG2));
        tabImageVaiss.add(new Image(Path.r22BG1));
        tabImageVaiss.add(new Image(Path.r22B));
        tabImageVaiss.add(new Image(Path.r22BD1));
        tabImageVaiss.add(new Image(Path.r22BD2));
        tabImageVaiss.add(new Image(Path.r22BD3));
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
    public void setTabImageVaiss(ArrayList tabImageVaiss) {
        this.tabImageVaiss = tabImageVaiss;
    }
}
