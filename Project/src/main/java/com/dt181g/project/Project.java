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
                View view = new View();
                GamePanel gamePanel = view.getGamePanel();
                ButtonPanel buttonPanel = view.getButtonPanel();

                Controller controller = new Controller(model, gamePanel);
                gamePanel.setGameController(controller);

                view.addKeyListener(controller);
                view.add(gamePanel);

                // Assuming this is the main frame
                JFrame frame = view.getFrame();
                frame.setVisible(true);


            }
        });
    }
}
