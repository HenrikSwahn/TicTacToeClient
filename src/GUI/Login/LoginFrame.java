package GUI.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by henrik on 14/04/15.
 */
public class LoginFrame extends JDialog {

    private GUI.Window win;
    private JPanel mPanel;
    private LoginPanel lPanel;
    private JoinPanel jPanel;



    public LoginFrame(GUI.Window win) {

        lPanel = new LoginPanel(this);
        jPanel = new JoinPanel();
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

    private JPanel createJoinPanel() {

        JTextField name = new JTextField();
        JTextField surName = new JTextField();
        JTextField email = new JTextField();
        JPasswordField pass = new JPasswordField();
        JPasswordField rePass = new JPasswordField();



        return null;

    }

    public void nextCard() {

        CardLayout c = (CardLayout)mPanel.getLayout();
        c.next(mPanel);

    }

    public void login() {


    }
}