package cz.muni.PV260.tron.Presentation;

import cz.muni.PV260.tron.engine.Core;
import cz.muni.PV260.tron.engine.ScreenManager;
import cz.muni.PV260.tron.model.Collision;
import cz.muni.PV260.tron.model.GameBoard;
import cz.muni.PV260.tron.model.TronModel;

import java.awt.*;
import java.util.List;

public class TronGame extends Core {

    private final static int MOVE_AMOUNT = 5;

    private Renderer renderer;
    private final TronModel tronModel;

    public TronGame(TronModel tronModel, ScreenManager screenManager) {
        super(screenManager);
        this.tronModel = tronModel;
    }

    @Override
    public void init() {
        super.init();
        GameBoard gameBoard = new GameBoard(screenManager.getScreenSize(), Color.BLACK, MOVE_AMOUNT);
        tronModel.setGameBoard(gameBoard);
        tronModel.addListeners(screenManager.getFullScreenWindow());
        renderer = new Renderer(screenManager.getGraphics());

    }

    @Override
    public void update() {
        tronModel.move();
        handleCollisions();
        tronModel.addPositionToPath();

    }

    private void handleCollisions() {
        List<Collision> collisions = tronModel.evaluateCollision();
        if (!collisions.isEmpty()) running = false;
    }

    @Override
    public void draw() {
        renderer.renderGameBoard(tronModel.getGameBoard());
        renderer.renderPlayers(tronModel.getPlayers());
    }

}
