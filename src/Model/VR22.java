package Model;

public class VR22 extends Vaisseaux {

    private int vitesse = 100;
    private String nomVaiss = "Géo-croiseur génésis t-16";
    private int life = 800;
    private int puissanceTir = 1;

    VR22(int vitesse, String nomVaiss, int life, int puissanceTir) {
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
