package Controller;

import Model.Menu;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ControllerJeux implements EventHandler<KeyEvent> {

    /**
     * Attributs du controleur du menu
     */
    private ViewHandler launcher;
    private Menu model;
    private int i = 0;

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

        if( keyEvent.getEventType().equals(KeyEvent.KEY_PRESSED) ) {
            if (keyEvent.getCode() == KeyCode.RIGHT) {
                launcher.getGame().j2goRight();
            }

            if (keyEvent.getCode() == KeyCode.LEFT) {
                    launcher.getGame().j2goLeft();
                }

            if (keyEvent.getCode() == KeyCode.D) {
                launcher.getGame().j1goRight();
            }

            if (keyEvent.getCode() == KeyCode.Q) {
                launcher.getGame().j1goLeft();
            }

        }







        if( keyEvent.getEventType().equals(KeyEvent.KEY_RELEASED) ) {


                launcher.getGame().getAnimTextMenuArrivee().stop();


        }
    }
}