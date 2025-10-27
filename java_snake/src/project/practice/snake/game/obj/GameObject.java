package project.practice.snake.game.obj;

import java.util.LinkedList;

public class GameObject {
    private LinkedList<int[]> poses = new LinkedList<>();
    private char pixel;


    public GameObject(char pixel) {
        this.pixel = pixel;
    }

    public LinkedList<int[]> getPoses() {
        return poses;
    }

    public void addPos(int r, int c) {
        poses.add(new int[]{r, c});
    }

    public void addFirstPos(int r, int c) {
        poses.addFirst(new int[]{r, c});
    }

    public void removeLastPos() {
        poses.removeLast();
    }

    public char getPixel() {
        return pixel;
    }

    public boolean isColliding(int[] targetPos) {
        for (int[] pos: poses) {
            if (pos[0] == targetPos[0] && pos[1] == targetPos[1]) {
                return true;
            }
        }
        return false;
    }
}
