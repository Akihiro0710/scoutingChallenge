package akihiro0710.scoutingChallenge.scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ta on 2017/06/29.
 */
class ScenePanel extends JPanel implements ActionListener{
    private SceneIF scene;

    ScenePanel(SceneIF scene){
        setScene(scene);
    }

    void setScene(SceneIF scene){
        this.scene = scene;
        System.out.println("change scene " + scene.getClass().getSimpleName());
    }

    SceneIF getScene(){
        return this.scene;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();
        scene.paint(g2D, panelWidth, panelHeight, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
