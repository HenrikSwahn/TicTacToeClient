package GUI.Login;

import GUI.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by henrik on 16/04/15.
 */
public class LoginPanel extends JPanel{

    private JLabel panelText;
    private JLabel userText;
    private JLabel passText;
    private JTextField nameField;
    private JPasswordField passField;
    private JButton okButton;
    private JButton joinB;
    private GridBagConstraints gbc;
    private LoginFrame parent;

    public LoginPanel(LoginFrame parent) {

        this.parent = parent;
        panelText = new JLabel("Login");
        userText = new JLabel("Email or username");
        passText = new JLabel("Password");
        nameField = new JTextField();
        passField = new JPasswordField();
        okButton = new JButton("Login");
        joinB = new JButton("Join");
        gbc = new GridBagConstraints();

        panelText.setFont(new Font("Ubuntu Mono", Font.PLAIN, 18));
        userText.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));
        passText.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));
        okButton.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));
        joinB.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));
        passField.setToolTipText("Password");

        okButton.addActionListener(new ButtonListener());
        joinB.addActionListener(new ButtonListener());
        okButton.setActionCommand("OK");
        joinB.setActionCommand("JOIN");

        setUpLayout();

    }

    private void setUpLayout() {

        setLayout(new GridBagLayout());
        addPanelText();
        addNameField();
        addPassField();

        gbc.insets = new Insets(10,30,10,30);
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.weightx = 0.5;
        gbc.gridwidth = 1;
        add(joinB, gbc);

        gbc.gridy = 3;
        gbc.gridx = 1;
        gbc.weightx = 0.5;
        add(okButton, gbc);
    }

    private void addPanelText() {

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weighty = 0.25;
        gbc.weightx = 1.0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10,30,10,30);
        add(panelText, gbc);

    }

    private void addNameField() {

        JPanel p = new JPanel(new GridLayout(2,1));
        gbc.gridy = 1;
        p.add(userText);
        p.add(nameField);
        add(p, gbc);

    }

    private void addPassField() {

        JPanel p = new JPanel(new GridLayout(2,1));
        gbc.gridy = 2;
        p.add(passText);
        p.add(passField);
        add(p, gbc);

    }

    private void joinPressed() {

        parent.nextCard();

    }

    private void okPressed() {

        parent.login();

    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            switch(e.getActionCommand()) {

                case "OK":
                    okPressed();
                    break;
                case "JOIN":
                    joinPressed();
                    break;
            }
        }
    }
}