package com.dt181g.project;

import javax.swing.*;

/**
 * The main starting point for Project Assignment.
 * @author Erik Ström
 */
public final class Project {

//    public static FlappyBird flappyBird;
    private Project() { // Utility classes should not have a public or default constructor
        throw new IllegalStateException("Utility class");
    }

    /**
     * Simple output of the assignment's name. Be sure to replace
     * this when working with the assignment!
     * @param args command arguments.
     */
    public static void main(final String... args) {
//        Renderer renderer = new Renderer();
//        GUI gui = new GUI();
        SwingUtilities.invokeLater(() -> {
            FlappyBird.flappyBird = new FlappyBird();
        });
    }
}
