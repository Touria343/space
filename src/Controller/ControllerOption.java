package Controller;

import Model.*;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerOption implements EventHandler<MouseEvent> {

    private ViewHandler launcher;
    private Menu model;
    private int i = 0;

    public ControllerOption(ViewHandler launcher, Menu model) {
        this.model = model;
        this.launcher = launcher;
        this.launcher.setEventHandlerOption(this);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        if( mouseEvent.getSource().equals(launcher.getMt().getTitre())) {
            launcher.getMt().setRandomColorForTitle();
        }
    }
}

