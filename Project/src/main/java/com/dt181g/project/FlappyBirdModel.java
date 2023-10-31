package com.dt181g.project;

import java.util.ArrayList;
import java.util.List;

public class FlappyBirdModel {
    private int birdY;
    private int birdVelocity;
    private List<Integer> pipeXPositions;

    public FlappyBirdModel() {
        birdY = 200;
        birdVelocity = 0;
        pipeXPositions = new ArrayList<>();
    }

    public void update() {
        birdY += birdVelocity;
        birdVelocity += 1; // Simulate gravity

        // Check for collisions with pipes
        for (int pipeX : pipeXPositions) {
            if (birdY < 0 || birdY > 400 || (birdY > 250 && birdY < 350 && pipeX < 100 && pipeX + 50 > 50)) {
                // Handle collision (game over)
            }
        }

        // Remove off-screen pipes
        if (!pipeXPositions.isEmpty() && pipeXPositions.get(0) < -50) {
            pipeXPositions.remove(0);
        }
    }

    public void jump() {
        birdVelocity = -10;
    }

    public int getBirdY() {
        return birdY;
    }

    public List<Integer> getPipeXPositions() {
        return pipeXPositions;
    }

    public void addPipe(int x) {
        pipeXPositions.add(x);
    }
}