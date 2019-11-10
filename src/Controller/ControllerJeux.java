package Controller;

import Model.*;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControllerJeux implements EventHandler<KeyEvent> {

    /**
     * Attributs du controleur du menu
     */
    private ViewHandler launcher;
    private Menu model;
    private int i = 0;
    private boolean presseRight = false;
    private boolean presseLeft = false;
    private Vaisseaux vaissJ1;
    private Vaisseaux vaissJ2;

    private int indice;
    private int indiceJ1;
    private int indiceJ2;
    double vitesseJ1;
    double vitesseJ2;
    private int vieJ1;
    private int puissanceTirJ1;
    private int vieJ2;
    private int puissanceTirJ2;

    public Vaisseaux getVaissJ1() {
        return vaissJ1;
    }

    public void setVaissJ1(Vaisseaux vaissJ1) {
        this.vaissJ1 = vaissJ1;
    }

    public Vaisseaux getVaissJ2() {
        return vaissJ2;
    }

    public void setVaissJ2(Vaisseaux vaissJ2) {
        this.vaissJ2 = vaissJ2;
    }

    /**
     * Constructeur du controleur relatif au menu principal
     *
     * @param launcher (Gestionnaire de vue)
     * @param model    (Modèle correcpondant au menu principal)
     */
    public ControllerJeux(ViewHandler launcher, Menu model) {
        this.model = model;
        this.launcher = launcher;
        this.launcher.setEventHandlerGame(this);







    }

    @Override
    public void handle(KeyEvent keyEvent) {

        indiceJ1 = launcher.getGame().getIndiVaissJ1();
        System.out.println(indiceJ1);
        indiceJ2 = launcher.getGame().getIndiVaissJ2();
        System.out.println(indiceJ2);


        if (indiceJ1 == 0) {
            VGeocroiseur j1geocroi = new VGeocroiseur();


            vitesseJ1 = j1geocroi.getVitesse();
            vieJ1 = j1geocroi.getLife();
            puissanceTirJ1 = j1geocroi.getPuissanceTir();

        } else if (indiceJ1 == 1) {
            VCorvette j1corv = new VCorvette();

            vitesseJ1 = j1corv.getVitesse();
            vieJ1 = j1corv.getLife();
            puissanceTirJ1 = j1corv.getPuissanceTir();


        } else if (indiceJ1 == 2) {
            VR22 j1R22 = new VR22();

            vitesseJ1 = j1R22.getVitesse();
            vieJ1 = j1R22.getLife();
            puissanceTirJ1 = j1R22.getPuissanceTir();


        } else if (indiceJ1 == 3) {
            VFaucon j1fauc = new VFaucon();

            vitesseJ1 = j1fauc.getVitesse();
            vieJ1 = j1fauc.getLife();
            puissanceTirJ1 = j1fauc.getPuissanceTir();


        }

        if (indiceJ2 == 0) {
            VGeocroiseur j2geocroi = new VGeocroiseur();
            vitesseJ2 = j2geocroi.getVitesse();
            vieJ2 = j2geocroi.getLife();
            puissanceTirJ2 = j2geocroi.getPuissanceTir();


        } else if (indiceJ2 == 1) {
            VCorvette j2corv = new VCorvette();
            vitesseJ2 = j2corv.getVitesse();
            vieJ2 = j2corv.getLife();
            puissanceTirJ2 = j2corv.getPuissanceTir();


        } else if (indiceJ2 == 2) {
            VR22 j2R22 = new VR22();
            vitesseJ2 = j2R22.getVitesse();
            vieJ2 = j2R22.getLife();
            puissanceTirJ2 = j2R22.getPuissanceTir();


        } else if (indiceJ2 == 3) {
            VFaucon j2fauc = new VFaucon();
            vitesseJ2 = j2fauc.getVitesse();
            vieJ2 = j2fauc.getLife();
            puissanceTirJ2 = j2fauc.getPuissanceTir();


        }













        if (keyEvent.getEventType().equals(KeyEvent.KEY_PRESSED)) {

            if (keyEvent.getCode() == KeyCode.RIGHT) {
                launcher.getGame().j2goRight(vitesseJ2);
                launcher.getGame().getTimelineGoRightJ2().playFromStart();
            }

            if (keyEvent.getCode() == KeyCode.LEFT) {
                launcher.getGame().j2goLeft(vitesseJ2);
                launcher.getGame().getTimelineGoLeftJ2().playFromStart();
            }

            if (keyEvent.getCode() == KeyCode.O) {
                launcher.getGame().tir(vieJ1, puissanceTirJ2, 2);
                System.out.println("hello tir");
            }

            if (keyEvent.getCode() == KeyCode.V) {
                launcher.getGame().tir(vieJ2, puissanceTirJ1, 1);
                System.out.println("hello tir");
            }

            if (keyEvent.getCode() == KeyCode.D) {
                launcher.getGame().j1goRight(vitesseJ1);
                launcher.getGame().getTimelineGoRightJ1().playFromStart();
            }

            if (keyEvent.getCode() == KeyCode.Q) {
                launcher.getGame().j1goLeft(vitesseJ1);
                launcher.getGame().getTimelineGoLeftJ1().playFromStart();
            }
        }


        if (keyEvent.getEventType().equals(KeyEvent.KEY_RELEASED)) {

            if (keyEvent.getCode() == KeyCode.RIGHT) {
                launcher.getGame().getTimelineGoRightJ2().stop();
                launcher.getGame().retourNormalBackJ2();
            }

            if (keyEvent.getCode() == KeyCode.LEFT) {
                launcher.getGame().getTimelineGoLeftJ2().stop();
                launcher.getGame().retourNormalBackJ2();
            }

            if (keyEvent.getCode() == KeyCode.D) {
                launcher.getGame().getTimelineGoRightJ1().stop();
                launcher.getGame().retourNormalBackJ1();
            }

            if (keyEvent.getCode() == KeyCode.Q) {
                launcher.getGame().getTimelineGoLeftJ1().stop();
                launcher.getGame().retourNormalBackJ1();
            }

        }
    }
}