package project.practice.snake.game;

import project.practice.snake.GameConfig;
import project.practice.snake.game.model.PlayState;
import project.practice.snake.game.model.SnakeMoveResult;
import project.practice.snake.game.obj.Apple;
import project.practice.snake.game.obj.Snake;
import project.practice.snake.game.obj.Wall;
import project.practice.snake.game.obj.Board;

public class GameSystem {

    public Snake snake = null;
    public Apple apple = null;
    public Wall wall = null;
    public Board board = null;
    public PlayState playState = PlayState.PAUSE;

    private static GameSystem instance = null;

    private GameSystem() {
        instance = this;

        this.snake = new Snake();
        this.apple = new Apple(this.snake);
        this.wall = new Wall();
        this.board = new Board();
    }

    public static GameSystem getInstance() {
        if (instance == null) {
            instance = new GameSystem();
        }
        return instance;
    }

    public void moveSnake() {
        SnakeMoveResult result = snake.move(apple, wall);

        if (result == SnakeMoveResult.WALL || result == SnakeMoveResult.SNAKE) {
            this.playState = PlayState.OVER;

        } else if (result == SnakeMoveResult.APPLE) {
            this.apple = new Apple(snake);
        }
    }

    public void drawBoard() {
        board.drawBoard(snake, apple, wall);
    }

}
