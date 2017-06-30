package akihiro0710.scoutingChallenge.roulette;

import akihiro0710.scoutingChallenge.scene.SceneIF;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by ta on 2017/06/28.
 */
public class Roulette implements SceneIF {
    private String imagePath;
    private BufferedImage image;

    public Roulette(){
        this.imagePath = "logo.png";
        reload();
    }

    public boolean reload() {
        try {
            this.image = ImageIO.read(getClass().getResource(imagePath));
        } catch (IOException ex) {
            ex.printStackTrace();
            this.image = null;
        }
        return image != null;
    }

    @Override
    public void paint(Graphics2D g2D, int width, int height, JPanel jPanel) {
        g2D.drawImage(image, 0,0, width, height, jPanel);
    }
}
