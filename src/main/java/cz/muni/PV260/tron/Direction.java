package cz.muni.PV260.tron;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;


    private static Map<Direction, Direction> forbiddenTurnMap = new HashMap<Direction, Direction>() {{
        put(DOWN, UP);
        put(UP, DOWN);
        put(LEFT, RIGHT);
        put(RIGHT, LEFT);
    }};

    public Direction turnToIfAllowed(Direction direction) {
        Direction forbiddenDirection = forbiddenTurnMap.get(this);
        if (forbiddenDirection == null || direction != forbiddenDirection)
            return direction;
        else return this;
    }

}