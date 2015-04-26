package GUI;

import Client.Client;
import GUI.GameGUI.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.Socket;

/**
 * Created by henrik on 13/04/15.
 */
public class Window extends JFrame{

    private GridBagConstraints gbc;
    private ChatPanel chat;
    private Client client;

    public Window(Client client) {

        this.client = client;
        gbc = new GridBagConstraints();
        chat = new ChatPanel(this);
        setUpLayout();

    }

    private void setUpLayout() {

        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(680, 555));
        setResizable(true);
        setUpPanels();
        setLocationRelativeTo(null);

    }

    private void setUpPanels() {

        GamePanel dummy = new GamePanel();

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.7;
        add(dummy, gbc);

        gbc.weighty = 0.3;
        gbc.gridy = 1;
        add(chat, gbc);

    }

    public void incMessage(Object obj) {

        chat.append(obj);

    }

    public void send(Object obj) {

        client.send(obj);

    }
}
