package project.practice.snake.game.obj;

import project.practice.snake.GameConfig;
import project.practice.snake.game.model.Pos;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class Board {
    private static char[][] board;
    private final GameConfig gameConfig;


    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out)
    );

    public Board(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
        initializeBoard();
    }

    private void initializeBoard() {
        board = new char[gameConfig.boardHeight][gameConfig.boardWidth];
        for (int i = 0; i < gameConfig.boardHeight; i++) {
            for (int j = 0; j < gameConfig.boardWidth; j++) {
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
        bw.write("Current delay: " + gameConfig.getDelay(score) + "\n");
        for (int i = 0; i < gameConfig.boardHeight; i++) {
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
