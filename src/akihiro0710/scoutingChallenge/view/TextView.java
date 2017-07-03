package akihiro0710.scoutingChallenge.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by ta on 2017/07/02.
 */
public class TextView implements ViewIF{
    private Color backColor;
    private String[] text;

    public TextView(Color backColor){
        this.backColor = backColor;
    }

    public void setText(String[] text) {
        this.text = text;
    }

    @Override
    public void paint(Graphics2D g2D, int x, int y, int width, int height, JPanel jPanel) {
        g2D.setBackground(backColor);
        g2D.clearRect(x, y, width,height);
        FontMetrics fm = g2D.getFontMetrics();
        for(int i = 0; i < text.length; i++) {
            Rectangle rectText = fm.getStringBounds(text[i], g2D).getBounds();
            g2D.drawString(
                    text[i],
                    x + (width - rectText.width) / 2,
                    y + (height - text.length * rectText.height) / 2 + i * rectText.height + fm.getMaxAscent()
            );
        }
    }
//
}
