package com.snake.model;

public class Board {

    private int width, height;
    private char[][] screenMatrix;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.screenMatrix = new char[this.height][this.width];
    }

    // Fill array with dots
    public void InitScreen() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.screenMatrix[i][j] = '.';
            }
        }
    }

    // Print the screen to console
    public void PrintScreen() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(this.screenMatrix[i][j]);
            }
            System.out.println();
        }
    }

    //Screen clear location
    public void ClearScreenLocation(int x, int y) {
        this.screenMatrix[y][x] = '.';
    }

    // Getters
    public int getScreenWidth() {
        return this.width;
    }

    public int getScreenHeight() {
        return this.height;
    }

    public char getObjectOnLocation(int x, int y) {
        return this.screenMatrix[y][x];
    }

    // Setters
    public void setSnakeOnLocation(Snake snake, int x, int y) {
        this.screenMatrix[y][x] = snake.points.getFirst().getSymbol();
    }

    public void setFoodOnLocation(Food food, int x, int y) {
        this.screenMatrix[y][x] = food.getSymbol();
    }

    public void setWallOnLocation(Wall wall, int x, int y) {
        this.screenMatrix[y][x] = wall.getSymbol();
    }

}
