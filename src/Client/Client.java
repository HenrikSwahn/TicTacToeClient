package Client;

import GUI.Window;
import Model.GameActionObject;
import Model.User;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

/**
 * Created by henrik on 13/04/15.
 */
public class Client {

    private Socket conn;
    private final String address;
    private final int PORT;
    private Window win;
    private ObjectOutputStream objOut;
    private ObjectInputStream objIn;
    private User usr;
    private String mark;

    public Client(String address, int port) {

        this.address = address;
        this.PORT = port;

    }

    private void newGameAsked() {

        int response = JOptionPane.showConfirmDialog(
            null,
            "Start a new game?",
            "New game",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        GameActionObject gao = null;

        if(response == JOptionPane.YES_OPTION) {

            gao = new GameActionObject(1, -1);

        }else if(response == JOptionPane.NO_OPTION) {

            gao = new GameActionObject(2, -1);

        }
        send(gao);
    }

    private void gotGameActionObject(GameActionObject gao) {


        switch(gao.getAction()) {

            case 0:
                newGameAsked();
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                mark = "X";
                win.incMessage("Server > You are X");
                win.setMarks("X", "O");
                break;
            case 5:
                this.mark = "O";
                win.incMessage("Server > You are O");
                win.setMarks("O", "X");
                break;
            case 6:
                 win.setClickedSquare(gao.getMark(), gao.getVal());
                win.incMessage("Server > Valid move");
                break;
            case 7:
                win.incMessage("Server > Invalid move");
                break;
            case 8:
                win.start();
                break;
            case 9:
                win.lock();
                break;
            case 10:
                win.unlock();
                break;
        }
    }

    public void runClient() {

        while(true) {

            try {

                Object obj = objIn.readObject();
                if(obj instanceof String) {

                    win.incMessage(obj);

                }else if(obj instanceof GameActionObject) {

                    gotGameActionObject((GameActionObject)obj);

                }
            }catch(IOException e) {

                System.err.print(e);
                e.printStackTrace();

            }catch(ClassNotFoundException e) {

                System.err.print(e);

            }
        }
    }

    public void connect(Socket sock, User usr) {

        try {

            this.usr = usr;
            conn = sock;
            objOut = new ObjectOutputStream(conn.getOutputStream());
            objIn = new ObjectInputStream(conn.getInputStream());
            win.setVisible(true);

        }catch(IOException e) {

            System.err.print(e);

        }
    }

    public void setWindow(Window win) {

        this.win = win;

    }

    public void send(Object obj) {

        try {

            objOut.writeObject(obj);
            objOut.flush();

        }catch(IOException e) {

            System.err.print(e);

        }
    }
}
