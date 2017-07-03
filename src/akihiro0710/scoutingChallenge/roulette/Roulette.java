package akihiro0710.scoutingChallenge.roulette;

import akihiro0710.scoutingChallenge.scene.SceneIF;
import akihiro0710.scoutingChallenge.view.TextView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by ta on 2017/06/28.
 */
public class Roulette implements SceneIF {
    private final static Color fontColor = Color.white;
    private final static Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 28);
    private final RouletteRow[] rows;
    private final TextView themeView;
    private final int rowCount = 3;
    private final int colCount = 12;
    final static double showCellCount = 3;
    private final int rollTime;
    private final int rollDelay;
    private int time;
    private final int dt;
    private Timer timer;


    public Roulette(){
        rollTime = 5000;
        rollDelay = 1000;
        dt = 30;
        rows = new RouletteRow[rowCount];
        for (int i = 0; i < rowCount; i++){
            rows[i] = new RouletteRow(colCount, i);
        }
        Color themeBackColor = Color.pink;
        themeView = new TextView(themeBackColor);
    }
    public boolean start(ActionListener listener){
        timer = new Timer(dt, listener);
        timer.start();
        time = 0;
        return true;
    }
    private String[] loadTheme(){
        String[] texts = new String[colCount];
        for (int j = 0; j < colCount; j++) {
            texts[j] = "Sample text, ";
        }
        return texts;
    }

    @Override
    public boolean stop(){
        if(timer != null) timer.stop();
        return true;
    }

    @Override
    public void paint(Graphics2D g2D, int x, int y, int width, int height, JPanel jPanel) {
        g2D.setColor(fontColor);
        if(time < rollTime + rollDelay) {
            int dy;
            double rollLength = height * (colCount - showCellCount) / showCellCount;
            if(time < rollTime) dy = (int)(rollLength * time / rollTime);
            else dy = (int)rollLength;
            g2D.setFont(font);
            for (int i = 0; i < rowCount; i++) {
                int rollY = - dy;
                if(i % 2 == 1) rollY = - (int)rollLength + dy;
                rows[i].setTexts(loadTheme());
                rows[i].paint(g2D, i * width / rowCount, rollY, width / rowCount, height, jPanel);
            }
        }else{
            g2D.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 56));
            themeView.setText(new String[]{"Theme", "Scene"});
            themeView.paint(g2D, x, y, width, height, jPanel);
            timer.stop();
        }
        time += dt;
    }
}
