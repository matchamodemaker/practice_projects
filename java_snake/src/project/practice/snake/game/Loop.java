package project.practice.snake.game;

import java.util.Timer;
import java.util.TimerTask;

public class Loop {

    private static final Timer timer = new Timer();

    public synchronized void run() {
        // TODO: read configs & save data
        while (true) {
            // TODO: add a log ... ? system message ... ?
            System.out.println(State.playState);
            // get user input

            // process game logic

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
