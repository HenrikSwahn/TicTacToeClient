package GUI.Login;

import Model.User;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by henrik on 16/04/15.
 */
public class JoinPanel extends JPanel {

    private JLabel panelLabel;
    private JLabel promptLabel;
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
    private JScrollPane jsp;
    private int fieldCounter;

    public JoinPanel(LoginFrame parent) {

        this.parent = parent;
        panelLabel = new JLabel("Fill form below please");
        promptLabel = new JLabel();
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
        fieldCounter = 0;

        panelLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        promptLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        surNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        rePassLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userNameLabel.setFont(new Font("Arialß", Font.PLAIN, 16));
        join.setActionCommand("JOIN");
        abort.setActionCommand("ABORT");
        join.addActionListener(new ButtonListener());
        abort.addActionListener(new ButtonListener());
        join.setEnabled(false);

        addFieldListeneners();

        setUpLayout();

    }

    private void setUpLayout() {

        setLayout(new GridLayout(1,1));
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setPreferredSize(new Dimension(200,500));

        addPanelText();
        addPromptLabel();
        addNameField();
        addSurNameField();
        addEmailField();
        addPasswordField();
        addRePasswordField();
        addUsernameField();
        addButtons();

        jsp = new JScrollPane(mainPanel);
        mainPanel.setAutoscrolls(true);
        add(jsp);
    }

    private void addPanelText() {

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weighty = 0.2;
        gbc.weightx = 0.5;
        gbc.gridwidth =  2;
        gbc.insets = new Insets(0,20,0,20);
        mainPanel.add(panelLabel, gbc);
    }

    private void addPromptLabel() {

        gbc.gridy = 1;
        mainPanel.add(promptLabel, gbc);
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

    private void abort() {

        parent.nextCard();
        name.setText("");
        surName.setText("");
        email.setText("");
        pass.setText("");
        rePass.setText("");
        userNameField.setText("");

    }

    private void join() {

        String name = this.name.getText();
        String surname = this.surName.getText();
        String email = this.email.getText();
        String pass = String.valueOf(this.pass.getPassword());
        String rePass = String.valueOf(this.rePass.getPassword());
        String userName = this.userNameField.getText();

        if(rePass.equals(pass)) {

            if(checkEmailFormat(email)) {

                User user = new User(name, surname, email, pass, userName);
                String response = parent.joinPressed(user);

                switch(response) {
                    case "Email already in use":
                        break;
                    case "Username already in use":
                        break;
                    case "Error, please try again":
                        break;
                    default:

                        break;
                }
            }else{

                jsp.getViewport().setViewPosition(new Point(0,0));
                promptLabel.setText("Error email format");

            }
        }else{

            jsp.getViewport().setViewPosition(new Point(0,0));
            promptLabel.setText("Password does not match");

        }
    }

    private boolean checkEmailFormat(String email) {

        String pattern = "(.*)(@)(.*)(\\.)(.*)";
        Pattern pat = Pattern.compile(pattern);
        Matcher match = pat.matcher(email);

        if(match.find()) {

            return true;

        }
        return false;
    }

    private void addFieldListeneners() {

        name.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                changeOccured();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                changeOccured();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                changeOccured();

            }
        });

        surName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                changeOccured();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                changeOccured();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                changeOccured();

            }
        });

        email.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                changeOccured();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                changeOccured();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                changeOccured();

            }
        });

        pass.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                changeOccured();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                changeOccured();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                changeOccured();

            }
        });

        rePass.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                changeOccured();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                changeOccured();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                changeOccured();

            }
        });

        userNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                changeOccured();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                changeOccured();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                changeOccured();

            }
        });
    }

    private void changeOccured() {

        if(!name.getText().equals("")) {

            if(!surName.getText().equals("")) {

                if(!email.getText().equals("")) {

                    if(!String.valueOf(pass.getPassword()).equals("")) {

                        if(!String.valueOf(rePass.getPassword()).equals("")) {

                            if(!userNameField.getText().equals("")) {

                                join.setEnabled(true);

                            }else{

                                join.setEnabled(false);

                            }
                        }else{

                            join.setEnabled(false);

                        }
                    }else{

                        join.setEnabled(false);

                    }
                }else{

                    join.setEnabled(false);

                }
            }else{

                join.setEnabled(false);

            }
        }else{

            join.setEnabled(false);

        }
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            switch(e.getActionCommand()) {

                case "ABORT":
                    abort();
                    break;
                case "JOIN":
                    join();
                    break;
            }
        }
    }
}
