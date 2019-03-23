package cz.muni.PV260.tron.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CollisionDetector {

    private final List<Collidable> collidables = new ArrayList<>();

    public void addCollidable(Collidable collidable) {
        collidables.add(collidable);
    }

    public List<Collision> findAllCollisions() {
        return collidables
                .stream()
                .map(collidable -> findCollisions(collidable, collidables))
                .flatMap(List::stream)
                .collect(Collectors.toList());

    }

    private List<Collision> findCollisions(Collidable collidable, List<Collidable> otherCollidables) {
        return otherCollidables
                .stream()
                .map(collidable::findCollision)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}

