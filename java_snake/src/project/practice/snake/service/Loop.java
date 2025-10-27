package project.practice.snake.service;

import project.practice.snake.config.Config;
import project.practice.snake.controller.ConsoleInput;
import project.practice.snake.model.Directions;

public class Loop {

    private final Config config;
    private final GameSystem gameSystem;
    private final ConsoleInput consoleInput;

    public Loop(Config config, GameSystem gameSystem, ConsoleInput consoleInput) {
        this.config = config;
        this.gameSystem = gameSystem;
        this.consoleInput = consoleInput;
    }

    public synchronized void run() {
        while (true) {
            // get user input
            Directions inputDirection = consoleInput.getInput();

            // move snake
            gameSystem.setSnakeDirection(inputDirection);
            gameSystem.moveSnake();

            switch (gameSystem.getPlayState()) {
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
            gameSystem.drawBoard();

            try {
                this.wait(config.getDelay(gameSystem.getScore()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void terminate() {
        System.out.println("Game over");
    }
}
