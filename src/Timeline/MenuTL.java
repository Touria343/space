/*
package Timeline;

import Controller.ControllerMenu;
import javafx.animation.AnimationTimer;

public class MenuTL extends AnimationTimer {

    private long lu30ns = 0, lu20ns = 0, lu10ns = 0;
    private ControllerMenu controller;

    public MenuTL(ControllerMenu controllerMenu) {

        this.controller = controllerMenu;
    }

    @Override
    public void handle(long now) {

        if( now - lu30ns >= 30_000_000 ) {
            controller.moveSpidersDeco();
            lu30ns = now;
        }
        if( now - lu20ns >= 20_000_000 ) {
            controller.moveSpidersDeco();
            lu20ns = now;
        }
        if( now - lu10ns >= 15_000_000 ) {
            controller.majAnimLezardDeco();
            controller.majAnimation();
            lu10ns = now;
        }
    }
}
*/