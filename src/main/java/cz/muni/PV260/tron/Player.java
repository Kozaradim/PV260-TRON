package cz.muni.PV260.tron;

import java.awt.event.KeyEvent;

public class Player {
    private final ControlKeys controlKeys;
    private int centrex;
    private int centrey;
    private int currentDirection;

    public Player(int centrex, int centrey, int currentDirection, ControlKeys controlKeys) {
        this.centrex = centrex;
        this.centrey = centrey;
        this.currentDirection = currentDirection;
        this.controlKeys = controlKeys;
    }

    public int getCentrex() {
        return centrex;
    }

    public int getCentrey() {
        return centrey;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void move(int height, int width, int moveAmount) {
        switch (currentDirection) {
            case 0:
                if (centrey > 0) {
                    centrey -= moveAmount;
                } else {
                    centrey = height;
                }
                break;
            case 1:
                if (centrex < width) {
                    centrex += moveAmount;
                } else {
                    centrex = 0;
                }
                break;
            case 2:
                if (centrey < height) {
                    centrey += moveAmount;
                } else {
                    centrey = 0;
                }
                break;
            case 3:
                if (centrex > 0) {
                    centrex -= moveAmount;
                } else {
                    centrex = width;
                }
                break;
        }
    }


    void turn(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == controlKeys.keyUp) {
            if (currentDirection != 2) {
                currentDirection = 0;
            }
        } else if (keyEvent.getKeyCode() == controlKeys.keyDown) {
            if (currentDirection != 0) {
                currentDirection = 2;
            }
        } else if (keyEvent.getKeyCode() == controlKeys.keyRight) {
            if (currentDirection != 3) {
                currentDirection = 1;
            }
        } else if (keyEvent.getKeyCode() == controlKeys.keyLeft) {
            if (currentDirection != 1) {
                currentDirection = 3;
            }
        }
    }
}
