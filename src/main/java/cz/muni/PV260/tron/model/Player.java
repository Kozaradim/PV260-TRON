package cz.muni.PV260.tron.model;

import cz.muni.PV260.tron.engine.Collidable;
import cz.muni.PV260.tron.engine.Collision;
import cz.muni.PV260.tron.engine.Position;
import cz.muni.PV260.tron.engine.Renderable;
import cz.muni.PV260.tron.engine.Shape;
import cz.muni.PV260.tron.engine.controls.Control;

import java.awt.*;

public class Player implements Renderable, Collidable {
    private final Control control;
    private Position position;
    private final Color color;
    private final cz.muni.PV260.tron.engine.Shape shape = new cz.muni.PV260.tron.engine.Shape();
    private static final int PIXEL_SIZE = 10;


    public Player(Position position, Control control, Color color) {
        this.position = position;
        this.control = control;
        this.color = color;
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

    public Control getControl() {
        return control;
    }

    public void move(GameBoard gameBoard) {

        position = gameBoard.move(position, control.getDirection());
    }

    public void addPositionToPath() {
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


