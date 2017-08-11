package akihiro0710.scoutingChallenge.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by ta on 2017/08/08.
 */
public class ImageView implements IView {

    protected BufferedImage image;

    public ImageView(){
    }
    public ImageView(BufferedImage image){
        setImage(image);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void paint(Graphics2D g2D, int x, int y, int width, int height, JPanel jPanel) {
        g2D.drawImage(image, x, y, width, height, jPanel);
    }
}
