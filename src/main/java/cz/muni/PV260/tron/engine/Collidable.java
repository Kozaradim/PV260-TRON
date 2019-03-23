package cz.muni.PV260.tron.engine;

public interface Collidable {
    Shape getShape();

    Collision findCollision(Collidable otherPlayer);

}
