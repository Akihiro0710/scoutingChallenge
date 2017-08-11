package akihiro0710.scoutingChallenge.theme;

import java.util.LinkedList;

/**
 * Created by ta on 2017/08/10.
 */
public interface ChangeThemeListener {
    void setTheme(String theme);
    void setThemeList(LinkedList<String[]> list);
}
