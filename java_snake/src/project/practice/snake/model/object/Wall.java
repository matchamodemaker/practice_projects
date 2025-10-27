package project.practice.snake.model.object;

import project.practice.snake.config.Config;

public class Wall extends GameObject {
    public Wall(Config config) {
        super(config.wallChar);

        for (int i = 0; i < config.boardHeight; i++) {
            this.addPos(i, 0);
            this.addPos(i, config.boardWidth - 1);
        }
        for (int i = 0; i < config.boardWidth; i++) {
            this.addPos(0, i);
            this.addPos(config.boardHeight - 1, i);
        }
    }
}
