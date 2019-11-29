package com.snake.model;

import java.util.LinkedList;

public class Snake {
    public LinkedList<Point> points = new LinkedList<>();

    public Snake(char symbol, int xStartingLocation, int yStartingLocation) {
        this.points.add(new Point(xStartingLocation, yStartingLocation, symbol));
    }

    public void moveLeft(Board board, Snake snake) {
        snake.points.getFirst().setX(snake.points.getFirst().getX() - 1);
        board.setSnakeOnLocation(snake, snake.points.getFirst().getX(), snake.points.getFirst().getY());
        board.ClearScreenLocation(snake.points.getFirst().getX() + 1, snake.points.getFirst().getY());
    }

    public void moveRight(Board screen, Snake snake) {
        snake.points.getFirst().setX(snake.points.getFirst().getX() + 1);
        screen.setSnakeOnLocation(snake, snake.points.getFirst().getX(), snake.points.getFirst().getY());
        screen.ClearScreenLocation(snake.points.getFirst().getX() - 1, snake.points.getFirst().getY());
    }

    public void moveUp(Board screen, Snake snake) {
        snake.points.getFirst().setY(snake.points.getFirst().getY() - 1);
        screen.setSnakeOnLocation(snake, snake.points.getFirst().getX(), snake.points.getFirst().getY());
        screen.ClearScreenLocation(snake.points.getFirst().getX(), snake.points.getFirst().getY() + 1);
    }

    public void moveDown(Board screen, Snake snake) {
        snake.points.getFirst().setY(snake.points.getFirst().getY() + 1);
        screen.setSnakeOnLocation(snake, snake.points.getFirst().getX(), snake.points.getFirst().getY());
        screen.ClearScreenLocation(snake.points.getFirst().getX(), snake.points.getFirst().getY() - 1);
    }
}