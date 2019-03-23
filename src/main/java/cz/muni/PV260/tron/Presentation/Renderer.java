package cz.muni.PV260.tron.Presentation;

import cz.muni.PV260.tron.model.GameBoard;
import cz.muni.PV260.tron.model.Player;

import java.awt.*;
import java.util.List;

public class Renderer {
    public static final int PIXEL_SIZE = 10;
    private final Graphics2D graphics;

    public Renderer(Graphics2D graphics) {
        this.graphics = graphics;
    }


    void renderGameBoard(GameBoard gameBoard) {
        graphics.setColor(gameBoard.getBackgroundColor());
        graphics.fillRect(0, 0, gameBoard.getDimension().getX(), gameBoard.getDimension().getY());
    }

    void renderPlayer(Player player) {
        graphics.setColor(player.getColor());
        player.getPath()
                .forEach(position ->
                        graphics.fillRect(position.getX(), position.getY(), PIXEL_SIZE, PIXEL_SIZE));
    }

    void renderPlayers(List<Player> players) {
        players.forEach(player -> renderPlayer(player));
    }
}
