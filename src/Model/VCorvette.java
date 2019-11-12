package Model;

import Tools.Path;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class VCorvette extends Vaisseaux {

    private double vitesse;
    private String nomVaiss;
    private int life;
    private int puissanceTir;
    private  ArrayList<Image> tabImageVaissBack = new ArrayList<Image>();
    private ArrayList<Image> tabImageVaissFace = new ArrayList<Image>();


    public VCorvette() {

        super();
        vitesse = 1;
        nomVaiss = "Touria Corvette -9";
        life = 2000;
        puissanceTir = 2;
        tabImageVaissBack = initArrayListVaissBack();
        tabImageVaissFace = initArrayListVaissFace();


    }

    public ArrayList<Image> getTabImageVaissFace() {
        return tabImageVaissFace;
    }

    public ArrayList initArrayListVaissBack() {

        tabImageVaissBack.add(new Image(Path.corvetteBG3));
        tabImageVaissBack.add(new Image(Path.corvetteBG2));
        tabImageVaissBack.add(new Image(Path.corvetteBG1));
        tabImageVaissBack.add(new Image(Path.corvetteB));
        tabImageVaissBack.add(new Image(Path.corvetteBD1));
        tabImageVaissBack.add(new Image(Path.corvetteBD2));
        tabImageVaissBack.add(new Image(Path.corvetteBD3));

        return tabImageVaissBack;
    }

    public ArrayList initArrayListVaissFace() {

        tabImageVaissFace.add(new Image(Path.corvetteFG3));
        tabImageVaissFace.add(new Image(Path.corvetteFG2));
        tabImageVaissFace.add(new Image(Path.corvetteFG1));
        tabImageVaissFace.add(new Image(Path.corvetteF));
        tabImageVaissFace.add(new Image(Path.corvetteFD1));
        tabImageVaissFace.add(new Image(Path.corvetteFD2));
        tabImageVaissFace.add(new Image(Path.corvetteFD3));

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
