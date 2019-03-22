package cz.muni.PV260.tron;

public class Collision {
    private final Player player;
    private final Player colidedWith;

    public Collision(Player player, Player colidedWith) {
        this.player = player;
        this.colidedWith = colidedWith;
    }

    @Override
    public String toString() {
        return "Collision{" +
                "player=" + player +
                ", colidedWith=" + colidedWith +
                '}';
    }
}
