package Client;

import GUI.Window;
import Model.GameActionObject;

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

                }

            }catch(IOException e) {

                System.err.print(e);

            }catch(ClassNotFoundException e) {

                System.err.print(e);

            }
        }
    }

    public void connect(Socket sock) {

        try {

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
