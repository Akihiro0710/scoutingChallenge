package akihiro0710.scoutingChallenge.scene;

import akihiro0710.scoutingChallenge.view.IView;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by ta on 2017/07/02.
 */
public abstract class AbstractScene implements IView {
    protected Timer timer;
    private final int dt;
    private int time;

    protected AbstractScene(int dt) {
        this.dt = dt;
    }

    public Timer getNewTimer(ActionListener listener){
        time = 0;
        timer = new Timer(dt, listener);
        return timer;
    }

    public boolean stopTimer() {
        if(timer != null) timer.stop();
        return true;
    }
    protected int passTime(){
        return time += dt;
    }
}
