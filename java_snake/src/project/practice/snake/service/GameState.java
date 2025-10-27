package project.practice.snake.service;

import project.practice.snake.config.Config;
import project.practice.snake.model.object.Apple;
import project.practice.snake.model.object.GameObject;
import project.practice.snake.model.object.Snake;
import project.practice.snake.model.object.Wall;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    private final Snake snake;
    private Apple apple;
    private final Wall wall;
    private final Config config;

    public GameState(Config config) {
        this.snake = new Snake(config);
        this.wall = new Wall(config);
        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.add(snake);
        gameObjects.add(wall);
        this.apple = new Apple(config, gameObjects);
        this.config = config;
    }

    public Snake getSnake() {
        return snake;
    }

    public Apple getApple() {
        return apple;
    }

    public Wall getWall() {
        return wall;
    }

    public Config getConfig() {
        return config;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public List<GameObject> getDrawObjects() {
        List<GameObject> drawObjects = new ArrayList<>();
        drawObjects.add(snake);
        drawObjects.add(apple);
        drawObjects.add(wall);
        return drawObjects;
    }
}
