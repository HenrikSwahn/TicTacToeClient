package GUI;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by henrik on 14/04/15.
 */
public class LoginFrame extends JDialog {

    private Window win;
    private GridBagConstraints gbc;
    private JPanel mPanel;



    public LoginFrame(Window win) {

        this.win = win;
        gbc = new GridBagConstraints();
        setUpLayout();
        setLocationRelativeTo(win);
        setResizable(false);
        setModal(true);
        setVisible(true);

    }

    private void setUpLayout() {

        setSize(new Dimension(300,300));
        setLayout(new GridBagLayout());

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.weighty = 0.2;
        gbc.weightx = 1.0;
        add(createBottmPanel(), gbc);

        gbc.weighty = 0.8;
        gbc.gridy = 0;
        mPanel = createMainPanel();
        add(mPanel, gbc);

    }

    private JPanel createBottmPanel() {

        JPanel p = new JPanel();
        JButton b = new JButton("CLICK ME");
        b.addActionListener(new ButtonListener());
        p.add(b);
        p.setBackground(Color.BLACK);
        return p;

    }

    private JPanel createMainPanel() {

        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        p.setLayout(new CardLayout());
        p.add(createMainPanel2());
        p.add(createMainPanel3());
        return p;

    }

    private JPanel createMainPanel2() {

        JPanel p = new JPanel();
        p.setBackground(Color.GREEN);
        return p;

    }

    private JPanel createMainPanel3() {

        JPanel p = new JPanel();
        p.setBackground(Color.RED);
        return p;

    }

    private void update() {

        CardLayout c = (CardLayout)mPanel.getLayout();
        c.next(mPanel);

    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            update();

        }
    }
}