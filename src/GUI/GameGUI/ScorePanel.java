package GUI.GameGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nilj on 26/04/15.
 */
public class ScorePanel extends JPanel {

    private JLabel playerLabel;
    private JLabel opponentLabel;
    private GridBagConstraints gbc;

    public ScorePanel() {

        playerLabel = new JLabel("Dummy1");
        opponentLabel = new JLabel("Dummy2");
        gbc = new GridBagConstraints();
        setUpLayout();

    }

    private void setUpLayout() {

        setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        add(playerLabel, gbc);

        gbc.gridy = 1;
        add(opponentLabel, gbc);

    }

    private void setPlayerMark(String player) {

        this.playerLabel.setText(player);

    }

    private void setOpponentMark(String opponent) {

        this.opponentLabel.setText(opponent);

    }

    public void setMarks(String playerMark, String opponentMark) {

        setPlayerMark("You are: " + playerMark);
        setOpponentMark("Opponent: " + opponentMark);

    }
}
