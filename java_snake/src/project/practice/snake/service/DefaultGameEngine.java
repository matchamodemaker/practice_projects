package project.practice.snake.service;

import project.practice.snake.config.Config;
import project.practice.snake.model.Directions;
import project.practice.snake.model.PlayState;
import project.practice.snake.model.Pos;
import project.practice.snake.model.object.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultGameEngine implements GameEngine {

    private final GameState gameState;
    private PlayState playState = PlayState.PAUSE;
    private int score = 0;

    public DefaultGameEngine(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public PlayState getPlayState() {
        return playState;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void moveSnake() {
        Snake snake = gameState.getSnake();
        Wall wall = gameState.getWall();
        Apple apple = gameState.getApple();
        Config config = gameState.getConfig();

        Pos nextPos = snake.getNextPos();

        if (wall.isColliding(nextPos) || snake.isColliding(nextPos)) {
            this.playState = PlayState.OVER;
        } else if (apple.isColliding(nextPos)) {
            gameState.setApple(new Apple(config, snake.getPoses()));
            this.score++;
        } else {
            snake.shrink();
        }
        snake.grow(nextPos);
    }

    @Override
    public void drawBoard() {
        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.add(gameState.getSnake());
        gameObjects.add(gameState.getApple());
        gameObjects.add(gameState.getWall());
        gameState.getBoard().drawBoard(score, gameObjects);
    }

    @Override
    public void setSnakeDirection(Directions direction) {
        gameState.getSnake().setDirection(direction);
    }

}
