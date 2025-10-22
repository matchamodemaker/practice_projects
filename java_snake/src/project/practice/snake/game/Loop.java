package project.practice.snake.game;

import project.practice.snake.GameConfig;
import project.practice.snake.controller.UserInput;
import project.practice.snake.model.Apple;
import project.practice.snake.model.Snake;
import project.practice.snake.model.Wall;
import project.practice.snake.view.Board;

import java.util.Timer;

public class Loop {

    private static final Timer timer = new Timer();
    private static final Board board = new Board();

    public synchronized void run() {
        GameConfig gameConfig = GameConfig.getInstance();

        Snake snake = new Snake(gameConfig.snakeChar);
        Wall wall = new Wall(gameConfig.wallChar);
        while (true) {

            // get user input
            UserInput.getInput();

            // process game logic
            // move snake
            snake.setDirection(UserInput.inputDirection);
            snake.move();

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
            board.drawBoard(snake, apple, wall);


            try {
                this.wait(gameConfig.gameDelayMS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void terminate() {

    }
}
