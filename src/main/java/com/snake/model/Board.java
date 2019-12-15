package com.snake.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

import static com.snake.model.Snake.Direction;

@Getter
@Setter
public class Board {
    private boolean isCovered[][];
    private final int width;
    private final int height;
    private int scores = 0;

    private Player player;
    private Snake snake;
    private Point food;

    private Direction snakeDirection = Direction.LEFT;
    public boolean isDirectionChanged = false;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        isCovered = new boolean[width][height];
        this.player = new Player();
        initSnake();
        createFood();
    }

    public void doGame() {
        while (true) {
            printBoard();
            isDirectionChanged = false;
            player.doMoove(this, snakeDirection);
            if (nextRound() == true) {
                printBoard();
            } else {
                System.out.print("Your scores: " + this.getScores());
                break;
            }
        }
    }

    private Snake initSnake() {
        snake = new Snake();
        for (int i = 0; i < 3; i++) {
            snake.addTail(new Point(i + width / 2, height / 2, '@'));
            isCovered[i + width / 2][height / 2] = true;
        }
        return snake;
    }

    public Point createFood() {
        int x, y;
        do {
            x = new Random().nextInt(width);
            y = new Random().nextInt(height);
        } while (isCovered[x][y] == true);
        food = new Point(x, y, '*');
        return food;
    }

    public boolean nextRound() {
        if (isMoveValid(snakeDirection)) {
            Point move = snake.move(snakeDirection);
            if (snake.isEatFood(food)) {
                snake.addTail(move);
                createFood();
                System.out.println(++scores);
            } else isCovered[move.getX()][move.getY()] = false;
            return true;
        } else return false;
    }

    private boolean isMoveValid(Direction direction) {
        int headX = snake.getHead().getX();
        int headY = snake.getHead().getY();
        switch (direction) {
            case UP:
                headY--;
                break;
            case RIGHT:
                headX++;
                break;
            case DOWN:
                headY++;
                break;
            case LEFT:
                headX--;
                break;
        }
        if (headX < 0 || headX >= width || headY < 0 || headY >= height) return false;
        if (isCovered[headX][headY] == true) return false;
        isCovered[headX][headY] = true;
        return true;
    }

    public void changeDirection(Direction newDirection) {
        if (snakeDirection.compatibleWith(newDirection)) {
            snakeDirection = newDirection;
            isDirectionChanged = true;
        }
    }

    public void printBoard() {
        for (Point point : snake.getBody()) {
            System.out.println(point.toString());
        }
        System.out.println("--------------------------------");
        char[][] boardChars = new char[height][width];
        for (Point point : snake.getBody()) {
            boardChars[point.getX()][point.getY()] = '@';
        }
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (boardChars[j][i] != '@' && food.getY() == i && food.getX() == j) {
                    boardChars[j][i] = '*';
                } else if (boardChars[j][i] != '@') {
                    boardChars[j][i] = '.';
                }
                System.out.print(boardChars[j][i]);
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
        System.out.println();

    }

}
