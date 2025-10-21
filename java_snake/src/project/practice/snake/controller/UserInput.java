package project.practice.snake.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
    private static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static InputKeys lastInputKey = InputKeys.UP;

    public static void getInput() throws UserInputException {
        try {
            int v = 0;
            if (br.ready()) {
                v = br.read();
                // TODO: add configs for WASD
                switch (v) {
                    case 'w', 'W':
                        lastInputKey =  InputKeys.UP;
                        break;
                    case 'a', 'A':
                        lastInputKey =  InputKeys.LEFT;
                        break;
                    case 's', 'S':
                        lastInputKey =  InputKeys.DOWN;
                        break;
                    case 'd', 'D':
                        lastInputKey =  InputKeys.RIGHT;
                        break;
                }
            }
        } catch (IOException e) {
            throw new UserInputException(e.getMessage());
        }
    }
}
