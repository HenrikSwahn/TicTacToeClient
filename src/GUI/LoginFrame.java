package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by henrik on 14/04/15.
 */
public class LoginFrame extends JDialog {

    private Window win;
    private GridBagConstraints gbc;

    public LoginFrame(Window win) {

        this.win = win;
        gbc = new GridBagConstraints();
        setUpLayout();
        setLocationRelativeTo(win);
        setResizable(false);
        setModal(true);
        setVisible(true);

    }

    private void setUpLayout() {

        setSize(new Dimension(300,300));
        setLayout(new GridBagLayout());

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.weighty = 0.2;
        gbc.weightx = 1.0;
        add(createBottmPanel(), gbc);

        gbc.weighty = 0.8;
        gbc.gridy = 0;
        add(createMainPanel(), gbc);

    }

    private JPanel createBottmPanel() {

        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        return p;

    }

    private JPanel createMainPanel() {

        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        return p;

    }
}