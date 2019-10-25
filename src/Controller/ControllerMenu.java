package Controller;

import Model.Menu;
import View.ViewHandler;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class ControllerMenu implements EventHandler<MouseEvent> {

    /**
     * Attributs du controleur du menu
     */
    private ViewHandler launcher;
    private Menu model;

    /**
     * Constructeur du controleur relatif au menu principal
     *
     * @param launcher (Gestionnaire de vue)
     * @param model    (Modèle correcpondant au menu principal)
     */
    public ControllerMenu(ViewHandler launcher, Menu model) {
        this.model = model;
        this.launcher = launcher;
        this.launcher.setEventHandlerMenu(this);
      //  this.launcher.setEventHandlerMenuOption(this);
    }


    @Override
    public void handle(MouseEvent mouseEvent) {

        if (mouseEvent.getSource().equals(launcher.getMp().getTitre())) {
            launcher.getMp().setRandomColorForTitle();
        }

        if (mouseEvent.getSource().equals(launcher.getMp().getChoixVaiss())) {
            launcher.setOption();
          //  launcher.getMo().

        }

        if (mouseEvent.getSource().equals(launcher.getMp().getQuitter())) {
            launcher.setQuitter();
        }

        if (mouseEvent.getSource().equals(launcher.getMp().getJouer())) {
            launcher.setJeux();
        }

        if (mouseEvent.getSource().equals(launcher.getMo().getChevron())) {
            launcher.getMo().grandissementChevron();
        }

        if (mouseEvent.getSource().equals(launcher.getMo().getChevrondroit())) {
            launcher.getMo().grandissementChevron();
        }




       /* final Animation animTextMenuArrivee = new Transition() {
            {
                setCycleDuration(Duration.millis(2000));
            }

            protected void interpolate(double frac) {

            }

        };*/

      //  animTextMenuArrivee.play();



    }
}