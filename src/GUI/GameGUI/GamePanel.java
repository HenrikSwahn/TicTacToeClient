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
}
