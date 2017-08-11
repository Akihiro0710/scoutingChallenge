package akihiro0710.scoutingChallenge.wait;

import akihiro0710.scoutingChallenge.scene.AbstractScene;
import akihiro0710.scoutingChallenge.view.ImageView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by ta on 2017/06/28.
 */
public final class Wait extends AbstractScene {
    private ImageView imageView;

    public Wait() {
        super(1000);
        String imagePath = "logo.png";
        try {
            BufferedImage image = ImageIO.read(getClass().getResource(imagePath));
            imageView = new ImageView(image);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics2D g2D, int x, int y, int width, int height, JPanel jPanel) {
        int time = passTime();
        imageView.paint(g2D, x, y, width, height,jPanel);
    }
}
