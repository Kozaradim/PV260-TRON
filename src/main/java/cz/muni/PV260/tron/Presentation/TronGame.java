package cz.muni.PV260.tron.Presentation;

import cz.muni.PV260.tron.engine.Collision;
import cz.muni.PV260.tron.engine.Core;
import cz.muni.PV260.tron.engine.ScreenManager;
import cz.muni.PV260.tron.model.TronModel;

import java.util.List;

public class TronGame extends Core {

    private final TronModel tronModel;

    public TronGame(TronModel tronModel, ScreenManager screenManager) {
        super(screenManager);
        this.tronModel = tronModel;
    }

    @Override
    public void init() {
        super.init();
        tronModel.addListeners(screenManager.getFullScreenWindow());
    }

    @Override
    public void update() {
        tronModel.moveManager.move();
        handleCollisions();
        tronModel.moveManager.updatePosition();

    }

    private void handleCollisions() {
        List<Collision> collisions = tronModel.collisionDetector.findAllCollisions();
        if (!collisions.isEmpty()) running = false;
    }

    @Override
    protected void draw() {
        tronModel.renderer.renderAll();
    }
}
