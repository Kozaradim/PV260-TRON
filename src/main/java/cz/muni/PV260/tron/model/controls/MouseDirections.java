package cz.muni.PV260.tron.model.controls;

import cz.muni.PV260.tron.model.Direction;

import static cz.muni.PV260.tron.model.Direction.LEFT;
import static cz.muni.PV260.tron.model.Direction.RIGHT;

public class MouseDirections {
    private final int mouseLeft;
    private final int mouseRight;

    public MouseDirections(int mouseLeft, int mouseRight) {
        this.mouseLeft = mouseLeft;
        this.mouseRight = mouseRight;
    }

    public Direction getDirection(int modifiersEx) {
        if ((modifiersEx & mouseLeft) != 0)
            return LEFT;
        else if ((modifiersEx & mouseRight) != 0)
            return RIGHT;
        else
            return null;
    }
}

