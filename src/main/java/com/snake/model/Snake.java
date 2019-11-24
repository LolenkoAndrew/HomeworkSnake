package com.snake.model;

import java.util.List;

public class Snake {

    private final List<Point> points;
    private final Point currentCoordinatesOnBoard;

    public Snake(List<Point> points, Point currentCoordinatesOnBoard) {
        this.points = points;
        this.currentCoordinatesOnBoard = currentCoordinatesOnBoard;
    }

    public List<Point> getPoints() {
        return points;
    }

    public Point getCurrentCoordinatesOnBoard() {
        return currentCoordinatesOnBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Snake figure = (Snake) o;

        if (!points.equals(figure.points)) return false;
        return currentCoordinatesOnBoard.equals(figure.currentCoordinatesOnBoard);
    }


    @Override
    public int hashCode() {
        int result = points.hashCode();
        result = 31 * result + currentCoordinatesOnBoard.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Snake{" +
                "points=" + points +
                ", currentCoordinatesOnBoard=" + currentCoordinatesOnBoard +
                '}';
    }

    public static class Builder {
        private List<Point> points;
        private Point currentCoordinatesOnBoard;

        public Builder points(List<Point> points) {
            this.points = points;
            return this;
        }

        public Builder currentCoordinatesOnBoard(Point currentCoordinatesOnBoard) {
            this.currentCoordinatesOnBoard = currentCoordinatesOnBoard;
            return this;
        }

        public Snake build() {
            return new Snake(points, currentCoordinatesOnBoard);
        }
    }

}
