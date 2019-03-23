package cz.muni.PV260.tron.model.controls;

import cz.muni.PV260.tron.model.Direction;

import java.awt.*;

public interface Control {
    Direction getDirection();

    void addListener(Component component);

}
