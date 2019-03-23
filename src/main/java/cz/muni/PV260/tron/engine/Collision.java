package cz.muni.PV260.tron.engine;

import cz.muni.PV260.tron.engine.Collidable;

public class Collision {
    private final Collidable collidable;
    private final Collidable collidedWith;

    public Collision(Collidable collidable, Collidable collidedWith) {
        this.collidable = collidable;
        this.collidedWith = collidedWith;
    }

    @Override
    public String toString() {
        return "Collision{" +
                "collidable=" + collidable +
                ", collidedWith=" + collidedWith +
                '}';
    }
}
