package akihiro0710.scoutingChallenge.scene;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ta on 2017/08/11.
 */
class SceneFrame extends JFrame{
    private GraphicsDevice device;

    SceneFrame(){
        this.device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    }

    boolean isFullScreen() {
        return device.getFullScreenWindow() != null;
    }

    void fullScreen(boolean flag) {
        if (flag){
            device.setFullScreenWindow(this);
        }else {
            device.setFullScreenWindow(null);
        }
    }
}
