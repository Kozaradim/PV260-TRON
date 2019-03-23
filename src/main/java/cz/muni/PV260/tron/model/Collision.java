package cz.muni.PV260.tron.model;

public class Collision {
    private final Player player;
    private final Player collidedWith;

    public Collision(Player player, Player collidedWith) {
        this.player = player;
        this.collidedWith = collidedWith;
    }

    @Override
    public String toString() {
        return "Collision{" +
                "player=" + player +
                ", collidedWith=" + collidedWith +
                '}';
    }
}
