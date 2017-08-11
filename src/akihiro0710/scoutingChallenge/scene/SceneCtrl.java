package akihiro0710.scoutingChallenge.scene;

import akihiro0710.scoutingChallenge.Commander;

import javax.swing.*;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by ta on 2017/06/30.
 */
public class SceneCtrl {
    private LinkedList<AbstractScene> sceneList;
    private ListIterator<AbstractScene> sceneItr;
    private ScenePanel panel;
    private SceneFrame frame;
    private Timer timer;

    public SceneCtrl(){
        sceneList = new LinkedList<>();
        sceneList.add(SceneEnum.wait.getScene());
        sceneList.add(SceneEnum.roulette.getScene());
        sceneList.add(SceneEnum.counter.getScene());
        sceneList.add(SceneEnum.camera.getScene());
        sceneList.add(SceneEnum.judge.getScene());
        panel = new ScenePanel();
        load();
        new Thread(
                () -> {
                    while (true) {
                        System.out.print("timer is ");
                        if (timer == null) {
                            System.out.println("null");
                        } else if (timer.isRunning()) {
                            System.out.println("running");
                        } else {
                            next();
                            System.out.println("stop");
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
    }

    public boolean load(){
        if(timer != null) timer.stop();
        sceneItr = sceneList.listIterator();
        return next();
    }

    public boolean next(){
        if(!panel.stopScene()) return false;
        timer = null;
        if(sceneItr.hasNext()) {
            timer = panel.startScene(sceneItr.next());
            timer.start();
            return true;
        }else{
            return false;
        }
    }

    public void setScene(SceneEnum scene){
        if(!panel.stopScene()) return;
        panel.startScene(scene.getScene()).start();
    }

    public void createFrame(Commander listener){
        new Thread(
                () -> {
                    frame = new SceneFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setBounds(10, 10, 800, 450);
                    frame.setTitle("View");
                    frame.add(this.panel);
                    frame.addKeyListener(listener);
                    frame.addMouseListener(listener);
                    frame.setVisible(true);
                }
        ).start();
    }

    public void fullScreen(){
        frame.fullScreen(!frame.isFullScreen());
    }
}
