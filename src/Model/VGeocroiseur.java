package Model;

public class VGeocroiseur extends Vaisseaux{

    private int vitesse = 60;
    private String nomVaiss = "Géo-croiseur génésis t-16";
    private int life = 1700;
    private int puissanceTir = 2;


    VGeocroiseur(int vitesse, String nomVaiss, int life, int puissanceTir) {
        super();
        this.vitesse = vitesse;
        this.nomVaiss = nomVaiss;
        this.life = life;
        this.puissanceTir = puissanceTir;
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
}
