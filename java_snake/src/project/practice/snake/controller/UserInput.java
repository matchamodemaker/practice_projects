package project.practice.snake.controller;

import project.practice.snake.GameConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
    private static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static Directions inputDirection = Directions.UP;

    public static void getInput() throws UserInputException {
        try {
            int v = 0;
            while (br.ready()) {
                v = br.read();
                switch (Character.toLowerCase(v)) {
                    case GameConfig.upKey:
                        inputDirection =  Directions.UP;
                        break;
                    case GameConfig.downKey:
                        inputDirection =  Directions.DOWN;
                        break;
                    case GameConfig.leftKey:
                        inputDirection =  Directions.LEFT;
                        break;
                    case GameConfig.rightKey:
                        inputDirection =  Directions.RIGHT;
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            throw new UserInputException(e.getMessage());
        }
    }
}
