package akihiro0710.scoutingChallenge.roulette;

import akihiro0710.scoutingChallenge.scene.AbstractScene;
import akihiro0710.scoutingChallenge.view.TextView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ta on 2017/06/28.
 */
public final class Roulette extends AbstractScene {
    private final static Color fontColor = Color.white;
    private final RouletteRow[] rows;
    private final TextView themeView;
    private final int rowCount = 3;
    private final int colCount = 12;
    final static double showCellCount = 3;
    private final int rollTime = 3000;
    private final int rollDelay = 1000;

    public Roulette() {
        super(30);
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 28);
        rows = new RouletteRow[rowCount];
        for (int i = 0; i < rowCount; i++) {
            rows[i] = new RouletteRow(font, Color.white, colCount, i);
        }
        Color themeBackColor = Color.pink;
        themeView = new TextView(
                new Font(Font.SANS_SERIF, Font.PLAIN, 56),
                Color.white,
                themeBackColor
        );
    }

    private String[] loadTheme(){
        String[] texts = new String[colCount];
        for (int j = 0; j < colCount; j++) {
            texts[j] = "Sample text, ";
        }
        return texts;
    }

    @Override
    public boolean stopTimer(){
        return !timer.isRunning();
    }

    @Override
    public void paint(Graphics2D g2D, int x, int y, int width, int height, JPanel jPanel) {
        g2D.setColor(fontColor);
        int time = passTime();
        if(time < rollTime + rollDelay) {
            double rollLength = height * (colCount - showCellCount) / showCellCount;
            int dy = (int)(rollLength * time / rollTime);
            if(dy > rollLength) dy = (int)rollLength;
            for (int i = 0; i < rowCount; i++) {
                int rollY = - dy;
                if(i % 2 == 1) rollY = - (int)rollLength + dy;
                rows[i].setTexts(loadTheme());
                rows[i].paint(g2D, i * width / rowCount, rollY, width / rowCount, height, jPanel);
            }
        }else{
            themeView.setTexts(new String[]{"Theme", "Scene"});
            themeView.paint(g2D, x, y, width, height, jPanel);
            super.stopTimer();
        }
    }
}
