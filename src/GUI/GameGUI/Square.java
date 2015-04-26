package GUI.GameGUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Nilj on 26/04/15.
 */
public class Square extends JPanel {

    private int id;
    private JLabel label;
    private MatteBorder regBorder;
    private Border highlightBorder;

    public Square(int id) {

        this.id = id;
        setLayout(new GridLayout(1,1));
        label = new JLabel();
        highlightBorder = BorderFactory.createLineBorder(Color.RED, 5);
        setUpLayout();
    }

    private void setUpLayout() {

        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);

        if(id == 0 || id == 1) {

            regBorder = new MatteBorder(1,0,0,1,Color.GRAY);
            setBorder(regBorder);

        }else if(id == 2) {

            regBorder = new MatteBorder(1,0,0,0,Color.GRAY);
            setBorder(regBorder);

        }else if(id == 3 || id == 4) {

            regBorder = new MatteBorder(1,0,0,1,Color.GRAY);
            setBorder(regBorder);

        }else if(id == 5) {

            regBorder = new MatteBorder(1,0,0,0,Color.GRAY);
            setBorder(regBorder);

        }else if(id == 6 || id == 7) {

            regBorder = new MatteBorder(0,0,0,1,Color.GRAY);
            setBorder(regBorder);

        }

        addListener();
    }

    private void addListener() {

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

                setBorder(highlightBorder);

            }

            @Override
            public void mouseExited(MouseEvent e) {

                setBorder(regBorder);

            }
        });
    }
}
