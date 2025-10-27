package project.practice.snake.service;

import project.practice.snake.config.Config;
import project.practice.snake.model.object.Apple;
import project.practice.snake.model.object.Snake;
import project.practice.snake.model.object.Wall;
import project.practice.snake.view.Board;

public class GameState {

    private final Snake snake;
    private Apple apple;
    private final Wall wall;
    private final Board board;
    private final Config config;

    public GameState(Config config) {
        this.snake = new Snake(config);
        this.apple = new Apple(config, this.snake.getPoses());
        this.wall = new Wall(config);
        this.board = new Board(config);
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

    public Board getBoard() {
        return board;
    }

    public Config getConfig() {
        return config;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }
}
