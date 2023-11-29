package com.dt181g.project;

public class Model {

    private Bird bird;
    private int WIDTH = 800;
    private int HEIGHT = 800;
    private boolean isGameOver;
    private boolean isStarted;
    private int yMotion;
    private int ticks;

    public Model() {

//        bird = new Bird();
        isGameOver = false;
        isStarted = true;
        yMotion = 0;
        ticks = 0;
        bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 40, 40);
    }

    public Bird getBird() {
        return bird;
    }
    public void jump() {
        if (isGameOver)
        {
            bird.setY(HEIGHT / 2 - 10);

            yMotion = 0;

            isGameOver = false;
        }

        if (!isStarted)
        {
            isStarted = true;
        }
        else if (!isGameOver)
        {
            if (yMotion > 0)
            {
                yMotion = 0;
            }
            System.out.println("Bird Jumped");
            yMotion -= 10;
        }
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public void setTicks(int value) {
        this.ticks += value;
    }
    public int getTicks() {
        return ticks;
    }

    public void setYMotion(int value) {
        this.yMotion += value;
    }
    public int getYMotion() {
        return yMotion;
    }

    public boolean getStartedStatus() {
        return isStarted;
    }

    public void setGameOver(boolean state) {
        isGameOver = state;
    }







}
