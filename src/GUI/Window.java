package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by henrik on 13/04/15.
 */
public class Window extends JFrame{

    private GridBagConstraints gbc;

    public Window() {

        gbc = new GridBagConstraints();
        setUpLayout();

    }

    private void setUpLayout() {

        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(680,420));
        setResizable(true);
        setVisible(true);

    }

    private void setUpPanels() {


    }
}
