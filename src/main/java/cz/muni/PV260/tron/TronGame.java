package cz.muni.PV260.tron;

import cz.muni.PV260.tron.controls.KeyControl;
import cz.muni.PV260.tron.controls.KeyDirections;
import cz.muni.PV260.tron.controls.MouseControl;
import cz.muni.PV260.tron.controls.MouseDirections;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.event.KeyEvent.*;

public class TronGame extends Core {

    private final List<Player> players = new ArrayList<>();
    private final CollisionDetector collisionDetector = new CollisionDetector();
    private Renderer renderer;

    private final int MOVE_AMOUNT = 5;
    GameBoard gameBoard;


    public static void main(String[] args) {
        TronGame tronGame = new TronGame();


        Player player1 = new Player(Position.of(40, 40),
                new KeyControl(
                        new KeyDirections(VK_UP, VK_DOWN, VK_LEFT, VK_RIGHT),
                        Direction.RIGHT),
                Color.GREEN);
        tronGame.addPlayer(player1);


        Player player2 = new Player(Position.of(600, 440),
                new KeyControl(
                        new KeyDirections(VK_W, VK_S, VK_A, VK_D), Direction.LEFT), Color.RED);
        tronGame.addPlayer(player2);

        Player player3 = new Player(Position.of(80, 900),
                new MouseControl(new MouseDirections(BUTTON1_DOWN_MASK, BUTTON3_DOWN_MASK),
                        Direction.RIGHT),
                Color.BLUE);
        tronGame.addPlayer(player3);

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
        addListeners(window);
    }

    private void addListeners(Component window) {
        players.forEach(player -> player.getControl().addListener(window));
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
}
