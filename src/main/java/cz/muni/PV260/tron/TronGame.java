package cz.muni.PV260.tron;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class TronGame extends Core implements KeyListener, MouseListener,
        MouseMotionListener {
    int centrex1 = 40;
    int centrey1 = 40;
    int centrex2 = 600;
    int centrey2 = 440;
    int currentDirection1 = 1;
    int currentDirection2 = 3;
    int moveAmount = 5;
    ArrayList<Integer> pathx1 = new ArrayList<Integer>();
    ArrayList<Integer> pathy1 = new ArrayList<Integer>();
    ArrayList<Integer> pathx2 = new ArrayList<Integer>();
    ArrayList<Integer> pathy2 = new ArrayList<Integer>();

    public static void main(String[] args) {
        new TronGame().run();
    }

    public void init() {
        super.init();

        Window window = screenManager.getFullScreenWindow();
        window.addKeyListener(this);
        window.addMouseListener(this);
        window.addMouseMotionListener(this);
    }

    public void draw(Graphics2D graphics) {
        switch (currentDirection1) {
            case 0:
                if (centrey1 > 0) {
                    centrey1 -= moveAmount;
                } else {
                    centrey1 = screenManager.getHeight();
                }
                break;
            case 1:
                if (centrex1 < screenManager.getWidth()) {
                    centrex1 += moveAmount;
                } else {
                    centrex1 = 0;
                }
                break;
            case 2:
                if (centrey1 < screenManager.getHeight()) {
                    centrey1 += moveAmount;
                } else {
                    centrey1 = 0;
                }
                break;
            case 3:
                if (centrex1 > 0) {
                    centrex1 -= moveAmount;
                } else {
                    centrex1 = screenManager.getWidth();
                }
                break;
        }
        switch (currentDirection2) {
            case 0:
                if (centrey2 > 0) {
                    centrey2 -= moveAmount;
                } else {
                    centrey2 = screenManager.getHeight();
                }
                break;
            case 1:
                if (centrex2 < screenManager.getWidth()) {
                    centrex2 += moveAmount;
                } else {
                    centrex2 = 0;
                }
                break;
            case 2:
                if (centrey2 < screenManager.getHeight()) {
                    centrey2 += moveAmount;
                } else {
                    centrey2 = 0;
                }
                break;
            case 3:
                if (centrex2 > 0) {
                    centrex2 -= moveAmount;
                } else {
                    centrex2 = screenManager.getWidth();
                }
                break;
        }
        for (int pathx1Index = 0; pathx1Index < pathx1.size(); pathx1Index++) {
            if (((centrex1 == pathx1.get(pathx1Index)) && (centrey1 == pathy1.get(pathx1Index)))
                    || ((centrex2 == pathx2.get(pathx1Index)) && (centrey2 == pathy2.get(pathx1Index)))
                    || ((centrex1 == pathx2.get(pathx1Index)) && (centrey1 == pathy2.get(pathx1Index)))
                    || ((centrex2 == pathx1.get(pathx1Index)) && (centrey2 == pathy1.get(pathx1Index)))) {
                System.exit(0);
            }
        }
        pathx1.add(centrex1);
        pathy1.add(centrey1);
        pathx2.add(centrex2);
        pathy2.add(centrey2);
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, screenManager.getWidth(), screenManager.getHeight());
        for (int pathx1Index = 0; pathx1Index < pathx1.size(); pathx1Index++) {
            graphics.setColor(Color.green);
            graphics.fillRect(pathx1.get(pathx1Index), pathy1.get(pathx1Index), 10, 10);
            graphics.setColor(Color.red);
            graphics.fillRect(pathx2.get(pathx1Index), pathy2.get(pathx1Index), 10, 10);
        }
    }

    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            if (currentDirection1 != 2) {
                currentDirection1 = 0;
            }
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            if (currentDirection1 != 0) {
                currentDirection1 = 2;
            }
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (currentDirection1 != 3) {
                currentDirection1 = 1;
            }
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            if (currentDirection1 != 1) {
                currentDirection1 = 3;
            }
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_W) {
            if (currentDirection2 != 2) {
                currentDirection2 = 0;
            }
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_S) {
            if (currentDirection2 != 0) {
                currentDirection2 = 2;
            }
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_D) {
            if (currentDirection2 != 3) {
                currentDirection2 = 1;
            }
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_A) {
            if (currentDirection2 != 1) {
                currentDirection2 = 3;
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent keyEvent) {

    }

    public void mouseClicked(MouseEvent mouseEvent) {

    }

    public void mouseEntered(MouseEvent mouseEvent) {
    }

    public void mouseExited(MouseEvent mouseEvent) {
    }

    public void mousePressed(MouseEvent mouseEvent) {
    }

    public void mouseReleased(MouseEvent mouseEvent) {
    }

    public void mouseDragged(MouseEvent mouseEvent) {

    }

    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
