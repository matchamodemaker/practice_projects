package project.practice.snake.controller;

import project.practice.snake.config.Config;
import project.practice.snake.model.Directions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {
    private static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );
    private final Config config;

    private Directions inputDirection = Directions.UP;

    public ConsoleInput(Config config) {
        this.config = config;
    }

    public Directions getInput() throws UserInputException {
        try {
            int v = 0;
            while (br.ready()) {
                v = br.read();
                v = Character.toLowerCase(v);
                if (v == config.upKey) {
                    inputDirection = Directions.UP;
                } else if (v == config.downKey) {
                    inputDirection = Directions.DOWN;
                } else if (v == config.leftKey) {
                    inputDirection = Directions.LEFT;
                } else if (v == config.rightKey) {
                    inputDirection = Directions.RIGHT;
                }
            }
        } catch (IOException e) {
            throw new UserInputException(e.getMessage());
        }
        return inputDirection;
    }
}
