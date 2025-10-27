package project.practice.snake.service;

import project.practice.snake.config.Config;
import project.practice.snake.controller.InputProvider;
import project.practice.snake.model.Directions;

public class Loop {

    private final Config config;
    private final GameEngine gameEngine;
    private final InputProvider inputProvider;

    public Loop(Config config, GameEngine gameEngine, InputProvider inputProvider) {
        this.config = config;
        this.gameEngine = gameEngine;
        this.inputProvider = inputProvider;
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
            gameEngine.drawBoard();

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
