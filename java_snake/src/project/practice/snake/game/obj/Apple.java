package project.practice.snake.game.obj;

import project.practice.snake.GameConfig;

import java.util.List;
import java.util.Random;

public class Apple extends GameObject {

    public Apple(List<int[]> snakePoses) {
        super(GameConfig.appleChar);

        int[] nextPos = getNewRandomPos(snakePoses);

        this.addPos(nextPos[0], nextPos[1]);
    }

    private int[] getNewRandomPos(List<int[]> poses) {
        // TODO: change to compare the new pos with all game objects

        Random rand = new Random();

        boolean findNew = true;
        int newHeightPos = 0;
        int newWidthPos = 0;
        while (findNew) {
            findNew = false;
            newHeightPos = rand.nextInt(1, GameConfig.boardHeight - 1);
            newWidthPos = rand.nextInt(1, GameConfig.boardWidth - 1);

            for (int[] pos : poses) {
                if (pos[0] == newWidthPos && pos[1] == newHeightPos) {
                    findNew = true;
                    break;
                }
            }
        }

        return new int[]{newHeightPos, newWidthPos};
    }
}
