package com.dt181g.laboration_3;

import com.dt181g.laboration_3.controllers.Controller;
import javax.swing.*;

/**
 * The main starting point for laboration 3.
 * @author Andreas Backman
 */
public final class Lab3 {
    private Lab3() { // Utility classes should not have a public or default constructor
    }

    /**
     * Main method for the application.
     * @param args command arguments.
     */
    public static void main(final String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Controller controller = new Controller();
            }
        });
    }
}
