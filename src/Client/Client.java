package Client;

import GUI.Window;
import Model.GameActionObject;
import Model.User;

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

    public Client(String address, int port) {

        this.address = address;
        this.PORT = port;

    }

    public void runClient() {

        while(true) {

            try {

                Object obj = objIn.readObject();
                if(obj instanceof String) {

                    win.incMessage(obj);

                }else if(obj instanceof GameActionObject) {

                    GameActionObject gao = new GameActionObject(1,-1);
                    objOut.writeObject(gao);
                    objOut.flush();
                    win.start();

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
