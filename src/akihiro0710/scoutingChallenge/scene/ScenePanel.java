package akihiro0710.scoutingChallenge.scene;

import akihiro0710.scoutingChallenge.view.ViewIF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ta on 2017/06/29.
 */
class ScenePanel extends JPanel implements ActionListener{
    private ViewIF view;

    ScenePanel(){
    }

    void setScene(ViewIF view){
        this.view = view;
        System.out.println("change scene " + view.getClass().getSimpleName());
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();
        if(view != null) view.paint(g2D, 0, 0, panelWidth, panelHeight, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
