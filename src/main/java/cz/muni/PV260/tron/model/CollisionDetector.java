package cz.muni.PV260.tron.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class CollisionDetector {
    public List<Collision> findAllCollisions(List<Player> players) {
        List<Collision> collisions = new ArrayList<>();
        players.stream()
                .map(player -> findCollisions(player, players))
                .forEach(collisions::addAll);
        return collisions;
    }

    private List<Collision> findCollisions(Player player, List<Player> players) {
        return players
                .stream()
                .map(otherPlayer -> findCollision(player, otherPlayer))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Collision findCollision(Player player, Player otherPlayer) {
        return otherPlayer.getPath().contains(player.getPosition())
                ? new Collision(player, otherPlayer) : null;
    }

}
