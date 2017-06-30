package akihiro0710.scoutingChallenge;

import akihiro0710.scoutingChallenge.roulette.Roulette;
import akihiro0710.scoutingChallenge.scene.SceneCtrl;
import akihiro0710.scoutingChallenge.scene.SceneEnum;
import akihiro0710.scoutingChallenge.wait.Wait;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by ta on 2017/06/27.
 */
public class Main implements KeyListener{
    private static SceneCtrl sceneCtrl;
    private static ManageFrame manageFrame;

    public static void main(String[] args) {
        sceneCtrl = new SceneCtrl();
        sceneCtrl.putScene(SceneEnum.wait, new Wait());
        sceneCtrl.putScene(SceneEnum.roulette, new Roulette());
        createFrame();
    }

    private static void createFrame(){
        new Thread(
                () -> {
                    manageFrame = new ManageFrame();
                    manageFrame.addKeyListener(new Main());
                    sceneCtrl.createFrame(SceneEnum.wait);
                }
        ).start();
    }

    private void command(){
        switch (sceneCtrl.getScene()){
            case wait:
                sceneCtrl.setScene(SceneEnum.roulette);
                break;
            case roulette:
            default:
                sceneCtrl.setScene(SceneEnum.wait);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char key = e.getKeyChar();
        if (key == ' '){
            command();
        }
    }
}
