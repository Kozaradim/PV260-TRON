package cz.muni.PV260.tron.model;

import cz.muni.PV260.tron.engine.Direction;
import cz.muni.PV260.tron.engine.GameBoard;
import cz.muni.PV260.tron.engine.Position;
import cz.muni.PV260.tron.engine.Renderable;

import java.awt.*;

public class TronGameBoard implements Renderable, GameBoard {
    private final Position dimension;
    private final Color backgroundColor;
    private final int moveAmount;

    public TronGameBoard(Position dimension, Color backgroundColor, int moveAmount) {
        this.dimension = dimension;
        this.backgroundColor = backgroundColor;
        this.moveAmount = moveAmount;
    }

    @Override
    public Position getDimension() {
        return dimension;
    }

    @Override
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

    @Override
    public void render(Graphics2D graphics) {
        graphics.setColor(backgroundColor);
        graphics.fillRect(0, 0, getDimension().getX(), getDimension().getY());
    }
}
