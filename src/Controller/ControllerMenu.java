package Controller;

import Model.Menu;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerMenu implements EventHandler<MouseEvent> {

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
            launcher.afficherOption();
          //  launcher.getMo().

        }

        if (mouseEvent.getSource().equals(launcher.getMp().getQuitter())) {
            launcher.goQuitter();
        }

        if (mouseEvent.getSource().equals(launcher.getMp().getJouer())) {
            launcher.afficherJeux();
            launcher.getMo().getVideoBackground().play();

        }

        if (mouseEvent.getSource().equals(launcher.getMo().getChevron())&& mouseEvent.getEventType().equals(MouseEvent.MOUSE_ENTERED )){
            launcher.getMo().grandissementChevron();
        }

        if(mouseEvent.getEventType().equals(MouseEvent.MOUSE_EXITED)){
            launcher.getMo().retourNormalChevronGauche();
        }

        if (mouseEvent.getSource().equals(launcher.getMo().getChevrondroit()) && mouseEvent.getEventType().equals(MouseEvent.MOUSE_ENTERED )) {
            launcher.getMo().grandissementChevronDroit();
        }

        if(mouseEvent.getEventType().equals(MouseEvent.MOUSE_EXITED)){
            launcher.getMo().retourNormalChevronDroit();
        }

        if (mouseEvent.getSource().equals(launcher.getMo().getChevrondroit()) && mouseEvent.getEventType().equals(MouseEvent.MOUSE_CLICKED )) {
            launcher.getMo().swipeVaisseaux(true);
        }

        if (mouseEvent.getSource().equals(launcher.getMo().getChevron()) && mouseEvent.getEventType().equals(MouseEvent.MOUSE_CLICKED )) {
            launcher.getMo().swipeVaisseaux(false);
        }

        if (mouseEvent.getSource().equals(launcher.getMo().getImageChoisir()) && i==0 && mouseEvent.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
            launcher.getMo().changeChoixJoueur();
            i=1;
        }else if (mouseEvent.getSource().equals(launcher.getMo().getImageChoisir()) && i==1 && mouseEvent.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
            launcher.getMo().changeChoixJoueur2();
            launcher.afficherGame();
        }





        /*if (mouseEvent.getSource().equals(launcher.getMo().getChevrondroit())) {
            launcher.getMo().grandissementChevron();
        } */




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