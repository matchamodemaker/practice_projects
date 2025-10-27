package project.practice.snake.controller;

import project.practice.snake.model.Directions;

public interface InputProvider {
    Directions getInput() throws UserInputException;
}
