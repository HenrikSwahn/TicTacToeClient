package GUI.GameGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nilj on 26/04/15.
 */
public class ScorePanel extends JPanel {

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

    private void setPlayerMark(String player) {

        this.p1Label.setText(player);

    }

    private void setOpponentMark(String opponent) {

        this.p2Label.setText(opponent);

    }

    public void setMarks(String playerMark, String opponentMark) {

        setPlayerMark("You are: " + playerMark);
        setOpponentMark("Opponent: " + opponentMark);

    }
}
