package com.dt181g.project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FlappyBirdController {
    private FlappyBirdModel model;
    private FlappyBirdView view;
    private Timer timer;

    public FlappyBirdController(FlappyBirdModel model, FlappyBirdView view) {
        this.model = model;
        this.view = view;

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.update();
                view.repaint();
            }
        });
        timer.start();
    }

    public void jump() {
        model.jump();
    }

    public void addRandomPipe() {
        Random rand = new Random();
        int x = 600 + rand.nextInt(200); // Randomize pipe spawn location
        model.addPipe(x);
    }
}
