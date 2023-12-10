package com.dt181g.project;

import javax.swing.*;

/**
 * The main starting point for Project Assignment.
 * @author Erik Ström
 */
public final class Project {
    private Project() { // Utility classes should not have a public or default constructor
        throw new IllegalStateException("Utility class");
    }

    /**
     * Simple output of the assignment's name. Be sure to replace
     * this when working with the assignment!
     * @param args command arguments.
     */
    public static void main(final String... args) {

        // SwingUtilities.invokeLater(GUI::new);



        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Model model = new Model();

                GamePanel gamePanel = new GamePanel();


                Controller controller = new Controller(model, gamePanel);
//                gamePanel.setController(controller);


            }
        });
    }
}
