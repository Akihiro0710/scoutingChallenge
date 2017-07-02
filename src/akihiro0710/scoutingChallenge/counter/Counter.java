package akihiro0710.scoutingChallenge.counter;

import akihiro0710.scoutingChallenge.scene.SceneIF;
import akihiro0710.scoutingChallenge.view.TextView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by ta on 2017/06/28.
 */
public class Counter implements SceneIF {
    private final static Color fontColor = Color.white;
    private final static Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 400);
    private final TextView themeView;
    private final int countTime;
    private int time;
    private final int dt;
    private Timer timer;


    public Counter(){
        countTime = 60 * 10;
        dt = 1000;
        Color themeBackColor = Color.pink;
        themeView = new TextView(themeBackColor);
    }

    public boolean start(ActionListener listener){
        timer = new Timer(dt, listener);
        timer.start();
        time = countTime;
        return true;
    }

    @Override
    public boolean stop(){
        if(timer != null) timer.stop();
        return true;
    }

    @Override
    public void paint(Graphics2D g2D, int x, int y, int width, int height, JPanel jPanel) {
        g2D.setColor(fontColor);
        g2D.setFont(font);
        themeView.setText(new String[]{String.format("%1$02d:%2$02d", time / 60, time % 60)});
        themeView.paint(g2D, x, y, width, height, jPanel);
        time--;
        if(time < 0) timer.stop();
    }
}
