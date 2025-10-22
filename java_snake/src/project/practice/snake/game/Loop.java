package project.practice.snake.game;

import project.practice.snake.GameConfig;
import project.practice.snake.controller.InputKeys;
import project.practice.snake.controller.UserInput;
import project.practice.snake.model.Apple;
import project.practice.snake.model.Snake;
import project.practice.snake.view.Board;

import java.util.Timer;
import java.util.TimerTask;

public class Loop {

    private static final Timer timer = new Timer();
    private static final Board board = new Board();

    public synchronized void run() {
        GameConfig gameConfig = GameConfig.getInstance();
        // TODO: read configs & save data

        Snake snake = new Snake(gameConfig.snakeChar);
        while (true) {
            System.out.println(State.playState);

            // get user input
            UserInput.getInput();
            System.out.println(UserInput.lastInputKey);

            // process game logic
            // move snake
            // create apple -> if there is no apple OR when destroyed?
            Apple apple = new Apple(gameConfig.appleChar, snake);

            // status? - continue/terminate
            switch (State.playState) {
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
            board.drawBoard(snake, apple);


            try {
                // TODO: add config file to set the delay
                this.wait(gameConfig.gameDelayMS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void terminate() {

    }
}
