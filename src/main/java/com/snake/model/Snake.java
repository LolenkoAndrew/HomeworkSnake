package com.snake.model;

import java.util.LinkedList;

public class Snake {

    private LinkedList<Point> body = new LinkedList<>();

    public Point move(Direction direction) {
        Point point = null;
        int headX = this.body.getFirst().getX();
        int headY = this.body.getFirst().getY();
        switch (direction) {
            case UP:
                point = new Point(headX, headY - 1, '@');
                break;
            case RIGHT:
                point = new Point(headX + 1, headY, '@');
                break;
            case DOWN:
                point = new Point(headX, headY + 1, '@');
                break;
            case LEFT:
                point = new Point(headX - 1, headY, '@');
                break;
        }
        this.body.addFirst(point);
        return body.removeLast();
    }

    public boolean isEatFood(Point food) {
        Point head = body.getFirst();
        return Math.abs(head.getX() - food.getX()) + Math.abs(head.getY() - food.getY()) == 0;
    }

    public Point getHead() {
        return body.getFirst();
    }

    public Point addTail(Point area) {
        this.body.addLast(area);
        return area;
    }

    public LinkedList<Point> getBody() {
        return body;
    }

    public enum Direction {
        LEFT, RIGHT, UP, DOWN;

        public boolean compatibleWith(Direction newDirection) {
            if (this.equals(LEFT) || this.equals(RIGHT)) {
                return UP.equals(newDirection) || DOWN.equals(newDirection);
            } else {
                return LEFT.equals(newDirection) || RIGHT.equals(newDirection);
            }
        }
    }
}