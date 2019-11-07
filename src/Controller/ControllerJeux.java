package Controller;

import Model.Menu;
import Model.Vaisseaux;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControllerJeux implements EventHandler<KeyEvent> {

    private final Vaisseaux vaissJ1;
    private final Vaisseaux vaissJ2;
    /**
     * Attributs du controleur du menu
     */
    private ViewHandler launcher;
    private Menu model;
    private int i = 0;
    private boolean presseRight = false;
    private boolean presseLeft = false;

    /**
     * Constructeur du controleur relatif au menu principal
     *
     * @param launcher (Gestionnaire de vue)
     * @param model    (Modèle correcpondant au menu principal)
     */
    public ControllerJeux(ViewHandler launcher, Menu model, Vaisseaux vaissJ1, Vaisseaux vaissJ2) {
        this.model = model;
        this.launcher = launcher;
        this.launcher.setEventHandlerGame(this);
        this.vaissJ1 = vaissJ1;
        this.vaissJ2 = vaissJ2;
    }

    @Override
    public void handle(KeyEvent keyEvent) {

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