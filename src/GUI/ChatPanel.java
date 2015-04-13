package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by henrik on 13/04/15.
 */
public class ChatPanel extends JPanel {

    private JTextArea area;
    private JTextField input;
    private GridBagConstraints gbc;

    public ChatPanel() {

        area = new JTextArea();
        input = new JTextField();
        gbc = new GridBagConstraints();
        setUpLayout();

    }

    private void setUpLayout() {

        setLayout(new GridBagLayout());

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.7;
        add(area, gbc);

        gbc.weighty = 0.3;
        JScrollPane jsp = new JScrollPane(area);
        add(jsp, gbc);

    }
}
