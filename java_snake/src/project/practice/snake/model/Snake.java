package project.practice.snake.model;

public class Snake extends GameObject {

    public Snake(char pixel) {
        super(pixel);
        // TODO: need to get board width and height
        this.setPos(5, 5);
        this.setPos(6, 5);
        this.setPos(7, 5);
    }
}
