package Model;

public class VCorvette extends Vaisseaux {

    private int vitesse = 40;
    private String nomVaiss = "Touria Corvette -9";
    private int life = 2000;
    private int puissanceTir = 2;


    VCorvette(int vitesse, String nomVaiss, int life, int puissanceTir) {
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
