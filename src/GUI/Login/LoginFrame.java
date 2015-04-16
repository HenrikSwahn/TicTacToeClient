package GUI.Login;

import GUI.Window;

import javax.swing.*;
import java.awt.*;

/**
 * Created by henrik on 14/04/15.
 */
public class LoginFrame extends JDialog {

    private GUI.Window win;
    private JPanel mPanel;
    private LoginPanel lPanel;
    private JoinPanel jPanel;

    public LoginFrame(Window win) {

        lPanel = new LoginPanel(this);
        jPanel = new JoinPanel(this);
        this.win = win;
        setUpLayout();
        setLocationRelativeTo(win);
        setResizable(false);
        setModal(true);
        setVisible(true);

    }

    private void setUpLayout() {

        setSize(new Dimension(300,300));

        mPanel = createMainPanel();
        add(mPanel, BorderLayout.CENTER);

    }

    private JPanel createMainPanel() {

        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        p.setLayout(new CardLayout());
        p.add(lPanel);
        p.add(jPanel);
        return p;

    }

    public void nextCard() {

        CardLayout c = (CardLayout)mPanel.getLayout();
        c.next(mPanel);

    }

    public void login() {


    }
}