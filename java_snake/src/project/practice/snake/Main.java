package project.practice.snake;

import project.practice.snake.config.Config;
import project.practice.snake.controller.ConsoleInput;
import project.practice.snake.controller.InputProvider;
import project.practice.snake.service.GameEngine;
import project.practice.snake.service.GameState;
import project.practice.snake.service.DefaultGameEngine;
import project.practice.snake.service.Loop;

public class Main {
    public static void main(String[] args) {
        Config config = new Config();

        GameState gameState = new GameState(config);
        GameEngine gameEngine = new DefaultGameEngine(gameState);
        InputProvider inputProvider = new ConsoleInput(config);

        Loop loop = new Loop(config, gameEngine, inputProvider);

        loop.run();
    }
}
