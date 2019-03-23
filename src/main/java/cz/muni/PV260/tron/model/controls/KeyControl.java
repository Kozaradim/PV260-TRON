package cz.muni.PV260.tron.model.controls;

import cz.muni.PV260.tron.model.Direction;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControl implements Control, KeyListener {

    private final KeyDirections keyDirections;
    private Direction direction;

    public KeyControl(KeyDirections keyDirections, Direction initialDirection) {
        this.direction = initialDirection;
        this.keyDirections = keyDirections;
    }

    private void turn(KeyEvent keyEvent) {
        Direction newDirection = keyDirections.getDirection(keyEvent.getKeyCode());
        if (newDirection == null) return;
        direction = direction.turnToIfAllowed(newDirection);
    }


    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void addListener(Component component) {
        component.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        turn(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
