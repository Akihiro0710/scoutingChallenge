package akihiro0710.scoutingChallenge.scene;

import akihiro0710.scoutingChallenge.camera.Camera;
import akihiro0710.scoutingChallenge.judge.Judge;

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
        if(activeScene != null) this.panel.getScene().stop();
        activeScene = key;
        this.panel.setScene(sceneMap.get(key));
        switch (key){
            case judge:
                Camera camera = (Camera) (this.sceneMap.get(SceneEnum.camera));
                Judge judge = (Judge) (this.sceneMap.get(SceneEnum.judge));
                judge.setImage(camera.getImage());
            default:
                sceneMap.get(key).start(panel);
                break;
        }
    }

    public SceneEnum getScene(){
        return activeScene;
    }

    public void createFrame(){
        this.panel = new ScenePanel();
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
