package project.practice.snake.view;

import project.practice.snake.model.Snake;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Board {
    // TODO: add configs to set width and height
    private static final int width = 10;
    private static final int height = 10;
    private static char[][] board = new char[height][width];

    private static BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out)
    );

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = 'X';
            }
        }
    }

    private void addSnake(Snake snake) {
        for (int[] pos: snake.getPoses()) {
            board[pos[0]][pos[1]] = snake.getPixel();
        }
    }

    private void draw() throws IOException {
        bw.write("\033[H\033[2J");
        bw.flush();
        for (int i = 0; i < height; i++) {
            bw.write(board[i]);
            bw.write("\n");
        }
        bw.flush();
    }

    public void drawBoard(Snake snake) {
        try {
            initializeBoard();
            addSnake(snake);
            draw();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
