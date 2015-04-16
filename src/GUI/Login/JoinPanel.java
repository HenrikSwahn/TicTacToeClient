package GUI.Login;

import javax.swing.*;
import java.awt.*;

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
    private GridBagConstraints gbc;
    private JPanel mainPanel;

    public JoinPanel() {

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


    }
}
