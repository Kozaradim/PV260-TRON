package cz.muni.PV260.tron.controls;

import cz.muni.PV260.tron.Direction;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseControl implements Control, MouseListener {

    private final MouseDirections mouseDirections;
    private Direction direction;

    public MouseControl(MouseDirections mouseDirections, Direction initialDirection) {
        this.mouseDirections = mouseDirections;
        this.direction = initialDirection;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void addListener(Component component) {
        component.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        turn(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    void turn(MouseEvent mouseEvent) {
        Direction turnDirection = mouseDirections.getDirection(mouseEvent.getModifiersEx());
        if (turnDirection == null) return;
        direction = direction.turn(turnDirection);
    }

}
