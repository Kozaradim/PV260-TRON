package cz.muni.PV260.tron.engine.controls;

import cz.muni.PV260.tron.engine.Direction;

import java.awt.*;

public interface Control {
    Direction getDirection();

    void addListener(Component component);

}
