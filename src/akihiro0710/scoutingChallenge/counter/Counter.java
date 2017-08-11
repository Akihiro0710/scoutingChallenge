package akihiro0710.scoutingChallenge.counter;

import akihiro0710.scoutingChallenge.scene.AbstractScene;
import akihiro0710.scoutingChallenge.view.TextView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by ta on 2017/06/28.
 */
public final class Counter extends AbstractScene {
    private final static Color fontColor = Color.white;
    private final static Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 300);
    private final TextView themeView;
    private final int countTime;
    private int time;

    public Counter(int countTime){
        super(1000);
        this.countTime = countTime;
        themeView = new TextView(font, fontColor, Color.pink);
    }

    @Override
    public Timer getNewTimer(ActionListener listener){
        time = countTime;
        return super.getNewTimer(listener);
    }

    @Override
    public void paint(Graphics2D g2D, int x, int y, int width, int height, JPanel jPanel) {
        themeView.setTexts(new String[]{String.format("%1$02d:%2$02d", time / 60, time % 60)});
        themeView.paint(g2D, x, y, width, height, jPanel);
        time = countTime - passTime() / 1000;
        if(time < 0) stopTimer();
    }
}
