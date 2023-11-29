package com.dt181g.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Controller implements ActionListener, KeyListener {

    private Model model;
    private View view;
    private Bird bird;

    private Timer timer;

    private BufferedImage birdImage;
    private BufferedImage birdImageJump;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        birdImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy1.png");
        birdImageJump = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy2.png");

        timer = new Timer(20, this);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (model.getGameOverStatus()) {
            model.getBird().setY(view.getHeight() + 1);
            view.repaint();
            return;
        }

        int speed = 10;


        model.setTicks(1);
        Rectangle b = new Rectangle(model.getBird().getX(), model.getBird().getY(), model.getBird().getWidth(), model.getBird().getHeight());


        if (model.getStartedStatus()) {

            for (int i = 0; i < model.getObstacle().size(); i++) {
                Rectangle obstacles = model.getObstacle().get(i);
                obstacles.x -= speed; // BIG IDK
            }

            if (model.getTicks() % 2 == 0 && model.getYMotion() < 15) {
                model.setYMotion(2);
            }

            if (model.getYMotion() >= 0) {
                view.setBirdImage(true, birdImage);

            }
            else {
                view.setBirdImage(false, birdImageJump);
            }

            for (int i = 0; i < model.getObstacle().size(); i++) {
                Rectangle obstacles = model.getObstacle().get(i);

                if (obstacles.x + obstacles.width < 0) {
                    model.getObstacle().remove(obstacles);

                    if (obstacles.y == 0) {
                        model.addObstacle(false);
                    }
                }
            }


            for (Rectangle o : model.getObstacle()) {
                if (o.y == 0 && model.getBird().getX() + model.getBird().getWidth() / 2 > o.x + o.width / 2 - 10 && model.getBird().getX() + model.getBird().getWidth() / 2 < o.x + o.width / 2 + 10) {
                    model.setScore(1);
                }
                Rectangle obs = new Rectangle(o.x, o.y, o.width, o.height);

                if (obs.intersects(b)) {
                    model.setGameOver(true);

                    if (model.getBird().getX() <= o.x) {
                        model.getBird().setX(o.y - model.getBird().getHeight());
                    } else {
                        if (o.y != 0) {
                            model.getBird().setY(o.y - model.getBird().getHeight());
                        } else if (model.getBird().getY() < o.height) {
                            model.getBird().setY(o.height);
                        }
                    }
                }
            }


            model.getBird().setY(model.getBird().getY() + model.getYMotion());

            if (model.getBird().getY() > view.getHeight() - 120 || model.getBird().getY() < 0) {
                model.setGameOver(true);
            }

            if (model.getBird().getY() + model.getBird().getHeight() >= view.getHeight() - 120) {
                model.getBird().setY(view.getHeight() - 120 - model.getBird().getHeight());
            }

            view.updateBirdPosition(model.getBird().getX(), model.getBird().getY(), model.getBird().getWidth(), model.getBird().getHeight());
            view.updateObstaclePosition(model.getObstacle());


        }
        System.out.println("Score is now: " + model.getScore());

        view.repaint();


    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (model.getGameOverStatus()) {
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
