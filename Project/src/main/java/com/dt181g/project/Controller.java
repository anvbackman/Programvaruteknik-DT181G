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

    private BufferedImage backgroundImage;
    private BufferedImage obstacleImageTop;
    private BufferedImage obstacleImageBottom;
    private int backgroundX;
    private boolean lastObstacleIsTop = false;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        backgroundImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\bg.png");
        backgroundX = 0;
        birdImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy1.png");
        birdImageJump = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy2.png");
//        obstacleImageTop = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe1.png");
//        obstacleImageBottom = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe2.png");
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

            view.updateBackgroundPosition();

//            for (int i = 0; i < model.getObstacle().size(); i++) {
//                Rectangle obstacles = model.getObstacle().get(i);
//                obstacles.x -= speed; // BIG IDK
//            }

            if (model.getTicks() % 2 == 0 && model.getYMotion() < 15) {
                model.setYMotion(2);
            }


            // Changing image of bird when jumpint
            if (model.getYMotion() >= 0) {
                view.setBirdImage(true, birdImage);

            } else {
                view.setBirdImage(false, birdImageJump);
            }





//             ORIGINAL CODE BEFORE STREAMS API
                for (int i = 0; i < model.getObstacle().size(); i++) {
                    Obstacle obstacles = model.getObstacle().get(i);
                    obstacles.setX(-speed);

                    if (obstacles.getX() + obstacles.getWidth() < 0) {
                        model.getObstacle().remove(obstacles);

                        if (obstacles.getY() == 0) {
                            model.addObstacle(false);
                        }
                    }
                }




                for (Obstacle o : model.getObstacle()) {
                    if (o.getY() == 0 && model.getBird().getX() + model.getBird().getWidth() / 2 > o.getX() + o.getWidth() / 2 - 10 && model.getBird().getX() + model.getBird().getWidth() / 2 < o.getX() + o.getWidth() / 2 + 10) {
                        model.setScore(1);
                        view.updateScore(model.getScore());
                    }
                    Rectangle obs = new Rectangle(o.getX(), o.getY(), o.getWidth(), o.getHeight());

                    if (obs.intersects(b)) {
                        model.setGameOver(true);

                        if (model.getBird().getX() <= o.getX()) {
                            model.getBird().setX(o.getY() - model.getBird().getHeight());
                        } else {
                            if (o.getY() != 0) {
                                model.getBird().setY(o.getY() - model.getBird().getHeight());
                            } else if (model.getBird().getY() < o.getHeight()) {
                                model.getBird().setY(o.getHeight());
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
                    model.setGameOver(true);
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
