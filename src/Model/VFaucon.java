package Model;

import Tools.Path;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class VFaucon extends Vaisseaux {

    private  ArrayList<ImageView> tabImageVaiss = new ArrayList<ImageView>();

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

        tabImageVaiss.add(new ImageView(Path.redBG3));
        tabImageVaiss.add(new ImageView(Path.redBG2));
        tabImageVaiss.add(new ImageView(Path.redBG1));
        tabImageVaiss.add(new ImageView(Path.redB));
        tabImageVaiss.add(new ImageView(Path.redBD1));
        tabImageVaiss.add(new ImageView(Path.redBD2));
        tabImageVaiss.add(new ImageView(Path.redBD3));
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
