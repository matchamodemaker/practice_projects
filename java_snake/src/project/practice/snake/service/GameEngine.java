package project.practice.snake.service;

import project.practice.snake.model.Directions;
import project.practice.snake.model.PlayState;

public interface GameEngine {
    PlayState getPlayState();

    int getScore();

    void moveSnake();

    void setSnakeDirection(Directions direction);
}
