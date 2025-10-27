package project.practice.snake.model.object;

import project.practice.snake.model.Pos;

import java.util.LinkedList;

public class GameObject {
    private LinkedList<Pos> poses = new LinkedList<>();
    private char pixel;


    public GameObject(char pixel) {
        this.pixel = pixel;
    }

    public LinkedList<Pos> getPoses() {
        return poses;
    }

    public void addPos(Pos pos) {
        poses.add(pos);
    }

    public void addPos(int r, int c) {
        poses.add(new Pos(r, c));
    }

    public void addFirstPos(Pos pos) {
        poses.addFirst(pos);
    }

    public void removeLastPos() {
        poses.removeLast();
    }

    public char getPixel() {
        return pixel;
    }

    public boolean isColliding(Pos targetPos) {
        for (Pos pos: poses) {
            if (pos.r() == targetPos.r() && pos.c() == targetPos.c()) {
                return true;
            }
        }
        return false;
    }
}
