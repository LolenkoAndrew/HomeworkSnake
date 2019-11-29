package com.snake.model;

public class Wall extends BasePoint{

    public Wall() {
        setSymbol('#');
    }

    public Wall(char symbol) {
        setSymbol(symbol);
    }

    // Add horizontal line of walls
    public void addWallsRow(Board board, Wall wall, int rowNumber) {
        for (int i = 0; i < board.getScreenWidth(); i++) {
            board.setWallOnLocation(wall, i, rowNumber);
        }
    }

    // Add vertical line of walls
    public void addWallsColumn(Board board, Wall wall, int columnNumber) {
        for (int i = 0; i < board.getScreenHeight(); i++) {
            board.setWallOnLocation(wall, columnNumber, i);
        }
    }
}
