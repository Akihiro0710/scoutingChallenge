package akihiro0710.scoutingChallenge.scene;

import akihiro0710.scoutingChallenge.camera.Camera;
import akihiro0710.scoutingChallenge.counter.Counter;
import akihiro0710.scoutingChallenge.judge.Judge;
import akihiro0710.scoutingChallenge.roulette.Roulette;
import akihiro0710.scoutingChallenge.wait.Wait;

/**
 * Created by ta on 2017/06/28.
 */
public enum SceneEnum {
    wait(new Wait()),
    roulette(new Roulette()),
    counter(new Counter(60 * 10)),
    camera(new Camera()),
    judge(new Judge());

    private final AbstractScene scene;
    SceneEnum(AbstractScene scene){
        this.scene = scene;
    }

    public AbstractScene getScene() {
        return scene;
    }
}
