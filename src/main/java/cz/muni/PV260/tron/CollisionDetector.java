package cz.muni.PV260.tron;

import java.util.ArrayList;
import java.util.List;

public class CollisionDetector {
    public List<Collision> findAllCollisions(List<Player> players) {
        List<Collision> collisions = new ArrayList<>();
        for (Player player : players) {
            collisions.addAll(findCollisions(player, players));
        }
        return collisions;
    }

    private List<Collision> findCollisions(Player player, List<Player> players) {
        List<Collision> collisions = new ArrayList<>();
        for (Player otherPlayer : players) {
            Collision collision = findCollision(player, otherPlayer);
            if (collision != null)
                collisions.add(collision);
        }
        return collisions;
    }

    private Collision findCollision(Player player, Player otherPlayer) {
        return otherPlayer.getPath().contains(player.getPosition())
                ? new Collision(player, otherPlayer) : null;
    }

}
