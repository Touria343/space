package Model;

public class VFaucon extends Vaisseaux {

    private int vitesse = 80;
    private String nomVaiss = "Red - Faucon";
    private int life = 1000;
    private int puissanceTir = 1;

    public VFaucon() {
        super();
        thisvitesse = vitesse;
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
