package Model;

import Tools.Path;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class VFaucon extends Vaisseaux {

    private ArrayList tabImageVaiss;
    private int vitesse = 80;
    private String nomVaiss = "Red - Faucon";
    private int life = 1000;
    private int puissanceTir = 1;


    public VFaucon() {
        super();
        vitesse = 80;
        nomVaiss = "Géo-croiseur génésis t-16";
        life = 1000;
        puissanceTir = 1;
        tabImageVaiss = initArrayListVaiss();
    }

    public ArrayList initArrayListVaiss(){

        tabImageVaiss.add(new ImageView(Path.vaissJ2BackTurnLeft1));
        tabImageVaiss.add(new ImageView(Path.vaissJ2Back));
        tabImageVaiss.add(new ImageView(Path.vaissJ2Back));
        tabImageVaiss.add(new ImageView(Path.vaissJ1Back));
        tabImageVaiss.add(new ImageView(Path.stats4));
        return tabImageVaiss;
    }


    public int getVitesse() {
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
