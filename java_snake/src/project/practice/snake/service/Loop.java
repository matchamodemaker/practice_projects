package project.practice.snake.service;

import project.practice.snake.config.Config;
import project.practice.snake.controller.InputProvider;
import project.practice.snake.model.Directions;
import project.practice.snake.view.Board;

public class Loop {

    private final Config config;
    private final GameState gameState;
    private final GameEngine gameEngine;
    private final InputProvider inputProvider;
    private final Board board;

    public Loop(Config config, GameState gameState, GameEngine gameEngine, InputProvider inputProvider, Board board) {
        this.config = config;
        this.gameState = gameState;
        this.gameEngine = gameEngine;
        this.inputProvider = inputProvider;
        this.board = board;
    }

    public synchronized void run() {
        while (true) {
            // get user input
            Directions inputDirection = inputProvider.getInput();

            // move snake
            gameEngine.setSnakeDirection(inputDirection);
            gameEngine.moveSnake();

            switch (gameEngine.getPlayState()) {
                case INITIAL:
                    break;

                case PLAYING:
                    break;

                case PAUSE:
                    break;

                case OVER:
                    terminate();
                    return;
            }

            // draw
            board.drawBoard(gameEngine.getScore(), gameState.getDrawObjects());

            try {
                this.wait(config.getDelay(gameEngine.getScore()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void terminate() {
        System.out.println("Game over");
    }
}
