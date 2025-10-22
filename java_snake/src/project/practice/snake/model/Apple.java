package project.practice.snake.model;

import project.practice.snake.GameConfig;

import java.util.ArrayList;
import java.util.Random;

public class Apple extends GameObject {

    // TODO: snake or snake poses?
    public Apple(char pixel, Snake snake) {
        super(pixel);

        // TODO: use game config
        int[] poses = getNewRandomPos(snake.getPoses());

        this.setPos(poses[0], poses[1]);
    }

    private int[] getNewRandomPos(ArrayList<int[]> poses) {
        GameConfig gameConfig = GameConfig.getInstance();

        Random rand = new Random();

        boolean findNew = true;
        int newHeightPos = 0;
        int newWidthPos = 0;
        while (findNew) {
            findNew = false;
            newHeightPos = rand.nextInt(1, gameConfig.boardHeight - 1);
            newWidthPos = rand.nextInt(1, gameConfig.boardWidth - 1);

            for (int[] pos: poses) {
                if (pos[0] == newWidthPos && pos[1] == newHeightPos) {
                    findNew = true;
                    break;
                }
            }
        }

        return new int[]{newHeightPos, newWidthPos};
    }
}
