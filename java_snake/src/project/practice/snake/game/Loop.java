package project.practice.snake.game;

import project.practice.snake.GameConfig;
import project.practice.snake.controller.ConsoleInput;

public class Loop {

    private GameConfig gameConfig;
    private GameSystem gameSystem;
    private ConsoleInput consoleInput;

    public Loop(GameConfig gameConfig, GameSystem gameSystem, ConsoleInput consoleInput) {
        this.gameConfig = gameConfig;
        this.gameSystem = gameSystem;
        this.consoleInput = consoleInput;
    }

    public synchronized void run() {
        while (true) {
            // get user input
            consoleInput.getInput();

            // move snake
            gameSystem.setSnakeDirection(ConsoleInput.inputDirection);
            gameSystem.moveSnake();

            switch (gameSystem.playState) {
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
                this.wait(gameConfig.getDelay(gameSystem.score));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void terminate() {
        System.out.println("Game over");
    }
}
