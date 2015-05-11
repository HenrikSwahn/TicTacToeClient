package GUI;

import Client.Client;
import GUI.GameGUI.GamePanel;
import Model.GameActionObject;

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
    private GamePanel gamePanel;
    private Client client;

    public Window(Client client) {

        this.client = client;
        gbc = new GridBagConstraints();
        chat = new ChatPanel(this);
        gamePanel = new GamePanel(this);
        chat.setSize(getWidth(), 150);
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

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.7;
        add(gamePanel, gbc);

        gbc.fill = GridBagConstraints.BOTH;
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

    public void squareClicked(int id) {

        client.send(new GameActionObject(3,id));

    }

    public void start() {

        gamePanel.start();

    }

    public void setMarks(String playerMark, String opponentMark) {

        gamePanel.setMarks(playerMark, opponentMark);

    }

    public void setClickedSquare(String mark, int id) {

        gamePanel.setClickedSquare(mark, id);

    }

    public void lock() {

        gamePanel.lock();

    }

    public void unlock() {

        gamePanel.unlock();

    }
}
