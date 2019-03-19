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

    public void left(int moveAmount, Position screenSize) {
        x -= moveAmount;
        if (x < 0) x = screenSize.x;
    }

    public void right(int moveAmount, Position screenSize) {
        x += moveAmount;
        if (x > screenSize.x) x = 0;
    }

    public void up(int moveAmount, Position screenSize) {
        y -= moveAmount;
        if (y < 0) y = screenSize.y;
    }

    public void down(int moveAmount, Position screenSize) {
        y += moveAmount;
        if (y > screenSize.y) y = 0;
    }

    public void move(Direction direction, int moveAmount, Position screenSize) {
        switch (direction) {
            case LEFT:
                left(moveAmount, screenSize);
                break;
            case RIGHT:
                right(moveAmount, screenSize);
                break;
            case UP:
                up(moveAmount, screenSize);
                break;
            case DOWN:
                down(moveAmount, screenSize);
                break;
            default:
                throw new IllegalArgumentException("Invalid direction");
        }

    }

}
