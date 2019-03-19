package cz.muni.PV260.tron;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    private final ControlKeys controlKeys;
    private Position position;
    private Direction currentDirection;
    private Color color;

    public Player(Position position, Direction currentDirection, ControlKeys controlKeys, Color color) {
        this.position = position;
        this.currentDirection = currentDirection;
        this.controlKeys = controlKeys;
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public void move(Position screenSize, int moveAmount) {
        position.move(currentDirection, moveAmount, screenSize);
    }


    void turn(KeyEvent keyEvent) {
        Direction newDirection = controlKeys.getDirection(keyEvent.getKeyCode());
        if (newDirection != null)
            currentDirection = currentDirection.turnToIfAllowed(newDirection);
    }
}
