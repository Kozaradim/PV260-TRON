package cz.muni.PV260.tron.Presentation;

import cz.muni.PV260.tron.model.*;
import cz.muni.PV260.tron.engine.Core;

import java.awt.*;

public class TronGame extends Core {

    public final TronModel tronModel;

    private Renderer renderer;

    private final int MOVE_AMOUNT = 5;

    public TronGame(TronModel tronModel) {
        this.tronModel = tronModel;
    }


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
        tronModel.evaluateCollision();

    }

    public void draw() {
        renderer.renderGameBoard(tronModel.getGameBoard());
        renderer.renderPlayers(tronModel.getPlayers());
    }

}
