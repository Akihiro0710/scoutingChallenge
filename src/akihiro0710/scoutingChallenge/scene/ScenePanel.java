package akihiro0710.scoutingChallenge.scene;

import akihiro0710.scoutingChallenge.view.IView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ta on 2017/06/29.
 */
class ScenePanel extends JPanel implements ActionListener, IView {
    private AbstractScene scene;

    ScenePanel(){
    }

    Timer startScene(AbstractScene scene){
        this.scene = scene;
        System.out.println("change scene: " + scene.getClass().getSimpleName());
        return scene.getNewTimer(this);
    }

    AbstractScene getScene(){
        return scene;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();
        paint(g2D, 0, 0, panelWidth, panelHeight, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paint(Graphics2D g2D, int x, int y, int width, int height, JPanel jPanel) {
        if(scene != null) scene.paint(g2D, x, y, width, height, jPanel);
    }

    public boolean stopScene() {
        if(scene == null) return true;
        boolean isStop = scene.stopTimer();
        if(isStop) System.out.println("stopScene scene: " + scene.getClass().getSimpleName());
        else System.out.println("stopScene scene: Failed");
        return isStop;
    }
}
