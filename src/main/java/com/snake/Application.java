package com.snake;

import com.snake.model.Board;

public class Application {
    private static int DEFAULT_GRID_WIDTH = 10;
    private static int DEFAULT_GRID_HEIGHT = 10;

    public static void main(String[] args) {
        Board board = new Board(DEFAULT_GRID_WIDTH, DEFAULT_GRID_HEIGHT);
        board.doGame();
    }
}
