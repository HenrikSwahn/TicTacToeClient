package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by henrik on 13/04/15.
 */
public class ChatPanel extends JPanel {

    private JTextArea area;
    private JTextField input;
    private GridBagConstraints gbc;
    private Window window;

    public ChatPanel(Window window) {

        this.window = window;
        area = new JTextArea();
        area.setEditable(false);
        input = new JTextField();
        gbc = new GridBagConstraints();
        setUpLayout();
        addListeners();
        this.setMaximumSize(new Dimension(getWidth(), getHeight()));

    }

    private void setUpLayout() {

        setLayout(new GridBagLayout());

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.95;
        JScrollPane jsp = new JScrollPane(area);
        add(jsp, gbc);

        gbc.weighty = 0.05;
        gbc.gridy = 1;
        add(input, gbc);

    }

    private void addListeners() {

        input.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_ENTER) {

                    window.send(input.getText());
                    input.setText("");

                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }

        });
    }

    public void append(Object obj) {

        if(obj instanceof String) {

            area.append(obj + "\n");

        }
    }
}
