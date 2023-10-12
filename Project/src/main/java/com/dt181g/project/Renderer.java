package com.dt181g.project;

import javax.swing.*;
import java.awt.*;

public class Renderer extends JPanel {

    public static final long serialVersionUID = 1L; // ????

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        FlappyBird flappyBird = FlappyBird.flappyBird;

//        // Draw the background
//        g.setColor(Color.CYAN);
//        g.fillRect(0, 0, flappyBird.WIDTH, flappyBird.HEIGHT);
//
//        // Draw the obstacles
//        for (Obstacle o : flappyBird.getObstacle()) {
//            flappyBird.paintObstacle(g, o);
//        }
//
//        // Draw the coins
//        for (Coin coin : flappyBird.getCoins()) {
//            flappyBird.paintCoin(g, coin);
//        }

//        Bird bird = flappyBird.getBird();
//        if (bird != null) {
//            g.drawImage(FlappyBird.flappyBird.getBirdImage(), bird.x, bird.y, this);
//        }
        FlappyBird.flappyBird.repaint(g);
    }
}
