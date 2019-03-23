package cz.muni.PV260.tron.engine;

import cz.muni.PV260.tron.engine.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Shape implements Iterable<Position> {
    private final List<Position> shape = new ArrayList<>();

    @Override
    public Iterator<Position> iterator() {
        return shape.iterator();
    }

    public void add(Position position) {
        shape.add(position);
    }

    public boolean collides(Position position) {
        return shape.contains(position);
    }
}
