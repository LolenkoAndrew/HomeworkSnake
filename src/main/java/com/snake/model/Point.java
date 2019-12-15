package com.snake.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class Point {
    private final int x;
    private final int y;
    private final char symbol;
}
