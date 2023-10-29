package com.dt181g.project;

import com.dt181g.project.View;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.InitializationException;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;

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

        View view = new View();

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException | IllegalAccessException |
               UnsupportedLookAndFeelException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            Window window = new Window(800, 800, "Flappy Bird", view);
        });



//        Model model = new Model();
//        View view = new View();
//        Controller controller = new Controller(model, view);
//        view.setVisible(true);
//        JButton start = new JButton("Start");
//        start.addActionListener(e -> controller.startGame());
//        Renderer renderer = new Renderer();
//        GUI gui = new GUI();
//        SwingUtilities.invokeLater(() -> {
//            FlappyBird.flappyBird = new FlappyBird();
//        });
//        SwingUtilities.invokeLater(() -> {
//
//
//            JFrame frame = new JFrame("Flappy Bird");
//            frame.add(view);
//            frame.setSize(800, 800);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setVisible(true);
//
//            JButton start = new JButton("Start Game");
//            start.addActionListener(e -> controller.startGame());
//            frame.add(start, BorderLayout.SOUTH);
////            view.addKeyListener(controller);
////            view.setFocusable(true);
//        });
    }
}
