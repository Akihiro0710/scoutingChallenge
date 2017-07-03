package akihiro0710.scoutingChallenge.judge;

import akihiro0710.scoutingChallenge.scene.SceneIF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Created by ta on 2017/06/28.
 */
public class Judge implements SceneIF {
    private BufferedImage image;
    private Timer timer;

    public Judge() {
        load();
    }

    public void setImage(BufferedImage image){
        this.image = image;
    }
    private boolean load() {
//        try {
//            setImage(ImageIO.read(getClass().getResource(imagePath)));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            this.image = null;
//        }
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
