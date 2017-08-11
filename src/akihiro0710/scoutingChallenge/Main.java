package akihiro0710.scoutingChallenge;

import akihiro0710.scoutingChallenge.camera.Camera;
import akihiro0710.scoutingChallenge.pict.ChangePictListener;
import akihiro0710.scoutingChallenge.pict.PictCtrl;
import akihiro0710.scoutingChallenge.scene.SceneCtrl;
import akihiro0710.scoutingChallenge.scene.SceneEnum;
import akihiro0710.scoutingChallenge.theme.ThemeCtrl;

/**
 * Created by ta on 2017/06/27.
 */
public class Main{
    static SceneCtrl sceneCtrl;

    public static void main(String[] args) {
        new ThemeCtrl();
        PictCtrl pictCtrl = new PictCtrl("pictures");
        pictCtrl.addChangePictListener((ChangePictListener) (SceneEnum.judge.getScene()));
        ((Camera)SceneEnum.camera.getScene()).setChangePictListener(pictCtrl);

        sceneCtrl = new SceneCtrl();

        new Thread(
                () -> {
                    sceneCtrl.createFrame(new Commander());
                }
        ).start();
    }
}
