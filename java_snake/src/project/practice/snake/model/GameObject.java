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

    public void setPos(int r, int c) {
        poses.add(new int[]{r, c});
    }

    public char getPixel() {
        return pixel;
    }
}
