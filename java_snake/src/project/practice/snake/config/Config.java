package project.practice.snake.config;

public class Config {
    public final int boardWidth = 30;
    public final int boardHeight = 20;

    public final int gameDelayMS = 250;

    public final char snakeChar = '#';
    public final char appleChar = '@';
    public final char wallChar = 'X';

    public final char upKey = 'w';
    public final char downKey = 's';
    public final char leftKey = 'a';
    public final char rightKey = 'd';


    public int getDelay(int score) {
        int delay = gameDelayMS - score * 20;
        if (delay <= 100) {
            delay = 100;
        }

        return delay;
    }
}
