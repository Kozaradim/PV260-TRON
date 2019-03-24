package cz.muni.PV260.tron;

import cz.muni.PV260.tron.Presentation.TronGame;
import cz.muni.PV260.tron.engine.*;
import cz.muni.PV260.tron.engine.controls.KeyControl;
import cz.muni.PV260.tron.engine.controls.KeyDirections;
import cz.muni.PV260.tron.engine.controls.MouseControl;
import cz.muni.PV260.tron.engine.controls.MouseDirections;
import cz.muni.PV260.tron.model.Player;
import cz.muni.PV260.tron.model.TronGameBoard;
import cz.muni.PV260.tron.model.TronModel;

import java.awt.*;

import static java.awt.event.KeyEvent.*;

class Main {

    public static final Color BACKGROUND_COLOR = Color.BLACK;
    public static final int MOVE_AMOUNT = 5;

    public static void main(String[] args) {
        ScreenManager screenManager = new ScreenManager();
        screenManager.init();

        CollisionDetector collisionDetector = new CollisionDetector();
        Renderer renderer = new Renderer(screenManager.getGraphics());

        TronGameBoard gameBoard = new TronGameBoard(screenManager.getScreenSize(), BACKGROUND_COLOR, MOVE_AMOUNT);

        TronModel tronModel = new TronModel(collisionDetector, renderer, gameBoard);

        Player player1 = new Player(Position.of(40, 40),
                new KeyControl(
                        new KeyDirections(VK_UP, VK_DOWN, VK_LEFT, VK_RIGHT),
                        Direction.RIGHT),
                Color.GREEN, gameBoard);
        tronModel.addPlayer(player1);


        Player player2 = new Player(Position.of(600, 440),
                new KeyControl(
                        new KeyDirections(VK_W, VK_S, VK_A, VK_D), Direction.LEFT), Color.RED, gameBoard);
        tronModel.addPlayer(player2);

        Player player3 = new Player(Position.of(80, 900),
                new MouseControl(new MouseDirections(BUTTON1_DOWN_MASK, BUTTON3_DOWN_MASK),
                        Direction.RIGHT),
                Color.BLUE, gameBoard);
        tronModel.addPlayer(player3);


        TronGame tronGame = new TronGame(tronModel, screenManager);
        tronGame.run();
    }
}
