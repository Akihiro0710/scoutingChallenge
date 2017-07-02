package akihiro0710.scoutingChallenge.wait;

import akihiro0710.scoutingChallenge.scene.SceneIF;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by ta on 2017/06/28.
 */
public class Wait implements SceneIF {
    private String imagePath;
    private BufferedImage image;
    private Timer timer;

    public Wait() {
        this.imagePath = "logo.png";
        load();
    }

    private boolean load() {
        try {
            this.image = ImageIO.read(getClass().getResource(imagePath));
        } catch (IOException ex) {
            ex.printStackTrace();
            this.image = null;
        }
        return image != null;
    }

    @Override
    public boolean start(ActionListener listener) {
        timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        return true;
    }

    @Override
    public boolean stop() {
        if(timer != null) timer.stop();
        return true;
    }

    @Override
    public void paint(Graphics2D g2D, int x, int y, int width, int height, JPanel jPanel) {
        g2D.drawImage(image, x, y, width, height, jPanel);
    }
}
