package project.practice.snake;

public class GameConfig {

    private static final GameConfig instance = new GameConfig();

    private GameConfig() {
    }

    public static GameConfig getInstance() {
        return instance;
    }

    public int boardWidth = 30;
    public int boardHeight = 20;

    public int gameDelayMS = 250;

    public final char snakeChar = '#';
    public final char appleChar = '@';
    public final char wallChar = 'X';

    public static final char upKey = 'w';
    public static final char downKey = 's';
    public static final char leftKey = 'a';
    public static final char rightKey = 'd';
}
