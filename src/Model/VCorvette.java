package Model;

import Tools.Path;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class VCorvette extends Vaisseaux {

    private double vitesse;
    private String nomVaiss;
    private int life;
    private int puissanceTir;
    private  ArrayList<Image> tabImageVaiss = new ArrayList<Image>();



    public VCorvette() {

        super();
        vitesse = 1;
        nomVaiss = "Touria Corvette -9";
        life = 2000;
        puissanceTir = 2;
        tabImageVaiss = initArrayListVaiss();

    }

    public ArrayList initArrayListVaiss() {

        tabImageVaiss.add(new Image(Path.corvetteBG3));
        tabImageVaiss.add(new Image(Path.corvetteBG2));
        tabImageVaiss.add(new Image(Path.corvetteBG1));
        tabImageVaiss.add(new Image(Path.corvetteB));
        tabImageVaiss.add(new Image(Path.corvetteBD1));
        tabImageVaiss.add(new Image(Path.corvetteBD2));
        tabImageVaiss.add(new Image(Path.corvetteBD3));

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
