package com.snake.model;

import java.util.Scanner;

import static com.snake.model.Snake.Direction;

public class Player {
    public void doMoove(Board board, Direction direction) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        switch (s) {
            case "w":
                board.changeDirection(Direction.UP);
                break;
            case "a":
                board.changeDirection(Direction.LEFT);
                break;
            case "s":
                board.changeDirection(Direction.DOWN);
                break;
            case "d":
                board.changeDirection(Direction.RIGHT);
                break;
        }
    }
}
