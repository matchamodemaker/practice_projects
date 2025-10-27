package project.practice.snake.game;

import project.practice.snake.GameConfig;
import project.practice.snake.controller.Directions;
import project.practice.snake.game.model.PlayState;
import project.practice.snake.game.model.SnakeMoveResult;
import project.practice.snake.game.obj.Apple;
import project.practice.snake.game.obj.Snake;
import project.practice.snake.game.obj.Wall;
import project.practice.snake.game.obj.Board;

public class GameSystem {

    private Snake snake;
    private Apple apple;
    private Wall wall;
    private Board board;
    private GameConfig gameConfig;

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
        SnakeMoveResult result = snake.move(apple, wall);

        if (result == SnakeMoveResult.WALL || result == SnakeMoveResult.SNAKE) {
            this.playState = PlayState.OVER;

        } else if (result == SnakeMoveResult.APPLE) {
            this.apple = new Apple(gameConfig, snake.getPoses());
            this.score++;
        }
    }

    public void drawBoard() {
        board.drawBoard(score, snake, apple, wall);
    }

    public void setSnakeDirection(Directions direction) {
        this.snake.setDirection(direction);
    }

}
