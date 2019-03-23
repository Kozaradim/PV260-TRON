package cz.muni.PV260.tron.model;

import cz.muni.PV260.tron.engine.CollisionDetector;
import cz.muni.PV260.tron.engine.MoveManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TronModel {

    private final List<Player> players = new ArrayList<>();
    public final CollisionDetector collisionDetector = new CollisionDetector();
    public final MoveManager moveManager;
    private final TronGameBoard gameBoard;

    public TronModel(TronGameBoard gameBoard) {
        this.gameBoard = gameBoard;
        this.moveManager = new MoveManager();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
        this.collisionDetector.addCollidable(player);
        this.moveManager.addMovable(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public TronGameBoard getGameBoard() {
        return gameBoard;
    }

    public void addListeners(Component window) {

        getPlayers().forEach(player -> player.getControl().addListener(window));
    }
}
