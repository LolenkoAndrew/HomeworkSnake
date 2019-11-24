package com.snake.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int height;
    private final int width;
    private List<Point> fillPoints = new ArrayList<>();
    private Snake activeFigure;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public String getStringState() {
        char[][] charBoard = new char[height][width];
        fillPoints.forEach(point -> charBoard[point.getX()][point.getY()] = '#');
        StringBuilder builder = new StringBuilder();
        for (char[] chars : charBoard) {
            for (char character : chars) {
                builder.append(character);
            }
            builder.append('\n');
        }
        return builder.toString();
    }
}
