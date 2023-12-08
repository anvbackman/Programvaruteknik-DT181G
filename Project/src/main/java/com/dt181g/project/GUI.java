//package com.dt181g.project;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class GUI extends JFrame  {
//
//    public GUI() {
//
//        Model model = new Model();
//        View view = new View();
//        Controller controller = new Controller(model, view);
//        view.setGameController(controller);
//
//        JFrame frame = new JFrame("Flappy Bird");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 800);
//        frame.setResizable(false);
//        frame.add(view);
//        frame.setVisible(true);
//        frame.setFocusable(true);
//
//        // Add key listener to the frame
//        frame.addKeyListener(controller);
//    }
//}
