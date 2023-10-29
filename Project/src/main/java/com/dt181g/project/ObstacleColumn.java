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

    public ObstacleColumn() {
        obstacleList = new ArrayList<>();
        random = new Random();
        basePosition = Window.HEIGHT - 60;
        score = 0;
        speed = 5;
        newSpeed = speed;
    }

    public void spawnObstacles() {
        int lastPosition = basePosition;
        int rand = random.nextInt(10);

        for (int i = 0; i < 20; i++) {
            Obstacle temporaryObstacle = new Obstacle(900, lastPosition);
            temporaryObstacle.setDx(speed);
            lastPosition = temporaryObstacle.getY() - temporaryObstacle.getHeight();
            if (i < rand || i > rand + 4) {
                obstacleList.add(temporaryObstacle);
            }
        }
    }

    public void tick() {
        for (int i = 0; i < obstacleList.size(); i++) {
            obstacleList.get(i).tick();

            if (obstacleList.get(i).getX() < 0) {
                obstacleList.remove(obstacleList.get(i));
            }
        }
        if (obstacleList.isEmpty()) {
            this.score += 1;
            if (newSpeed == score) {
                this.speed += 1;
                newSpeed += 5;
                System.out.println(speed);
            }
            spawnObstacles();
        }
    }

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
