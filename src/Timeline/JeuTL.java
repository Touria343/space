/*
package Timeline;

import Controller.ControllerJeu;
import javafx.animation.AnimationTimer;


public class JeuTL extends AnimationTimer {
    private final ControllerJeu controlleurJeu;
    private long lu150ms, lu10ms, lu750ms, countDownUpdate;
    private boolean isLevelStarted, firstTime;

    public JeuTL(ControllerJeu controlleurJeu) {
        this.controlleurJeu = controlleurJeu;
        isLevelStarted = false;
        firstTime = true;
        lu150ms = lu10ms = lu750ms = countDownUpdate = 0;
    }

    @Override
    public void handle(long now) {
        if( firstTime ) {
            controlleurJeu.setAllUnitsVisible(false);
            countDownUpdate = now;
            controlleurJeu.setBeginText("3");
            firstTime = false;
            return;
        }
        if( !isLevelStarted ) {
            if( now - countDownUpdate >= 4_000_000_000L ) {
                controlleurJeu.setBeginText(null);
                controlleurJeu.setAllUnitsVisible(true);
                isLevelStarted = true;
            } else if( now - countDownUpdate >= 3_000_000_000L ) {
                controlleurJeu.setBeginText("GO !");
            } else if( now - countDownUpdate >= 2_000_000_000L ) {
                controlleurJeu.setBeginText("1");
            } else if( now - countDownUpdate >= 1_000_000_000L ) {
                controlleurJeu.setBeginText("2");
            }
            return;
        }
        if( now - lu10ms >= 10_000_000 ) {
            controlleurJeu.majPositions();
            controlleurJeu.majMapPosition();
            controlleurJeu.majMiniMap();
            controlleurJeu.bougerLesLezards();
            controlleurJeu.majDestinations();
            lu10ms = now;
        }
        if( now - lu150ms >= 150_000_000 ) {
            controlleurJeu.majAnimation();
            lu150ms = now;
        }
        if( now - lu750ms >= 750_000_000 ) {
            controlleurJeu.majAttaques();
            lu750ms = now;
        }
    }

    public void restartCountDownStartGame() {firstTime=true; isLevelStarted=false;}
}

*/