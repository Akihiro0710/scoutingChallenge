package akihiro0710.scoutingChallenge.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ta on 2017/07/02.
 */
public class TextView implements IView {
    private Font font;
    private Color fontColor;
    private Color backColor;
    private String[] texts;

    public TextView(Font font, Color fontColor, Color backColor){
        this.font = font;
        this.fontColor = fontColor;
        this.backColor = backColor;
    }

    public void setTexts(String[] texts) {
        this.texts = texts;
    }

    public void setText(String test){
        setTexts(new String[]{test});
    }

    @Override
    public void paint(Graphics2D g2D, int x, int y, int width, int height, JPanel jPanel) {
        if(font != null) g2D.setFont(font);
        if(fontColor != null) g2D.setColor(fontColor);
        if(backColor != null) g2D.setBackground(backColor);
        g2D.clearRect(x, y, width,height);
        FontMetrics fm = g2D.getFontMetrics();
        for(int i = 0; i < texts.length; i++) {
            Rectangle rectText = fm.getStringBounds(texts[i], g2D).getBounds();
            g2D.drawString(
                    texts[i],
                    x + (width - rectText.width) / 2,
                    y + (height + (i * 2 - texts.length) * rectText.height) / 2 + fm.getMaxAscent()
            );
        }
    }
}
