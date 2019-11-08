package Controller;

import Model.*;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControllerJeux implements EventHandler<KeyEvent> {

    private Vaisseaux vaissJ1;
    private Vaisseaux vaissJ2;
    /**
     * Attributs du controleur du menu
     */
    private ViewHandler launcher;
    private Menu model;
    private int i = 0;
    private boolean presseRight = false;
    private boolean presseLeft = false;
    private int vaissJ1;
    private int vaissJ2;
    private int indice;
    private int indiceJ1;
    private int indiceJ2;

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
        indiceJ2 = launcher.getGame().getIndiVaissJ2();

        if (indiceJ1 == 0) {
            setVaissJ1((VGeocroiseur) launcher.getGame().getVaissJ1Obj());
        } else if (indiceJ1 == 1) {
            setVaissJ1((VCorvette) launcher.getGame().getVaissJ1Obj());
        } else if (indiceJ1 == 2) {
            setVaissJ1((VR22) launcher.getGame().getVaissJ1Obj());
        } else if (indiceJ1 == 3) {
            setVaissJ1((VFaucon) launcher.getGame().getVaissJ1Obj());
        }

        if (indiceJ2 == 0) {
            setVaissJ2((VGeocroiseur) launcher.getGame().getVaissJ2Obj());
        } else if (indiceJ2 == 1) {
            setVaissJ2((VCorvette) launcher.getGame().getVaissJ2Obj());
        } else if (indiceJ2 == 2) {
            setVaissJ2((VR22) launcher.getGame().getVaissJ2Obj());
        } else if (indiceJ2 == 3) {
            setVaissJ2((VFaucon) launcher.getGame().getVaissJ2Obj());
        }


        if (keyEvent.getEventType().equals(KeyEvent.KEY_PRESSED)) {

            if (keyEvent.getCode() == KeyCode.RIGHT) {
                launcher.getGame().j2goRight();
                launcher.getGame().getTimelineGoRightJ2().playFromStart();
            }

            if (keyEvent.getCode() == KeyCode.LEFT) {
                launcher.getGame().j2goLeft();
                launcher.getGame().getTimelineGoLeftJ2().playFromStart();
            }

            if (keyEvent.getCode() == KeyCode.O) {
                launcher.getGame().tir();
                System.out.println("hello tir");
            }
            if (keyEvent.getCode() == KeyCode.D) {
                launcher.getGame().j1goRight();
                launcher.getGame().getTimelineGoRightJ1().playFromStart();
            }

            if (keyEvent.getCode() == KeyCode.Q) {
                launcher.getGame().j1goLeft();
                launcher.getGame().getTimelineGoLeftJ1().playFromStart();
            }
        }


        if (keyEvent.getEventType().equals(KeyEvent.KEY_RELEASED)) {

            if (keyEvent.getCode() == KeyCode.RIGHT) {
                launcher.getGame().getTimelineGoRightJ2().stop();
                launcher.getGame().retourNormalBack();
            }

            if (keyEvent.getCode() == KeyCode.LEFT) {
                launcher.getGame().getTimelineGoLeftJ2().stop();
                launcher.getGame().retourNormalBack();
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