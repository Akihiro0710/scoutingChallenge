package akihiro0710.scoutingChallenge.scene;

import javax.swing.*;
import java.util.EnumMap;

/**
 * Created by ta on 2017/06/30.
 */
public class SceneCtrl {
    private ScenePanel panel;
    private final EnumMap<SceneEnum, SceneIF> sceneMap = new EnumMap<>(SceneEnum.class);
    private static SceneEnum activeScene;

    public SceneCtrl(){
    }
    public void putScene(SceneEnum key, SceneIF value) {
        this.sceneMap.put(key, value);
    }
    public void setScene(SceneEnum key){
        this.activeScene = key;
        this.panel.setScene(sceneMap.get(key));
        this.panel.repaint();
    }
    public SceneEnum getScene(){
        return activeScene;
    }
    public void createFrame(SceneEnum key){
        this.activeScene = key;
        this.panel = new ScenePanel(sceneMap.get(key));
        new Thread(
                () -> {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setBounds(10, 10, 800, 450);
                    frame.setTitle("View");
                    frame.add(this.panel);
                    frame.setVisible(true);
                }
        ).start();
    }
}
