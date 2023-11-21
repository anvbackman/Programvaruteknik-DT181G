package com.dt181g.laboration_3;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * The main starting point for laboration 3.
 * @author Erik Ström
 */
public final class Lab3 extends JFrame {
    private JTextField numberOfCardsField;
    private Lab3() { // Utility classes should not have a public or default constructor
        numberOfCardsField = new JTextField();
    }

    /**
     * Simple output of the assignment's name. Be sure to replace
     * this when working with the assignment!
     * @param args command arguments.
     */
    public static void main(final String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                JFrame frame = new JFrame("Memory");
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setSize(600, 400);

                Model model = new Model();
                View view = new View(model.getCards());
                Controller controller = new Controller(model, view);



//                frame.add(view);
//                frame.setLocationRelativeTo(null);
//                frame.setVisible(true);
            }
        });
    }
}
