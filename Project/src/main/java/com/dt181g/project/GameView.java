package com.dt181g.project;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class GameView extends JPanel {

    private List<ObstacleModel> obstacles;
    private BirdModel bird;
    private BufferedImage backgroundImage;

    public GameView(List<ObstacleModel> obstacles, BirdModel bird, BufferedImage backgroundImage) {
        this.obstacles = obstacles;
        this.bird = bird;
        this.backgroundImage = backgroundImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        for (ObstacleModel obstacle : obstacles) {
            drawObstacle(g, obstacle);
        }

        drawBird(g, bird);

        // if gameover, draw gameOver.
    }

    private void drawBackground(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, 800, 800, null);
    }

    private void drawObstacle(Graphics g, ObstacleModel obstacle) {
        g.drawImage(obstacle.getObstacleImage(), obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight(), null);
    }

    private void drawBird(Graphics g, BirdModel bird) {
        bird.updateImage();
        g.drawImage(bird.getCurrentImage(), bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight(), null);
    }

    private void drawGameOver(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 36));
        g.drawString("Game Over!", 800 / 2 - 100, 800 / 2);
    }





}
