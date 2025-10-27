package project.practice.snake.view;

import project.practice.snake.config.Config;
import project.practice.snake.model.Pos;
import project.practice.snake.model.object.GameObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class Board {
    private char[][] board;
    private final Config config;
    private final BufferedWriter bw;

    public Board(Config config) {
        this.config = config;
        this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        initializeBoard();
    }

    private void initializeBoard() {
        board = new char[config.boardHeight][config.boardWidth];
        for (int i = 0; i < config.boardHeight; i++) {
            for (int j = 0; j < config.boardWidth; j++) {
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
        bw.write("Current delay: " + config.getDelay(score) + "\n");
        for (int i = 0; i < config.boardHeight; i++) {
            bw.write(board[i]);
            bw.write("\n");
        }
        bw.flush();
    }

    public void drawBoard(int score, List<GameObject> gameObjects) {
        try {
            initializeBoard();
            for (GameObject gameObject : gameObjects) {
                addGameObject(gameObject);
            }
            draw(score);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
