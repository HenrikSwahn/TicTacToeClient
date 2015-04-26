package GUI.GameGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nilj on 26/04/15.
 */
public class GameField extends JPanel {

    public GameField() {

        setUpLayout();
    }

    private void setUpLayout() {

        setBounds(80,20,300,300);
        setBackground(Color.black);

    }

}
