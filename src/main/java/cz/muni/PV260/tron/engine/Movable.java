package cz.muni.PV260.tron.engine;

import cz.muni.PV260.tron.engine.controls.Control;

public interface Movable {
    Control getControl();

    void move();

    void updatePosition();
}
