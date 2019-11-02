package Controller;

import Model.Menu;
import View.ViewHandler;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import static javafx.animation.Animation.Status.RUNNING;

public class ControllerJeux implements EventHandler<KeyEvent> {

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
    public ControllerJeux(ViewHandler launcher, Menu model) {
        this.model = model;
        this.launcher = launcher;
        this.launcher.setEventHandlerGame(this);
    }

    @Override
    public void handle(KeyEvent keyEvent) {

        if (keyEvent.getEventType().equals(KeyEvent.KEY_PRESSED)) {

            if (keyEvent.getCode() == KeyCode.RIGHT) {
              //  if (!presseRight) {
               //     presseRight = true;
                    launcher.getGame().j2goRight();
                 /*   if (Timeline.Status.RUNNING == launcher.getGame().getTimelineGoLeft().getStatus()){
                   launcher.getGame().getTimelineGoLeft().stop();
                   }*/
                    launcher.getGame().getTimelineGoRight().playFromStart();
                //}
            }

            if (keyEvent.getCode() == KeyCode.LEFT) {
              //  if (!presseLeft) {
               //     presseRight = true;

                    launcher.getGame().j2goLeft();
               /* if (Timeline.Status.RUNNING == launcher.getGame().getTimelineGoRight().getStatus()){
                launcher.getGame().getTimelineGoRight().stop();
                }*/
                    launcher.getGame().getTimelineGoLeft().playFromStart();
              //  }
            }

            if (keyEvent.getCode() == KeyCode.D) {
                launcher.getGame().j1goRight();
            }

            if (keyEvent.getCode() == KeyCode.Q) {
                launcher.getGame().j1goLeft();
            }
        }


        if (keyEvent.getEventType().equals(KeyEvent.KEY_RELEASED)) {

            if (keyEvent.getCode() == KeyCode.RIGHT) {
                launcher.getGame().getTimelineGoRight().stop();
                launcher.getGame().retourNormalBack();
                // presseLeft = false;
                // launcher.getGame().getAnimTextMenuArrivee().stop();
            }

            if (keyEvent.getCode() == KeyCode.LEFT) {
                launcher.getGame().getTimelineGoLeft().stop();
                launcher.getGame().retourNormalBack();


                // presseRight = false;

                // launcher.getGame().getAnimTextMenuArrivee().stop();
            }

        }
    }
}