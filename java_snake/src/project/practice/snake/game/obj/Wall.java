package project.practice.snake.game.obj;

import project.practice.snake.GameConfig;

public class Wall extends GameObject {
    public Wall() {
        super(GameConfig.wallChar);

        for (int i = 0; i < GameConfig.boardHeight; i++) {
            this.addPos(i, 0);
            this.addPos(i, GameConfig.boardWidth - 1);
        }
        for (int i = 0; i < GameConfig.boardWidth; i++) {
            this.addPos(0, i);
            this.addPos(GameConfig.boardHeight - 1, i);
        }
    }
}
