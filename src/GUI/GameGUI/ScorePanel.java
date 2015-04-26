package GUI.GameGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nilj on 26/04/15.
 */
public class ScorePanel extends JPanel {

    private String player1;
    private String player2;
    private JLabel p1Label;
    private JLabel p2Label;
    private GridBagConstraints gbc;

    public ScorePanel() {

        setBackground(Color.red);
        p1Label = new JLabel("Dummy1");
        p2Label = new JLabel("Dummy2");
        gbc = new GridBagConstraints();
        setUpLayout();

    }

    private void setUpLayout() {


    }

    public void setPlayer1(String player1) {
        
        this.player1 = player1;
        this.p1Label.setText(this.player1);

    }

    public void setPlayer2(String player2) {

        this.player2 = player2;
        this.p2Label.setText(this.player2);

    }
}
