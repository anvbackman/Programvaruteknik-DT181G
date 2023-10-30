package com.dt181g.project;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstacleColumn {

    private List<Obstacle> obstacleList;
    private int basePosition;
    private Random random;
    private int score;
    private int speed;
    private int newSpeed;
    private Random rand;

    public ObstacleColumn() {
        obstacleList = new ArrayList<>();
        random = new Random();
        basePosition = Window.HEIGHT - 60;
        score = 0;
        speed = 5;
        newSpeed = speed;
        rand = new Random();
    }

    public void setObstacleList(List<Obstacle> obstacleList) {
        this.obstacleList = obstacleList;
    }

//    public void addObstacle() {
//        int spacing = 300;
//        int width = 100;
//        int height = 50 + rand.nextInt(300);
//        View view = new View();
//
//        if (view.getIsRunning()) {
//            obstacleList.add(new Obstacle(Window.WIDTH + width + obstacleList.size() * 300, Window.HEIGHT - height - 120));
//            obstacleList.add(new Obstacle(Window.WIDTH + width + (obstacleList.size() - 1) * 300, 0));
//        }
//        else {
//            obstacleList.add(new Obstacle(obstacleList.get(obstacleList.size() - 1).x + 600, Window.HEIGHT - height - 120));
//            obstacleList.add(new Obstacle(obstacleList.get(obstacleList.size() - 1).x, 0));
//        }
//    }

//    public void tick() {
//        for (int i = 0; i < obstacleList.size(); i++) {
//            obstacleList.get(i).tick();
//
//            if (obstacleList.get(i).getX() < 0) {
//                obstacleList.remove(obstacleList.get(i));
//            }
//        }
//        if (obstacleList.isEmpty()) {
//            this.score += 1;
//            if (newSpeed == score) {
//                this.speed += 1;
//                newSpeed += 5;
//                System.out.println(speed);
//            }
//            spawnObstacles();
//        }
//    }

    public void render(Graphics g, ImageObserver observer) {
        for (int i = 0; i < obstacleList.size(); i++) {
            obstacleList.get(i).render(g, observer);
        }
    }

    public void setObstacles(List<Obstacle> obstacleList) {
        this.obstacleList = obstacleList;
    }

    public List<Obstacle> getObstacles() {
        return obstacleList;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
