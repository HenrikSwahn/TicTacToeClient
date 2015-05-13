package GUI.GameGUI;

import GUI.*;
import GUI.Window;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nilj on 26/04/15.
 */
public class GamePanel extends JPanel {

    private GridBagConstraints gbc;
    private ScorePanel scorePanel;
    private GameField gf;
    private Window parent;

    public GamePanel(Window parent) {

        this.parent = parent;
        gbc = new GridBagConstraints();
        scorePanel = new ScorePanel();
        gf = new GameField(this);
        setUpLayout();

    }

    private void setUpLayout() {

        setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.7;
        gbc.weighty = 1.0;
        JPanel dummy = new JPanel();
        dummy.setLayout(null);
        dummy.add(gf);
        add(dummy, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.weightx = 0.3;
        add(scorePanel, gbc);

    }

    public void squareClicked(int id) {

        parent.squareClicked(id);

    }

    public void start() {

        gf.start();

    }

    public void setMarks(String playerMark, String opponentMark) {

        scorePanel.setMarks(playerMark, opponentMark);

    }

    public void setClickedSquare(String mark, int id) {

        gf.setClickedSquare(mark, id);

    }

    public void lock() {

        gf.lock();
        scorePanel.setOpponentTurn();

    }

    public void unlock() {

        gf.unlock();
        scorePanel.setPlayerTurn();

    }

    public void updateScore(String myMark, String incMark,  int val) {

        if(myMark.equals(incMark))
            scorePanel.setPlayerScore(val);
        else if(!myMark.equals(incMark))
            scorePanel.setOpponenScore(val);

    }
}
