package cz.muni.PV260.tron;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Player {
    private final ControlKeys controlKeys;
    private final ControlMouse controlMouse;
    private Position position;
    private Direction currentDirection;
    private Color color;

    public Player(Position position, Direction currentDirection, ControlKeys controlKeys, ControlMouse controlMouse, Color color) {
        this.position = position;
        this.currentDirection = currentDirection;
        this.controlKeys = controlKeys;
        this.controlMouse = controlMouse;
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
        if (controlKeys == null) return;
        Direction newDirection = controlKeys.getDirection(keyEvent.getKeyCode());
        if (newDirection == null) return;
        currentDirection = currentDirection.turnToIfAllowed(newDirection);
    }

    void turn(MouseEvent mouseEvent) {
        if (controlMouse == null) return;
        Direction turnDirection = controlMouse.getDirection(mouseEvent.getModifiersEx());
        if (turnDirection == null) return;
        currentDirection = currentDirection.turn(turnDirection);
    }


}
