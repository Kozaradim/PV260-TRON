package cz.muni.PV260.tron.controls;

import cz.muni.PV260.tron.Direction;
import cz.muni.PV260.tron.Player;

import java.awt.*;
import java.awt.event.KeyEvent;

public interface Control {
    Direction getDirection();

    void addListener(Component component);

}
