package cz.muni.PV260.tron.model;

import java.util.Objects;

public class Position {
    private final int x, y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position of(int x, int y) {
        return new Position(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Position left(int moveAmount) {
        return Position.of(this.x - moveAmount, this.y);
    }

    public Position right(int moveAmount) {
        return Position.of(this.x + moveAmount, this.y);
    }

    public Position up(int moveAmount) {
        return Position.of(this.x, y - moveAmount);
    }

    public Position down(int moveAmount) {
        return Position.of(this.x, this.y + moveAmount);
    }

    public Position move(Direction direction, int moveAmount) {
        switch (direction) {
            case LEFT:
                return left(moveAmount);
            case RIGHT:
                return right(moveAmount);
            case UP:
                return up(moveAmount);
            case DOWN:
                return down(moveAmount);
            default:
                throw new IllegalArgumentException("Invalid direction");
        }

    }

}
