package akihiro0710.scoutingChallenge.camera;

import akihiro0710.scoutingChallenge.scene.SceneIF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by ta on 2017/07/03.
 */
public class Camera implements SceneIF{
    @Override
    public void paint(Graphics2D g2D, int x, int y, int width, int height, JPanel jPanel) {

    }

    @Override
    public boolean start(ActionListener listener) {
        return false;
    }

    @Override
    public boolean stop() {
        return false;
    }
}
