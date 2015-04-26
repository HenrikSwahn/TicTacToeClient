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
        setLayout(new GridLayout(3,3));
        setBackground(Color.green);

        int counter = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                add(new Square(counter++),i,j);
            }
        }
    }
}
