package cz.muni.PV260.tron;

public class GameBoard {
    private final Position dimension;
    private int moveAmount;

    public GameBoard(Position dimension, int moveAmount) {
        this.dimension = dimension;
        this.moveAmount = moveAmount;
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
