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
    private GameField parent;
    private boolean enabled;

    public Square(int id, GameField parent) {

        this.id = id;
        this.parent = parent;
        enabled = false;
        setLayout(new GridLayout(1,1));
        label = new JLabel("-");
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

    public void start() {

        enabled = true;

    }

    public void lock() {

        setBorder(regBorder);
        enabled = false;

    }

    public void unlock() {

        enabled = true;

    }

    public void setSquareMark(String mark) {

        label.setText(mark);

    }

    private void addListener() {

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

                if(enabled)
                    parent.squareClicked(id);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

                if(enabled)
                    setBorder(highlightBorder);

            }

            @Override
            public void mouseExited(MouseEvent e) {

                if(enabled)
                    setBorder(regBorder);

            }
        });
    }
}
