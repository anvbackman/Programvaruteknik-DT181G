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

                Controller controller = new Controller();
//                Model model = new Model();
//                View view = new View();
//
//                Controller controller = new Controller(model, view);
//                view.setController(controller);
            }
        });
    }
}
