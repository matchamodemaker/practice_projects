package project.practice.snake.model;

import project.practice.snake.GameConfig;
import project.practice.snake.controller.Directions;

import java.util.HashMap;

public class Snake extends GameObject {
    private Directions direction = null;
    private HashMap<Directions, int[]> deltas;


    public Snake(char pixel) {
        super(pixel);

        deltas = new HashMap<>();
        deltas.put(Directions.UP, new int[]{-1, 0});
        deltas.put(Directions.DOWN, new int[]{1, 0});
        deltas.put(Directions.LEFT, new int[]{0, -1});
        deltas.put(Directions.RIGHT, new int[]{0, 1});

        GameConfig gameConfig = GameConfig.getInstance();
        int midHeight = gameConfig.boardHeight / 2;
        int midWidth = gameConfig.boardWidth / 2;

        for (int i = 0; i < 3; i++) {
            this.addPos(midHeight + i, midWidth);
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

    public void move() {
        if (this.direction == null) {
            return;
        }

        int[] delta = deltas.get(this.direction);
        int[] head = this.getPoses().get(0);

        // TODO: check collision, oob
        // wall -> OVER
        // apple -> grow
        // snake -> OVER
        this.addFirstPos(head[0] + delta[0], head[1] + delta[1]);
        this.removeLastPos();
    }
}
