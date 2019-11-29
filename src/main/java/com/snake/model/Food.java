package com.snake.model;

public class Food extends BasePoint{

	public Food(char symbol) {
		setSymbol(symbol);
	}

	// Add food to random location inside the matrix limits
	public void addRandomFood(Board board, Food food) {
		board.setFoodOnLocation(food, (int) (Math.random() * (board.getScreenWidth() - 1)),
				(int) (Math.random() * (board.getScreenHeight() - 1)));
	}
}
