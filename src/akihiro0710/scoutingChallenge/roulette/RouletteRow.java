package akihiro0710.scoutingChallenge.roulette;

import akihiro0710.scoutingChallenge.view.TextView;
import akihiro0710.scoutingChallenge.view.ViewIF;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by ta on 2017/07/02.
 */
class RouletteRow implements ViewIF {
    private static Color[] backColors = new Color[]{Color.pink, Color.cyan};
    private LinkedList<TextView> cells;

    RouletteRow(int colCount, int index){
        this.cells = new LinkedList<>();
        for (int i = 0; i < colCount; i++) {
            cells.add(new TextView(backColors[(i + index) % backColors.length]));
        }
    }
    void setTexts(String[] texts){
        for (int i = 0; i < cells.size(); i++) {
            try {
                cells.get(i).setText(new String[]{texts[i]});
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Error: " + e);
                break;
            }
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
