package com.dt181g.laboration_3;

import com.dt181g.laboration_3.controllers.Controller;
import com.dt181g.laboration_3.models.Model;
import com.dt181g.laboration_3.views.View;

import javax.swing.*;

/**
 * The main starting point for laboration 3.
 * @author Andreas Backman
 */
public final class Lab3 extends JFrame {
<<<<<<< HEAD

    private Lab3() { // Utility classes should not have a public or default constructor
=======
    private Lab3() { // Utility classes should not have a public or default constructor

>>>>>>> new_project
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
<<<<<<< HEAD
                Model model = new Model();
                View view = new View(model.getCards());
                Controller controller = new Controller(model, view);
                view.setController(controller);
=======
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
>>>>>>> new_project
            }
        });
    }
}
