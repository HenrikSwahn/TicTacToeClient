package Client;

import GUI.Window;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by henrik on 13/04/15.
 */
public class Client {

    private Socket conn;
    private final String address;
    private final int PORT;

    private OutputStream out;
    private InputStream in;

    private Window win;

    public Client(String address, int port) {

        this.address = address;
        this.PORT = port;

    }

    private void runServer() {

        byte[] incBytes;

        while(true) {

            incBytes = new byte[4096];

            try {

                in.read(incBytes);
                win.incMessage(new String(incBytes, "UTF-8"));

            }catch(IOException e) {

                System.err.print(e);

            }
        }
    }

    public void connect() {

        try {

            conn = new Socket(address, PORT);
            out = conn.getOutputStream();
            in = conn.getInputStream();
            runServer();

        }catch(IOException e) {

            System.err.print(e);

        }
    }

    public void setWindow(Window win) {

        this.win = win;

    }

    public void send(Object obj) {

        try {

            if(obj instanceof String) {

                out.write(((String) obj).getBytes());

            }

        }catch(IOException e) {

            System.err.print(e);

        }
    }
}
