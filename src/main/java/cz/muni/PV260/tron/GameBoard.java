package cz.muni.PV260.tron;

import java.awt.*;

public class GameBoard {
    private final Position dimension;
    private Color backgroundColor;
    private int moveAmount;

    public GameBoard(Position dimension, Color backgroundColor, int moveAmount) {
        this.dimension = dimension;
        this.backgroundColor = backgroundColor;
        this.moveAmount = moveAmount;
    }

    public Position getDimension() {
        return dimension;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Position move(Position position, Direction direction) {
        Position newPosition = position.move(direction, moveAmount);
        return fixPosition(newPosition);
    }

    private Position fixPosition(Position position) {
        int x = position.x;
        int y = position.y;
        if (x < 0) x = dimension.x;
        if (x > dimension.x) x = 0;
        if (y < 0) y = dimension.y;
        if (y > dimension.y) y = 0;
        return Position.of(x, y);
    }

}
