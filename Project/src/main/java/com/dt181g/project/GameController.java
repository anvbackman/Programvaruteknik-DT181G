package com.dt181g.project;

import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class GameController implements ActionListener, KeyListener {

    private GameModel model;
    private GameView view;
    private Timer timer;

    private BufferedImage obstacleImageTop;
    private BufferedImage obstacleImageBottom;


    public GameController(GameModel model, GameView view) {

        this.model = model;
        this.view = view;

        if (obstacleImageTop == null) {
            obstacleImageTop = com.dt181g.project.IMG.ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe1.png");
        }
        if (obstacleImageBottom == null) {
            obstacleImageBottom = com.dt181g.project.IMG.ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe2.png");

        }

        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.updateGame(); // Updates the game state
        view.repaint(); // Repaints the game view
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (model.isGameOver()) {
            model.setGameOver(false);
            model.setStarted(true);
            model.newGame();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            model.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
