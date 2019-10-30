/*package Timeline;

import IA.IAComputeAction;

public class IAThread {

    private long lastUpdate;
    private IAComputeAction ia;

    public IAThread(IAComputeAction ia) {
        this.ia = ia;
    }

    public void handle(long now) {
        if( now > lastUpdate ) {
            if( now - lastUpdate >= 20_000_000 ) {
                ia.defineAction();
                lastUpdate = now;
            }
        }
    }
}
*/