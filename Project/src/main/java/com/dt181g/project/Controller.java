package com.dt181g.project;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import com.dt181g.project.View;

public class Controller implements StrategyInterface {

    @Override
    public void controller(Bird bird, KeyEvent keyEvent) {

    }

    @Override public void releaseController(Bird bird, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
            bird.jump();
            bird.setJumping();
        }
    }

//    private Model model;
//    private View view;
//    private Renderer renderer;
//    private int ticks;
//
//    private List<Coin> coinsToRemove;
//    BufferedImage birdImage;
//    BufferedImage birdImageJump;
//
//    public Controller(Model model, View view) {
//        this.model = model;
//        this.view = view;
//        renderer = new Renderer();
//        birdImage = com.dt181g.project.IMG.ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy1.png");
//        birdImageJump = com.dt181g.project.IMG.ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy2.png");
//
//
////        view.addMouseListener(new GameMouseListener)
//    }
//
//
//
//    public void jump() {
//
//        System.out.println("Jumping");
//
//        if (!model.isStarted()) {
//            model.setStarted(true);
//        }
//        else if (!model.isGameOver()) {
//            if (model.getYMotion() > 0) {
//                model.setYMotion(0);
//            }
//            model.setYMotion(-10);
//        }
//    }
//
//    public void keyPressed(KeyEvent e) {
//        if (model.isGameOver()) {
//            model.setGameOver(false);
//            model.setStarted(true);
//            model.newGame();
//        }
//        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//            jump();
//        }
//    }
//
//    public void actionPerformed(ActionEvent e) {
//
//        Bird bird = model.getBird();
//
//        if (model.isGameOver()) {
//            bird.y = model.getHEIGHT() + 1;
//            renderer.repaint();
//            return;
//        }
//
////        int bulletSpeed = 15;
//        Rectangle p = new Rectangle(bird.x, bird.y, bird.width, bird.height);
//        ticks++;
//        List<Coin> coinsToRemove = new ArrayList<>();
////        powerUpsToRemove = new ArrayList<>();
////        obstaclesToRemove = new ArrayList<>();
////        bulletsToRemove = new ArrayList<>();
//
//
//        if (model.isStarted()) {
//
//            bird.setJumping(model.isJumping());
//
//            if (model.getBackgroundX() < -model.getBackgroundImage().getWidth()) {
//                model.setBackgroundX(0);
//            }
//
//            model.setBackgroundX(-bird.getSpeed());
//
//            if (model.getGroundX() < -model.getGroundImage().getWidth()) {
//                model.setGroundX(0); // Reset the ground to start again.
//            }
//            model.setGroundX(-bird.getSpeed());
//
//            for (int i = 0; i < model.getObstacles().size(); i++) {
//                Obstacle o = model.getObstacles().get(i);
//                o.x -= bird.getSpeed();
//                if (o.x + o.width < 0) {
//                    model.getObstacles().remove(o);
//                    if (o.y == 0) {
//                        model.addObstacle(false);
//                    }
//                }
//            }
//
//            if (ticks % 2 == 0 && model.getYMotion() < 15) {
//                model.setYMotion(2);
//            }
//
//            bird.y += model.getYMotion();
//
//            if (model.getYMotion() >= 0) {
//                model.setJumping(false);
//                bird.setImage(birdImage);
//            }
//            else {
//                model.setJumping(true);
//                bird.setImage(birdImageJump);
//            }
//
//
//            for (Obstacle o : model.getObstacles()) {
//                if (o.y == 0 && bird.x + bird.width / 2 > o.x + o.width / 2 - 10 && bird.x + bird.width / 2 < o.x + o.width / 2 + 10) {
////                    score++;
//                }
//                Rectangle obs = new Rectangle(o.x, o.y, o.width, o.height);
//
//                if (obs.intersects(p)) {
//                    model.setGameOver(true);
//
//                    if (bird.x <= o.x) {
//                        bird.x = o.y - bird.height;
//                    }
//
//                    else {
//                        if (o.y != 0) {
//                            bird.y = o.y - bird.height;
//                        }
//                        else if (bird.y < o.height) {
//                            bird.y = o.height;
//                        }
//
//                    }
//                }
//            }
//
//
//
//            for (int i = 0; i < model.getCoins().size(); i++) {
//                Coin coin = model.getCoins().get(i);
//                coin.x -= bird.getSpeed();
//                if (coin.x + coin.width < 0) {
//                    model.getCoins().remove(coin);
//                    if (coin.y == 0) {
//                        model.addCoin(false);
//                    }
//                }
//            }
//
//            for (Coin coin : model.getCoins()) {
//                Rectangle c = new Rectangle(coin.x, coin.y, coin.width, coin.height);
//                if (c.intersects(p)) {
////                    coinsGained++;
//                    coinsToRemove.add(coin); // Add the coin to the removal list.
//                }
//            }
//
//            // Now, remove the coins outside of the loop.
//            model.getCoins().removeAll(coinsToRemove);
//
//
//            if (bird.y > model.getHEIGHT() - 120 || bird.y < 0) {
//                model.setGameOver(true);
//            }
//            if (bird.y + model.getYMotion() >= model.getHEIGHT() - 120) {
//                bird.y = model.getHEIGHT() - 120 - bird.height;
//                model.setGameOver(true);
//            }
//        }
//        renderer.repaint();
//    }
//
//    public void startGame() {
//        model.newGame();
//    }
}
