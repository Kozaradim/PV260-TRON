package cz.muni.PV260.tron;

import java.util.Objects;

public class Position {
    final int x, y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position of(int x, int y) {
        return new Position(x, y);
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

    public Position left(int moveAmount, Position screenSize) {
        int newX = this.x - moveAmount;
        if (newX < 0) newX = screenSize.x;
        return Position.of(newX, this.y);
    }

    public Position right(int moveAmount, Position screenSize) {
        int newX = this.x + moveAmount;
        if (newX > screenSize.x) newX = 0;
        return Position.of(newX, this.y);
    }

    public Position up(int moveAmount, Position screenSize) {
        int newY = y - moveAmount;
        if (newY < 0) newY = screenSize.y;
        return Position.of(this.x, newY);
    }

    public Position down(int moveAmount, Position screenSize) {
        int newY = this.y + moveAmount;
        if (newY > screenSize.y) newY = 0;
        return Position.of(this.x, newY);
    }

    public Position move(Direction direction, int moveAmount, Position screenSize) {
        switch (direction) {
            case LEFT:
                return left(moveAmount, screenSize);
            case RIGHT:
                return right(moveAmount, screenSize);
            case UP:
                return up(moveAmount, screenSize);
            case DOWN:
                return down(moveAmount, screenSize);
            default:
                throw new IllegalArgumentException("Invalid direction");
        }

    }

}
