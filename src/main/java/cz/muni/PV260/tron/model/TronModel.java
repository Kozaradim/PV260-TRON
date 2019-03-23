package cz.muni.PV260.tron.model;

import cz.muni.PV260.tron.engine.CollisionDetector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TronModel {

    private final List<Player> players = new ArrayList<>();
    public final CollisionDetector collisionDetector = new CollisionDetector();
    private GameBoard gameBoard;

    public void addPlayer(Player player) {
        this.players.add(player);
        this.collisionDetector.addCollidable(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void move() {
        players.forEach(player -> player.move(gameBoard));
    }

    public void addPositionToPath() {
        players.forEach(Player::addPositionToPath);
    }

    public void addListeners(Component window) {

        getPlayers().forEach(player -> player.getControl().addListener(window));
    }
}
