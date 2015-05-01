package GUI.Login;

import GUI.Window;
import Model.LoginObject;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by henrik on 14/04/15.
 */
public class LoginFrame extends JDialog {

    private Client.Client client;
    private JPanel mPanel;
    private LoginPanel lPanel;
    private JoinPanel jPanel;
    private Socket conn;

    public LoginFrame(Client.Client client) {

        lPanel = new LoginPanel(this);
        jPanel = new JoinPanel(this);
        this.client = client;
        setUpLayout();
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
        setVisible(true);

    }

    private void setUpLayout() {

        setSize(new Dimension(300,300));
        mPanel = createMainPanel();
        add(mPanel, BorderLayout.CENTER);

    }

    private JPanel createMainPanel() {

        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        p.setLayout(new CardLayout());
        p.add(lPanel);
        p.add(jPanel);
        return p;

    }

    public void nextCard() {

        CardLayout c = (CardLayout)mPanel.getLayout();
        c.next(mPanel);

    }

    public String login(LoginObject login) {

        try {

            conn = new Socket("127.0.0.1", 6066);
            ObjectOutputStream ObjOut = new ObjectOutputStream(conn.getOutputStream());
            ObjOut.writeObject(login);
            ObjOut.flush();

            ObjectInputStream ObjIn = new ObjectInputStream(conn.getInputStream());
            int statueCode = ObjIn.readInt();
            User usr = (User)ObjIn.readObject();

            switch(statueCode) {
                case 0:
                    dispose();
                    client.connect(conn, usr);
                    break;
                case 1:
                    conn.close();
                    return "Wrong password";
                case 2:
                    conn.close();
                    return "User does not exist";
            }
        }catch(IOException e) {

            System.err.print(e);

        }catch(ClassNotFoundException e) {

            System.err.print(e);

        }

        return null;

    }

    public String joinPressed(User user) {

        try {

            conn = new Socket("127.0.0.1", 6066);
            ObjectOutputStream ObjOut = new ObjectOutputStream(conn.getOutputStream());
            ObjOut.writeObject(user);
            ObjOut.flush();

            ObjectInputStream ObjIn = new ObjectInputStream(conn.getInputStream());
            int statusCode = ObjIn.readInt();
            User usr = (User)ObjIn.readObject();

            switch(statusCode) {
                case 0:
                    dispose();
                    client.connect(conn, usr);
                    return "Account created, logged in";
                case 1:
                    return "Email already in use";
                case 2:
                    return "Username already in use";
                default:
                    return "Error, please try again";

            }

        }catch(IOException e) {

            System.err.print(e);

        }catch(ClassNotFoundException e) {

            System.err.print(e);

        }
        return null;
    }
}