package akihiro0710.scoutingChallenge.judge;

import akihiro0710.scoutingChallenge.scene.SceneIF;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.EnumMap;

/**
 * Created by ta on 2017/06/28.
 */
public class Judge implements SceneIF {
    private BufferedImage image;
    private EnumMap<JudgeEnum, BufferedImage> judgeMap = new EnumMap<>(JudgeEnum.class);
    private BufferedImage judgeImage;
    private Timer timer;

    public Judge() {
        try {
            judgeMap.put(JudgeEnum.success, ImageIO.read(getClass().getResource("success.png")));
            judgeMap.put(JudgeEnum.failed, ImageIO.read(getClass().getResource("failed.png")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        judge(JudgeEnum.success);
    }

    public void setImage(BufferedImage image){
        this.image = image;
    }

    public void judge(JudgeEnum key){
        judgeImage = judgeMap.get(key);
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
        g2D.drawImage(judgeImage, x, y, width, height, jPanel);
    }
}
