package cz.muni.PV260.tron;

import cz.muni.PV260.tron.model.*;
import cz.muni.PV260.tron.Presentation.TronGame;
import cz.muni.PV260.tron.model.controls.KeyControl;
import cz.muni.PV260.tron.model.controls.KeyDirections;
import cz.muni.PV260.tron.model.controls.MouseControl;
import cz.muni.PV260.tron.model.controls.MouseDirections;

import java.awt.*;

import static java.awt.event.KeyEvent.*;

public class Main {
    public static void main(String[] args) {
        TronModel tronModel = new TronModel();

        Player player1 = new Player(Position.of(40, 40),
                new KeyControl(
                        new KeyDirections(VK_UP, VK_DOWN, VK_LEFT, VK_RIGHT),
                        Direction.RIGHT),
                Color.GREEN);
        tronModel.addPlayer(player1);


        Player player2 = new Player(Position.of(600, 440),
                new KeyControl(
                        new KeyDirections(VK_W, VK_S, VK_A, VK_D), Direction.LEFT), Color.RED);
        tronModel.addPlayer(player2);

        Player player3 = new Player(Position.of(80, 900),
                new MouseControl(new MouseDirections(BUTTON1_DOWN_MASK, BUTTON3_DOWN_MASK),
                        Direction.RIGHT),
                Color.BLUE);
        tronModel.addPlayer(player3);

        TronGame tronGame = new TronGame(tronModel);
        tronGame.run();
    }
}
