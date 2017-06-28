package akihiro0710.scoutingChallenge;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by ta on 2017/06/27.
 */
public class Main implements KeyListener{
    private static ViewFrame viewFrame;
    private static ManageFrame manageFrame;
    public static void main(String[] args) {
        viewFrame = new ViewFrame();
        manageFrame = new ManageFrame();
        manageFrame.addKeyListener(new Main());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
