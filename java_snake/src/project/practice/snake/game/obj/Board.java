package project.practice.snake.game.obj;

import project.practice.snake.GameConfig;
import project.practice.snake.game.model.Pos;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Board {
    private static char[][] board;


    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out)
    );

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        board = new char[GameConfig.boardHeight][GameConfig.boardWidth];
        for (int i = 0; i < GameConfig.boardHeight; i++) {
            for (int j = 0; j < GameConfig.boardWidth; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private void addGameObject(GameObject gameObject) {
        for (Pos pos : gameObject.getPoses()) {
            board[pos.r()][pos.c()] = gameObject.getPixel();
        }
    }

    private void draw(int score) throws IOException {
        bw.write("\033[H\033[2J");
        bw.flush();
        bw.write("Current score: " + score + "\n");
        int d = GameConfig.gameDelayMS;
        d -= score * 10;
        if (d <= 100) { d = 100; }
        bw.write("Current delay: " + d + "\n");
        for (int i = 0; i < GameConfig.boardHeight; i++) {
            bw.write(board[i]);
            bw.write("\n");
        }
        bw.flush();
    }

    public void drawBoard(int score, Snake snake, Apple apple, Wall wall) {
        try {
            initializeBoard();
            addGameObject(snake);
            addGameObject(apple);
            addGameObject(wall);
            draw(score);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
