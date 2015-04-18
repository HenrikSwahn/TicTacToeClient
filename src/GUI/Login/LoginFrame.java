package GUI.Login;

import GUI.Window;
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

    private GUI.Window win;
    private JPanel mPanel;
    private LoginPanel lPanel;
    private JoinPanel jPanel;
    private Socket conn;

    public LoginFrame(Window win) {

        lPanel = new LoginPanel(this);
        jPanel = new JoinPanel(this);
        this.win = win;
        setUpLayout();
        setLocationRelativeTo(win);
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

    public void login() {


    }

    public String joinPressed(User user) {

        try {

            conn = new Socket("127.0.0.1", 6066);
            ObjectOutputStream ObjOut = new ObjectOutputStream(conn.getOutputStream());
            ObjectInputStream ObjIn = new ObjectInputStream(conn.getInputStream());

            ObjOut.writeObject(user);
            ObjOut.flush();
            int statusCode = ObjIn.readInt();

            switch(statusCode) {
                case 0:
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

        }
        return null;
    }
}