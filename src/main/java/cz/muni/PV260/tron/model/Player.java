package cz.muni.PV260.tron.model;

import cz.muni.PV260.tron.engine.Shape;
import cz.muni.PV260.tron.engine.*;
import cz.muni.PV260.tron.engine.controls.Control;

import java.awt.*;

public class Player implements Renderable, Collidable, Movable {
    private final Control control;
    private Position position;
    private final Color color;
    private final Shape shape = new Shape();
    private final GameBoard gameBoard;
    private static final int PIXEL_SIZE = 10;


    public Player(Position position, Control control, Color color, GameBoard gameBoard) {
        this.position = position;
        this.control = control;
        this.color = color;
        this.gameBoard = gameBoard;
        this.shape.add(position);
    }

    public Position getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    @Override
    public Control getControl() {
        return control;
    }

    @Override
    public void move() {

        position = gameBoard.move(position, control.getDirection());
    }

    @Override
    public void updatePosition() {
        shape.add(position);
    }

    @Override
    public void render(Graphics2D graphics) {
        graphics.setColor(getColor());
        getShape()
                .forEach(position ->
                        graphics.fillRect(position.getX(), position.getY(), PIXEL_SIZE, PIXEL_SIZE));
    }

    @Override
    public Collision findCollision(Collidable otherPlayer) {
        return otherPlayer.getShape().collides(getPosition())
                ? new Collision(this, otherPlayer) : null;
    }
}


