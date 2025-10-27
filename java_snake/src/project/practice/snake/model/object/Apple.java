package project.practice.snake.model.object;

import project.practice.snake.config.Config;
import project.practice.snake.model.Pos;

import java.util.List;
import java.util.Random;

public class Apple extends GameObject {

    public Apple(Config config, List<GameObject> objs) {
        super(config.appleChar);

        Pos nextPos = getNewRandomPos(config, objs);

        this.addPos(nextPos);
    }

    private Pos getNewRandomPos(Config config, List<GameObject> objs) {
        Random rand = new Random();

        boolean findNew = true;
        int newHeightPos = 0;
        int newWidthPos = 0;
        while (findNew) {
            findNew = false;
            newHeightPos = rand.nextInt(1, config.boardHeight - 1);
            newWidthPos = rand.nextInt(1, config.boardWidth - 1);

            for (GameObject obj : objs) {
                for (Pos pos : obj.getPoses()) {
                    if (pos.r() == newHeightPos && pos.c() == newWidthPos) {
                        findNew = true;
                        break;
                    }
                }

            }
        }

        return new Pos(newHeightPos, newWidthPos);
    }
}
