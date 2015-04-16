package GUI.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by henrik on 16/04/15.
 */
public class JoinPanel extends JPanel {

    private JLabel panelLabel;
    private JLabel nameLabel;
    private JLabel surNameLabel;
    private JLabel emailLabel;
    private JLabel passLabel;
    private JLabel rePassLabel;
    private JLabel userNameLabel;
    private JTextField name;
    private JTextField surName;
    private JTextField email;
    private JPasswordField pass;
    private JPasswordField rePass;
    private JTextField userNameField;
    private JButton join;
    private JButton abort;
    private GridBagConstraints gbc;
    private JPanel mainPanel;
    private LoginFrame parent;

    public JoinPanel(LoginFrame parent) {

        this.parent = parent;
        panelLabel = new JLabel("Fill form below please");
        nameLabel = new JLabel("Name");
        surNameLabel = new JLabel("Lastname");
        emailLabel = new JLabel("Email");
        passLabel = new JLabel("Password");
        rePassLabel = new JLabel("Confirm password");
        userNameLabel = new JLabel("Username");
        name = new JTextField();
        surName = new JTextField();
        email = new JTextField();
        pass = new JPasswordField();
        rePass = new JPasswordField();
        userNameField = new JTextField();
        join = new JButton("Join");
        abort = new JButton("Abort");
        gbc = new GridBagConstraints();
        mainPanel = new JPanel();

        panelLabel.setFont(new Font("Ubuntu Mono", Font.PLAIN, 18));
        nameLabel.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));
        surNameLabel.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));
        emailLabel.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));
        passLabel.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));
        rePassLabel.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));
        userNameLabel.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));

        setUpLayout();

    }

    private void setUpLayout() {

        setLayout(new GridLayout(1,1));
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setPreferredSize(new Dimension(200,500));


        addPanelText();
        addNameField();
        addSurNameField();
        addEmailField();
        addPasswordField();
        addRePasswordField();
        addUsernameField();
        addButtons();

        JScrollPane jsp = new JScrollPane(mainPanel);
        mainPanel.setAutoscrolls(true);
        add(jsp);
    }

    private void addPanelText() {

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.weighty = 0.2;
        gbc.weightx = 0.5;
        gbc.gridwidth =  2;
        gbc.insets = new Insets(0,20,0,20);
        mainPanel.add(panelLabel, gbc);
    }

    private void addNameField() {

        JPanel p = new JPanel(new GridLayout(2,1));
        gbc.gridy = 2;
        gbc.weightx = 0.2;
        p.add(nameLabel);
        p.add(name);
        mainPanel.add(p, gbc);

    }

    private void addSurNameField() {

        JPanel p = new JPanel(new GridLayout(2,1));
        gbc.gridy = 3;
        p.add(surNameLabel);
        p.add(surName);
        mainPanel.add(p, gbc);

    }

    private void addEmailField() {

        JPanel p = new JPanel(new GridLayout(2,1));
        gbc.gridy = 4;
        p.add(emailLabel);
        p.add(email);
        mainPanel.add(p, gbc);

    }

    private void addPasswordField() {

        JPanel p = new JPanel(new GridLayout(2,1));
        gbc.gridy = 5;
        p.add(passLabel);
        p.add(pass);
        mainPanel.add(p, gbc);

    }

    private void addRePasswordField() {

        JPanel p = new JPanel(new GridLayout(2,1));
        gbc.gridy = 6;
        p.add(rePassLabel);
        p.add(rePass);
        mainPanel.add(p, gbc);

    }

    private void addUsernameField() {

        JPanel p = new JPanel(new GridLayout(2,1));
        gbc.gridy = 7;
        p.add(userNameLabel);
        p.add(userNameField);
        mainPanel.add(p, gbc);

    }

    private void addButtons() {

        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(0,40,0,40);
        mainPanel.add(join, gbc);

        gbc.gridy = 9;
        mainPanel.add(abort, gbc);

    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
