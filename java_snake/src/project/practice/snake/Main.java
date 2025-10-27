package project.practice.snake;

import project.practice.snake.controller.ConsoleInput;
import project.practice.snake.game.GameSystem;
import project.practice.snake.game.Loop;

public class Main {
    public static void main(String[] args) {
        GameConfig gameConfig = new GameConfig();

        GameSystem gameSystem = new GameSystem(gameConfig);
        ConsoleInput consoleInput = new ConsoleInput(gameConfig);

        Loop loop = new Loop(gameConfig, gameSystem, consoleInput);

        loop.run();
    }
}
