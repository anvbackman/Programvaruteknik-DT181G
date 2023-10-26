package com.dt181g.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class View extends JPanel implements ActionListener {

    private Renderer renderer;
    private Bird bird;
    private int backgroundX;


    public View() {
        Timer timer = new Timer(20, this);
        renderer = new Renderer();
        JFrame frame = new JFrame();
        frame.add(renderer);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        backgroundX = 0;
        timer.start();
    }


    public void actionPerformed(ActionEvent e) {
        repaint();
    }


    public void repaint(Graphics g) {

        for (int x = backgroundX; x < WIDTH; x += backgroundImage.getWidth()) {
            g.drawImage(backgroundImage, x, 0, WIDTH + 120, HEIGHT, null);
        }
        for (int x = groundX; x < WIDTH; x += groundImage.getWidth()) {
            g.drawImage(groundImage, x, HEIGHT - 120, WIDTH, 150, null);
        }

        if (bird != null) {
            BufferedImage currentImage = bird.getCurrentImage();
            g.drawImage(currentImage, bird.x, bird.y, bird.width, bird.height, null);
        }

        for (Obstacle o : obstacle) {
            paintObstacle(g, o);
        }

        for (Coin coin : coins) {
            paintCoin(g, coin);
        }

        for (PowerUp powerUp : powerUps) {
            paintPowerUp(g, powerUp);
        }

        for (Bullet bullet : bullets) {
            paintBullet(g, bullet);
        }

        g.setColor(Color.white);
        g.setFont(new Font("Arial", 1, 25));

        if (!started) {
            g.drawString("Press Space to start!", 75, HEIGHT / 2 - 50);
        }
        if (gameOver) {
            g.drawString("Game Over! Press Space to start!", 100, HEIGHT / 2 - 50);
        }
        if (!gameOver && started) {
            g.drawString(String.valueOf(score), WIDTH / 2 - 100, 100);
            g.drawString(String.valueOf(coinsGained), WIDTH / 2 -25, 100);
        }
        if (isMoreCoins) {
            g.drawString("Get ready for some fucking coins!", 75, HEIGHT / 2 - 50);
        }

        if (isGhost) {
            g.drawString("Spookers", 75, HEIGHT / 2 - 50);
        }
    }

    public void paintObstacle(Graphics g, Obstacle obstacle) {
        if (obstacle.getPosition()) {
            g.drawImage(obstacleImageBottom, obstacle.x, obstacle.y, obstacle.width, obstacle.height, null);
        }
        else {
            g.drawImage(obstacleImageTop, obstacle.x, obstacle.y, obstacle.width, obstacle.height, null);
        }
    }

    public void paintCoin(Graphics g, Coin coin) {
        g.drawImage(coinImage, coin.x, coin.y, coin.width, coin.height, null);
    }

    public void paintPowerUp(Graphics g, PowerUp powerUp) {
        g.drawImage(powerUpImage, powerUp.x, powerUp.y, powerUp.width, powerUp.height, null);
    }

    public void paintBullet(Graphics g, Bullet bullet) {
        g.drawImage(bulletImage, bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight(), null);
    }
}
