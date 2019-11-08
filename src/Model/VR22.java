package Model;

import Tools.Path;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class VR22 extends Vaisseaux {



    private int vitesse;
    private String nomVaiss;
    private int life;
    private int puissanceTir;
    private ArrayList tabImageVaiss;


    public VR22() {
        super();
        vitesse = 100;
        nomVaiss = "Géo-croiseur génésis t-16";
        life = 800;
        puissanceTir = 1;
        tabImageVaiss = initArrayListVaiss();
    }

    public ArrayList initArrayListVaiss(){

        tabImageVaiss.add(new ImageView(Path.vaissJ2BackTurnLeft1));
        tabImageVaiss.add(new ImageView(Path.vaissJ2Back));
        tabImageVaiss.add(new ImageView(Path.vaissJ1Back));
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
    public void setTabImageVaiss(ArrayList tabImageVaiss) {
        this.tabImageVaiss = tabImageVaiss;
    }
}
