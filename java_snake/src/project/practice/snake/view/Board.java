package project.practice.snake.view;

import project.practice.snake.GameConfig;
import project.practice.snake.model.Apple;
import project.practice.snake.model.GameObject;
import project.practice.snake.model.Snake;
import project.practice.snake.model.Wall;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Board {
    private static GameConfig gameConfig;
    private static char[][] board;


    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out)
    );

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        gameConfig = GameConfig.getInstance();
        board = new char[gameConfig.boardHeight][gameConfig.boardWidth];
        for (int i = 0; i < gameConfig.boardHeight; i++) {
            for (int j = 0; j < gameConfig.boardWidth; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private void addGameObject(GameObject gameObject) {
        for (int[] pos : gameObject.getPoses()) {
            board[pos[0]][pos[1]] = gameObject.getPixel();
        }
    }

    private void draw() throws IOException {
        bw.write("\033[H\033[2J");
        bw.flush();
        for (int i = 0; i < gameConfig.boardHeight; i++) {
            bw.write(board[i]);
            bw.write("\n");
        }
        bw.flush();
    }

    public void drawBoard(Snake snake, Apple apple, Wall wall) {
        try {
            initializeBoard();
            addGameObject(snake);
            addGameObject(apple);
            addGameObject(wall);
            draw();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
