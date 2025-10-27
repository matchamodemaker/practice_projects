package project.practice.snake;

public class GameConfig {
    public final int boardWidth = 30;
    public final int boardHeight = 20;

    public int gameDelayMS = 250;

    public final char snakeChar = '#';
    public final char appleChar = '@';
    public final char wallChar = 'X';

    public static final char upKey = 'w';
    public static final char downKey = 's';
    public static final char leftKey = 'a';
    public static final char rightKey = 'd';


    public int getDelay(int score) {
        int delay = gameDelayMS - score * 20;
        if (delay <= 100) {
            delay = 100;
        }

        return delay;
    }
}
