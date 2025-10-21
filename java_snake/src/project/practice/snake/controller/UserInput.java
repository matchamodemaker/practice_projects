package project.practice.snake.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UserInput {
    private static final InputStream is = System.in;
    private static InputStreamReader isr = new InputStreamReader(is);
    private static BufferedReader br = new BufferedReader(isr);
    private static char[] buf = new char[1];

    public static InputKeys getInput() {
        // w, a, s, d
        int v = 0;
        try {
            v = br.read(buf);
            v = br.read();
            // interfaces for w, a, s, d ?
            switch (v) {
                // enter?
                case 'w', 'W':
                    return InputKeys.UP;
                case 'a', 'A':
                    return InputKeys.LEFT;
                case 's', 'S':
                    return InputKeys.DOWN;
                case 'd', 'D':
                    return InputKeys.RIGHT;
                default:
                    // do nothing?
                    throw new UserInputException("UserInputNotValid");
            }
            // flush buffers?
            // get the last char.
        } catch (IOException e) {
            throw new UserInputException(e.getMessage());
        }
    }
}
