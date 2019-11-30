package com.snake.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class BoardTest {
    private static final Logger LOGGER = Logger.getLogger("com.snake.model.BoardTest");
    private Board testBoard;

    @Before
    public void setUp() throws Exception {
        testBoard = new Board(10, 10);
        LOGGER.info("Start test");
    }

    @After
    public void tearDown() throws Exception {
        LOGGER.info("End test");
    }

    @Test
    public void createFood() {
        boolean res = false;
        if (testBoard.getFood() != null) {
            res = true;
        }
        assertTrue(res);
    }

    @Test
    public void nextRound() {
        assertTrue(testBoard.nextRound());
    }

    @Test
    public void changeDirection() {
        testBoard.changeDirection(Snake.Direction.UP);
        assertTrue(testBoard.isDirectionChanged);
    }
}