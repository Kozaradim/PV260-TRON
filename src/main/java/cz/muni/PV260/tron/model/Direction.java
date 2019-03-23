package cz.muni.PV260.tron.model;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;


    private static final Map<Direction, Direction> forbiddenTurnMap = new HashMap<Direction, Direction>() {{
        put(DOWN, UP);
        put(UP, DOWN);
        put(LEFT, RIGHT);
        put(RIGHT, LEFT);
    }};

    private static final Map<Direction, Direction> turnLeftMap = new HashMap<Direction, Direction>() {{
        put(DOWN, RIGHT);
        put(UP, LEFT);
        put(LEFT, DOWN);
        put(RIGHT, UP);
    }};

    private static final Map<Direction, Direction> turnRightMap = new HashMap<Direction, Direction>() {{
        put(DOWN, LEFT);
        put(UP, RIGHT);
        put(LEFT, UP);
        put(RIGHT, DOWN);
    }};


    public Direction turnToIfAllowed(Direction direction) {
        Direction forbiddenDirection = forbiddenTurnMap.get(this);
        if (forbiddenDirection == null || direction != forbiddenDirection)
            return direction;
        else return this;
    }

    public Direction turn(Direction turnDirection) {
        if (turnDirection == LEFT)
            return turnLeftMap.get(this);
        else if (turnDirection == RIGHT)
            return turnRightMap.get(this);
        else return null;
    }
}