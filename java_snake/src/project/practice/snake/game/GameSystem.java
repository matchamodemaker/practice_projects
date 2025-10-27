package project.practice.snake.game;

import project.practice.snake.GameConfig;
import project.practice.snake.controller.Directions;
import project.practice.snake.game.model.PlayState;
import project.practice.snake.game.model.Pos;
import project.practice.snake.game.obj.*;

import java.util.ArrayList;
import java.util.List;

public class GameSystem {

    private final Snake snake;
    private Apple apple;
    private final Wall wall;
    private final Board board;
    private final GameConfig gameConfig;

    public PlayState playState = PlayState.PAUSE;
    public int score = 0;

    public GameSystem(GameConfig gameConfig) {
        this.snake = new Snake(gameConfig);
        this.apple = new Apple(gameConfig, this.snake.getPoses());
        this.wall = new Wall(gameConfig);
        this.board = new Board(gameConfig);
        this.gameConfig = gameConfig;
    }

    public void moveSnake() {
        Pos nextPos = snake.getNextPos();

        if (wall.isColliding(nextPos) || snake.isColliding(nextPos)) {
            this.playState = PlayState.OVER;
        } else if (apple.isColliding(nextPos)) {
            this.apple = new Apple(gameConfig, snake.getPoses());
            this.score++;
        } else {
            snake.shrink();
        }
        snake.grow(nextPos);
    }

    public void drawBoard() {
        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.add(snake);
        gameObjects.add(apple);
        gameObjects.add(wall);
        board.drawBoard(score, gameObjects);
    }

    public void setSnakeDirection(Directions direction) {
        this.snake.setDirection(direction);
    }

}
