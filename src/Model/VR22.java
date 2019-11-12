package Model;

import Tools.Path;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class VR22 extends Vaisseaux {



    private double vitesse;
    private String nomVaiss;
    private int life;
    private int puissanceTir;
    private  ArrayList<Image> tabImageVaissBack = new ArrayList<Image>();
    private  ArrayList<Image> tabImageVaissFace = new ArrayList<Image>();


    public VR22() {
        super();
        vitesse = 0.5;
        nomVaiss = "Géo-croiseur génésis t-16";
        life = 800;
        puissanceTir = 1;
        tabImageVaissBack = initArrayListVaissBack();
        tabImageVaissFace = initArrayListVaissFace();

    }

    public ArrayList initArrayListVaissBack(){

        tabImageVaissBack.add(new Image(Path.r22BG3));
        tabImageVaissBack.add(new Image(Path.r22BG2));
        tabImageVaissBack.add(new Image(Path.r22BG1));
        tabImageVaissBack.add(new Image(Path.r22B));
        tabImageVaissBack.add(new Image(Path.r22BD1));
        tabImageVaissBack.add(new Image(Path.r22BD2));
        tabImageVaissBack.add(new Image(Path.r22BD3));
        return tabImageVaissBack;
    }

    public ArrayList initArrayListVaissFace() {

        tabImageVaissFace.add(new Image(Path.r22FG3));
        tabImageVaissFace.add(new Image(Path.r22FG2));
        tabImageVaissFace.add(new Image(Path.r22FG1));
        tabImageVaissFace.add(new Image(Path.r22F));
        tabImageVaissFace.add(new Image(Path.r22FD1));
        tabImageVaissFace.add(new Image(Path.r22FD2));
        tabImageVaissFace.add(new Image(Path.r22FD3));

        return tabImageVaissFace;
    }

    public ArrayList<Image> getTabImageVaissFace() {
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
