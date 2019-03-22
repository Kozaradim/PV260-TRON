package cz.muni.PV260.tron;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import static java.awt.event.KeyEvent.*;

public class TronGame extends Core implements KeyListener, MouseListener,
        MouseMotionListener {

    Player player1 = new Player(Position.of(40, 40), Direction.RIGHT,
            new ControlKeys(VK_UP, VK_DOWN, VK_LEFT, VK_RIGHT),
            new ControlMouse(BUTTON1_DOWN_MASK, BUTTON3_DOWN_MASK),
            Color.GREEN);
    Player player2 = new Player(Position.of(600, 440), Direction.LEFT,
            new ControlKeys(VK_W, VK_S, VK_A, VK_D), null, Color.RED);


    private final int MOVE_AMOUNT = 5;
    GameBoard gameBoard;

    public static void main(String[] args) {
        new TronGame().run();
    }

    public void init() {
        super.init();
        gameBoard = new GameBoard(screenManager.getScreenSize(), MOVE_AMOUNT);

        Window window = screenManager.getFullScreenWindow();
        window.addKeyListener(this);
        window.addMouseListener(this);
        window.addMouseMotionListener(this);
    }

    public void draw(Graphics2D graphics) {
        player1.move(gameBoard);
        player2.move(gameBoard);

        if (player1.getPath().subList(0, player1.getPath().size() - 1).contains(player1.getPosition())
                || player1.getPath().contains(player2.getPosition())
                || player2.getPath().subList(0, player2.getPath().size() - 1).contains(player2.getPosition())
                || player2.getPath().contains(player1.getPosition()))
            System.exit(0);


        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, screenManager.getWidth(), screenManager.getHeight());
        for (int pathx1Index = 0; pathx1Index < player1.getPath().size(); pathx1Index++) {
            graphics.setColor(player1.getColor());
            Position position1 = player1.getPath().get(pathx1Index);
            graphics.fillRect(position1.x, position1.y, 10, 10);
            Position position2 = player2.getPath().get(pathx1Index);
            graphics.setColor(player2.getColor());
            graphics.fillRect(position2.x, position2.y, 10, 10);
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
