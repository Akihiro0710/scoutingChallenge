package akihiro0710.scoutingChallenge.judge;

/**
 * Created by ta on 2017/08/08.
 */
public class JudgeCtrl {
    private final Judge judge;
    public JudgeCtrl(Judge judge) {
        this.judge = judge;
    }
    public void setJudge(JudgeEnum judge){
        this.judge.setJudge(judge);
    }
}
