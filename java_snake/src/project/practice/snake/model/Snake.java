package project.practice.snake.model;

import project.practice.snake.GameConfig;

public class Snake extends GameObject {

    public Snake(char pixel) {
        super(pixel);

        // TODO: use game config
        GameConfig gameConfig = GameConfig.getInstance();
        this.setPos(5, 5);
        this.setPos(6, 5);
        this.setPos(7, 5);
    }
}
