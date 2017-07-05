package akihiro0710.scoutingChallenge.camera;

import akihiro0710.scoutingChallenge.scene.SceneIF;
import com.github.sarxos.webcam.Webcam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Created by ta on 2017/07/03.
 */
public class Camera implements SceneIF{
    private Webcam webcam;
    private BufferedImage image;
    private Timer timer;

    public Camera() {
        webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(640, 480));
    }

    public void setImage(BufferedImage image){
        this.image = image;
    }
    public BufferedImage getImage(){
        return image;
    }

    @Override
    public boolean start(ActionListener listener) {
        webcam.open();
        timer = new Timer(100, listener);
        timer.start();
        return true;
    }

    @Override
    public boolean stop() {
        if(timer != null) timer.stop();
        webcam.close();
        return true;
    }

    @Override
    public void paint(Graphics2D g2D, int x, int y, int width, int height, JPanel jPanel) {
        setImage(webcam.getImage());
        g2D.drawImage(image, x, y, width, height, jPanel);
    }
}
