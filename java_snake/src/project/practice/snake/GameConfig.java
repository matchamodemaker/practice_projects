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

    public int gameDelayMS = 500;

    public char snakeChar = '#';
    public char appleChar = '@';
    public char wallChar = 'X';

}
