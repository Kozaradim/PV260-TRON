package cz.muni.PV260.tron;

import java.awt.event.KeyEvent;

import static cz.muni.PV260.tron.Direction.*;

public class Player {
    private final ControlKeys controlKeys;
    private Position position;
    private Direction currentDirection;

    public Player(Position position, Direction currentDirection, ControlKeys controlKeys) {
        this.position = position;
        this.currentDirection = currentDirection;
        this.controlKeys = controlKeys;
    }

    public Position getPosition() {
        return position;
    }


    public Direction getCurrentDirection() {
        return currentDirection;
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
