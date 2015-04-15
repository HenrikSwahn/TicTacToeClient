package GUI;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by henrik on 14/04/15.
 */
public class LoginFrame extends JDialog {

    private Window win;
    private JPanel mPanel;



    public LoginFrame(Window win) {

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
        p.add(createLoginPanel());
        p.add(createMainPanel3());
        return p;

    }

    private JPanel createLoginPanel() {

        JPanel p = new JPanel();
        JLabel l = new JLabel("Login");
        JTextField nameField = createLoginField();
        JPasswordField passField = new JPasswordField();
        JButton okButton = new JButton("Login");
        JButton noAccountB = new JButton("Join");
        GridBagConstraints gbc = new GridBagConstraints();
        p.setLayout(new GridBagLayout());

        l.setFont(new Font("Ubuntu Mono", Font.PLAIN, 18));
        okButton.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));
        noAccountB.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));

        passField.setToolTipText("Password");

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weighty = 0.25;
        gbc.weightx = 1.0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10,30,10,30);
        p.add(l, gbc);

        gbc.gridy = 1;
        p.add(nameField, gbc);

        gbc.gridy = 2;
        p.add(passField, gbc);


        gbc.insets = new Insets(15,30,15,30);
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.weightx = 0.5;
        gbc.gridwidth = 1;
        p.add(noAccountB, gbc);

        gbc.gridy = 3;
        gbc.gridx = 1;
        gbc.weightx = 0.5;
        p.add(okButton, gbc);

        return p;

    }

    private JTextField createLoginField() {

        final JTextField nameField = new JTextField();

        nameField.setFont(new Font("Ubuntu Mono", Font.ITALIC, 16));
        nameField.setToolTipText("Email or username");
        nameField.setText("Username or email");

        nameField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

                nameField.setText("");
                nameField.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));

            }

            @Override
            public void focusLost(FocusEvent e) {

                nameField.setFont(new Font("Ubuntu Mono", Font.ITALIC, 16));
                nameField.setText("Username or email");

            }
        });

        return nameField;

    }

    private JPanel createMainPanel3() {

        JPanel p = new JPanel();
        p.setBackground(Color.RED);
        return p;

    }

    private void update() {

        CardLayout c = (CardLayout)mPanel.getLayout();
        c.next(mPanel);

    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            update();

        }
    }
}