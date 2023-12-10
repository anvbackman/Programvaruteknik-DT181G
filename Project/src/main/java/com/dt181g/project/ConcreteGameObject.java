package com.dt181g.project;

public class ConcreteGameObject implements GameObjectInterface {

//    private Model model = new Model();
    @Override
    public Bird createBird(int x, int y, int width, int height) {
        return new Bird(x, y, width, height);

    }

    @Override
    public Obstacle createObstacle(int x, int y, int width, int height) {
        return new Obstacle(x, y, width, height);
    }
}
