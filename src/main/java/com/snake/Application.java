package com.snake;

import com.snake.model.Board;
import com.snake.model.Food;
import com.snake.model.Snake;
import com.snake.model.Wall;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        // Constants
        final int SCREEN_WIDTH = 20; // Columns
        final int SCREEN_HEIGHT = 10; // Rows
        final int SNAKE_STARTING_X = SCREEN_WIDTH / 2;
        final int SNAKE_STARTING_Y = SCREEN_HEIGHT / 2;

        // screen
        Board screen = new Board(SCREEN_WIDTH, SCREEN_HEIGHT);
        screen.InitScreen();

        //TODO move to Wall
        Wall wall = new Wall('#');
        wall.addWallsRow(screen, wall, 0); // First row
        wall.addWallsRow(screen, wall, screen.getScreenHeight() - 1); // Last

        wall.addWallsColumn(screen, wall, 0); // First column
        wall.addWallsColumn(screen, wall, screen.getScreenWidth() - 1); // Last

        // TODO move to Snake
        Snake snake = new Snake('@', SNAKE_STARTING_X, SNAKE_STARTING_Y);
        screen.setSnakeOnLocation(snake, snake.points.getFirst().getX(), snake.points.getFirst().getY());

        // food
        Food food = new Food('*');
        food.addRandomFood(screen, food);

        Scanner scanner = new Scanner(System.in);
        char input;
        boolean isRunning = true;
        while (isRunning) {
            screen.PrintScreen();
            switch (input = scanner.nextLine().charAt(0)) {
                case 'a':
                    snake.moveLeft(screen, snake);
                    break;
                case 'd':
                    snake.moveRight(screen, snake);
                    break;
                case 'w':
                    snake.moveUp(screen, snake);
                    break;
                case 's':
                    snake.moveDown(screen, snake);
                    break;
            }
        }
    }

}
