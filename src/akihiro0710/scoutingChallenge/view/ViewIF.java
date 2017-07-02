package akihiro0710.scoutingChallenge.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by ta on 2017/06/28.
 */
public interface ViewIF {
    boolean start(ActionListener listener);
    boolean stop();
    void paint(Graphics2D g2D, int x, int y, int width, int height, JPanel jPanel);
}
