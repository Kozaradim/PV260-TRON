package cz.muni.PV260.tron.engine;

import java.util.ArrayList;
import java.util.List;


public class MoveManager {

    private final List<Movable> movables = new ArrayList<>();

    public MoveManager() {
    }

    public void addMovable(Movable movable) {
        movables.add(movable);
    }

    public List<Movable> getMovables() {
        return movables;
    }

    public void move() {
        movables.forEach(Movable::move);
    }

    public void updatePosition() {
        movables.forEach(Movable::updatePosition);
    }
}
