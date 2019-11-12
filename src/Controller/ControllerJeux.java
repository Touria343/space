package Controller;

import Model.*;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControllerJeux implements EventHandler<KeyEvent> {

    private VR22 vaissJoueur1r22;
    private VGeocroiseur vaissJoueur2geo;
    private VFaucon vaissJoueur1fauc;
    private VCorvette vaissJoueur2corv;
    private VR22 vaissJoueur2r22;
    private VFaucon vaissJoueur2fauc;
    private VGeocroiseur vaissJoueur1geo;
    private VCorvette vaissJoueur1corv;
    /**
     * Attributs du controleur du menu
     */
    private ViewHandler launcher;
    private Menu model;
    private int i = 0;
    private boolean presseRightJ2 = false;
    private boolean presseLeftJ2 = false;
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
    private boolean presseRightJ1 = false;
    private boolean presseLeftJ1 = false;

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
    public ControllerJeux(ViewHandler launcher, Menu model, VGeocroiseur geocJ1, VR22 r22J1, VCorvette corvJ1, VFaucon faucJ1, VGeocroiseur geocJ2, VR22 r22J2, VCorvette corvJ2, VFaucon faucJ2) {
        this.model = model;
        this.launcher = launcher;
        this.launcher.setEventHandlerGame(this);
        vaissJoueur1geo = new VGeocroiseur();
        this.vaissJoueur1geo = geocJ1;

        vaissJoueur1corv = new VCorvette();
        this.vaissJoueur1corv = corvJ1;
        vaissJoueur1r22 = new VR22();
        this.vaissJoueur1r22 = r22J1;
        vaissJoueur1fauc = new VFaucon();
        this.vaissJoueur1fauc = faucJ1;

        vaissJoueur2geo = new VGeocroiseur();
        this.vaissJoueur2geo = geocJ2;
        vaissJoueur2corv = new VCorvette();
        this.vaissJoueur2corv = corvJ2;
        vaissJoueur2r22 = new VR22();
        this.vaissJoueur2r22 = r22J2;
        vaissJoueur2fauc = new VFaucon();
        this.vaissJoueur2fauc = faucJ2;

    }

    @Override
    public void handle(KeyEvent keyEvent) {

        indiceJ1 = launcher.getGame().getIndiVaissJ1();
        System.out.println(indiceJ1);
        indiceJ2 = launcher.getGame().getIndiVaissJ2();
        System.out.println(indiceJ2);

        if (indiceJ1 == 0) {
            vitesseJ1 = vaissJoueur1geo.getVitesse();
            vieJ1 = vaissJoueur1geo.getLife();
            puissanceTirJ1 = vaissJoueur1geo.getPuissanceTir();

        } else if (indiceJ1 == 1) {
            vitesseJ1 = vaissJoueur1corv.getVitesse();
            vieJ1 = vaissJoueur1corv.getLife();
            puissanceTirJ1 = vaissJoueur1corv.getPuissanceTir();
        } else if (indiceJ1 == 2) {
            vitesseJ1 = vaissJoueur1r22.getVitesse();
            vieJ1 = vaissJoueur1r22.getLife();
            puissanceTirJ1 = vaissJoueur1r22.getPuissanceTir();

        } else if (indiceJ1 == 3) {
            vitesseJ1 = vaissJoueur1fauc.getVitesse();
            vieJ1 = vaissJoueur1fauc.getLife();
            puissanceTirJ1 = vaissJoueur1fauc.getPuissanceTir();
        }

        if (indiceJ2 == 0) {
            vitesseJ2 = vaissJoueur2geo.getVitesse();
            vieJ2 = vaissJoueur2geo.getLife();
            puissanceTirJ2 = vaissJoueur2geo.getPuissanceTir();

        } else if (indiceJ2 == 1) {
            vitesseJ2 = vaissJoueur2corv.getVitesse();
            vieJ2 = vaissJoueur2corv.getLife();
            puissanceTirJ2 = vaissJoueur2corv.getPuissanceTir();

        } else if (indiceJ2 == 2) {
            vitesseJ2 = vaissJoueur2r22.getVitesse();
            vieJ2 = vaissJoueur2r22.getLife();
            puissanceTirJ2 = vaissJoueur2r22.getPuissanceTir();

        } else if (indiceJ2 == 3) {
            vitesseJ2 = vaissJoueur2fauc.getVitesse();
            vieJ2 = vaissJoueur2r22.getLife();
            puissanceTirJ2 = vaissJoueur2r22.getPuissanceTir();
        }

        if (keyEvent.getEventType().equals(KeyEvent.KEY_PRESSED)) {
            if (launcher.getGame().getViejoueur1() > 0 && launcher.getGame().getViejoueur2() > 0 ) {
                if (keyEvent.getCode() == KeyCode.RIGHT) {
                    if (presseRightJ2 == false) {
                        launcher.getGame().j2goRight(vitesseJ2);
                        launcher.getGame().getTimelineGoRightJ2().playFromStart();
                        presseRightJ2 = true;
                    }
                }

                if (keyEvent.getCode() == KeyCode.LEFT) {
                    if (presseLeftJ2 == false) {
                        launcher.getGame().j2goLeft(vitesseJ2);
                        launcher.getGame().getTimelineGoLeftJ2().playFromStart();
                        presseLeftJ2 = true;
                    }
                }


                if (keyEvent.getCode() == KeyCode.D) {
                    if (presseRightJ1 == false) {
                        launcher.getGame().j1goRight(vitesseJ1);
                        launcher.getGame().getTimelineGoRightJ1().playFromStart();
                        presseRightJ1 = true;
                    }
                }

                if (keyEvent.getCode() == KeyCode.Q) {
                    if (presseLeftJ1 == false) {
                        launcher.getGame().j1goLeft(vitesseJ1);
                        launcher.getGame().getTimelineGoLeftJ1().playFromStart();
                        presseLeftJ1 = true;
                    }
                }

                if (keyEvent.getCode() == KeyCode.O) {
                    launcher.getGame().tir(vieJ1, puissanceTirJ2, 2);
                }

                if (keyEvent.getCode() == KeyCode.V) {
                    launcher.getGame().tir(vieJ2, puissanceTirJ1, 1);
                }

            }
        }


        if (keyEvent.getEventType().equals(KeyEvent.KEY_RELEASED)) {
            if (launcher.getGame().getViejoueur1() > 0 && launcher.getGame().getViejoueur2() > 0 ) {

                if (keyEvent.getCode() == KeyCode.RIGHT) {

                    launcher.getGame().getTimelineGoRightJ2().stop();
                    launcher.getGame().retourNormalBackJ2();
                    launcher.getGame().retourNormalFrontJ2();

                    presseRightJ2 = false;
                }

                if (keyEvent.getCode() == KeyCode.LEFT) {

                    launcher.getGame().getTimelineGoLeftJ2().stop();
                    launcher.getGame().retourNormalBackJ2();
                    launcher.getGame().retourNormalFrontJ2();

                    presseLeftJ2 = false;
                }

                if (keyEvent.getCode() == KeyCode.D) {

                    launcher.getGame().getTimelineGoRightJ1().stop();
                    launcher.getGame().retourNormalBackJ1();
                    launcher.getGame().retourNormalFrontJ1();

                    presseRightJ1 = false;
                }

                if (keyEvent.getCode() == KeyCode.Q) {

                    launcher.getGame().getTimelineGoLeftJ1().stop();
                    launcher.getGame().retourNormalBackJ1();
                    launcher.getGame().retourNormalFrontJ1();

                    presseLeftJ1 = false;


                }
            }
        }
    }
}