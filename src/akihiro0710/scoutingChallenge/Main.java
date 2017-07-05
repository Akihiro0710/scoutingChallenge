package akihiro0710.scoutingChallenge;

import akihiro0710.scoutingChallenge.camera.Camera;
import akihiro0710.scoutingChallenge.counter.Counter;
import akihiro0710.scoutingChallenge.judge.Judge;
import akihiro0710.scoutingChallenge.roulette.Roulette;
import akihiro0710.scoutingChallenge.scene.SceneCtrl;
import akihiro0710.scoutingChallenge.scene.SceneEnum;
import akihiro0710.scoutingChallenge.wait.Wait;

import java.awt.event.InputEvent;
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
        sceneCtrl.putScene(SceneEnum.counter, new Counter());
        sceneCtrl.putScene(SceneEnum.camera, new Camera());
        sceneCtrl.putScene(SceneEnum.judge, new Judge());
        createFrame();
    }

    private static void createFrame(){
        new Thread(
                () -> {
                    manageFrame = new ManageFrame();
                    manageFrame.addKeyListener(new Main());
                    sceneCtrl.createFrame();
                    sceneCtrl.setScene(SceneEnum.wait);
                }
        ).start();
    }

    private void command(CommandEnum command){
        switch (command) {
            case button:
                switch (sceneCtrl.getScene()) {
                    case wait:
                        sceneCtrl.setScene(SceneEnum.roulette);
                        break;
                    case roulette:
                        sceneCtrl.setScene(SceneEnum.counter);
                        break;
                    case counter:
                        sceneCtrl.setScene(SceneEnum.camera);
                        break;
                    case camera:
                        sceneCtrl.setScene(SceneEnum.judge);
                        break;
                    case judge:
                        sceneCtrl.setScene(SceneEnum.wait);
                        break;
                    default:
                        command(CommandEnum.reset);
                        break;
                }
                break;
            case reset:
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
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE){
            command(CommandEnum.button);
        }
        System.out.println(KeyEvent.getKeyText(key));
        int mod = e.getModifiersEx();
        if ((mod & InputEvent.CTRL_DOWN_MASK) != 0){
            if(KeyEvent.getKeyText(key).equals("R")){
                command(CommandEnum.reset);
            }
        }
    }
}
