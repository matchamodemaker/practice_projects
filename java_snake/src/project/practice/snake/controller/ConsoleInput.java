package project.practice.snake.controller;

import project.practice.snake.GameConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {
    private static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );
    private final GameConfig gameConfig;

    public static Directions inputDirection = Directions.UP;

    public ConsoleInput(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public void getInput() throws UserInputException {
        try {
            int v = 0;
            while (br.ready()) {
                v = br.read();
                v = Character.toLowerCase(v);
                if (v == gameConfig.upKey) {
                    inputDirection = Directions.UP;
                } else if (v == gameConfig.downKey) {
                    inputDirection = Directions.DOWN;
                } else if (v == gameConfig.leftKey) {
                    inputDirection = Directions.LEFT;
                } else if (v == gameConfig.rightKey) {
                    inputDirection = Directions.RIGHT;
                }
            }
        } catch (IOException e) {
            throw new UserInputException(e.getMessage());
        }
    }
}
