package project.practice.snake.game;

import project.practice.snake.controller.InputKeys;
import project.practice.snake.controller.UserInput;

import java.util.Timer;
import java.util.TimerTask;

public class Loop {

    private static final Timer timer = new Timer();

    public synchronized void run() {
        // TODO: read configs & save data
        while (true) {
            System.out.println(State.playState);

            // get user input
            UserInput.getInput();
            System.out.println(UserInput.lastInputKey);

            // process game logic
            // move snake
            // create apple -> if there is no apple OR when destroyed?

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
            try {
                // TODO: add config file to set the delay
                this.wait(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void terminate() {

    }
}
