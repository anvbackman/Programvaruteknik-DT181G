package com.dt181g.laboration_3;

import javax.swing.*;

/**
 * The main starting point for laboration 3.
 * @author Erik Ström
 */
public final class Lab3 extends JFrame {
    private Lab3() { // Utility classes should not have a public or default constructor

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
                Lab3 frame = new Lab3();
                frame.setTitle("Memory");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 400);

                Model model = new Model();
                View view = new View(model.getCards());
                Controller controller = new Controller(model, view);

                frame.add(view);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
