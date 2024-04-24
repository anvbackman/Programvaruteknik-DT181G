package com.dt181g.laboration_2;

import javax.swing.SwingUtilities;

/**
 * The main starting point for laboration 3.
 * @author Andreas Backman
 */
public final class Lab2 {
    private Lab2() { // Utility classes should not have a public or default constructor
        throw new IllegalStateException("Utility class");
    }

    /**
     * The main method that starts the GUI.
     * @param args the command line arguments
     */
    public static void main(final String... args) {

        SwingUtilities.invokeLater(() -> {
            ResourcePool resourcePool = new ResourcePool(50); // Start with 50 resources
            GUI gui = new GUI(resourcePool); // Create the GUI with the resource pool
        });
    }
}
