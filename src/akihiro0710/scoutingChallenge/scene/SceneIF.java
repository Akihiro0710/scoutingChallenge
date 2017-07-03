package akihiro0710.scoutingChallenge.scene;

import akihiro0710.scoutingChallenge.view.ViewIF;

import java.awt.event.ActionListener;

/**
 * Created by ta on 2017/07/02.
 */
public interface SceneIF extends ViewIF{
    boolean start(ActionListener listener);
    boolean stop();
}
