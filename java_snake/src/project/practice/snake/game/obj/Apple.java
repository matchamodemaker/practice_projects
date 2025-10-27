package project.practice.snake.game.obj;

import project.practice.snake.GameConfig;
import project.practice.snake.game.model.Pos;

import java.util.List;
import java.util.Random;

public class Apple extends GameObject {

    public Apple(GameConfig gameConfig, List<Pos> snakePoses) {
        super(gameConfig.appleChar);

        Pos nextPos = getNewRandomPos(gameConfig, snakePoses);

        this.addPos(nextPos);
    }

    private Pos getNewRandomPos(GameConfig gameConfig, List<Pos> poses) {
        // TODO: change to compare the new pos with all game objects

        Random rand = new Random();

        boolean findNew = true;
        int newHeightPos = 0;
        int newWidthPos = 0;
        while (findNew) {
            findNew = false;
            newHeightPos = rand.nextInt(1, gameConfig.boardHeight - 1);
            newWidthPos = rand.nextInt(1, gameConfig.boardWidth - 1);

            for (Pos pos : poses) {
                if (pos.r() == newWidthPos && pos.c() == newHeightPos) {
                    findNew = true;
                    break;
                }
            }
        }

        return new Pos(newHeightPos, newWidthPos);
    }
}
