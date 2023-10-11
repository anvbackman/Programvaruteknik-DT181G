package com.dt181g.project;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird {

    public static FlappyBird flappyBird;
    private Bird bird;
    private ArrayList<Obstacle> obstacle;
    private int WIDTH = 800;
    private int HEIGHT = 800;
    public Random rand;
    public Renderer renderer;
    private String birdSymbol = "A";

    public FlappyBird() {
        GUI gui = new GUI();
        bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
        obstacle = new ArrayList<>();
        rand = new Random();
    }


    public void addObstacle(boolean start) {
        int spacing = 300;
        int width = 100;
        int height = 50 + rand.nextInt(300);

        if (start) {
            obstacle.add(new Obstacle(WIDTH + width + obstacle.size() * 300, HEIGHT - height - 120, width, height));
            obstacle.add(new Obstacle(WIDTH + width + (obstacle.size() - 1) * 300, 0, width, HEIGHT - height - spacing));
        }
        else {
            obstacle.add(new Obstacle(obstacle.get(obstacle.size() - 1).x + 600, HEIGHT - height - 120, width, height));
            obstacle.add(new Obstacle(obstacle.get(obstacle.size() - 1).x, 0, width, HEIGHT - height - spacing));
        }
    }

    public void paintObstacle(Graphics g, Obstacle obstacle) {
        g.setColor(Color.GREEN.darker());
        g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
    }

    public void repaint(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString(String.valueOf(birdSymbol), bird.x, bird.y);
//        g.fillRect(bird.x, bird.y, bird.width, bird.height);

        g.setColor(Color.ORANGE);
        g.fillRect(0, HEIGHT - 150, WIDTH, 150);
        g.setColor(Color.GREEN);
        g.fillRect(0, HEIGHT - 150, WIDTH, 20);
    }

    public void addSymbol(String symbol) {
        birdSymbol += symbol;
    }

    public void removeSymbol() {
        if (birdSymbol.length() > 1) {
            birdSymbol = birdSymbol.substring(0, birdSymbol.length() - 1);
        }
    }
}
