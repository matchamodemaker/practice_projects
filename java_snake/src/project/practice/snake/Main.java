package project.practice.snake;

import project.practice.snake.config.Config;
import project.practice.snake.controller.ConsoleInput;
import project.practice.snake.controller.InputProvider;
import project.practice.snake.service.GameEngine;
import project.practice.snake.service.GameState;
import project.practice.snake.service.DefaultGameEngine;
import project.practice.snake.service.Loop;
import project.practice.snake.view.Board;

public class Main {
    public static void main(String[] args) {
        Config config = new Config();

        GameState gameState = new GameState(config);
        GameEngine gameEngine = new DefaultGameEngine(gameState);

        InputProvider inputProvider = new ConsoleInput(config);
        Board board = new Board(config);

        Loop loop = new Loop(config, gameState, gameEngine, inputProvider, board);

        loop.run();
    }
}
