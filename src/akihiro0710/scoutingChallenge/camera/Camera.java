package akihiro0710.scoutingChallenge.camera;

import akihiro0710.scoutingChallenge.pict.ChangePictListener;
import akihiro0710.scoutingChallenge.scene.AbstractScene;
import akihiro0710.scoutingChallenge.view.ImageView;
import com.github.sarxos.webcam.Webcam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by ta on 2017/07/03.
 */
public final class Camera extends AbstractScene {
    private ImageView imageView;
    private static Webcam webcam;
    private ChangePictListener listener;

    public Camera() {
        super(100);
        imageView = new ImageView();
        webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(640, 480));
    }

    public void setChangePictListener(ChangePictListener listener){
        this.listener = listener;
    }

    @Override
    public Timer getNewTimer(ActionListener listener) {
        webcam.open();
        return super.getNewTimer(listener);
    }

    @Override
    public boolean stopTimer() {
        super.stopTimer();
        webcam.close();
        listener.setPict(imageView.getImage());
        return true;
    }

    @Override
    public void paint(Graphics2D g2D, int x, int y, int width, int height, JPanel jPanel) {
        imageView.setImage(webcam.getImage());
        imageView.paint(g2D, x, y, width, height, jPanel);
    }
}
