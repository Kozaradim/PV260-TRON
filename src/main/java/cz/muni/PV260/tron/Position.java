package cz.muni.PV260.tron;

import java.util.Objects;

public class Position {
    int x, y;

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

    public void left(int moveAmount) {
        x -= moveAmount;
    }

    public void right(int moveAmount) {
        x += moveAmount;
    }

    public void up(int moveAmount) {
        y -= moveAmount;
    }

    public void down(int moveAmount) {
        y += moveAmount;
    }

    public void move(Direction direction, int moveAmount) {
        switch (direction) {
            case LEFT:
                left(moveAmount);
            case RIGHT:
                right(moveAmount);
            case UP:
                up(moveAmount);
            case DOWN:
                down(moveAmount);
            default:
                throw new IllegalArgumentException("Invalid direction");
        }

    }

}
