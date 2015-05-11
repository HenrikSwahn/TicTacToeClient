package GUI.GameGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nilj on 26/04/15.
 */
public class GameField extends JPanel {

    private GamePanel parent;
    private Square[][] squares;

    public GameField(GamePanel parent) {

        this.parent = parent;
        this.squares = new Square[3][3];
        setUpLayout();

    }

    private void setUpLayout() {

        setBounds(80,20,300,300);
        setLayout(new GridLayout(3,3));
        setBackground(Color.green);

        int counter = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                Square s = new Square(counter++, this);
                squares[i][j] = s;
                add(s,i,j);
            }
        }
    }

    public void squareClicked(int id) {

        parent.squareClicked(id);

    }

    public void start() {

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                squares[i][j].start();
            }
        }
    }

    public void setClickedSquare(String mark, int id) {

        int i;

        if(id <= 2)
            i = 0;
        else if(id >= 3 && id <= 5) {
            id = id - 3;
            i = 1;
        }else {
            id = id - 6;
            i = 2;
        }

        squares[i][id].setSquareMark(mark);

    }
}
