package cz.muni.PV260.tron.model;

import cz.muni.PV260.tron.Presentation.TronGame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TronModel {

    private final List<Player> players = new ArrayList<>();
    private final CollisionDetector collisionDetector = new CollisionDetector();
    private GameBoard gameBoard;

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void evaluateCollision() {
        List<Collision> collisions = collisionDetector.findAllCollisions(players);
        if (!collisions.isEmpty())
            System.exit(0);
        addPositionToPath();
    }

    public void move() {
        players.forEach(player -> player.move(gameBoard));
    }

    private void addPositionToPath() {
        players.forEach(Player::addPositionToPath);
    }

    public void addListeners(Component window) {

        getPlayers().forEach(player -> player.getControl().addListener(window));
    }
}
