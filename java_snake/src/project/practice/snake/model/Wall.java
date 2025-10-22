package project.practice.snake.model;

import project.practice.snake.GameConfig;

public class Wall extends GameObject{
    public Wall(char pixel) {
        super(pixel);

        GameConfig gameConfig = GameConfig.getInstance();
        for (int i = 0; i < gameConfig.boardHeight; i++) {
            this.addPos(i, 0);
            this.addPos(i, gameConfig.boardWidth - 1);
        }
        for (int i = 0; i < gameConfig.boardWidth; i++) {
            this.addPos(0, i);
            this.addPos(gameConfig.boardHeight - 1, i);
        }
    }
}
