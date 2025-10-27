package project.practice.snake.game.obj;

import project.practice.snake.GameConfig;
import project.practice.snake.game.model.Pos;

import java.util.List;
import java.util.Random;

public class Apple extends GameObject {

    public Apple(List<Pos> snakePoses) {
        super(GameConfig.appleChar);

        Pos nextPos = getNewRandomPos(snakePoses);

        this.addPos(nextPos);
    }

    private Pos getNewRandomPos(List<Pos> poses) {
        // TODO: change to compare the new pos with all game objects

        Random rand = new Random();

        boolean findNew = true;
        int newHeightPos = 0;
        int newWidthPos = 0;
        while (findNew) {
            findNew = false;
            newHeightPos = rand.nextInt(1, GameConfig.boardHeight - 1);
            newWidthPos = rand.nextInt(1, GameConfig.boardWidth - 1);

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
