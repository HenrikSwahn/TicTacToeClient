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

    //private OutputStream out;
    //private InputStream in;

    private ObjectOutputStream out;
    private ObjectInputStream in;

    private Window win;

    public Client(String address, int port) {

        this.address = address;
        this.PORT = port;

    }

    public void runClient() {

        //byte[] incBytes;

        while(true) {

            //incBytes = new byte[4096];

            try {

                //in.read(incBytes);
                //win.incMessage(new String(incBytes, "UTF-8"));
                Object obj = in.readObject();

            }catch(IOException e) {

                System.err.print(e);

            }catch(ClassNotFoundException e) {

                e.printStackTrace();

            }
        }
    }

    public void connect(Socket sock) {

        try {

            conn = sock;
            out = new ObjectOutputStream(conn.getOutputStream());
            in = new ObjectInputStream(conn.getInputStream());
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

            /*if(obj instanceof String) {

                out.write(((String) obj).getBytes());

            }*/
            System.out.println(((GameActionObject)obj).getId());
            out.writeObject(obj);

        }catch(IOException e) {

            System.err.print(e);

        }
    }
}
