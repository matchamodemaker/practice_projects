package project.practice.snake;

import project.practice.snake.config.Config;
import project.practice.snake.controller.ConsoleInput;
import project.practice.snake.service.GameState;
import project.practice.snake.service.GameSystem;
import project.practice.snake.service.Loop;

public class Main {
    public static void main(String[] args) {
        Config config = new Config();

        GameState gameState = new GameState(config);
        GameSystem gameSystem = new GameSystem(gameState);
        ConsoleInput consoleInput = new ConsoleInput(config);

        Loop loop = new Loop(config, gameSystem, consoleInput);

        loop.run();
    }
}
