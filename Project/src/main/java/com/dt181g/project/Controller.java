package com.dt181g.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements ActionListener, KeyListener {

    private Model model;
    private View view;
    private Bird bird;

    private Timer timer;


    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        timer = new Timer(100, this);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        model.setTicks(1);
//        Rectangle b = new Rectangle(bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());
//        view.updateBirdPosition(bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());

        if (model.getTicks() % 2 == 0 && model.getYMotion() < 15) {
            model.setYMotion(2);
        }

        model.getBird().setY(model.getBird().getY() + model.getYMotion());

        if (model.getBird().getY() > view.getHeight() - 120 || model.getBird().getY() < 0) {
            model.setGameOver(true);
        }

        if (model.getBird().getY() + model.getBird().getHeight() >= view.getHeight() - 120) {
            model.getBird().setY(view.getHeight() - 120 - model.getBird().getHeight());
        }

        view.updateBirdPosition(model.getBird().getX(), model.getBird().getY(), model.getBird().getWidth(), model.getBird().getHeight());

//
//
//
////            model.getBird().setY(model.getBird().getY() + model.getYMotion());
////            model.getBird().setY(model.getBird().getY() + model.getYMotion());
//
////            if (model.getBird().getY() > view.getHeight() - 120 || model.getBird().getY() < 0) {
////                model.setGameOver(true);
////            }
////
////            if (model.getBird().getY() + model.getYMotion() >= view.getHeight() - 120) {
////                model.getBird().setY((view.getHeight() - 120) - model.getBird().getHeight());
////            }
//
////            view.updateBirdPosition(model.getBird().getX(), model.getBird().getY(), model.getBird().getWidth(), model.getBird().getHeight());
//
        view.repaint();


    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
//        if (gameOver) {
//            gameOver = false;
//            started = true;
//            newGame();
//        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            model.jump();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
