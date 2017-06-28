package akihiro0710.scoutingChallenge;

import akihiro0710.scoutingChallenge.wait.WaitViewPanel;

import javax.swing.*;

/**
 * Created by ta on 2017/06/28.
 */
public class ViewFrame extends JFrame {
    public ViewFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(10, 10, 800, 450);
        this.setTitle("View");
        this.add(new WaitViewPanel());
        this.setVisible(true);
    }
}
