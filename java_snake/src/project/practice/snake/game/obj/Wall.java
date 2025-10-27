package project.practice.snake.game.obj;

import project.practice.snake.GameConfig;

public class Wall extends GameObject {
    public Wall(GameConfig gameConfig) {
        super(gameConfig.wallChar);

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
