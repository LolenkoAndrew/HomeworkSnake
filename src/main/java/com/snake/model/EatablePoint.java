package com.snake.model;

public class EatablePoint {
    private final int x;
    private final int y;

    public EatablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EatablePoint eatablePoint = (EatablePoint) o;

        if (x != eatablePoint.x) return false;
        return y == eatablePoint.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "EatablePoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
