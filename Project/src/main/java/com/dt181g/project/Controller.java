package com.dt181g.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Controller implements GameController, ActionListener, KeyListener {

    private Model model;
    private View view;
    private GamePanel gamePanel;
    private ButtonPanel buttonPanel;
    private Bird bird;

    private Timer timer;

    private BufferedImage birdImage;
    private BufferedImage birdImageJump;

    private BufferedImage backgroundImage;
    private BufferedImage obstacleImageTop;
    private BufferedImage obstacleImageBottom;
    private int backgroundX;
    private boolean lastObstacleIsTop = false;
    private JButton quitButton;

    public Controller(Model model, GamePanel gamePanel) {
        this.model = model;
        view = new View();
        this.gamePanel = gamePanel;
        buttonPanel = new ButtonPanel();
//        view.setGameController(this);
        view.add(buttonPanel);
        view.setLayout(null);
        gamePanel.setBounds(0, 0, 800, 800);
        buttonPanel.setBounds(0, 600, 800, 200);
        view.addKeyListener(this);

        backgroundImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\bg.png");
        backgroundX = 0;
        birdImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy1.png");
        birdImageJump = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy2.png");
//        obstacleImageTop = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe1.png");
//        obstacleImageBottom = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe2.png");
//        view.setQuitButton(this, "Quit");

        ActionListener quitActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Quitted");
                System.exit(0);
            }
        };
        buttonPanel.setQuitButton(quitActionListener);

        ActionListener startActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Started");
                startGame();
//                gamePanel.requestFocusInWindow();
            }
        };
        buttonPanel.setStartButton(startActionListener);



        timer = new Timer(20, this);
        timer.start();



    }

    @Override
    public void actionPerformed(ActionEvent e) {





        if (model.getGameOverStatus()) {
            model.getBird().setY(gamePanel.getHeight() + 1);
            gamePanel.repaint();
            return;
        }

        int speed = 10;


        model.setTicks(1);
        Rectangle b = new Rectangle(model.getBird().getX(), model.getBird().getY(), model.getBird().getWidth(), model.getBird().getHeight());


        if (model.getStartedStatus()) {

            gamePanel.updateBackgroundPosition();

//            for (int i = 0; i < model.getObstacle().size(); i++) {
//                Rectangle obstacles = model.getObstacle().get(i);
//                obstacles.x -= speed; // BIG IDK
//            }

            if (model.getTicks() % 2 == 0 && model.getYMotion() < 15) {
                model.setYMotion(2);
            }


            // Changing image of bird when jumpint
            if (model.getYMotion() >= 0) {
                gamePanel.setBirdImage(true, birdImage);

            } else {
                gamePanel.setBirdImage(false, birdImageJump);
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
                        gamePanel.updateScore(model.getScore());
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

                if (model.getBird().getY() > gamePanel.getHeight() - 120 || model.getBird().getY() < 0) {
                    model.setGameOver(true);
                }

                if (model.getBird().getY() + model.getBird().getHeight() >= gamePanel.getHeight() - 120) {
                    model.getBird().setY(gamePanel.getHeight() - 120 - model.getBird().getHeight());
                    model.setGameOver(true);
                }

            gamePanel.updateBirdPosition(model.getBird().getX(), model.getBird().getY(), model.getBird().getWidth(), model.getBird().getHeight());
            gamePanel.updateObstaclePosition(model.getObstacle());


            }
            System.out.println("Score is now: " + model.getScore());

            gamePanel.repaint();


        }

    @Override
    public void startGame() {

        if (!model.getStartedStatus()) {
            view.add(gamePanel);
            gamePanel.setButtonVisible(true);
            gamePanel.updateBackgroundPosition();
            gamePanel.updateBirdPosition(model.getBird().getX(), model.getBird().getY(), model.getBird().getWidth(), model.getBird().getHeight());
            gamePanel.updateObstaclePosition(model.getObstacle());
            gamePanel.updateScore(0);
            model.setStarted(true);
            model.setGameOver(false);
        }
        else {
            gamePanel.setButtonVisible(false);
        }




////        model.setStarted(true);
////        this.view.getContentPane();
//        model.startGame();
//
//        // Reset the view
//        gamePanel.updateBackgroundPosition();
//        gamePanel.updateBirdPosition(model.getBird().getX(), model.getBird().getY(), model.getBird().getWidth(), model.getBird().getHeight());
//        gamePanel.updateObstaclePosition(model.getObstacle());
//        gamePanel.updateScore(0);
//
//        // Set the game as started
//        model.setStarted(true);
//        model.setGameOver(false);
//
//        // Trigger a repaint
//        gamePanel.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
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
