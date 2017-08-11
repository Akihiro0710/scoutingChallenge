package akihiro0710.scoutingChallenge.judge;

import akihiro0710.scoutingChallenge.pict.ChangePictListener;
import akihiro0710.scoutingChallenge.scene.AbstractScene;
import akihiro0710.scoutingChallenge.view.IView;
import akihiro0710.scoutingChallenge.view.ImageView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.EnumMap;

/**
 * Created by ta on 2017/06/28.
 */
public final class Judge extends AbstractScene implements ChangePictListener {
    private final static EnumMap<JudgeEnum, IView> Results = new EnumMap<>(JudgeEnum.class);
    private ImageView imageView;
    private JudgeEnum judge;

    public Judge() {
        super(100);
        try {
            for(JudgeEnum key : JudgeEnum.values()) {
                BufferedImage image = ImageIO.read(getClass().getResource(key + ".png"));
                Results.put(key, new ImageView(image));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        setJudge(JudgeEnum.success);
        imageView = new ImageView();
    }

    void setJudge(JudgeEnum judge){
        this.judge = judge;
    }

    @Override
    public void paint(Graphics2D g2D, int x, int y, int width, int height, JPanel jPanel) {
        imageView.paint(g2D, x, y, width, height, jPanel);
        Results.get(judge).paint(g2D, x, y, width, height, jPanel);
    }

    @Override
    public boolean stopTimer() {
        return !timer.isRunning();
    }

    @Override
    public void setPict(BufferedImage image) {
        int time = passTime();
        imageView.setImage(image);
        if(time == 1000) super.stopTimer();
    }
}
