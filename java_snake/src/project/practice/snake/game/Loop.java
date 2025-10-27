package project.practice.snake.game;

import project.practice.snake.GameConfig;
import project.practice.snake.controller.UserInput;

public class Loop {

    private static final GameSystem gameSystem = GameSystem.getInstance();

    public synchronized void run() {
        while (true) {
            // get user input
            UserInput.getInput();

            // move snake
            gameSystem.snake.setDirection(UserInput.inputDirection);
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
                // TODO: need to speed up
                this.wait(GameConfig.gameDelayMS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void terminate() {
        System.out.println("Game over");
    }
}
