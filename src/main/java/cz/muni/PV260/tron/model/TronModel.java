package cz.muni.PV260.tron.model;

import cz.muni.PV260.tron.engine.CollisionDetector;
import cz.muni.PV260.tron.engine.MoveManager;
import cz.muni.PV260.tron.engine.Renderer;

import java.awt.*;

public class TronModel {

    public final CollisionDetector collisionDetector;
    public final MoveManager moveManager;
    public final Renderer renderer;

    public TronModel(CollisionDetector collisionDetector, Renderer renderer, TronGameBoard gameBoard) {
        this.collisionDetector = collisionDetector;
        this.renderer = renderer;
        this.moveManager = new MoveManager();
        renderer.addRenderable(gameBoard);
    }

    public void addPlayer(Player player) {
        this.collisionDetector.addCollidable(player);
        this.moveManager.addMovable(player);
        this.renderer.addRenderable(player);
    }

    public void addListeners(Component window) {

        moveManager.getMovables().forEach(player -> player.getControl().addListener(window));
    }
}
