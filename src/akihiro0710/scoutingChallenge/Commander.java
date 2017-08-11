package akihiro0710.scoutingChallenge;

import java.awt.event.*;

import static akihiro0710.scoutingChallenge.Main.sceneCtrl;

/**
 * Created by ta on 2017/08/08.
 */
public class Commander implements KeyListener, MouseListener{

    private void command(CommandEnum command){
        switch (command) {
            case button:
                sceneCtrl.next();
                break;
            case reset:
                sceneCtrl.load();
                break;
            case fullScreen:
                sceneCtrl.fullScreen();
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
        boolean isCtrl = (e.getModifiersEx() & InputEvent.CTRL_DOWN_MASK) != 0;
        if (key == KeyEvent.VK_SPACE){
            command(CommandEnum.button);
        }
        if (isCtrl){
            if(KeyEvent.getKeyText(key).equals("R")){
                command(CommandEnum.reset);
            }else if(KeyEvent.getKeyText(key).equals("F")){
                command(CommandEnum.fullScreen);
            }
        }
        System.out.println(KeyEvent.getKeyText(key));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        command(CommandEnum.button);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
