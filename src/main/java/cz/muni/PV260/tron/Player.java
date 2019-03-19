package cz.muni.PV260.tron;

import java.awt.event.KeyEvent;

import static cz.muni.PV260.tron.Direction.*;

public class Player {
    private final ControlKeys controlKeys;
    private Position position;
    private Direction currentDirection;

    public Player(Position position, Direction currentDirection, ControlKeys controlKeys) {
        this.position = position;
        this.currentDirection = currentDirection;
        this.controlKeys = controlKeys;
    }

    public Position getPosition() {
        return position;
    }


    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void move(int height, int width, int moveAmount) {
        switch (currentDirection) {
            case UP:
                if (position.y > 0) {
                    position.up(moveAmount);
                } else {
                    position.y = height;
                }
                break;
            case RIGHT:
                if (position.x < width) {
                    position.right(moveAmount);
                } else {
                    position.x = 0;
                }
                break;
            case DOWN:
                if (position.y < height) {
                    position.down(moveAmount);
                } else {
                    position.y = 0;
                }
                break;
            case LEFT:
                if (position.x > 0) {
                    position.left(moveAmount);
                } else {
                    position.x = width;
                }
                break;
        }
    }


    void turn(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == controlKeys.keyUp) {
            if (currentDirection != DOWN) {
                currentDirection = UP;
            }
        } else if (keyEvent.getKeyCode() == controlKeys.keyDown) {
            if (currentDirection != UP) {
                currentDirection = DOWN;
            }
        } else if (keyEvent.getKeyCode() == controlKeys.keyRight) {
            if (currentDirection != LEFT) {
                currentDirection = RIGHT;
            }
        } else if (keyEvent.getKeyCode() == controlKeys.keyLeft) {
            if (currentDirection != RIGHT) {
                currentDirection = LEFT;
            }
        }
    }
}
