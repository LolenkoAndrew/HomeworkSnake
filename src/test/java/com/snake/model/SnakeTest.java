package com.snake.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class SnakeTest {
    private static final Logger LOGGER = Logger.getLogger("com.snake.model.SnakeTest");
    private Snake testSnake;

    private void initSnake() {
        this.testSnake = new Snake();
        for (int i = 0; i < 3; i++) {
            this.testSnake.addTail(new Point(i + 10 / 2, 10 / 2, '@'));
        }
    }

    @Before
    public void setUp() throws Exception {
        initSnake();
        LOGGER.info("Start test");
    }

    @After
    public void tearDown() throws Exception {
        LOGGER.info("End test");
    }

    @Test
    public void move() {
        int headX = this.testSnake.getHead().getX();
        int headY = this.testSnake.getHead().getY();
        testSnake.move(Snake.Direction.UP);
        Point expectedHead = new Point(headX, headY - 1, '@');
        boolean res = false;
        if(testSnake.getHead().getX() == expectedHead.getX() && testSnake.getHead().getY() == expectedHead.getY()){
            res = true;
        }
        assertTrue(res);
    }

    @Test
    public void isEatFood() {
        int headX = this.testSnake.getHead().getX();
        int headY = this.testSnake.getHead().getY();
        Point food = new Point(headX, headY, '@');
        assertTrue(testSnake.isEatFood(food));
    }

}