package project.practice.snake.model;

import java.util.ArrayList;

public class GameObject {
    private ArrayList<int[]> poses = new ArrayList<>();
    private char pixel;


    public GameObject(char pixel) {
        this.pixel = pixel;
    }

    public ArrayList<int[]> getPoses() {
        return poses;
    }

    public void setPos(int x, int y) {
        poses.add(new int[]{x, y});
    }

    public char getPixel() {
        return pixel;
    }
}
