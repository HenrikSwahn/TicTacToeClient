package Main;

import Client.Client;
import GUI.Login.LoginFrame;
import GUI.Window;

/**
 * Created by henrik on 13/04/15.
 */
public class Main {

    public static void main(String[] args) {

        Client client = new Client("127.0.0.1", 6066);
        LoginFrame login = new LoginFrame(client);
        Window win = new Window(client);
        client.setWindow(win);


        //client.connect();
    }
}
