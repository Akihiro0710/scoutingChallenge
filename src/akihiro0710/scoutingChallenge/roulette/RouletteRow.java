package akihiro0710.scoutingChallenge.roulette;

import akihiro0710.scoutingChallenge.view.TextView;
import akihiro0710.scoutingChallenge.view.IView;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by ta on 2017/07/02.
 */
class RouletteRow implements IView {
    private static Color[] backColors = new Color[]{Color.pink, Color.cyan};
    private LinkedList<TextView> cells;

    RouletteRow(Font font, Color fontColor, int colCount, int row){
        this.cells = new LinkedList<>();
        for (int i = 0; i < colCount; i++) {
            Color backColor = backColors[(i + row) % backColors.length];
            cells.add(new TextView(font, fontColor, backColor));
        }
    }

    void setTexts(String[] texts) throws ArrayIndexOutOfBoundsException{
        if(texts.length != cells.size()) throw new ArrayIndexOutOfBoundsException();
        for (int i = 0; i < cells.size(); i++) {
            TextView textView = cells.get(i);
            textView.setText(texts[i]);
        }
    }

    @Override
    public void paint(Graphics2D g2D, int x, int y, int width, int height, JPanel jPanel) {
        for (int i = 0; i < cells.size(); i ++) {
            double cellHeight = height / Roulette.showCellCount;
            cells.get(i).paint(g2D, x, y + (int)(i * cellHeight), width, (int)cellHeight, jPanel);
        }
    }
}
