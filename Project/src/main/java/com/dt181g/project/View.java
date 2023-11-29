package com.dt181g.project;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel {

    private GamePanel gamePanel;

    private int birdX;
    private int birdY;
    private int birdWidth;
    private int birdHeight;

    public View() {
//        gamePanel = new GamePanel();
//        add(gamePanel);
//
//        setSize(800, 800);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setTitle("Flappy Bird");
//        setVisible(true);

//        JFrame frame = new JFrame("Flappy Bird");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 800);
//        frame.setResizable(false);
//        frame.add(this);
//        frame.setVisible(true);


    }

//    public void setbX(int value) {
//        this.bX += value;
//    }
//
//    public void setbY(int value) {
//        this.bY += value;
//    }


    public void updateBirdPosition(int x, int y, int width, int height) {
        // Update the bird position
        this.birdX = x;
        this.birdY = y;
        this.birdWidth = width;
        this.birdHeight = height;
        System.out.println("Bird Position: x=" + birdX + ", y=" + birdY + ", width=" + birdWidth + ", height=" + birdHeight);


        // Trigger a repaint
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);



        doDraw(g);
    }

    private void doDraw(Graphics g) {

        g.setColor(Color.cyan);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.red);
        g.fillRect(birdX, birdY, birdWidth, birdHeight);
//        g.fillRect(getWidth() / 2 - 10, getHeight() / 2 - 10, 40, 40);

        g.setColor(Color.ORANGE);
        g.fillRect(0, getHeight() - 120, getWidth(), 120);

        g.setColor(Color.green);
        g.fillRect(0, getHeight() - 120, getWidth(), 20);


    }

}
