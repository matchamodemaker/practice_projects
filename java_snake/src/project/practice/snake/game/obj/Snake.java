package project.practice.snake.game.obj;

import project.practice.snake.GameConfig;
import project.practice.snake.controller.Directions;
import project.practice.snake.game.model.Pos;
import project.practice.snake.game.model.SnakeMoveResult;

import java.util.HashMap;

public class Snake extends GameObject {
    private Directions direction = null;
    private HashMap<Directions, Pos> deltas;


    public Snake(GameConfig gameConfig) {
        super(gameConfig.snakeChar);

        deltas = new HashMap<>();
        deltas.put(Directions.UP, new Pos(-1, 0));
        deltas.put(Directions.DOWN, new Pos(1, 0));
        deltas.put(Directions.LEFT, new Pos(0, -1));
        deltas.put(Directions.RIGHT, new Pos(0, 1));

        int midHeight = gameConfig.boardHeight / 2;
        int midWidth = gameConfig.boardWidth / 2;

        for (int i = 0; i < 3; i++) {
            this.addPos(new Pos(midHeight + i, midWidth));
        }
    }

    public void setDirection(Directions direction) {
        if (this.direction == null) {
            this.direction = direction;
            return;
        }

        if (this.direction == Directions.UP) {
            if (direction == Directions.DOWN
                    || direction == Directions.UP) {
                return;
            }
        } else if (this.direction == Directions.DOWN) {
            if (direction == Directions.UP
                    || direction == Directions.DOWN) {
                return;
            }
        } else if (this.direction == Directions.LEFT) {
            if (direction == Directions.RIGHT
                    || direction == Directions.LEFT) {
                return;
            }
        } else if (this.direction == Directions.RIGHT) {
            if (direction == Directions.LEFT
                    || direction == Directions.RIGHT) {
                return;
            }
        }
        this.direction = direction;
    }

    private Pos getNextPos() {
        Pos delta = deltas.get(this.direction);
        Pos head = this.getPoses().get(0);

        return new Pos(head.r() + delta.r(), head.c() + delta.c());
    }

    public SnakeMoveResult move(Apple apple, Wall wall) {
        if (this.direction == null) {
            return SnakeMoveResult.PASS;
        }

        Pos nextPos = getNextPos();

        // apple, wall, snake - nextpos
        if (wall.isColliding(nextPos)) {
            return SnakeMoveResult.WALL;
        } else if (this.isColliding(nextPos)) {
            return SnakeMoveResult.SNAKE;
        }

        if (apple.isColliding(nextPos)) {
            this.addFirstPos(nextPos);
            return SnakeMoveResult.APPLE;
        } else {
            this.addFirstPos(nextPos);
            this.removeLastPos();
            return SnakeMoveResult.PASS;
        }
    }

    public void grow() {

    }

}
