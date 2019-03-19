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


import static java.awt.event.KeyEvent.*;

public class TronGame extends Core implements KeyListener, MouseListener,
        MouseMotionListener {

    Player player1 = new Player(Position.of(40, 40), Direction.RIGHT,
            new ControlKeys(VK_UP, VK_DOWN, VK_LEFT, VK_RIGHT),
            new ControlMouse(BUTTON1_DOWN_MASK, BUTTON3_DOWN_MASK),
            Color.GREEN);
    Player player2 = new Player(Position.of(600, 440), Direction.LEFT,
            new ControlKeys(VK_W, VK_S, VK_A, VK_D), null, Color.RED);



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
        player1.move(screenManager.getScreenSize(), moveAmount);
        player2.move(screenManager.getScreenSize(), moveAmount);

        int centrex1 = player1.getPosition().x;
        int centrey1 = player1.getPosition().y;
        int centrex2 = player2.getPosition().x;
        int centrey2 = player2.getPosition().y;

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
            graphics.setColor(player1.getColor());
            graphics.fillRect(pathx1.get(pathx1Index), pathy1.get(pathx1Index), 10, 10);
            graphics.setColor(player2.getColor());
            graphics.fillRect(pathx2.get(pathx1Index), pathy2.get(pathx1Index), 10, 10);
        }
    }

    public void keyPressed(KeyEvent keyEvent) {
        player1.turn(keyEvent);
        player2.turn(keyEvent);
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
        player1.turn(mouseEvent);
        player2.turn(mouseEvent);
    }

    public void mouseReleased(MouseEvent mouseEvent) {
    }

    public void mouseDragged(MouseEvent mouseEvent) {

    }

    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
