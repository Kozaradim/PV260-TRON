package cz.muni.PV260.tron;

import cz.muni.PV260.tron.controls.Control;
import cz.muni.PV260.tron.controls.KeyControl;
import cz.muni.PV260.tron.controls.MouseControl;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Player {
    final Control control;
    private Position position;
    private Color color;
    private final List<Position> path = new ArrayList();

    public Player(Position position, Control control, Color color) {
        this.position = position;
        this.control = control;
        this.color = color;
        this.path.add(position);
    }

    public Position getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public List<Position> getPath() {
        return path;
    }

    public Control getControl() {
        return control;
    }

    public void move(GameBoard gameBoard) {

        position = gameBoard.move(position, control.getDirection());
    }

    public void addPositionToPath() {
        path.add(position);
    }
}
