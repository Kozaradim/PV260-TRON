package cz.muni.PV260.tron;

import static cz.muni.PV260.tron.Direction.LEFT;
import static cz.muni.PV260.tron.Direction.RIGHT;

public class ControlMouse {
    final int mouseLeft;
    final int mouseRight;

    public ControlMouse(int mouseLeft, int mouseRight) {
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

