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
import java.util.List;


import static java.awt.event.KeyEvent.*;

public class TronGame extends Core implements KeyListener, MouseListener,
        MouseMotionListener {

    private final List<Player> players = new ArrayList<>();
    private final CollisionDetector collisionDetector = new CollisionDetector();
    private Renderer renderer;

    private final int MOVE_AMOUNT = 5;
    GameBoard gameBoard;


    public static void main(String[] args) {
        TronGame tronGame = new TronGame();

        Player player1 = new Player(Position.of(40, 40), Direction.RIGHT,
                new ControlKeys(VK_UP, VK_DOWN, VK_LEFT, VK_RIGHT),
                new ControlMouse(BUTTON1_DOWN_MASK, BUTTON3_DOWN_MASK),
                Color.GREEN);
        tronGame.addPlayer(player1);
        Player player2 = new Player(Position.of(600, 440), Direction.LEFT,
                new ControlKeys(VK_W, VK_S, VK_A, VK_D), null, Color.RED);
        tronGame.addPlayer(player2);
        tronGame.run();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void init() {
        super.init();
        gameBoard = new GameBoard(screenManager.getScreenSize(), Color.BLACK, MOVE_AMOUNT);
        renderer = new Renderer(screenManager.getGraphics());


        Window window = screenManager.getFullScreenWindow();
        window.addKeyListener(this);
        window.addMouseListener(this);
        window.addMouseMotionListener(this);
    }

    @Override
    public void update() {
        move();
        List<Collision> collisions = collisionDetector.findAllCollisions(players);
        if (!collisions.isEmpty())
            System.exit(0);
        addPositionToPath();

    }

    private void addPositionToPath() {
        players.forEach(Player::addPositionToPath);
    }

    private void move() {
        players.forEach(player -> player.move(gameBoard));
    }


    public void draw(Graphics2D graphics) {

        renderer.renderBackground(gameBoard);
        renderPlayers(players);
    }

    private void renderPlayers(List<Player> players) {
        players.forEach(player -> renderer.renderPlayer(player));
    }

    public void keyPressed(KeyEvent keyEvent) {
        turn(keyEvent);
    }

    private void turn(KeyEvent keyEvent) {
        players.forEach(player -> player.turn(keyEvent));
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
        turn(mouseEvent);
    }

    private void turn(MouseEvent mouseEvent) {
        players.forEach(player -> player.turn(mouseEvent));
    }

    public void mouseReleased(MouseEvent mouseEvent) {
    }

    public void mouseDragged(MouseEvent mouseEvent) {

    }

    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
