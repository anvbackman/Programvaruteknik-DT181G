package com.dt181g.project;

import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class GameController implements ActionListener, KeyListener {

    private GameModel model;
    private GameView view;
    private Timer timer;

    int ticks = 0;

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

        if (model.isGameOver()) {
            model.getBird().setY(model.getHeight() + 1);
            view.repaint();
            return;
        }


        ticks++;
//        coinsToRemove = new ArrayList<>();
//        powerUpsToRemove = new ArrayList<>();


        if (model.isStarted()) {

            model.getBird().setJumping(true);

            if (model.getBackgroundX() < -view.getBackgroundImage().getWidth()) {
                model.setBackgroundX(0);
            }

            model.setBackgroundX(5);


            if (ticks % 2 == 0 && model.getYMotion() < 15) {
                model.setYMotion(model.getYMotion() + 2);
            }


//            model.getBird().setY(model.getYMotion());
            model.getBird().setY(model.getBird().getY() + model.getYMotion());


            if (model.getBird().getY() > model.getHeight() - 120 || model.getBird().getY() < 0) {
                model.setGameOver(true);
            }
            if (model.getBird().getY() + model.getYMotion() >= model.getHeight() - 120) {
                model.getBird().setY(model.getHeight() - 120 - model.getBird().getHeight());
                model.setGameOver(true);
            }
        }

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
