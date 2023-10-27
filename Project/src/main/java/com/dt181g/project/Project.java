package com.dt181g.project;

import com.dt181g.project.View;
import javax.swing.*;
import java.awt.*;

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

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        view.setVisible(true);
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
