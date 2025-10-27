package project.practice.snake.model.object;

import project.practice.snake.config.Config;
import project.practice.snake.model.Directions;
import project.practice.snake.model.Pos;

import java.util.HashMap;

public class Snake extends GameObject {
    private Directions direction = null;
    private final HashMap<Directions, Pos> deltas;


    public Snake(Config config) {
        super(config.snakeChar);

        deltas = new HashMap<>();
        deltas.put(Directions.UP, new Pos(-1, 0));
        deltas.put(Directions.DOWN, new Pos(1, 0));
        deltas.put(Directions.LEFT, new Pos(0, -1));
        deltas.put(Directions.RIGHT, new Pos(0, 1));

        int midHeight = config.boardHeight / 2;
        int midWidth = config.boardWidth / 2;

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

    public Pos getNextPos() {
        Pos delta = deltas.get(this.direction);
        Pos head = this.getPoses().get(0);

        return new Pos(head.r() + delta.r(), head.c() + delta.c());
    }

    public void grow(Pos nextPos) {
        this.addFirstPos(nextPos);
    }

    public void shrink() {
        this.removeLastPos();
    }

}
