package GUI.GameGUI;

import javafx.scene.text.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;

/**
 * Created by Nilj on 26/04/15.
 */
public class ScorePanel extends JPanel {

    private JLabel playerLabel;
    private JLabel opponentLabel;
    private JLabel playerScore;
    private JLabel opponenScore;
    private JLabel playerTurn;
    private JLabel opponentTurn;
    private GridBagConstraints gbc;

    public ScorePanel() {

        playerLabel = new JLabel("-");
        opponentLabel = new JLabel("-");
        playerScore = new JLabel("-");
        opponenScore = new JLabel("-");
        playerTurn = new JLabel("-");
        opponentTurn = new JLabel("-");
        gbc = new GridBagConstraints();
        setLabelAttributes();
        setUpLayout();

    }

    private void setLabelAttributes() {

        playerLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        opponentLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        playerScore.setFont(new Font("Arial", Font.PLAIN, 12));
        opponenScore.setFont(new Font("Arial", Font.PLAIN, 12));
        playerTurn.setFont(new Font("Arial", Font.PLAIN, 12));
        opponentTurn.setFont(new Font("Arial", Font.PLAIN, 12));

    }

    private void setUpLayout() {

        setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.5;
        gbc.weightx = 1.0;
        add(createPanel(true), gbc);

        gbc.gridy = 1;
        add(createPanel(false), gbc);

    }

    private JPanel createPanel(boolean b) {

        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints p_gbc = new GridBagConstraints();

        p_gbc.fill = GridBagConstraints.BOTH;
        p_gbc.gridy = 0;
        p_gbc.gridx = 0;
        p_gbc.weightx = 1.0;
        p_gbc.weighty = 0.4;

        if(b)
            p.add(playerLabel, p_gbc);
        else
            p.add(opponentLabel, p_gbc);

        p_gbc.gridy = 1;
        p_gbc.weighty = 0.3;

        if(b)
            p.add(playerScore, p_gbc);
        else
            p.add(opponenScore, p_gbc);

        p_gbc.gridy = 2;

        if(b)
            p.add(playerTurn, p_gbc);
        else
            p.add(opponentTurn, p_gbc);

        return p;
    }

    private void setPlayerMark(String player) {

        this.playerLabel.setText(player);

    }

    private void setOpponentMark(String opponent) {

        this.opponentLabel.setText(opponent);

    }

    public void setPlayerScore(JLabel playerScore) {

        this.playerScore = playerScore;

    }

    public void setOpponenScore(JLabel opponenScore) {

        this.opponenScore = opponenScore;

    }

    public void setPlayerTurn() {

        this.playerTurn.setText("It's your turn!");
        this.opponentTurn.setText("");

    }

    public void setOpponentTurn() {

        this.opponentTurn.setText("It's opponents turn!");
        this.playerTurn.setText("");

    }

    public void setMarks(String playerMark, String opponentMark) {

        setPlayerMark("Your mark: " + playerMark);
        setOpponentMark("Opponent mark: " + opponentMark);

    }
}
