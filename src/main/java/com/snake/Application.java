package com.snake;

import com.snake.model.Board;

public class Application {
    private static int GRID_WIDTH = 10;
    private static int GRID_HEIGHT = 10;

    public static void main(String[] args) {
        Board board = new Board(GRID_WIDTH, GRID_HEIGHT);
        board.doGame();
    }
}
