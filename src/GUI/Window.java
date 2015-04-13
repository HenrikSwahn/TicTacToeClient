package GUI;

import Client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by henrik on 13/04/15.
 */
public class Window extends JFrame{

    private GridBagConstraints gbc;
    private ChatPanel chat;
    private Client client;

    public Window() {

        gbc = new GridBagConstraints();
        chat = new ChatPanel();
        setUpLayout();

    }

    private void setUpLayout() {

        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(680,420));
        setResizable(true);
        setUpPanels();
        setVisible(true);

    }

    private void setUpPanels() {

        JPanel dummy = new JPanel();

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.6;
        add(dummy, gbc);

        gbc.weighty = 0.4;
        gbc.gridy = 1;
        add(chat, gbc);

    }

    public void incMessage(Object obj) {

        chat.append(obj);
    }
}
