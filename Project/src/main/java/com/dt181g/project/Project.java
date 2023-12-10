package com.dt181g.project;

import javax.swing.*;

/**
 * The main starting point for Project Assignment.
 * @author Andreas Backman
 */
public final class Project {
    private Project() { // Utility classes should not have a public or default constructor
        throw new IllegalStateException("Utility class");
    }

    /**
     * Main method for launching the program
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
