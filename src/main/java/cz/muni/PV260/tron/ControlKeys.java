package cz.muni.PV260.tron;

import java.util.HashMap;
import java.util.Map;

import static cz.muni.PV260.tron.Direction.*;

public class ControlKeys {
    final int keyUp;
    final int keyDown;
    final int keyLeft;
    final int keyRight;
    private final Map<Integer, Direction> directionMap = new HashMap<>();

    public ControlKeys(int keyUp, int keyDown, int keyLeft, int keyRight) {
        this.keyUp = keyUp;
        this.keyDown = keyDown;
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;

        initDirectionMap();
    }

    private void initDirectionMap() {
        directionMap.put(keyLeft, LEFT);
        directionMap.put(keyRight, RIGHT);
        directionMap.put(keyUp, UP);
        directionMap.put(keyDown, DOWN);
    }

    public Direction getDirection(int keyCode) {
        return directionMap.get(keyCode);
    }
}
