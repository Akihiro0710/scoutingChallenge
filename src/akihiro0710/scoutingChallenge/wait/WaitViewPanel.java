package akihiro0710.scoutingChallenge.wait;

import akihiro0710.scoutingChallenge.ViewIF;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by ta on 2017/06/28.
 */
public class WaitViewPanel extends JPanel implements ViewIF {
    private BufferedImage image;

    public WaitViewPanel() {
        reload();
    }

    @Override
    public boolean reload() {
        try {
            this.image = ImageIO.read(getClass().getResource("logo.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
            this.image = null;
        }
        return image != null;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        double imageWidth = image.getWidth();
        double imageHeight = image.getHeight();
        double panelWidth = this.getWidth();
        double panelHeight = this.getHeight();

        // 画像がコンポーネントの何倍の大きさか計算
        double sx = (panelWidth / imageWidth);
        double sy = (panelHeight / imageHeight);

        // スケーリング
        AffineTransform af = AffineTransform.getScaleInstance(sx, sy);
        g2D.drawImage(image, af, this);
    }
}