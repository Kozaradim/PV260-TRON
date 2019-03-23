package cz.muni.PV260.tron.model;

import java.awt.*;

public class GameBoard {
    private final Position dimension;
    private final Color backgroundColor;
    private final int moveAmount;

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
        int x = position.getX();
        int y = position.getY();
        if (x < 0) x = dimension.getX();
        if (x > dimension.getX()) x = 0;
        if (y < 0) y = dimension.getY();
        if (y > dimension.getY()) y = 0;
        return Position.of(x, y);
    }

}
